package leituraescrita;

import java.util.Scanner;
import java.io.FileWriter; // Prepara o arquivo para escrita
import java.io.FileReader; // Prepara o arquivo para leitura
import java.io.BufferedWriter; // Cria o buffer para escrita
import java.io.BufferedReader; // Cria o buffer para leitura
import java.io.IOException; // Tratar erros de IO
import java.util.InputMismatchException;

public class LeituraEscrita {

    public static void menuOpcoes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=============================");
        System.out.println("1 - Arquivo existente");
        System.out.println("2 - Novo arquivo");
        System.out.println("3 - Ler um arquivo");
        System.out.println("0 - Sair");
        System.out.println("=============================");
    }

    public static int opcao() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        try {
            switch (n) {
                case 1:
                    // Arquivo existente
                    System.out.print("Digite o local do arquivo: ");
                    criarTxt();
                    break;
                case 2:
                    // Novo arquivo
                    System.out.print("Digite o local para salvar o arquivo: ");
                    criarTxt();
                    break;
                case 0:
                    // Encerra o programa
                    System.out.println("Fim do programa!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro! O valor digitado não é válido. Tente novamente!");
        }
        return n;
    }

    public static void criarTxt() {
        try {
            Scanner sc = new Scanner(System.in);
            // Passando o parâmetro true, não é feito a sobrescrição do arquivo
            FileWriter arquivo = new FileWriter(sc.nextLine(), true);
            BufferedWriter buffer = new BufferedWriter(arquivo);
            System.out.println("===== Agora só digitar igual um animal =====");
            buffer.append(sc.nextLine());
            buffer.close();
            arquivo.close();
            //sc.close();
        } catch (IOException e) {
            System.out.println("Amigo, não zoar");
        }
    }

    public static void main(String[] args) {

        int programa = 20;
        while (programa != 0) {
            menuOpcoes();
            try {
                programa = opcao();
            } catch (InputMismatchException e) {
                System.out.println("Erro! O valor digitado não é válido é uma opção válida!");
            }
        }
    }

}
