package desafios;

import java.io.IOException;
import java.util.Scanner;

public class Fibonacci {
    
    public static void main(String[] args) throws IOException {
        
        int proximo, anterior = 0, atual= 1;
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        
        for (int i = 1; i <= N; i++) {
            
            if (i == N) {
                System.out.println(anterior);
            } else {
                System.out.print(anterior + " ");
                proximo = anterior + atual;
                anterior = proximo - anterior;
                atual = proximo;
            }
            
        }
        
    }
    
}