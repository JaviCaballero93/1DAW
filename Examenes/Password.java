package objects;

public class Password {
	 
    private final static int LONGITUD_POR_DEFECTO = 8;
    private int longitud;
    private String contrase�a;
    
    public Password() {
        
    	this(LONGITUD_POR_DEFECTO);
    }
 
    public Password(int longitud) {
        
    	this.longitud = longitud;
        contrase�a = generarPassword();
    }
    
    public String getContrase�a() {
        
    	return contrase�a;
    }
    
    public int getLongitud() {
        
    	return longitud;
    }
    
    public void setLongitud(int longitud) {
        
    	this.longitud = longitud;
    }
 
    public String generarPassword() {
        
    	String password = "";
        
    	for (int i=0; i<longitud; i++) {
            //Generamos un numero aleatorio, segun este elige si a�adir una minuscula, mayuscula o numero
            int eleccion = ((int)Math.floor(Math.random()* 3 + 1));
 
            if (eleccion==1) {
            	
                char minusculas = (char)(Math.floor(Math.random()* 26 + 'a'));
                password += minusculas;
            }
            
            else if(eleccion==2) {
            	char mayusculas = (char)(Math.floor(Math.random()*26 + 'A'));
                password += mayusculas;
             }
            
            else {
            	char numeros = (char)(Math.floor(Math.random()*10 + '0'));
            	password += numeros;
            } 
        }
    	
        return password;
    }
 
    public boolean esFuerte() {
    	
        int countNum = 0;
        int countMin = 0;
        int countMay = 0;
        
        //Vamos caracter a caracter y comprobamos que tipo de caracter es
        for (int i=0; i<contrase�a.length(); i++) {
                if(contrase�a.charAt(i)>='a' && contrase�a.charAt(i)<='z')
                    countMin += 1;
                
                else if(contrase�a.charAt(i)>='A' && contrase�a.charAt(i)<='Z') 
                	countMay += 1;
                
                else
                    countNum += 1;
        }
        
        //Si la constrase�a tiene mas de 5 numeros, mas de 1 minuscula y mas de 2 mayusculas
        if (countNum>=5 && countMin>=1 && countMay>=2)
        	return true;
            
        return false;
    }
}