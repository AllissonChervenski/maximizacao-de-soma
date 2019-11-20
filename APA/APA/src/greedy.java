import java.util.ArrayList;
import java.util.Collections;

public class greedy {


    public static void choose(ArrayList entrada, ArrayList saida, ArrayList s) {
        while (entrada.size() != 0) {
        int maior = 0;
        int holder = 0;
        int resultado = 0;

            resultado = removeLast(entrada);
            if (maior < resultado) {
                maior = resultado;
                holder = 2;
            }
            if (entrada.size() > 1) {
                resultado = removeTwoLast(entrada);
                if (maior < resultado) {
                    maior = resultado;
                    holder = 3;
                }
            }
            if (entrada.size() > 1) {
                inversion(entrada);
                resultado = removeTwoLast(entrada);
                if (maior < resultado) {
                    maior = resultado;
                    holder = 4;
                }
                else{
                    inversion(entrada);
                }
            }

            inversion(entrada);
            resultado = removeLast(entrada);
            if (maior < resultado) {
                maior = resultado;
                holder = 1;
            }
            else{
                inversion(entrada);
            }

            if (holder == 1) {
                System.out.println("Vetor A antes da operação: " + entrada.toString() + " Vetor B antes da operaçao: " + saida.toString());
                entrada.remove(entrada.get(entrada.size() - 1));
                System.out.println("inverte e remove o ultimo: ");
                saida.add(maior);
                s.add(holder);
            System.out.println("Vetor A: " + entrada.toString() + " Vetor B: " + saida.toString());
            }
            else if(holder == 2){
                System.out.println("Vetor A antes da operação: " + entrada.toString() + " Vetor B antes da operaçao: " + saida.toString());
                entrada.remove(entrada.get(entrada.size() - 1));
                System.out.println("Remove o ultimo: ");
                saida.add(maior);
                s.add(holder);
                System.out.println("Vetor A: " + entrada.toString() + " Vetor B: " + saida.toString());
            }
            else if (holder == 3) {
                System.out.println("Vetor A antes da operação: " + entrada.toString() + " Vetor B antes da operaçao: " + saida.toString());
                entrada.remove(entrada.get(entrada.size() - 2));
                entrada.remove(entrada.get(entrada.size() - 1));
                System.out.println("Remove os dois ultimos e multiplica: ");
                saida.add(maior);
                s.add(holder);
                System.out.println("Vetor A: " + entrada.toString() + " Vetor B: " + saida.toString());
            } else if (holder == 4) {
                System.out.println("Vetor A antes da operação: " + entrada.toString() + " Vetor B antes da operaçao: " + saida.toString());
                entrada.remove(entrada.get(entrada.size() - 2));
                entrada.remove(entrada.get(entrada.size() - 1));
                System.out.println("Inverte remove os dois ultimos e multiplica: ");
                saida.add(maior);
                s.add(holder);
                System.out.println("Vetor A: " + entrada.toString() + " Vetor B: " + saida.toString());
            }
            if (entrada.size() == 1) {
                System.out.println("Vetor A antes da operação: " + entrada.toString() + " Vetor B antes da operaçao: " + saida.toString());
                System.out.println("Remove o ultimo: ");
                saida.add(removeLast(entrada));
                s.add(2);
                entrada.remove(entrada.get(entrada.size() - 1));
                System.out.println("Vetor A: " + entrada.toString() + " Vetor B: " + saida.toString());
            }
        }
        System.out.println("Soma das operações: " + soma(saida));
        System.out.println("Conjunto solução da operação: " + s.toString());
    }







    public static int soma(ArrayList<Integer> p) {
        int resultado = 0;
        for (int elemento : p) {
            resultado += elemento;
        }
        return resultado;
    }

    public static String toString(ArrayList a) {
        StringBuilder result = new StringBuilder();
        for (Object e : a) {
            result.append(e);
        }
        return result.toString();
    }

    public static void inversion(ArrayList a) {
        Collections.reverse(a);
    }

    public static int removeLast(ArrayList<Integer> a) {
        int maior = 0;
        maior = (a.get(a.size() - 1));
        return maior;
    }

    public static int removeTwoLast(ArrayList<Integer> a) {
    int maior = 0;
    maior = ((a.get(a.size() - 2)) * (a.get((a.size() - 1))));
    return maior;
    }

    public static void main(String[] args) {
        ArrayList op = new ArrayList();
        op.add(1);
        op.add(2);
        op.add(3);
        op.add(4);

        ArrayList a = new ArrayList();
        a.add(1);
        a.add(4);
        a.add(2);
        a.add(3);
        a.add(5);

        ArrayList b = new ArrayList();
        ArrayList s = new ArrayList();
        choose(a, b, s);
    }
}

