package CI_PROCESS;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CI_LOGIN extends javax.swing.JFrame {

    public CI_LOGIN() {
        initComponents();
        
        //Centrar Ventana
        setLocationRelativeTo(null);        
        
        //BTN "X" = Llamar al metodo Confirmar Salida
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CI_MAIN.confirmarSalida(CI_LOGIN.this);
            }
        });
        
        //BTN Salir = Llamar al metodo Confirmar Salida
        CI_LOGIN_BTN_SALIR.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CI_MAIN.confirmarSalida(CI_LOGIN.this);
            }
        });
        
        //BTN Iniciar Sesion = Manda solicitud de inicio de sesion 
        CI_LOGIN_BTN_INICIAR_SESION.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
            //Obtener el elemento seleccionado de CI_LOGIN_CBX_TIPO_USUARIO
            String CI_LOGIN_MESSAGE = "LOGIN";
            String CI_LOGIN_USER_TIPE = (String) CI_LOGIN_CBX_TIPO_USUARIO.getSelectedItem();
            String CI_LOGIN_USERNAME = CI_LOGIN_FIL_USUARIO.getText();
            String CI_LOGIN_PASSWORD = new String(CI_LOGIN_FIL_PASSWORD.getPassword());
            
            //Procesar CI_LOGIN_USER_TIPE
            switch (CI_LOGIN_USER_TIPE) {
                case "Cliente":
                    CI_LOGIN_MESSAGE += ";001";
                    break;
                case "Empleado":
                    CI_LOGIN_MESSAGE += ";002";
                    break;
                default:
                    break;
            }
            
            //Procesar CI_LOGIN_USERNAME
            CI_LOGIN_USERNAME = CI_LOGIN_USERNAME.replace(";", "");
            
            //Procesar CI_LOGIN_FIL_PASSWORD
            CI_LOGIN_PASSWORD = CI_LOGIN_PASSWORD.replace(";", "");
            
            CI_LOGIN_MESSAGE += ";" + CI_LOGIN_USERNAME + ";" + CI_LOGIN_PASSWORD;
            CI_MAIN.enviarMensaje(CI_LOGIN_MESSAGE);
            }
        }); 
        
        //CHK Ocultar = Oculta contenido del password
        CI_LOGIN_CHK_HIDEPASS.setSelected(true);
        CI_LOGIN_CHK_HIDEPASS.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            boolean hidePassword = CI_LOGIN_CHK_HIDEPASS.isSelected();
            if (hidePassword) {
                CI_LOGIN_FIL_PASSWORD.setEchoChar('\u2022'); 
            } else {
                CI_LOGIN_FIL_PASSWORD.setEchoChar((char) 0);
            }
        }
        });
        
    }
    
    //INICIO DE CODIGO GENERADO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CI_LOGIN_BTN_SALIR = new javax.swing.JButton();
        CI_LOGIN_LB_TITULO = new javax.swing.JLabel();
        CI_LOGIN_BTN_INICIAR_SESION = new javax.swing.JButton();
        CI_LOGIN_CBX_TIPO_USUARIO = new javax.swing.JComboBox<>();
        CI_LOGIN_LB_TIPO_USUARIO = new javax.swing.JLabel();
        CI_LOGIN_FIL_USUARIO = new javax.swing.JTextField();
        CI_LOGIN_LB_USUARIO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CI_LOGIN_CHK_HIDEPASS = new javax.swing.JCheckBox();
        CI_LOGIN_FIL_PASSWORD = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CI_LOGIN_BTN_SALIR.setText("Salir");

        CI_LOGIN_LB_TITULO.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        CI_LOGIN_LB_TITULO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CI_LOGIN_LB_TITULO.setText("Cable&Red Full Conect ");

        CI_LOGIN_BTN_INICIAR_SESION.setText("Iniciar Sesión");

        CI_LOGIN_CBX_TIPO_USUARIO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Empleado" }));

        CI_LOGIN_LB_TIPO_USUARIO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CI_LOGIN_LB_TIPO_USUARIO.setText("Tipo de Usuario");

        CI_LOGIN_LB_USUARIO.setText("Usuario");

        jLabel1.setText("Contraseña");

        CI_LOGIN_CHK_HIDEPASS.setText("Ocultar");

        CI_LOGIN_FIL_PASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CI_LOGIN_FIL_PASSWORDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CI_LOGIN_LB_TITULO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CI_LOGIN_LB_TIPO_USUARIO)
                                    .addComponent(CI_LOGIN_LB_USUARIO)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(CI_LOGIN_BTN_SALIR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CI_LOGIN_BTN_INICIAR_SESION))
                                    .addComponent(jLabel1))
                                .addGap(0, 212, Short.MAX_VALUE)))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CI_LOGIN_CBX_TIPO_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CI_LOGIN_CHK_HIDEPASS, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CI_LOGIN_FIL_USUARIO)
                                .addComponent(CI_LOGIN_FIL_PASSWORD, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CI_LOGIN_LB_TITULO)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CI_LOGIN_CBX_TIPO_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CI_LOGIN_LB_TIPO_USUARIO))
                .addGap(18, 18, 18)
                .addComponent(CI_LOGIN_LB_USUARIO)
                .addGap(2, 2, 2)
                .addComponent(CI_LOGIN_FIL_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CI_LOGIN_FIL_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(CI_LOGIN_CHK_HIDEPASS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CI_LOGIN_BTN_SALIR)
                    .addComponent(CI_LOGIN_BTN_INICIAR_SESION))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CI_LOGIN_FIL_PASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CI_LOGIN_FIL_PASSWORDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CI_LOGIN_FIL_PASSWORDActionPerformed
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
            java.util.logging.Logger.getLogger(CI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //FIN DE CODIGO GENRADO
        
        //Metodo para mostrar la ventana LOGIN
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CI_LOGIN().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CI_LOGIN_BTN_INICIAR_SESION;
    private javax.swing.JButton CI_LOGIN_BTN_SALIR;
    private javax.swing.JComboBox<String> CI_LOGIN_CBX_TIPO_USUARIO;
    private javax.swing.JCheckBox CI_LOGIN_CHK_HIDEPASS;
    private javax.swing.JPasswordField CI_LOGIN_FIL_PASSWORD;
    private javax.swing.JTextField CI_LOGIN_FIL_USUARIO;
    private javax.swing.JLabel CI_LOGIN_LB_TIPO_USUARIO;
    private javax.swing.JLabel CI_LOGIN_LB_TITULO;
    private javax.swing.JLabel CI_LOGIN_LB_USUARIO;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}