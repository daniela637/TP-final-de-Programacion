
package utiles;

import java.util.Scanner;


public class Validador {
     private Scanner sc;

    public Validador(Scanner sc) {
        this.sc = sc;
    }

    
    public int validarInt (String pregunta, String error){
       boolean isCorrecto = false;
        System.out.println(pregunta);
        while(!isCorrecto){
          
            String sIngresado = sc.next();
            
            try{
                int retorno = Integer.parseInt(sIngresado);
                  if(retorno > 0){
                       return retorno;
                  }
               
              
            }catch(Exception e){
                
                
            }
            System.out.println(error);
        }
        return 0;
    }
    
    public double validarDouble (String pregunta, String error){
         boolean isCorrecto = false;
        System.out.println(pregunta);
        while(!isCorrecto){
          
            String sIngresado = sc.next();
            
            try{
                double retorno = Double.parseDouble(sIngresado);
                  if (retorno >0){
                       return retorno;
                  }
               
              
            }catch(Exception e){
              
                
            }
              System.out.println(error);
        }
        return 0;
    }
}
