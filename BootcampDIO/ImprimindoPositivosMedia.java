import java.io.IOException;
import java.util.Scanner;

public class DIO {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int cont = 0;
        double media = 0;
        double x = 0;

        //TODO: Implemente as condições adequadas para obter a quantidade 
        //de valores positivos e a média dos valores positivos:

        /**
         * Poderia ser criado uma entrada que pergunta quantos valores serão digitados
         * System.out.print("Será digitado quantos números? ");
         * int contador = leitor.nextInt();
         */
        
        System.out.print("Será digitado quantos números? ");
        int contador = leitor.nextInt();
        for (int c = 0; c < 6; c++) {
            x = leitor.nextDouble();
            if (x > 0) {
                cont++;
                media += x;
            }
        }
        
        media = media / cont;
        System.out.println(cont + " valores positivos");
        System.out.println(String.format("%.1f", media));
        
    }

}