import java.util.Scanner;
public class Exemplo02{
    public Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("um a cem");
        umCem();
        System.out.println("\n\n impares ");
        impares();
        System.out.println("\n\n pares");
        pares();
        System.out.println("\n\nmultiplos de 3");
        multiplosTres();
        System.out.println("\n\nsequencia");
        sequencia();
    }
    public static void umCem(){
        for(int i = 1; i<101; i++){
            System.out.printf(i+", ");
        }
    }
    public static void impares (){
        for(int i = 1; i<100; i+=2){
            System.out.printf(i+", ");
        }
    }
    public static void pares(){
        for(int i = 2; i<101; i+=2){
            System.out.printf(i+", ");
        }
    }
    public static void multiplosTres(){
        for(int i = 3; i<100; i+=3){
            System.out.printf(i+", ");
        }
    }
    public static void sequencia(){
        for(int  i =1; i<100; i++){
            if (i%3 == 0 || i%10 == 3) {
                System.out.printf(i+", ");
            }
        }
    }
    
}

