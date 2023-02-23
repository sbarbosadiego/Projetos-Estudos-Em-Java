
package calculo;

import javax.swing.JOptionPane;

public class Classes {
    
    public String nome;
    public int idade;
    public double peso;
    public double altura;
    private double imc;
    
    public void cadastro() {
        nome = JOptionPane.showInputDialog("Qual seu nome? ");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade:"));
        peso = Double.parseDouble(JOptionPane.showInputDialog("Informe seu peso:").replace(",","."));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura:").replace(",","."));
    }
    
    private void calculoDoIMC() {
        this.imc = this.peso / (this.altura * this.altura);
    }
    
    public void status() {
        this.calculoDoIMC();
        String classificacao = "";
        if (imc < 16.9) {
            classificacao = "Muito abaixo do peso";
        } else if (imc == 17.0 || imc <= 18.4) {
            classificacao = "Abaixo do peso";
        } else if (imc == 18.5 || imc <= 24.9) {
            classificacao = "Peso normal";
        } else if (imc == 25.0 || imc <= 29.9) {
            classificacao = "Acima do peso";
        } else if (imc == 30.0 || imc <= 34.9) {
            classificacao = "Obesidade grau I";
        } else if (imc == 35.0 || imc <= 39.9) {
            classificacao = "Obesidade grau II";
        } else {
            classificacao = "Obesidade grau III";
        }
        String texto = String.format("%s você pesa %.1f Kg, e tem %.2f centímetros de altura\n"
                + "Atualmente seu IMC é de %.2f, que é ", nome, peso, altura, imc);
        JOptionPane.showMessageDialog(null,texto+classificacao);
    }
}
