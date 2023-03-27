package desafios;

import java.util.Scanner;

public class Dragao {
    
    public static void main(String[] args) {
        
        int poderDeLuta, casos;
        Scanner ler = new Scanner(System.in);
        
        casos = ler.nextInt();
        
        for (int i = 0; i < casos; i++) {
            poderDeLuta = ler.nextInt();
            if (poderDeLuta > 8000) {
                System.out.println("Mais de 8000!");
            } else if (poderDeLuta <= 8000) {
                System.out.println("Inseto!");
            }   
        }
        
    }
    
}