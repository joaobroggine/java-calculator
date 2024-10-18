package br.com.git.beans;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Calculo {

	private static boolean sum = false;
	private static boolean minus = false;
	private static boolean times = false;
	private static boolean divide = false;
    private static boolean firstNumberSet = false;
    private static String number1String = "";
    private static String number2String = "";
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
            if (!firstNumberSet) {
                firstNumberSet = true;
				resultLabel.setText(number1String + " + ");
				sum = true;
            }
        });
        
        return sumbutton;
    }
    
    public static JButton minus() {
        JButton minusbutton = new JButton("-");
        minusbutton.setBackground(Color.GRAY);
        minusbutton.setFocusPainted(false);
        
        minusbutton.addActionListener(e -> {
            if (!firstNumberSet) {
                firstNumberSet = true;
				resultLabel.setText(number1String + " - ");
				minus = true;
            }
        });
        
        return minusbutton;
    }
    
    public static JButton times() {
        JButton timesbutton = new JButton("x");
        timesbutton.setBackground(Color.GRAY);
        timesbutton.setFocusPainted(false);
        
        timesbutton.addActionListener(e -> {
            if (!firstNumberSet) {
                firstNumberSet = true;
				resultLabel.setText(number1String + " x ");
				times = true;
            }
        });
        
        return timesbutton;
    }
    
    public static JButton divide() {
        JButton dividebutton = new JButton("÷");
        dividebutton.setBackground(Color.GRAY);
        dividebutton.setFocusPainted(false);
        
        dividebutton.addActionListener(e -> {
            if (!firstNumberSet) {
                firstNumberSet = true;
				resultLabel.setText(number1String + " ÷ ");
				divide = true;
            }
        });
        
        return dividebutton;
    }
    
    public static JButton equal() {
        JButton equal = new JButton("=");
        equal.setBackground(Color.GRAY);
        equal.setFocusPainted(false);
        
        equal.addActionListener(e -> {
        	if (firstNumberSet && !number2String.isEmpty() && sum == true) {
                int number1 = Integer.parseInt(number1String);
                int number2 = Integer.parseInt(number2String);
                int sum = number1 + number2;
                updateResult(String.valueOf(sum));
                resetCalculation();
        	}
        	if(firstNumberSet && !number2String.isEmpty() && minus == true) {
        		int number1 = Integer.parseInt(number1String);
                int number2 = Integer.parseInt(number2String);
                int minus = number1 - number2;
                updateResult(String.valueOf(minus));
                resetCalculation();
        	}
        	if(firstNumberSet && !number2String.isEmpty() && times == true) {
        		int number1 = Integer.parseInt(number1String);
                int number2 = Integer.parseInt(number2String);
                int times = number1 * number2;
                updateResult(String.valueOf(times));
                resetCalculation();
        	}
        	if(firstNumberSet && !number2String.isEmpty() && divide == true) {
        		int number1 = Integer.parseInt(number1String);
                int number2 = Integer.parseInt(number2String);
                double divide = (double) number1 / number2;
                updateResult(String.valueOf(divide));
                resetCalculation();
        	}
        });
        
        return equal;
    }
    
    public static JButton erase() {
    	JButton c = new JButton("C");
        c.setBackground(Color.GRAY);
        c.setFocusPainted(false);
        
        c.addActionListener(e -> {
        	resetCalculation();
        	updateResult("0");
        });
        
        return c;
    }

    public static void setResultLabel(JLabel resultLabel) {
        Calculo.resultLabel = resultLabel;
    }

    private static void handleNumber(int num) {
        if (!firstNumberSet) {
            number1String += num;            
            resultLabel.setText(number1String);
            
        } else if (sum == true) {
            number2String += num;
            resultLabel.setText(number1String + " + " + number2String);
        }
        else if (minus == true) {
        	number2String += num;
            resultLabel.setText(number1String + " - " + number2String);
        }
        else if (times == true) {
        	number2String += num;
            resultLabel.setText(number1String + " x " + number2String);
        }
        else if (divide == true) {
        	number2String += num;
            resultLabel.setText(number1String + " ÷ " + number2String);
        }
    }


    private static void updateResult(String result) {
        if (resultLabel != null) {
            resultLabel.setText(result);
        }
    }

    private static void resetCalculation() {
        number1String = "";
        number2String = "";
        firstNumberSet = false;
        sum = false;
        minus = false;
        times = false;
    	divide = false;
    }

	public int getNumber() {
		return 0;
	}
}
