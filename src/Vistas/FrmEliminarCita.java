/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Usuario;
import Controladores.ControladorUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel CB
 */
public class FrmEliminarCita extends javax.swing.JInternalFrame {

    private ControladorUsuarios ctu;
    private Usuario usuario;

    public FrmEliminarCita() {
        initComponents();

        ctu = new ControladorUsuarios();

    }

    public void limpiarCajas() {

        cajaCedula.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaCedula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EliminarUsuarios");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("             Eliminar Cita");

        jLabel2.setText("Ingrese ID");

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (cajaCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el numero de cedula");
        } else {
            usuario = new Usuario();
            try {
                usuario.setCedula(Integer.parseInt(this.cajaCedula.getText()));
                if (ctu.eliminarUsuario(usuario)) {

                    JOptionPane.showMessageDialog(this, "Usuario eliminado");
                } else {

                    JOptionPane.showMessageDialog(this, "Usuario NO eliminado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR AL ELIMINAR USUARIO DEVIDO A " + e.getMessage());
            }
        }
//                
//        if(!this.cajaCedula.getText().equals("")){    
//            
//            usuario = new Usuario();
//            
//            usuario.setCedula(Integer.valueOf( this.cajaCedula.getText() ));
//    
//            
//            
//            if(cu.buscarUsuario(usuario)!= null)
//            {
//                usuario = cu.buscarUsuario(usuario);
//                
//                if(cu.listarUsuarios().size()> 1 && cu.eliminar(usuario) )
//                    
//                    
//                {
//                    JOptionPane.showMessageDialog(this, "Se elimino Usuario correctamente");
//                   
//                    
//                    
//                    usuario=null;
//                    
//                    
//                    
//                    
//                    this.limpiarCajas();
//                }else
//                {
//                    JOptionPane.showMessageDialog(this,"El Sistema no se puede quedar sin usuarios");
//                }
//            }
//            
//        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cajaCedula;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
