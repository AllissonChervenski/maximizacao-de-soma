import java.util.ArrayList;
import java.util.Collections;

public class forcaBruta {
    public static ArrayList<String> result = new ArrayList<>();             
    public static ArrayList<Integer> solution = new ArrayList<>();          
    public static int maior = 0;                                            
    public static ArrayList<Integer> maiorSolucao = new ArrayList<>();      

    public static void permuta(ArrayList a) {
        permuta(toString(a), "");                      
    }

    static void permuta(String a, String b) {
        if (a.length() == 0) {                                      
                   if(!result.contains(b)){                         //r     
                    result.add(b);                              
                   }
        } else {
            for (int i = 0; i < a.length(); i++) {                      
                String rem = a.substring(0, i) + a.substring(i + 1);     
                permuta(rem, b + a.charAt(i));                            //h(logi1.n!)
            }
        }
    }


    static void repeticao(String a) {
        ArrayList<Character> b = new ArrayList<>(a.length());                          
        ArrayList<Character> aux = new ArrayList<>(a.length());                        
        ArrayList<Character> aux2 = new ArrayList<>(a.length());                       
        ArrayList<Character> aux3 = new ArrayList<>(a.length());                       
        for (int e = 0; e < a.length(); e++) {                                         
            b.add(e, a.charAt(e));
        }

        for (int j = 0; j < b.size(); j++) {                                            //N + 1         N = b.length
            for (int u = 0; u < a.length(); u++) {                                      //N*(N + 1)   a = b  N = a.length
                ArrayList<Character> c = new ArrayList<>(b);
                if(a.charAt(j) != c.get(u)){                                            //1
                    c.set(u, a.charAt(j));                                              //1
                    permuta(c);                                                         //N*(N + 1) * (logi1*N!)
                }
                aux = c;                                                                
                }
            for (int u = 0; u < a.length() - 1; u++) {                                  //(N -1) *(N+1)
                ArrayList<Character> c = new ArrayList<>(aux);
                if(a.charAt(j) != c.get(u)){                                            
                    c.set(u, a.charAt(j));                                          
                    permuta(c);                                                         //(N-1) * (N+1) * (logi1*N!)                                                             
                }   
                aux2 = c;                                                           
            }
            for (int u = 0; u < a.length() - 2; u++) {                                   //(N - 2) *(N+1)
                ArrayList<Character> c = new ArrayList<>(aux2);
                if(a.charAt(j) != c.get(u)){                                             
                    c.set(u, a.charAt(j));
                    permuta(c);                                                          //(N-2) * (N+1) * (logi1*N!)                
                }
                aux3 = c;                                                                
            }
            for (int u = 0; u < a.length() - 3; u++) {                                   //(N - 3) *(N+1)
                ArrayList<Character> c = new ArrayList<>(aux3);
                if(a.charAt(j) != c.get(u)){                                             
                c.set(u, a.charAt(j));
                permuta(c);                                                               //(N-3) * (N+1) * (logi1*N!)      
                }
            }

            }

        }


    public static void inversion(ArrayList a) {                                         //n
        Collections.reverse(a);
    }

    public static void removeLast(ArrayList<Integer> a, ArrayList<Integer> p) {
        if (a.size() > 0) {
            p.add(a.get(a.size() - 1));                                                   //1
            a.remove(a.get(a.size() - 1));                                                //1
        }
    }

    public static void removeTwoLast(ArrayList<Integer> a, ArrayList<Integer> p) {        //1
        if (a.size() > 1) {
            p.add((a.get(a.size() - 2)) * (a.get((a.size() - 1))));
            a.remove(a.get(a.size() - 2));
            a.remove(a.get(a.size() - 1));
        }
    }


    public static void escolhe(ArrayList<Integer> op, ArrayList<Integer> entrada, ArrayList<Integer> saida) {
        permuta(op);                                                                            //H(logi1*N!)
        repeticao(toString(op));                                                                //N² * (logi1*N!)
        ArrayList<Integer> aux = new ArrayList<>(entrada);                                         
        for (int f = 0; f < result.size(); f++) {                                                   //r     r=result
            int len = result.get(f).length();                                                       
            int m = 1;
            for (int i = 0; i < len; i++) {                                                         //r * f     f=r(i)
                if (aux.size() > 0) {
                    System.out.println("Vetor A antes da operação: " + aux.toString() + " Vetor B antes da operaçao: " + saida.toString());
                    if (result.get(f).charAt(i) == '3') {
                        inversion(aux);                                                 //a
                        removeLast(aux, saida);                                         //1
                        System.out.println("Inverte o vetor A, remove o ultimo e adiciona ao Vetor B: ");
                        System.out.println("Vetor A: " + aux.toString() + " Vetor B: " + saida.toString());
                        solution.add(1);
                    } else if (result.get(f).charAt(i) == '1') {    
                        removeLast(aux, saida);                                         //1
                        System.out.println("Remove o ultimo: ");
                        System.out.println("Vetor A: " + aux.toString() + " Vetor B: " + saida.toString());
                        solution.add(2);
                    } else if (result.get(f).charAt(i) == '2') {
                        if (aux.size() > 1) {
                            removeTwoLast(aux, saida);                                   //2
                            System.out.println("Remove os dois ultimos e multiplica: ");
                            System.out.println("Vetor A: " + aux.toString() + " Vetor B: " + saida.toString());
                            solution.add(3);
                        }
                    } else if (result.get(f).charAt(i) == '4') {
                        if(aux.size() > 1) {
                            inversion(aux);                                             //a = pior caso = r * f * a
                            removeTwoLast(aux, saida);                                  //2
                            System.out.println(" inverte e Remove os dois ultimos: ");
                            System.out.println("Vetor A: " + aux.toString() + " Vetor B: " + saida.toString());
                            solution.add(4);
                        }
                    }
                    if (aux.size() != 0 && result.get(f).charAt(i) == result.get(f).charAt(result.get(f).length() - 1)) {       
                        if (m < 4) {                                                                                        
                            result.set(f, result.get(f).concat(String.valueOf(m)));
                            len++;
                            m++;
                        }

                    }

                }
                else{
                    i = len;
                }
            }

            System.out.println("Conjunto solucao: " + solution.toString());         
            aux.addAll(entrada);                                                    //n * r       
            System.out.println("Soma da saida: " + soma(saida));                    

            if(maior < soma(saida)){                                                 
                maiorSolucao.clear();
                maiorSolucao.addAll(solution);                                      //s
                maior = soma(saida);                                                //n
            }

            solution.clear();
            saida.clear();
        }
        System.out.println("Maior resultado: " + maior);
        System.out.println("Sequencia da maior soma: " + maiorSolucao.toString() ); //s
    }
        //H(logi1*N!) + (N² * (logi1*N!)) + (r * f * a) + (n*r) + s + n + s = O(N² * logi1*N!)


    public static int soma(ArrayList<Integer> p) {                                      
        int resultado = 0;
        for (int elemento : p) {                                                    //p
            resultado += elemento;
        }
        return resultado;
    }

    public static String toString(ArrayList a) {                                    //a
        StringBuilder result = new StringBuilder();
        for (Object e : a) {                                                        //a
            result.append(e);
        }
        return result.toString();                                                   //a
    }


    public static void main(String[] args) {
        ArrayList op = new ArrayList();
        op.add(1);
        op.add(2);
        op.add(3);
        op.add(4);

        ArrayList b = new ArrayList();
        ArrayList a = new ArrayList();
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);

        escolhe(op, a, b); //O(N²* logi1*N!)



    }
}

