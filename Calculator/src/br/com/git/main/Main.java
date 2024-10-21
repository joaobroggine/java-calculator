package br.com.git.main;

import java.io.IOException;

import javax.swing.JFrame;

import br.com.git.beans.Interface;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		JFrame ui = Interface.calculator();
		ui.setVisible(true);
		
	}

}
