package br.com.git.beans;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface {
	
	@SuppressWarnings("static-access")
	public static JFrame calculator() {
		
		// Criação da janela principal da calculadora
		JFrame ui = new JFrame("Calculator");
		
		// Criação dos botões da calculadora
		JButton zero = Calculo.zero();
		JButton one = Calculo.one();
		JButton two = Calculo.two();
		JButton three = Calculo.three();
		JButton four = Calculo.four();
		JButton five = Calculo.five();
		JButton six = Calculo.six();
		JButton seven = Calculo.seven();
		JButton eight = Calculo.eight();
		JButton nine = Calculo.nine();
		JButton sum = Calculo.sum();
		JButton equal = Calculo.equal();
		
		Calculo calculo = new Calculo();
		int number = calculo.getNumber();
		
		
		String numberAsString = String.valueOf(number);
		
		// Criação da área de resultado
		JLabel resultLabel = new JLabel(numberAsString, JLabel.RIGHT);  // Alinha à direita
		calculo.setResultLabel(resultLabel);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.WHITE);  // Cor de fundo para parecer uma tela
		resultLabel.setForeground(Color.BLACK);  // Cor do texto
		resultLabel.setFont(resultLabel.getFont().deriveFont(30f)); // Tamanho da fonte
		
		// Criação do painel de botões com GridLayout (4 linhas, 3 colunas)
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 3));
		
		// Adiciona os botões ao painel
		buttonPanel.add(seven);
		buttonPanel.add(eight);
		buttonPanel.add(nine);
		buttonPanel.add(four);
		buttonPanel.add(five);
		buttonPanel.add(six);
		buttonPanel.add(one);
		buttonPanel.add(two);
		buttonPanel.add(three);
		buttonPanel.add(zero);
		buttonPanel.add(sum);
		buttonPanel.add(equal);

		// Configuração do layout da janela principal com BorderLayout
		ui.setLayout(new BorderLayout());
		
		// Adiciona a área de resultado ao topo
		ui.add(resultLabel, BorderLayout.NORTH);
		
		// Adiciona o painel de botões ao centro
		ui.add(buttonPanel, BorderLayout.CENTER);
		
	    try {
	    	ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	ui.setResizable(false);
	    	ui.setSize(320, 500);
	    	
	    	// Exibe a janela
	    	ui.setVisible(true);
	            
		} catch (Exception e) {
			System.exit(0);
		}
		
		return ui;
	}
}
