package CI_PROCESS;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CI_MC001 extends javax.swing.JFrame {
    
    public CI_MC001() {
        initComponents();
        
        //Centrar Ventana
        setLocationRelativeTo(null);        
        
        //BTN "X" = Llamar al metodo Confirmar Salida
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CI_MAIN.confirmarSalida(CI_MC001.this);
            }
        });
        
        //BTN Cerrar Sesión = Regresa al menú de LOGIN
        CI_MC001_BTN_CLOSE_SESION.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Llamar a la clase CI_LOGIN
            CI_MC001.this.dispose();
            CI_MAIN.main(null);
            }
        });
        
        //BTN Consultar = Ingresa al menú de consulta
        CI_MC001_BTN_CONSULTAR.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Llamar a la clase CI_LOGIN
            String CI_LOGIN_MESSAGE = "ERROR";
            CI_LOGIN_MESSAGE += ";" + "098";
            CI_MAIN.enviarMensaje(CI_LOGIN_MESSAGE);
            }
        });     
        
        //BTN Comprar = Ingresa al menú de compra
        CI_MC001_BTN_COMPRAR.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Llamar a la clase CI_LOGIN
            String CI_LOGIN_MESSAGE = "ERROR";
            CI_LOGIN_MESSAGE += ";" + "098";
            CI_MAIN.enviarMensaje(CI_LOGIN_MESSAGE);
            }
        });   

        //BTN Pagar = Ingresa al menú de pago
        CI_MC001_BTN_PAGAR.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //Llamar a la clase CI_LOGIN
            String CI_LOGIN_MESSAGE = "ERROR";
            CI_LOGIN_MESSAGE += ";" + "098";
            CI_MAIN.enviarMensaje(CI_LOGIN_MESSAGE);
            }
        });           
        
    }
    
    //INICIO DE CODIGO GENERADO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CI_MC001_BTN_CLOSE_SESION = new javax.swing.JButton();
        CI_MC001_LB_TITULO = new javax.swing.JLabel();
        CI_MC001_BTN_CONSULTAR = new javax.swing.JButton();
        CI_MC001_BTN_COMPRAR = new javax.swing.JButton();
        CI_MC001_BTN_PAGAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CI_MC001_BTN_CLOSE_SESION.setText("Cerrar Sesión");

        CI_MC001_LB_TITULO.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        CI_MC001_LB_TITULO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CI_MC001_LB_TITULO.setText("Menú de Usuario");

        CI_MC001_BTN_CONSULTAR.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CI_MC001_BTN_CONSULTAR.setText("Consultar");
        CI_MC001_BTN_CONSULTAR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        CI_MC001_BTN_COMPRAR.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CI_MC001_BTN_COMPRAR.setText("Comprar");
        CI_MC001_BTN_COMPRAR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        CI_MC001_BTN_PAGAR.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CI_MC001_BTN_PAGAR.setText("Pagar");
        CI_MC001_BTN_PAGAR.setHideActionText(true);
        CI_MC001_BTN_PAGAR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CI_MC001_LB_TITULO, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CI_MC001_BTN_PAGAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CI_MC001_BTN_COMPRAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CI_MC001_BTN_CONSULTAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(CI_MC001_BTN_CLOSE_SESION, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CI_MC001_LB_TITULO)
                .addGap(18, 18, 18)
                .addComponent(CI_MC001_BTN_CONSULTAR)
                .addGap(18, 18, 18)
                .addComponent(CI_MC001_BTN_COMPRAR)
                .addGap(18, 18, 18)
                .addComponent(CI_MC001_BTN_PAGAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(CI_MC001_BTN_CLOSE_SESION)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //FIN DE CODIGO GENERADO
    
    public static void main(String args[]) {
        
        //INICIO DE CODIGO GENRADO
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CI_MC001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CI_MC001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CI_MC001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CI_MC001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //FIN DE CODIGO GENRADO
        //FIN DE CODIGO GENRADO
        
        //Metodo para mostrar la ventana LOGIN
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CI_MC001().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CI_MC001_BTN_CLOSE_SESION;
    private javax.swing.JButton CI_MC001_BTN_COMPRAR;
    private javax.swing.JButton CI_MC001_BTN_CONSULTAR;
    private javax.swing.JButton CI_MC001_BTN_PAGAR;
    private javax.swing.JLabel CI_MC001_LB_TITULO;
    // End of variables declaration//GEN-END:variables
}