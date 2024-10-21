package br.com.git.beans;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface {

    @SuppressWarnings("static-access")
    public static JFrame calculator() throws IOException {
        
        JFrame ui = new JFrame("Calculator");
        
        Image icon = ImageIO.read(new File("img/logo.png"));
        ui.setIconImage(icon);

        JButton[] buttons = new JButton[]{
        		Calculo.erase(), Calculo.one(), Calculo.two(), Calculo.divide(),
                Calculo.three(), Calculo.four(), Calculo.five(), Calculo.sum(),
                Calculo.six(), Calculo.seven(), Calculo.eight(), Calculo.minus(),      
                Calculo.nine(), Calculo.zero(), Calculo.symbols(), Calculo.times(),
                Calculo.byOne(), Calculo.exponentiation(), Calculo.squareRoot(),
                Calculo.equal()
            };
        
        Calculo calculo = new Calculo();
        int number = calculo.getNumber();
        
        String numberAsString = String.valueOf(number);
        
        JLabel resultLabel = new JLabel(numberAsString, JLabel.RIGHT);
        calculo.setResultLabel(resultLabel);
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.WHITE);
        resultLabel.setForeground(Color.BLACK);
        resultLabel.setFont(resultLabel.getFont().deriveFont(40f));
        
        Font buttonFont = new Font("Arial", Font.BOLD, 24);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 3));    
        
        for (JButton button : buttons) {
        	button.setBackground(Color.decode("#ADD8E6"));
        	button.setFocusPainted(false);
        	button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            button.setFont(buttonFont);
            buttonPanel.add(button);
        }

        ui.setLayout(new BorderLayout());
        
        ui.add(resultLabel, BorderLayout.NORTH);
        ui.add(buttonPanel, BorderLayout.CENTER);
        
        try {
            ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ui.setResizable(false);
            ui.setSize(320, 500);
            ui.setVisible(true);
                
        } catch (Exception e) {
            System.exit(0);
        }
        
        return ui;
    }
}
