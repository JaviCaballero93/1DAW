package test;

import javax.swing.JOptionPane;
import objects.Password;

public class PasswordTest {
 
    public static void main(String[] args) {
 
        //Introducimos el tama�o del array y la longitud del password
        int tama�o = Integer.parseInt(JOptionPane.showInputDialog("Introduce un tama�o para el array"));
        int longitud = Integer.parseInt(JOptionPane.showInputDialog("Introduce la longitud del password"));
        String text = "";
 
        //Creamos los arrays
        Password contrase�as[] = new Password[tama�o];
        boolean fortaleza[] = new boolean[tama�o];
 
        //Creamos objetos, indicamos si es fuerte y mostramos la contrase�a y su fortaleza.
        for(int i=0; i<contrase�as.length; i++){
            
        	contrase�as[i] = new Password(longitud);
            fortaleza[i] = contrase�as[i].esFuerte();
            text += contrase�as[i].getContrase�a() + " " + fortaleza[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, text);
    }
}