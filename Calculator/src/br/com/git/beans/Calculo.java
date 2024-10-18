package br.com.git.beans;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Calculo {

    private static int number1 = 0;
    private static int number2 = 0;
    private static boolean firstNumberSet = false;
    private static boolean secondNumberSet = false;
    private static JLabel resultLabel;

    public Calculo() {}

    public static JButton zero() {
        JButton zero = new JButton("0");
        zero.setBackground(Color.GRAY);
        zero.setFocusPainted(false);
        
        zero.addActionListener(e -> handleNumber(0));
        
        return zero;
    }

    public static JButton one() {
        JButton one = new JButton("1");
        one.setBackground(Color.GRAY);
        one.setFocusPainted(false);
        
        one.addActionListener(e -> handleNumber(1));
        
        return one;
    }

    public static JButton two() {
        JButton two = new JButton("2");
        two.setBackground(Color.GRAY);
        two.setFocusPainted(false);
        
        two.addActionListener(e -> handleNumber(2));
        
        return two;
    }

    public static JButton three() {
        JButton three = new JButton("3");
        three.setBackground(Color.GRAY);
        three.setFocusPainted(false);
        
        three.addActionListener(e -> handleNumber(3));
        
        return three;
    }

    public static JButton four() {
        JButton four = new JButton("4");
        four.setBackground(Color.GRAY);
        four.setFocusPainted(false);
        
        four.addActionListener(e -> handleNumber(4));
        
        return four;
    }

    public static JButton five() {
        JButton five = new JButton("5");
        five.setBackground(Color.GRAY);
        five.setFocusPainted(false);
        
        five.addActionListener(e -> handleNumber(5));
        
        return five;
    }

    public static JButton six() {
        JButton six = new JButton("6");
        six.setBackground(Color.GRAY);
        six.setFocusPainted(false);
        
        six.addActionListener(e -> handleNumber(6));
        
        return six;
    }

    public static JButton seven() {
        JButton seven = new JButton("7");
        seven.setBackground(Color.GRAY);
        seven.setFocusPainted(false);
        
        seven.addActionListener(e -> handleNumber(7));
        
        return seven;
    }

    public static JButton eight() {
        JButton eight = new JButton("8");
        eight.setBackground(Color.GRAY);
        eight.setFocusPainted(false);
        
        eight.addActionListener(e -> handleNumber(8));
        
        return eight;
    }

    public static JButton nine() {
        JButton nine = new JButton("9");
        nine.setBackground(Color.GRAY);
        nine.setFocusPainted(false);
        
        nine.addActionListener(e -> handleNumber(9));
        
        return nine;
    }

    public static JButton sum() {
        JButton sumbutton = new JButton("+");
        sumbutton.setBackground(Color.GRAY);
        sumbutton.setFocusPainted(false);
        
        sumbutton.addActionListener(e -> {
            if (firstNumberSet) {
                resultLabel.setText(number1 + " + ");
            }
        });
        
        return sumbutton;
    }
    
    public static JButton equal() {
        JButton equal = new JButton("=");
        equal.setBackground(Color.GRAY);
        equal.setFocusPainted(false);
        
        equal.addActionListener(e -> {
            if (firstNumberSet && secondNumberSet) {
                int sum = number1 + number2;
                updateResult(String.valueOf(sum));
                resetCalculation();
            }
        });
        
        return equal;
    }

    public static void setResultLabel(JLabel resultLabel) {
        Calculo.resultLabel = resultLabel;
    }

    private static void handleNumber(int num) {
        if (!firstNumberSet) {
            number1 = num;
            resultLabel.setText(String.valueOf(number1));
            firstNumberSet = true;
        } else if (!secondNumberSet) {
            number2 = num;
            resultLabel.setText(resultLabel.getText() + String.valueOf(number2));
            secondNumberSet = true;
        }
    }

    private static void updateResult(String result) {
        if (resultLabel != null) {
            resultLabel.setText(result);
        }
    }

    private static void resetCalculation() {
        number1 = 0;
        number2 = 0;
        firstNumberSet = false;
        secondNumberSet = false;
    }

	public int getNumber() {
		return 0;
	}
}
