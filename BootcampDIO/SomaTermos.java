package desafios;

import java.util.Scanner;

public class SomaTermos {
    
    public static void main(String[] args) {
        
        /**
         * Neste desafio, faça um programa que calcule o valor de H com N termos.
         * Sendo, H = 1 + 1/2 + 1/3 + 1/4 + ... + 1/N.
         */
        double h = 0;
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        
        
        for (double i = 1; i <= n; i++) {
            h += 1/i;
        }
        
        System.out.println(Math.round(h));
        sc.close();
    }
    
}