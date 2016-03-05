package test;

import polinomios.*;
import javax.swing.JOptionPane;

public class TestPolinomios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sp;
		String sp2;
		
		sp = JOptionPane.showInputDialog("Introduce primer polinomio");
		Polinomio miPolinomio1 = new Polinomio(sp);
		sp = miPolinomio1.toString();
		
		sp2 = JOptionPane.showInputDialog("Introudce segundo polinomio");
		Polinomio miPolinomio2 = new Polinomio(sp2);
		sp2 = miPolinomio2.toString();
		
		String result = miPolinomio1.suma(miPolinomio2).toString();
		
		JOptionPane.showMessageDialog(null, "Polinomio1: " + sp + "\nPolinomio2: " + sp2 + "\nSuma: " + result);
	}
}