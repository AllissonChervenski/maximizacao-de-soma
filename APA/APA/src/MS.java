import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MS {
    public static ArrayList<Integer> A = new ArrayList<Integer>();
    public ArrayList P = new ArrayList();

    public static void inversion(ArrayList a){
        Collections.reverse(a);
    }

    public static void removeLast(ArrayList<Integer> a, ArrayList<Integer> p){
        if(a.size() > 0) {
            p.add(a.get(a.size()-1));
        }
    }

    public static void removeTwoLast(ArrayList<Integer> a, ArrayList<Integer> p){
        if(a.size() > 1){
            p.add((a.get(a.size() - 2)) * (a.get((a.size() - 1 ))));
        }
    }

    public static void bruteForce(ArrayList<Integer> a){
            ArrayList<Integer> p = new ArrayList<>();
            bruteForce(a, p);
    }

    public static void bruteForce(ArrayList<Integer> a, ArrayList<Integer> p){
        if(a.size() == 0){
                System.out.println("Lista dos numero: " + p.toString());
                System.out.println("Soma dos numeros: " + soma(p));
            }

            else{
                for(int i = 0; i <= a.size(); i++){
                    removeLast(a, p);
                    bruteForce(a, p);
                }
            }
    }

    public static int soma(ArrayList<Integer> p){
        int resultado = 0;
        for (int elemento : p) {
            resultado += elemento;
        }
        return resultado;
    }

    public static void main(String[] args) {
       ArrayList<Integer> a = new ArrayList<Integer>();
       a.add(1);
       a.add(5);
       a.add(6);
       bruteForce(a);
           }
}
