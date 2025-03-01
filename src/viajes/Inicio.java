/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajes;

import java.awt.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO DELL
 */
public class Inicio extends javax.swing.JFrame {
    
    //Instancias de registros seleccionados
    Cliente ClienteActual = null;
    Sucursal SucursalActual = null;
    Transportista TransportistaActual = null;
    Unidad UnidadActual = null;
    Ruta RutaActual = null;
    Tarifa TarifaActual = null;
    Pedido PedidoActual = null;
    Viaje ViajeActual = null;
    
    //Modales para los formularios
    AgregarCliente modalAgregarCliente = null;
    AgregarSucursal modalAgregarSucursal = null;
    AgregarTransportista modalAgregarTransportista = null;
    AgregarUnidad modalAgregarUnidad = null;
    AgregarRuta modalAgregarRuta = null;
    AgregarTarifa modalAgregarTarifa = null;
    AgregarPedido modalAgregarPedido = null;
    AgregarViaje modalAgregarViaje = null;
    
    
    //Conexion con BD
    DefaultTableModel md;
    String data[][] = {};
    
    String url = "jdbc:postgresql://localhost:5432/Viajes";
    String usuario = "";
    String contrasena = "";
    
    
    private String CatalogoActual;
    /**
     * Creates new form Inicio
     * @param user
     * @param pass
     */
    public Inicio(String user, String pass) {
        usuario = user;
        contrasena = pass;
        
        initComponents();
        setLocationRelativeTo(null);
        CatalogoActual = "DASHBOARD";
        txtTitle.setText(CatalogoActual);
        txtUsuario.setText(user.toUpperCase());
        setVisible(true);
        
        //Configuracion botones
        btnAgregar.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCambiarEstatus.setVisible(false);
        jtTabla.setVisible(false);
    }
    
    
    public void GetAllData(String esquema, String tabla){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{esquema, tabla};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus != ''CANCELADO''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel) jtTabla.getModel();
            model.setRowCount(0);
            
            //Asignacion de los ecabezados
            switch(CatalogoActual){
                case "CLIENTES":
                    //Se le asignan los encabezados a la tabla
                    md = new DefaultTableModel(data,Cliente.Header);
                    jtTabla.setModel(md);
                    break;
                case "SUCURSALES":
                    md = new DefaultTableModel(data,Sucursal.Header);
                    jtTabla.setModel(md);
                    break;
                case "TRANSPORTISTAS":
                    md = new DefaultTableModel(data,Transportista.Header);
                    jtTabla.setModel(md);
                    break;
                case "UNIDADES":
                    md = new DefaultTableModel(data,Unidad.Header);
                    jtTabla.setModel(md);
                    break;
                case "RUTAS":
                    md = new DefaultTableModel(data,Ruta.Header);
                    jtTabla.setModel(md);
                    break;
                case "TARIFAS":
                    md = new DefaultTableModel(data,Tarifa.Header);
                    jtTabla.setModel(md);
                    break;
                case "PEDIDOS":
                    md = new DefaultTableModel(data,Pedido.Header);
                    jtTabla.setModel(md);
                    break;
                case "VIAJES":
                    md = new DefaultTableModel(data,Viaje.Header);
                    jtTabla.setModel(md);
                    break;
                case "HISTORIAL_VIAJES":
                    md = new DefaultTableModel(data,HistorialViajes.Header);
                    jtTabla.setModel(md);
            }

            //Se itera sobre cada una de las tuplas para agregarlas a la tabla
            while(result.next())
            {
                String row[] = {};
                switch(CatalogoActual){
                    case "CLIENTES":
                        //Se obtiene el conjunto de datos para una tupla
                        row = Cliente.GetRow(result);
                        break;
                    case "SUCURSALES":
                        row = Sucursal.GetRow(result);
                        break;
                    case "TRANSPORTISTAS":
                        row = Transportista.GetRow(result);
                        break;
                    case "UNIDADES":
                        row = Unidad.GetRow(result);
                        break;
                    case "RUTAS":
                        row = Ruta.GetRow(result);
                        break;
                     case "TARIFAS":
                        row = Tarifa.GetRow(result);
                        break;
                    case "PEDIDOS":
                        row = Pedido.GetRow(result);
                        break;
                    case "VIAJES":
                        row = Viaje.GetRow(result);
                        break;
                    case "HISTORIAL_VIAJES":
                        row = HistorialViajes.GetRow(result);
                }
                md.addRow(row);
            }
            
            result.close();
            sentencia.close();
        }
        catch(Exception err){
            JOptionPane.showMessageDialog(null, err.getMessage(), "Error al obtener los datos: ", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnSucursales = new javax.swing.JButton();
        btnUnidades = new javax.swing.JButton();
        btnTransportistas = new javax.swing.JButton();
        btnRutas = new javax.swing.JButton();
        btnTarifas = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        btnViajes = new javax.swing.JButton();
        btnHistorialViajes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        txtTitle = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCambiarEstatus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Viajes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnSucursales.setText("Sucursales");
        btnSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSucursalesActionPerformed(evt);
            }
        });

        btnUnidades.setText("Unidades");
        btnUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidadesActionPerformed(evt);
            }
        });

        btnTransportistas.setText("Transportistas");
        btnTransportistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransportistasActionPerformed(evt);
            }
        });

        btnRutas.setText("Rutas");
        btnRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutasActionPerformed(evt);
            }
        });

        btnTarifas.setText("Tarifas");
        btnTarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarifasActionPerformed(evt);
            }
        });

        btnPedidos.setText("Pedidos");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        btnViajes.setText("Viajes");
        btnViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViajesActionPerformed(evt);
            }
        });

        btnHistorialViajes.setText("Historial Viajes");
        btnHistorialViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialViajesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSucursales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUnidades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTransportistas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
            .addComponent(btnRutas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
            .addComponent(btnTarifas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
            .addComponent(btnPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
            .addComponent(btnViajes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
            .addComponent(btnHistorialViajes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransportistas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarifas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorialViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        txtUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtUsuario.setText("Title");

        btnLogout.setBackground(new java.awt.Color(204, 153, 0));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsuario)
                .addGap(48, 48, 48)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario)
                    .addComponent(btnLogout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabla);

        txtTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtTitle.setText("Title");

        btnAgregar.setBackground(new java.awt.Color(51, 102, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(51, 255, 51));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCambiarEstatus.setBackground(new java.awt.Color(51, 255, 51));
        btnCambiarEstatus.setText("Cambiar Estatus");
        btnCambiarEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCambiarEstatus)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTitle)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "CLIENTES";
        txtTitle.setText(CatalogoActual);
        GetAllData("informacion","cliente");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,true,true,false);
                break;
            case "operador":
                SetButtonConfig(false,false,false,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,true,true,false);
                break;
        }
            
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSucursalesActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "SUCURSALES";
        txtTitle.setText(CatalogoActual);
        GetAllData("informacion","sucursal");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,true,true,false);
                break;
            case "operador":
                SetButtonConfig(false,false,false,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,true,true,false);
                break;
        }
        
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnSucursalesActionPerformed

    private void btnUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidadesActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "UNIDADES";
        txtTitle.setText(CatalogoActual);
        GetAllData("informacion","view_unidad");
       
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,true,true,false);
                break;
            case "operador":
                SetButtonConfig(true,true,true,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,true,true,false);
                break;
        }
       
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnUnidadesActionPerformed

    private void btnTransportistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransportistasActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "TRANSPORTISTAS";
        txtTitle.setText(CatalogoActual);
        GetAllData("informacion","transportista");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,true,true,false);
                break;
            case "operador":
                SetButtonConfig(true,true,true,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,true,true,false);
                break;
        }
        
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnTransportistasActionPerformed

    private void btnRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutasActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "RUTAS";
        txtTitle.setText(CatalogoActual);
        GetAllData("informacion","ruta");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,true,true,false);
                break;
            case "operador":
                SetButtonConfig(true,true,true,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,true,true,false);
                break;
        }
        
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnRutasActionPerformed

    private void btnTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarifasActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "TARIFAS";
        txtTitle.setText(CatalogoActual);
        GetAllData("operacion","view_tarifa");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,false,true,false);
                break;
            case "operador":
                SetButtonConfig(false,false,false,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,false,true,false);
                break;
        }
        
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnTarifasActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "PEDIDOS";
        txtTitle.setText(CatalogoActual);
        GetAllData("operacion","view_pedido");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,false,true,false);
                break;
            case "operador":
                SetButtonConfig(true,false,true,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,false,true,false);
                break;
        }
        
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViajesActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "VIAJES";
        txtTitle.setText(CatalogoActual);
        GetAllData("Operacion","View_Viaje");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(true,false,true,true);
                break;
            case "operador":
                SetButtonConfig(true,false,true,true);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(true,false,true,true);
                break;
        }
        
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnViajesActionPerformed

    private void btnHistorialViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialViajesActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "HISTORIAL_VIAJES";
        txtTitle.setText(CatalogoActual);
        GetAllData("operacion","view_historialviajes");
        
        //SE AFECTAN LOS PRIVILEGIOS SEGUN EL TIPO DE USUARIO
        switch(usuario){
            case "administrador":
                SetButtonConfig(false,false,false,false);
                break;
            case "operador":
                SetButtonConfig(false,false,false,false);
                break;
            case "consultor":
                SetButtonConfig(false,false,false,false);
                break;
            default: 
                SetButtonConfig(false,false,false,false);
                break;
        }
        
        jtTabla.setVisible(true);
    }//GEN-LAST:event_btnHistorialViajesActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        CatalogoActual = "DASHBOARD";
        txtTitle.setText(CatalogoActual);
        
        //Configuración de botones
        btnAgregar.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCambiarEstatus.setVisible(false);
        jtTabla.setVisible(false);
    }//GEN-LAST:event_btnDashboardActionPerformed

    //AGREGAR
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        switch(CatalogoActual){
            case "CLIENTES":
                modalAgregarCliente = new AgregarCliente(this);
                break;
            case "SUCURSALES":
                modalAgregarSucursal = new AgregarSucursal(this);
                break;
            case "TRANSPORTISTAS":
                modalAgregarTransportista = new AgregarTransportista(this);
                break;
            case "UNIDADES":
                modalAgregarUnidad = new AgregarUnidad(this);
                break;
            case "RUTAS":
                modalAgregarRuta = new AgregarRuta(this);
                break;
            case "TARIFAS":
                modalAgregarTarifa = new AgregarTarifa(this);
                break;
            case "PEDIDOS":
                modalAgregarPedido = new AgregarPedido(this);
                break;
            case "VIAJES":
                modalAgregarViaje = new AgregarViaje(this);
                break;
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    //ELIMINAR
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        switch(CatalogoActual){
            case "CLIENTES":
                if(ClienteActual != null){
                    modalAgregarCliente = new AgregarCliente(this);
                    modalAgregarCliente.setVisible(ClienteActual,"ELIMINAR");
                } 
                break;
            case "SUCURSALES":
                if(SucursalActual != null){
                    modalAgregarSucursal = new AgregarSucursal(this);
                    modalAgregarSucursal.setVisible(SucursalActual,"ELIMINAR");
                } 
                break;
            case "TRANSPORTISTAS":
                if(TransportistaActual != null){
                    modalAgregarTransportista = new AgregarTransportista(this);
                    modalAgregarTransportista.setVisible(TransportistaActual,"ELIMINAR");
                } 
                break;
            case "UNIDADES":
                if(UnidadActual != null){
                    modalAgregarUnidad = new AgregarUnidad(this);
                    modalAgregarUnidad.setVisible(UnidadActual,"ELIMINAR");
                } 
                break;
            case "RUTAS":
                if(RutaActual != null){
                    modalAgregarRuta = new AgregarRuta(this);
                    modalAgregarRuta.setVisible(RutaActual,"ELIMINAR");
                } 
                break;
            case "TARIFAS":
                if(TarifaActual != null){
                    modalAgregarTarifa = new AgregarTarifa(this);
                    modalAgregarTarifa.setVisible(TarifaActual,"ELIMINAR");
                } 
                break;
            case "PEDIDOS":
                if(PedidoActual != null){
                    modalAgregarPedido = new AgregarPedido(this);
                    modalAgregarPedido.setVisible(PedidoActual,"ELIMINAR");
                } 
                break;
            case "VIAJES":
                if(ViajeActual != null){
                    modalAgregarViaje = new AgregarViaje(this);
                    modalAgregarViaje.setVisible(ViajeActual,"ELIMINAR");
                } 
                break;
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    //EDITAR
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        switch(CatalogoActual){
            case "CLIENTES":
                if(ClienteActual != null){
                    modalAgregarCliente = new AgregarCliente(this);
                    modalAgregarCliente.setVisible(ClienteActual,"EDITAR");
                } 
                break;
            case "SUCURSALES":
                if(SucursalActual != null){
                    modalAgregarSucursal = new AgregarSucursal(this);
                    modalAgregarSucursal.setVisible(SucursalActual,"EDITAR");
                }
                break;
            case "TRANSPORTISTAS":
                if(TransportistaActual != null){
                    modalAgregarTransportista = new AgregarTransportista(this);
                    modalAgregarTransportista.setVisible(TransportistaActual,"EDITAR");
                } 
                break;
            case "UNIDADES":
                if(UnidadActual != null){
                    modalAgregarUnidad = new AgregarUnidad(this);
                    modalAgregarUnidad.setVisible(UnidadActual,"EDITAR");
                } 
                break;
            case "RUTAS":
                if(RutaActual != null){
                    modalAgregarRuta = new AgregarRuta(this);
                    modalAgregarRuta.setVisible(RutaActual,"EDITAR");
                } 
                break;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    //SELECCIONA UN REGISTRO
    private void jtTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMouseClicked
        // TODO add your handling code here:
        
        int row = jtTabla.getSelectedRow();
        int col = jtTabla.getSelectedColumn();
        
        DefaultTableModel model = (DefaultTableModel) jtTabla.getModel();
        int IdRegistro = Integer.parseInt(model.getValueAt(row, 0).toString());
        
        switch(CatalogoActual){
            case "DASHBOARD":
                break;
            case "CLIENTES":
                ClienteActual = GetCliente(IdRegistro);
                break;
            case "SUCURSALES":
                SucursalActual = GetSucursal(IdRegistro);
                break;
            case "TRANSPORTISTAS":
                TransportistaActual = GetTransportista(IdRegistro);
                break;
            case "UNIDADES":
                UnidadActual = GetUnidad(IdRegistro);
                break;
            case "RUTAS":
                RutaActual = GetRuta(IdRegistro);
                break;
            case "TARIFAS":
                TarifaActual = GetTarifa(IdRegistro);
                break;
            case "PEDIDOS":
                PedidoActual = GetPedido(IdRegistro);
                break;
            case "VIAJES":
                ViajeActual = GetViaje(IdRegistro);
                break;
        }
    }//GEN-LAST:event_jtTablaMouseClicked

    //CAMBIA ESTATUS
    private void btnCambiarEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstatusActionPerformed
        // TODO add your handling code here:
        
            String estatusActual = ViajeActual.Estatus;

            if(estatusActual.equals("ACTIVO"))
            {
                ViajeActual.Estatus = "CARGA";
            }else if(estatusActual.equals("CARGA"))
            {
                ViajeActual.Estatus = "RUTA";
            }else if(estatusActual.equals("RUTA"))
            {
                ViajeActual.Estatus = "DESCARGA";
            } else if(estatusActual.equals("DESCARGA"))
            {
                ViajeActual.Estatus = "FINALIZADO";
            }

            EditaViaje(ViajeActual);
    }//GEN-LAST:event_btnCambiarEstatusActionPerformed

    //LOG OUT
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        InicioSesion sesion = new InicioSesion();
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    public void SetButtonConfig(boolean isAgregar, boolean isEditar, boolean isEliminar,boolean isCambiarEstatus){
        btnAgregar.setVisible(isAgregar);
        btnEditar.setVisible(isEditar);
        btnEliminar.setVisible(isEliminar);
        btnCambiarEstatus.setVisible(isCambiarEstatus);
    }
    //CLIENTES
    public void GuardaCliente(Cliente cliente){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{cliente.RazonSocial, cliente.NombreComercial,cliente.Tipo,cliente.Direccion,Double.toString(cliente.PorcentajeVenta),cliente.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO informacion.cliente(razonsocial,nombrecomercial,tipo,direccion,porcentajeventa,estatus) VALUES(''{0}'',''{1}'',''{2}'',''{3}'',{4},''{5}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","cliente");
            modalAgregarCliente.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EditaCliente(Cliente cliente){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{ClienteActual.IdCliente,cliente.RazonSocial, cliente.NombreComercial,cliente.Tipo,cliente.Direccion,Double.toString(cliente.PorcentajeVenta)};
            String sql = 
                    MessageFormat.format("UPDATE informacion.cliente SET razonsocial = ''{1}'',nombrecomercial = ''{2}'',tipo = ''{3}'',direccion = ''{4}'',porcentajeventa = {5} WHERE IdCliente = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","cliente");
            modalAgregarCliente.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void EliminaCliente(Cliente cliente){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{ClienteActual.IdCliente};
            String sql = 
                    MessageFormat.format("UPDATE informacion.cliente SET estatus = ''CANCELADO'' WHERE IdCliente = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","cliente");
            modalAgregarCliente.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Cliente GetCliente(int idregistro){
        
        Cliente cliente = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "cliente",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdCliente = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                cliente = Cliente.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return cliente;
    }
    public ArrayList<Cliente> GetClientesFiscales(){
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "cliente","ACTIVO","FISCAL"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}'' AND Tipo = ''{3}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                clientes.add(Cliente.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return clientes;
    }
    public ArrayList<Cliente> GetClientesOrigen(){
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "cliente","ACTIVO","ORIGEN"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}'' AND Tipo = ''{3}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                clientes.add(Cliente.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return clientes;
    }
    public ArrayList<Cliente> GetClientesDestino(){
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "cliente","ACTIVO","DESTINO"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}'' AND Tipo = ''{3}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                clientes.add(Cliente.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return clientes;
    }
    
    //SUCURSALES
    public void GuardaSucursal(Sucursal sucursal){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{sucursal.Nombre,sucursal.Direccion,sucursal.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO informacion.sucursal(nombre,direccion,estatus) VALUES(''{0}'',''{1}'',''{2}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","sucursal");
            modalAgregarSucursal.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EditaSucursal(Sucursal sucursal){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{SucursalActual.IdSucursal,sucursal.Nombre,sucursal.Direccion};
            String sql = 
                    MessageFormat.format("UPDATE informacion.sucursal SET nombre = ''{1}'',direccion = ''{2}'' WHERE IdSucursal = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","sucursal");
            modalAgregarSucursal.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void EliminaSucursal(Sucursal sucursal){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{SucursalActual.IdSucursal};
            String sql = 
                    MessageFormat.format("UPDATE informacion.sucursal SET estatus = ''CANCELADO'' WHERE IdSucursal = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","sucursal");
            modalAgregarSucursal.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Sucursal GetSucursal(int idregistro){
        
        Sucursal sucursal = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "sucursal",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdSucursal = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                sucursal = Sucursal.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return sucursal;
    }
    public ArrayList<Sucursal> GetSucursales(){
        
        ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "sucursal","ACTIVO"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                sucursales.add(Sucursal.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return sucursales;
    }
    
    //TRANSPORTISTAS
    public void GuardaTransportista(Transportista transportista){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{transportista.RazonSocial, transportista.NombreComercial,transportista.Comision,transportista.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO informacion.transportista(razonsocial,nombrecomercial,comision,estatus) VALUES(''{0}'',''{1}'',{2},''{3}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","transportista");
            modalAgregarTransportista.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EditaTransportista(Transportista transportista){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{TransportistaActual.IdTransportista,transportista.RazonSocial, transportista.NombreComercial,transportista.Comision};
            String sql = 
                    MessageFormat.format("UPDATE informacion.transportista SET razonsocial = ''{1}'',nombrecomercial = ''{2}'',Comision = {3} WHERE IdTransportista = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","transportista");
            modalAgregarTransportista.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void EliminaTransportista(Transportista transportista){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{TransportistaActual.IdTransportista};
            String sql = 
                    MessageFormat.format("UPDATE informacion.transportista SET estatus = ''CANCELADO'' WHERE IdTransportista = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","transportista");
            modalAgregarTransportista.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Transportista GetTransportista(int idregistro){
        
        Transportista transportista = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "transportista",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdTransportista = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                transportista = Transportista.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return transportista;
    }
    public ArrayList<Transportista> GetTransportistas(){
        
        ArrayList<Transportista> transportistas = new ArrayList<Transportista>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "transportista","ACTIVO"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                transportistas.add(Transportista.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return transportistas;
    }
    
    
    //UNIDADES
    public void GuardaUnidad(Unidad unidad){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{unidad.IdTransportista,unidad.Nombre, unidad.Placas,unidad.PesoMaximo,unidad.CostoxKilometro,unidad.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO informacion.unidad(idtransportista,nombre,placas,pesomaximo,costoxkilometro,estatus) VALUES({0},''{1}'',''{2}'',{3},{4},''{5}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","view_unidad");
            modalAgregarUnidad.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EditaUnidad(Unidad unidad){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{UnidadActual.IdUnidad,unidad.IdTransportista,unidad.Nombre,unidad.Placas,unidad.PesoMaximo,unidad.CostoxKilometro};
            String sql = 
                    MessageFormat.format("UPDATE informacion.unidad SET idtransportista = {1},nombre = ''{2}'',placas = ''{3}'',pesomaximo = {4},costoxkilometro = {5} WHERE IdUnidad = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","view_unidad");
            modalAgregarUnidad.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void EliminaUnidad(Unidad unidad){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{UnidadActual.IdUnidad};
            String sql = 
                    MessageFormat.format("UPDATE informacion.unidad SET estatus = ''CANCELADO'' WHERE IdUnidad = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","view_unidad");
            modalAgregarUnidad.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Unidad GetUnidad(int idregistro){
        
        Unidad unidad = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "unidad",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdUnidad = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                unidad = Unidad.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return unidad;
    }
    public ArrayList<Unidad> GetUnidades(){
        
        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "unidad","ACTIVO"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                unidades.add(Unidad.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return unidades;
    }
    
    //RUTAS
    public void GuardaRuta(Ruta ruta){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{ruta.EstadoOrigen,ruta.EstadoDestino,ruta.CPOrigen,ruta.CPDestino,ruta.Kilometros,ruta.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO informacion.ruta(EstadoOrigen,EstadoDestino,CPOrigen,CPDestino,Kilometros,estatus) VALUES(''{0}'',''{1}'',{2},{3},{4}, ''{5}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","ruta");
            modalAgregarRuta.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EditaRuta(Ruta ruta){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{RutaActual.IdRuta,ruta.EstadoOrigen,ruta.EstadoDestino,ruta.CPOrigen,ruta.CPDestino,ruta.Kilometros};
            String sql = 
                    MessageFormat.format("UPDATE informacion.ruta SET EstadoOrigen = ''{1}'',EstadoDestino = ''{2}'', CPOrigen = {3},CPDestino = {4},Kilometros = {5}  WHERE IdRuta = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","ruta");
            modalAgregarRuta.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void EliminaRuta(Ruta ruta){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{RutaActual.IdRuta};
            String sql = 
                    MessageFormat.format("UPDATE informacion.ruta SET estatus = ''CANCELADO'' WHERE IdRuta = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("informacion","ruta");
            modalAgregarRuta.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Ruta GetRuta(int idregistro){
        
        Ruta ruta = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "ruta",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdRuta = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                ruta = Ruta.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return ruta;
    }
    public ArrayList<Ruta> GetRutas(){
        
        ArrayList<Ruta> rutas = new ArrayList<Ruta>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"informacion", "ruta","ACTIVO"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                rutas.add(Ruta.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return rutas;
    }
    
    //TARIFAS
    public void GuardaTarifa(Tarifa tarifa){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{tarifa.IdRuta,tarifa.IdUnidad,tarifa.IdClienteFiscal,tarifa.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO Operacion.Tarifa (IdRuta,IdUnidad,IdClienteFiscal,Estatus) VALUES({0},{1},{2},''{3}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("operacion","view_tarifa");
            modalAgregarTarifa.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EliminaTarifa(Tarifa tarifa){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{TarifaActual.IdTarifa};
            String sql = 
                    MessageFormat.format("UPDATE operacion.tarifa SET estatus = ''CANCELADO'' WHERE IdTarifa = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("operacion","view_tarifa");
            modalAgregarTarifa.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Tarifa GetTarifa(int idregistro){
        
        Tarifa tarifa = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"operacion", "tarifa",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdTarifa = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                tarifa = Tarifa.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return tarifa;
    }
    
    //PEDIDOS
    public void GuardaPedido(Pedido pedido){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{pedido.IdClienteOrigen,pedido.IdClienteDestino,pedido.Delivery,pedido.Peso,pedido.Piezas,pedido.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO Operacion.Pedido (IdClienteOrigen,IdClienteDestino,Delivery,Peso,Piezas,Estatus) VALUES({0},{1},''{2}'',{3},{4},''{5}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("operacion","view_pedido");
            modalAgregarPedido.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EliminaPedido(Pedido pedido){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{PedidoActual.IdPedido};
            String sql = 
                    MessageFormat.format("UPDATE operacion.pedido SET estatus = ''CANCELADO'' WHERE IdPedido = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("operacion","view_pedido");
            modalAgregarPedido.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Pedido GetPedido(int idregistro){
        
        Pedido pedido = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"operacion", "pedido",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdPedido = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                pedido = Pedido.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return pedido;
    }
    public ArrayList<Pedido> GetPedidos(){
        
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"operacion", "pedido","ACTIVO"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                pedidos.add(Pedido.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return pedidos;
    }
    public ArrayList<Pedido> GetPedidosxViaje(int idviaje){
        
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"operacion", "pedido",idviaje};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdViaje = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                pedidos.add(Pedido.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return pedidos;
    }
    public void GuardaIdViajePedido(int idpedido,int idviaje){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{idpedido,idviaje};
            String sql = 
                    MessageFormat.format("UPDATE operacion.pedido SET IdViaje = {1}  WHERE IdPedido = {0}", params);
            
            sentencia.execute(sql);
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void GuardaIdViajePedidos(ArrayList<Pedido> pedidos, int idviaje){
        try
        {
          
            for(int i = 0; i< pedidos.size(); i++){
                
                int idpedido = pedidos.get(i).IdPedido;
                GuardaIdViajePedido(idpedido,idviaje);
            }
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //VIAJES
    public void GuardaViaje(Viaje viaje){
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();
            Object[] params = new Object[]{viaje.IdRuta,viaje.IdSucursal,viaje.Folio,viaje.PesoTotal,viaje.Estatus};
            String sql = 
                    MessageFormat.format("INSERT INTO Operacion.Viaje (IdRuta,IdSucursal,Folio,PesoTotal,Estatus) VALUES({0},{1},''{2}'',{3},''{4}'')", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("operacion","view_viaje");
            modalAgregarViaje.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al guardar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void EliminaViaje(Viaje viaje){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{ViajeActual.IdViaje};
            String sql = 
                    MessageFormat.format("UPDATE operacion.viaje SET estatus = ''CANCELADO'' WHERE IdViaje = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("operacion","view_viaje");
            modalAgregarViaje.dispose();
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void EditaViaje(Viaje viaje){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{ViajeActual.IdViaje,viaje.Estatus};
            String sql = 
                    MessageFormat.format("UPDATE operacion.viaje SET estatus = ''{1}'' WHERE IdViaje = {0}", params);
            
            sentencia.execute(sql);
            //Imprime los resultados de la tabla
            GetAllData("operacion","view_viaje");
            conexion.close();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error al editar el registro: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Viaje GetViaje(int idregistro){
        
        Viaje viaje = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"operacion", "viaje",idregistro};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE IdViaje = {2}", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                viaje = Viaje.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return viaje;
    }
    public Viaje GetViaje(String folio){
        
        Viaje viaje = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"operacion", "viaje",folio};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Folio = ''{2}'' AND Estatus != ''CANCELADO''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                viaje = Viaje.GetInstance(result);
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return viaje;
    }
    public ArrayList<Viaje> GetViajes(){
        
        ArrayList<Viaje> viajes = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,contrasena);
            java.sql.Statement sentencia = conexion.createStatement();

            Object[] params = new Object[]{"operacion", "viaje","ACTIVO"};
            String sql = MessageFormat.format("SELECT * FROM {0}.{1} WHERE Estatus = ''{2}''", params);
            
            ResultSet result = sentencia.executeQuery(sql);
            
            //Se itera sobre la tupla encontrada si es que existe
            while(result.next())
            {
                viajes.add(Viaje.GetInstance(result));
            }
            
            result.close();
            sentencia.close();
            
        }
        catch(Exception error){
            
        }
        
        return viajes;
    }
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Inicio("postgres","postgres").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCambiarEstatus;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHistorialViajes;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnRutas;
    private javax.swing.JButton btnSucursales;
    private javax.swing.JButton btnTarifas;
    private javax.swing.JButton btnTransportistas;
    private javax.swing.JButton btnUnidades;
    private javax.swing.JButton btnViajes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabla;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
