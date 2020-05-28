/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes;

import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author USUARIO DELL
 */
public final class AgregarViaje extends javax.swing.JFrame {

    Inicio FormInicio;
    String Accion;
    /**
     * Creates new form AgregarCliente
     */
    
    public AgregarViaje() {
        //FormInicio = inicio;
        initComponents();
    }
    
    public AgregarViaje(Inicio inicio){
        FormInicio = inicio;
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        Accion = "ALTA";
        loadCboRutas(null);
        loadCboSucursales(null);
        loadPedidos(null);
    }
    
    public void loadPedidos(ComboboxItem defItem){
        listPedidos.removeAll();;
        DefaultListModel model = new DefaultListModel();
        ArrayList<Pedido> pedidos = FormInicio.GetPedidos();
        
        for(int i = 0; i < pedidos.size(); i++){
            Pedido p = pedidos.get(i);
            model.addElement(new ComboboxItem(p.Delivery,p.IdPedido));
        }
        listPedidos.setModel(model);
        if(defItem != null){
            listPedidos.setSelectedIndex(0);
        }
        
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
    public void loadCboSucursales(ComboboxItem defItem){
        cboSucursal.removeAllItems();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<Sucursal> sucursales = FormInicio.GetSucursales();
        
        for(int i = 0; i < sucursales.size(); i++){
            Sucursal s = sucursales.get(i);
            model.addElement(new ComboboxItem(s.Nombre,s.IdSucursal));
        }
        cboSucursal.setModel(model);
        if(defItem != null){
            cboSucursal.setSelectedItem(defItem);
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
    
    public void setVisible(Viaje viaje,String accion){
        Accion = accion;
        if(Accion == "EDITAR"){
            
            cboRuta.setSelectedIndex(getIndexOfItem(viaje.IdRuta));
            cboSucursal.setSelectedIndex(getIndexOfItem(viaje.IdSucursal));
            txtFolio.setText(viaje.Folio);
            btnGuardar.setText("Editar");
            setVisible(true);
        } 
        else if(Accion == "ELIMINAR"){
            cboRuta.setSelectedIndex(getIndexOfItem(viaje.IdRuta));
            cboSucursal.setSelectedIndex(getIndexOfItem(viaje.IdSucursal));
            txtFolio.setText(viaje.Folio);
            btnGuardar.setText("Eliminar");
            setVisible(true);
            
            cboRuta.setEnabled(false);
            cboSucursal.setEnabled(false);
            txtFolio.setEnabled(false);
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
        cboSucursal = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        scrollPanel = new javax.swing.JScrollPane();
        listPedidos = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setText("Pedidos");

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

        cboSucursal.setFont(new java.awt.Font("Gill Sans MT", 0, 10)); // NOI18N
        cboSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel4.setText("Sucursal");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setText("Ruta");

        txtFolio.setFont(new java.awt.Font("Gill Sans MT", 0, 10)); // NOI18N
        txtFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFolioActionPerformed(evt);
            }
        });

        listPedidos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollPanel.setViewportView(listPedidos);
        listPedidos.getAccessibleContext().setAccessibleParent(listPedidos);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setText("Folio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(103, 103, 103))
                            .addComponent(cboSucursal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
            Object itemSucursal = cboSucursal.getSelectedItem();
            int idruta = ((ComboboxItem)itemRuta).getValue();
            int idsucursal = ((ComboboxItem)itemSucursal).getValue();
            String folio = txtFolio.getText();
            String estatus = "ACTIVO";
            
            ArrayList<Pedido> pedidos = new ArrayList<>();
            int[] selectedItems = listPedidos.getSelectedIndices();
            for(int i = 0; i < selectedItems.length ; i++)
            {
                Object obj = listPedidos.getModel().getElementAt(i);
                ComboboxItem item = (ComboboxItem)obj;
                Pedido p = FormInicio.GetPedido(item.getValue());
                pedidos.add(p);
            }

            double PesoTotal = pedidos.stream().mapToDouble(p -> p.Peso).sum();
            
            Viaje viaje = new Viaje(idruta,idsucursal,folio,PesoTotal,estatus);

            if(Accion == "ALTA"){
                FormInicio.GuardaViaje(viaje);
                Viaje nviaje = FormInicio.GetViaje(viaje.Folio);
                FormInicio.GuardaIdViajePedidos(pedidos, nviaje.IdViaje);
            }
            else if(Accion == "ELIMINAR"){
                FormInicio.EliminaViaje(viaje);
            }
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFolioActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarViaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboRuta;
    private javax.swing.JComboBox<String> cboSucursal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> listPedidos;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTextField txtFolio;
    // End of variables declaration//GEN-END:variables
}
