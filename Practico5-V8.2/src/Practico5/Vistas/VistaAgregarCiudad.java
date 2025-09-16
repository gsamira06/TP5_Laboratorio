
package Practico5.Vistas;

import javax.swing.JOptionPane;
import Practico5.Entidades.Directorio;


public class VistaAgregarCiudad extends javax.swing.JInternalFrame {

    
    public VistaAgregarCiudad() {
        initComponents();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelNombreCiudad = new javax.swing.JLabel();
        jTextFieldCiudad = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 204, 255));
        jLabel1.setText("Agregar Ciudad");

        jLabelNombreCiudad.setText("Nombre Ciudad:");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNombreCiudad)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButtonGuardar)
                .addGap(47, 268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreCiudad)
                    .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButtonGuardar)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here BOTON GUARDAR:
        String ciuSelec = jTextFieldCiudad.getText();
        if(!ciuSelec.isEmpty()){
            Directorio.agregarCiudad(ciuSelec); //Guardo en un Set para Usarlo en el iFrame "agregarContacto"
            JOptionPane.showMessageDialog(this, "Ciudad agregada correctamente");
            jTextFieldCiudad.setText("");//limpiamos
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de una ciudad");
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNombreCiudad;
    private javax.swing.JTextField jTextFieldCiudad;
    // End of variables declaration//GEN-END:variables
}
