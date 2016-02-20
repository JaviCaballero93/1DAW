package test;

import javax.swing.JOptionPane;
import objects.Password;

public class PasswordTest {
 
    public static void main(String[] args) {
 
        //Introducimos el tamaño del array y la longitud del password
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Introduce un tamaño para el array"));
        int longitud = Integer.parseInt(JOptionPane.showInputDialog("Introduce la longitud del password"));
        String text = "";
 
        //Creamos los arrays
        Password contraseñas[] = new Password[tamaño];
        boolean fortaleza[] = new boolean[tamaño];
 
        //Creamos objetos, indicamos si es fuerte y mostramos la contraseña y su fortaleza.
        for(int i=0; i<contraseñas.length; i++){
            
        	contraseñas[i] = new Password(longitud);
            fortaleza[i] = contraseñas[i].esFuerte();
            text += contraseñas[i].getContraseña() + " " + fortaleza[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, text);
    }
}