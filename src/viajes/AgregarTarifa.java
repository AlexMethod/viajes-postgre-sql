/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO DELL
 */
public class AgregarTarifa extends javax.swing.JFrame {

    Inicio FormInicio;
    String Accion;
    /**
     * Creates new form AgregarCliente
     */
    
    public AgregarTarifa() {
        //FormInicio = inicio;
        initComponents();
    }
    
    public AgregarTarifa(Inicio inicio){
        FormInicio = inicio;
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        Accion = "ALTA";
        loadCboRutas(null);
        loadCboUnidades(null);
        loadCboClientesFiscales(null);
        
    }
    
    public void loadCboRutas(ComboboxItem defItem){
        cboRuta.removeAllItems();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<Ruta> rutas = FormInicio.GetRutas();
        
        for(int i = 0; i < rutas.size(); i++){
            Ruta r = rutas.get(i);
            model.addElement(new ComboboxItem(r.toString(),r.IdRuta));
        }
        cboRuta.setModel(model);
        if(defItem != null){
            cboRuta.setSelectedItem(defItem);
        }
    }
    public void loadCboUnidades(ComboboxItem defItem){
        cboUnidad.removeAllItems();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<Unidad> unidades = FormInicio.GetUnidades();
        
        for(int i = 0; i < unidades.size(); i++){
            Unidad u = unidades.get(i);
            model.addElement(new ComboboxItem(u.Nombre,u.IdUnidad));
        }
        cboUnidad.setModel(model);
        if(defItem != null){
            cboUnidad.setSelectedItem(defItem);
        }
    }
    public void loadCboClientesFiscales(ComboboxItem defItem){
        cboClienteFiscal.removeAllItems();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<Cliente> clientes = FormInicio.GetClientesFiscales();
        
        for(int i = 0; i < clientes.size(); i++){
            Cliente c = clientes.get(i);
            model.addElement(new ComboboxItem(c.NombreComercial,c.IdCliente));
        }
        cboClienteFiscal.setModel(model);
        if(defItem != null){
            cboClienteFiscal.setSelectedItem(defItem);
        }
    }
    
    public int getIndexOfItem(int value){
        int index = 0;
        DefaultComboBoxModel model = (DefaultComboBoxModel)cboRuta.getModel();
        for(int i = 0; i < model.getSize(); i++){
            ComboboxItem item = (ComboboxItem)model.getElementAt(i);
            String textItem = item.getText();
            int valueItem = item.getValue();
            if(valueItem == value){
                 index =  i;
            }
        }
        return index;
    }
    
    public void setVisible(Tarifa tarifa,String accion){
        Accion = accion;
        if(Accion == "EDITAR"){
            
            cboRuta.setSelectedIndex(getIndexOfItem(tarifa.IdRuta));
            cboUnidad.setSelectedIndex(getIndexOfItem(tarifa.IdUnidad));
            cboClienteFiscal.setSelectedIndex(getIndexOfItem(tarifa.IdClienteFiscal));
            btnGuardar.setText("Editar");
            setVisible(true);
        } 
        else if(Accion == "ELIMINAR"){
            cboRuta.setSelectedIndex(getIndexOfItem(tarifa.IdRuta));
            cboUnidad.setSelectedIndex(getIndexOfItem(tarifa.IdUnidad));
            cboClienteFiscal.setSelectedIndex(getIndexOfItem(tarifa.IdClienteFiscal));
            btnGuardar.setText("Eliminar");
            setVisible(true);
            
            cboRuta.setEnabled(false);
            cboUnidad.setEnabled(false);
            cboClienteFiscal.setEnabled(false);
            btnGuardar.setText("Eliminar");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cboRuta = new javax.swing.JComboBox<>();
        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cboUnidad = new javax.swing.JComboBox<>();
        cboClienteFiscal = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setText("Cliente Fiscal");

        cboRuta.setFont(new java.awt.Font("Gill Sans MT", 0, 10)); // NOI18N
        cboRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCerrar.setBackground(new java.awt.Color(204, 204, 255));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 204, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cboUnidad.setFont(new java.awt.Font("Gill Sans MT", 0, 10)); // NOI18N
        cboUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboClienteFiscal.setFont(new java.awt.Font("Gill Sans MT", 0, 10)); // NOI18N
        cboClienteFiscal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel4.setText("Unidad");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setText("Ruta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(103, 103, 103))
                            .addComponent(cboUnidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cboClienteFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboClienteFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        try
        {
            Object itemRuta = cboRuta.getSelectedItem();
            Object itemUnidad = cboUnidad.getSelectedItem();
            Object itemClienteFiscal = cboClienteFiscal.getSelectedItem();
            
            int idruta = ((ComboboxItem)itemRuta).getValue();
            int idunidad = ((ComboboxItem)itemUnidad).getValue();
            int idclientefiscal = ((ComboboxItem)itemClienteFiscal).getValue();
            String estatus = "ACTIVO";
            Tarifa tarifa = new Tarifa(idruta,idunidad,idclientefiscal,estatus);

            if(Accion == "ALTA"){
                FormInicio.GuardaTarifa(tarifa);
            }
            else if(Accion == "ELIMINAR"){
                FormInicio.EliminaTarifa(tarifa);
            }
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarTarifa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarTarifa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboClienteFiscal;
    private javax.swing.JComboBox<String> cboRuta;
    private javax.swing.JComboBox<String> cboUnidad;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
