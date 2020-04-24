

package Vistas;

import Archivo.Configuraciones;
import Clases.Usuario;
import Controladores.ControladorUsuarios;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel CB
 */
public class FrmCrearUsuarios extends javax.swing.JInternalFrame {

    private Usuario usuario;
    private ControladorUsuarios cu;

  //private static Configuraciones conexion=new Configuraciones();
  
  
    public FrmCrearUsuarios() {
        cu = new ControladorUsuarios();
        initComponents();

    }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cajaCedula = new javax.swing.JTextField();
        cajaEmail = new javax.swing.JTextField();
        cajaNombre = new javax.swing.JTextField();
        cajaTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Corre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        cajaUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cajaContra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        combox = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar usuarios o modificar");

        cajaCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCedulaActionPerformed(evt);
            }
        });

        cajaTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTelefonoActionPerformed(evt);
            }
        });

        jLabel2.setText("Cedula");

        jLabel4.setText("Nombre Completo");

        jLabel5.setText("Telefono");

        Corre.setText("email");

        jLabel7.setText("Fecha  nacimiento");

        jLabel1.setText("Tipo");

        btnGuardar.setText("Agregar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cajaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre usuario");

        cajaContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaContraActionPerformed(evt);
            }
        });

        jLabel6.setText("Contraseña");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnico", "Secretaria" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Corre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cajaUsuario)
                            .addComponent(cajaCedula)
                            .addComponent(cajaEmail)
                            .addComponent(cajaTelefono)
                            .addComponent(cajaContra)
                            .addComponent(combox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 205, Short.MAX_VALUE)
                            .addComponent(cajaNombre)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnLimpiar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(17, 17, 17)
                        .addComponent(Corre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(cajaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cajaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cajaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(combox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar))
                .addContainerGap())
        );

        cajaContra.getAccessibleContext().setAccessibleParent(cajaContra);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaTelefonoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        usuario = new Usuario();
        try{
        usuario.setCedula(Integer.parseInt(this.cajaCedula.getText()));
        usuario.setTelefono(Integer.parseInt(this.cajaTelefono.getText()));
        System.out.println("si lee el try");
        } catch(NumberFormatException e){
            System.out.println("error"+e.getMessage());
            
            
        }

        usuario.setNombre(this.cajaNombre.getText());
        usuario.setContrasena(this.cajaContra.getText());
        usuario.setCorreoElectronico(this.cajaEmail.getText());
        usuario.setNombreUsuario(this.cajaUsuario.getText());
        usuario.setTipoUsuario((String) this.combox.getSelectedItem());
        usuario.setFechaNacimiento(this.txtDate.getDate());

        System.out.println("antes de añadir");
        if (cu.agregarUsuario(usuario)) {

            JOptionPane.showMessageDialog(this, "Usuario agregado");
            usuario=null;
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cajaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaUsuarioActionPerformed

    }//GEN-LAST:event_cajaUsuarioActionPerformed

    private void cajaCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCedulaActionPerformed


    }//GEN-LAST:event_cajaCedulaActionPerformed

    private void cajaContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaContraActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         usuario = new Usuario();
        try{
        usuario.setCedula(Integer.parseInt(this.cajaCedula.getText()));
        usuario.setTelefono(Integer.parseInt(this.cajaTelefono.getText()));
        System.out.println("si lee el try");
        } catch(NumberFormatException e){
            System.out.println("error"+e.getMessage());
            
            
        }

        usuario.setNombre(this.cajaNombre.getText());
        usuario.setContrasena(this.cajaContra.getText());
        usuario.setCorreoElectronico(this.cajaEmail.getText());
        usuario.setNombreUsuario(this.cajaUsuario.getText());
        usuario.setTipoUsuario((String) this.combox.getSelectedItem());
        usuario.setFechaNacimiento(this.txtDate.getDate());

        System.out.println("antes de añadir");
        if (cu.actualizar(usuario)) {

            JOptionPane.showMessageDialog(this, "Usuario Modificado");
            usuario=null;
        }

        
        
        
        
        
    }//GEN-LAST:event_btnModificarActionPerformed

    public String concatenar(char pass[]) {
        String pass2 = "";

        if (pass.length > 0) {
            for (int i = 0; i <= pass.length - 1; i++) {
                pass2 += pass[i];

            }
            return pass2;

        } else {
            return pass2;
        }
    }

    public void Limpiar() {
        this.cajaCedula.setText("");
        this.cajaContra.setText("");
        this.cajaEmail.setText("");
        this.cajaNombre.setText("");
        this.cajaTelefono.setText("");
        this.cajaUsuario.setText("");
        this.combox.setSelectedIndex(0);
        this.txtDate.setCalendar(null);

    }

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Corre;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JTextField cajaCedula;
    public javax.swing.JTextField cajaContra;
    public javax.swing.JTextField cajaEmail;
    public javax.swing.JTextField cajaNombre;
    public javax.swing.JTextField cajaTelefono;
    public javax.swing.JTextField cajaUsuario;
    private javax.swing.JComboBox<String> combox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private com.toedter.calendar.JDateChooser txtDate;
    // End of variables declaration//GEN-END:variables
}
