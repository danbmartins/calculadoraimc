import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame {

    private JTextField campoPeso;
    private JTextField campoAltura;
    private JButton botaoCalcular;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel labelPeso = new JLabel("Peso (Kg):");
        labelPeso.setBounds(20, 20, 100, 25);
        add(labelPeso);

        campoPeso = new JTextField();
        campoPeso.setBounds(120, 20, 140, 25);
        add(campoPeso);

        JLabel labelAltura = new JLabel("Altura (Cm):");
        labelAltura.setBounds(20, 60, 100, 25);
        add(labelAltura);

        campoAltura = new JTextField();
        campoAltura.setBounds(120, 60, 140, 25);
        add(campoAltura);

        botaoCalcular = new JButton("Calcular IMC");
        botaoCalcular.setBounds(70, 110, 150, 30);
        add(botaoCalcular);

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(campoPeso.getText());
            double alturaCm = Double.parseDouble(campoAltura.getText());
            double alturaM = alturaCm / 100;
            double imc = peso / (alturaM * alturaM);
            String classificacao;

            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (imc < 24.9) {
                classificacao = "Peso normal";
            } else if (imc < 29.9) {
                classificacao = "Sobrepeso";
            } else if (imc < 34.9) {
                classificacao = "Obesidade grau I";
            } else if (imc < 39.9) {
                classificacao = "Obesidade grau II";
            } else {
                classificacao = "Obesidade grau III ou mórbida";
            }

            String mensagem = String.format("Seu IMC é: %.2f\nClassificação: %s", imc, classificacao);
            JOptionPane.showMessageDialog(this, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraIMC().setVisible(true));
    }
}