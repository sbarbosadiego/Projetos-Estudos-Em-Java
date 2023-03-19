package leituraescrita;

import java.util.Scanner;
import java.io.FileWriter; // Prepara o arquivo para escrita
import java.io.FileReader; // Prepara o arquivo para leitura
import java.io.BufferedWriter; // Cria o buffer para escrita
import java.io.BufferedReader; // Cria o buffer para leitura
import java.io.FileNotFoundException;
import java.io.IOException; // Tratar erros de IO
import java.util.InputMismatchException;

public class LeituraEscrita {

    /**
     * Método para imprimir o menu
     */
    public static void menuOpcoes() {
        Scanner sc = new Scanner(System.in, "latin1");
        System.out.println("\n==================== M E N U ====================");
        System.out.println("1 - Novo arquivo de Texto");
        System.out.println("2 - Sobrescrever arquivo existente");
        System.out.println("3 - Escrever em um arquivo Existente");
        System.out.println("4 - Ler um arquivo");
        System.out.println("0 - Sair");
        System.out.print("Informe a opção: ");
    }

    /**
     * Método para carregar os métodos contidos nas opções do menu
     * @return int
     */
    public static int opcao() {
        Scanner sc = new Scanner(System.in, "latin1");
        int n = sc.nextInt();
        try {
            switch (n) {
                case 1:
                    // Novo arquivo de Texto
                    System.out.print("Digite o local do arquivo: ");
                    criarTxt();
                    break;
                case 2:
                    // Sobrescrever arquivo existente
                    System.out.print("Digite o local para salvar o arquivo: ");
                    sobrescreverTxt();
                    break;
                case 3:
                    // Escrever em um arquivo Existente
                    System.out.print("Digite o local do arquivo: ");
                    criarTxt();
                    break;
                case 4:
                    // Ler um arquivo
                    System.out.print("Digite o local do arquivo: ");
                    lerTxt();
                    break;
                case 0:
                    // Encerra o programa
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("Informe a opção: ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro! O valor digitado não é válido. Tente novamente!");
        }
        return n;
    }

    /**
     * Método para criar um novo arquivo de texto
     */
    public static void criarTxt() {
        try {
            Scanner sc = new Scanner(System.in, "latin1");
            // Passando o parâmetro true, não é feito a sobrescrição do arquivo
            FileWriter arquivo = new FileWriter(sc.nextLine(), true);
            BufferedWriter buffer = new BufferedWriter(arquivo);
            System.out.println("======= PARA SALVAR O TEXTO DIGITE \"FFGG\" =======");
            System.out.println("=============== DIGITE NO ARQUIVO ===============");
            boolean salvar = false;
            String linha = "";
            do {
                linha = sc.nextLine();
                if (linha.contains("FFGG")) {
                    salvar = true;
                } else {
                    linha += "\n";
                    buffer.append(linha);
                }
            } while (salvar == false);
            buffer.close();
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Não foi informado nenhum caminho de diretório válido");
        }
    }

    /**
     * Método que sobrescreve o conteúdo de um arquivo de texto existente
     */
    public static void sobrescreverTxt() {
        try {
            Scanner sc = new Scanner(System.in, "latin1");
            // Passando o parâmetro true, não é feito a sobrescrição do arquivo
            FileWriter arquivo = new FileWriter(sc.nextLine(), false);
            BufferedWriter buffer = new BufferedWriter(arquivo);
            System.out.println("======= PARA SALVAR O TEXTO DIGITE \"FFGG\" =======");
            System.out.println("=============== DIGITE NO ARQUIVO ===============");
            boolean salvar = false;
            String linha = "";
            do {
                linha = sc.nextLine();
                if (linha.contains("FFGG")) {
                    salvar = true;
                } else {
                    linha += "\n";
                    buffer.append(linha);
                }
            } while (salvar == false);
            buffer.close();
            arquivo.close();
            //sc.close();
        } catch (IOException e) {
            System.out.println("Não foi informado nenhum caminho de diretório válido");
        }
    }

    /**
     * Método que lê o contéudo do arquivo de texto
     */
    public static void lerTxt() {
        try {
            Scanner sc = new Scanner(System.in, "latin1");
            FileReader arquivo = new FileReader(sc.nextLine());
            BufferedReader buffer = new BufferedReader(arquivo);
            System.out.println(" ");
            System.out.println("============== CONTEÚDO DO ARQUIVO ==============");
            String linha = buffer.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = buffer.readLine();
            }
            buffer.close();
            arquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! Digite o caminho completo do arquivo");
        } catch (IOException a) {
            System.out.println("Amigo, não zoar");
        }
    }

    public static void main(String[] args) {

        int programa = 5;
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
