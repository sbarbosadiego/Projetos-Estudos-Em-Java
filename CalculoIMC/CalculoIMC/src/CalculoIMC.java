
import java.util.Scanner;

public class CalculoIMC {
    
    // Função para limpar o buffer do scanner
    private static void clearBuffer (Scanner scanner) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    
    public static void main (String[] args) {
        
        String nome;
        
        // Criado entrada pelo teclado
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        nome = teclado.next();
        // Chama a função para limpar o buffer após ler um valor não alfanumérico
        clearBuffer(teclado);
        // Declarado as variáveis e feito um pequeno tratamento com replace
        System.out.print("Informe seu peso: ");
        double peso = Double.parseDouble(teclado.nextLine().replace(",","."));
        System.out.print("Informe sua altura: ");
        double altura = Double.parseDouble(teclado.nextLine().replace(",","."));
        
        /* 
        Criado a variável aonde é feito o cálculo do IMC
        IMC = Peso ÷ (Altura × Altura)
        */
        double imc = peso / (altura * altura);
        
        // Fecha o escaneamento de leitura
        teclado.close();
        
        System.out.printf("%s você pesa %.1f Kg, e tem %.2f centímetros de altura\n"
                + "Atualmente seu IMC é de %.2f, que é ", nome, peso, altura, imc);
        
        if (imc < 16.9) {
            System.out.println("Muito abaixo do peso");
        } else if (imc == 17.0 || imc <= 18.4) {
            System.out.println("Abaixo do peso");
        } else if (imc == 18.5 || imc <= 24.9) {
            System.out.println("Peso normal");
        } else if (imc == 25.0 || imc <= 29.9) {
            System.out.println("Acima do peso");
        } else if (imc == 30.0 || imc <= 34.9) {
            System.out.println("Obesidade grau I");
        } else if (imc == 35.0 || imc <= 39.9) {
            System.out.println("Obesidade grau II");
        } else {
            System.out.println("Obesidade grau III");
        }
        
        
        
        /*
        *Também seria possível fazer o teste usando um &&
        if (imc < 16.9) {
            System.out.println("Muito abaixo do peso");
        } else if (imc >= 17.0 && imc <= 18.4) {
            System.out.println("Abaixo do peso");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("Peso normal");
        } else if (imc >= 25.0 && imc <= 29.9) {
            System.out.println("Acima do peso");
        } else if (imc >= 30.0 && imc <= 34.9) {
            System.out.println("Obesidade grau I");
        } else if (imc >= 35.0 && imc <= 39.9) {
            System.out.println("Obesidade grau II");
        } else {
            System.out.println("Obesidade grau III");
        }
        
        *Outra forma de fazer o teste de condicional:
        if (imc <= 16.9) {
            System.out.println("Muito abaixo do peso");
        } else {
            if (imc >= 17.0 || imc <= 18.4) {
                System.out.println("Abaixo do peso");
            } else {
                if (imc >= 18.5 || imc <= 24.9) {
                    System.out.println("Peso normal");
                } else {
                    if (imc >= 25.0 || imc <= 29.9) {
                        System.out.println("Acima do peso");
                    } else {
                        if (imc >= 30.0 || imc <= 34.9) {
                            System.out.println("Obesidade grau I");
                        } else {
                            if (imc >= 35.0 || imc <= 39.9) {
                                System.out.println("Obesidade grau II");
                            } else {
                                System.out.println("Obesidade grau III");
                            }
                        }
                    }
                }
            }
        }
        */
        
    }
}
