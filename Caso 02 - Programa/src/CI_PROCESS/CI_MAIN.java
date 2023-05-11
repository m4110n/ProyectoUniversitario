package CI_PROCESS;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CI_MAIN {
    private static CI_LOGIN CI_MAIN_VTN_LOGIN;
    private static CI_MC001 CI_MAIN_VTN_MC001;
    private static CI_ME001 CI_MAIN_VTN_ME001;
    private static CI_ME002 CI_MAIN_VTN_ME002;
    private static CI_ME003 CI_MAIN_VTN_ME003;
    private static CI_DBO CI_MAIN_CLS_DBO;

    //METODO PRINCIPAL
    public static void main(String[] args) {
        
        //Inicializar miembros
        CI_MAIN_VTN_LOGIN = new CI_LOGIN();
        CI_MAIN_VTN_MC001 = new CI_MC001();
        CI_MAIN_VTN_ME001 = new CI_ME001();
        CI_MAIN_VTN_ME002 = new CI_ME002();
        CI_MAIN_VTN_ME003 = new CI_ME003();
        
        //Llamar a la clase CI_LOGIN
        CI_MAIN_VTN_LOGIN.setVisible(true);
    }

    //METODO PARA CERRAR POR COMPLETO EL PROGRAMA
    public static void confirmarSalida(JFrame CI_MAIN_NOCLOSE_VTN) {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir del aplicativo?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            
            //Finaliza por completo el programa
            System.exit(0); 
        } else {
            
            //Evita el cierre de la ventana CI_LOGIN
            CI_MAIN_NOCLOSE_VTN.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
    
    //Método que envia mensaje a la Base de Datos
    public static void enviarMensaje(String CI_MAIN_OUT_MESSAGE) {
        CI_MAIN_CLS_DBO = new CI_DBO();
        CI_MAIN_CLS_DBO.procesarMensaje(CI_MAIN_OUT_MESSAGE);
    }    
    
    //Método que recibe mensaje de la Base de Datos
    public static void recibeMensaje(String CI_MAIN_INP_MESSAGE) {
        String[] CI_MAIN_DATA = CI_MAIN_INP_MESSAGE.split(";");
        switch (CI_MAIN_DATA[0]){
            case "MC001":
                CI_MAIN_VTN_LOGIN.dispose();
                CI_MAIN_VTN_MC001.setVisible(true);
                break;
            case "ERROR":
                mensajeError(CI_MAIN_DATA[1]);
                break;
            case "ME001":
                CI_MAIN_VTN_LOGIN.dispose();
                CI_MAIN_VTN_ME001.setVisible(true);
                break;
            case "ME002":
                CI_MAIN_VTN_LOGIN.dispose();
                CI_MAIN_VTN_ME002.setVisible(true);
                break;
            case "ME003":
                CI_MAIN_VTN_LOGIN.dispose();
                CI_MAIN_VTN_ME003.setVisible(true);
                break;                
            default:
                break;
        }
    }
    
    //Método que despliega un determinado mensaje de error
    public static void mensajeError(String CI_MAIN_ERROR_MESSAGE){
        switch (CI_MAIN_ERROR_MESSAGE){
            case "001":
                JOptionPane.showMessageDialog(null, "Usuario Inválido, ingrese credenciales correctas", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "098":
                JOptionPane.showMessageDialog(null, "Esta sección del aplicativo se encuentra en fase de desarrollo, vuelva más tarde", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "097":
                JOptionPane.showMessageDialog(null, "Error en archivo de perfiles", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "099":
                JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }
    }
}
