package CI_PROCESS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CI_DBO {

    //Metodo que procesa el mensaje de entrada
    public void procesarMensaje(String CI_DBO_INP_MESSAGE) {
        
        //Separa los datos delimitados por ";"
        String[] CI_DBO_DATO = CI_DBO_INP_MESSAGE.split(";");
        
        //Valida tipo de solicitud
        switch (CI_DBO_DATO[0]) {
            
                //Inicio de Sesion 
                case "LOGIN":
                    if (CI_DBO_DATO.length >= 4) {
                        CI_DBO_INP_MESSAGE = validationLOGIN(CI_DBO_DATO[1],CI_DBO_DATO[2],CI_DBO_DATO[3]);
                        enviarMensaje(CI_DBO_INP_MESSAGE);
                    }else{
                        CI_DBO_INP_MESSAGE = "ERROR" + ";" + "001";
                        enviarMensaje(CI_DBO_INP_MESSAGE);
                    }
                    break;
                case "ERROR":
                        enviarMensaje(CI_DBO_INP_MESSAGE);
                    break;
                default:
                    break;
            }
    }
    
    //Metodo que envía mensaje de salida
    public void enviarMensaje(String CI_DBO_OUT_MESSAGE) {
        CI_MAIN.recibeMensaje(CI_DBO_OUT_MESSAGE);
    }
    
    //Método valida inicio de sesión
    public static String validationLOGIN(String CI_DBO_TIPE, String CI_DBO_USERNAME, String CI_DBO_PASSWORD) {
        String CI_DBO_REPLY_LOGIN = "";
        switch (CI_DBO_TIPE) {
            
            //Cuando es un usuario Cliente
            case "001":
                
                //Instancia buffer para lectura de archivo
                try (BufferedReader CI_DBO_BR = new BufferedReader(new FileReader("files/clientes.txt"))) {
                    
                    //Instancia linea donde guardara cada registro
                    String CI_DBO_LINE;
                    
                    //Bucle hasta que la linea leida sea vacía
                    while ((CI_DBO_LINE = CI_DBO_BR.readLine()) != null) {
                        String[] CI_DBO_DATA = CI_DBO_LINE.split(";");
                        
                        //Valida que el largo del arreglo seá 3 o mayor
                        if (CI_DBO_DATA.length >= 3) {
                            
                            //Valida usuario y password correctos
                            if (CI_DBO_DATA[1].equals(CI_DBO_USERNAME) && CI_DBO_DATA[2].equals(CI_DBO_PASSWORD)) {
                            CI_DBO_REPLY_LOGIN = "MC001" + ";" + CI_DBO_DATA[0];
                            break;
                            }
                        }
                    }
                
                    //Cuando no encuentra usuario
                    if (CI_DBO_REPLY_LOGIN.isEmpty()) {
                        CI_DBO_REPLY_LOGIN = "ERROR" + ";" + "001";
                    }
                
                //Cuando no existe el archivo
                } catch (IOException e) {
                    CI_DBO_REPLY_LOGIN = "ERROR" + ";" + "099";
                }
                break;
                
            //Cuando es un usuario Empleado   
            case "002":
                
                //Instancia buffer para lectura de archivo
                try (BufferedReader CI_DBO_BR = new BufferedReader(new FileReader("files/empleados.txt"))) {
                    
                    //Instancia linea donde guardara cada registro
                    String CI_DBO_LINE;
                    
                    //Bucle hasta que la linea leida sea vacía
                    while ((CI_DBO_LINE = CI_DBO_BR.readLine()) != null) {
                        String[] CI_DBO_DATA = CI_DBO_LINE.split(";");
                        
                        //Valida que el largo del arreglo seá 2 o mayor
                        if (CI_DBO_DATA.length >= 2) {
                            
                            //Valida usuario y password correctos
                            if (CI_DBO_DATA[0].equals(CI_DBO_USERNAME) && CI_DBO_DATA[1].equals(CI_DBO_PASSWORD)) {
                                CI_DBO_REPLY_LOGIN += validationProfile(CI_DBO_DATA[0]) + ";" + CI_DBO_DATA[0];
                                break;
                            }
                        }
                    }
                    
                    //Cuando no encuentra usuario
                    if (CI_DBO_REPLY_LOGIN.isEmpty()) {
                        CI_DBO_REPLY_LOGIN = "ERROR" + ";" + "001";
                    }
                
                //Cuando no existe el archivo 
                } catch (IOException e) {
                CI_DBO_REPLY_LOGIN = "ERROR" + ";" + "099";
                }
                break;
            default:
                CI_DBO_REPLY_LOGIN = "ERROR" + ";" + "001";
                break;
        }
        return CI_DBO_REPLY_LOGIN;
    }    
    
    public static String validationProfile(String CI_DBO_USERNAME){
        String CI_DBO_REPLY_PROFILE = "";
        //Instancia buffer para lectura de archivo
        try (BufferedReader CI_DBO_BR = new BufferedReader(new FileReader("files/perfiles.txt"))) {
                    
            //Instancia linea donde guardara cada registro
            String CI_DBO_LINE;
                    
            //Bucle hasta que la linea leida sea vacía
            while ((CI_DBO_LINE = CI_DBO_BR.readLine()) != null) {
                String[] CI_DBO_DATA = CI_DBO_LINE.split(";");
                        
                //Valida que el largo del arreglo seá 3 o mayor
                if (CI_DBO_DATA.length >= 2) {
                            
                    //Valida usuario y password correctos
                    if (CI_DBO_DATA[0].equals(CI_DBO_USERNAME)){
                        CI_DBO_REPLY_PROFILE = CI_DBO_DATA[1];
                        break;
                        }
                    }
                }
                //Cuando no encuentra usuario
                if (CI_DBO_REPLY_PROFILE.isEmpty()) {
                    CI_DBO_REPLY_PROFILE = "ERROR" + ";" + "097";
                }
                
                //Cuando no existe el archivo
                } catch (IOException e) {
                    CI_DBO_REPLY_PROFILE = "ERROR" + ";" + "099";
                }
        
        return CI_DBO_REPLY_PROFILE;
    }
}
