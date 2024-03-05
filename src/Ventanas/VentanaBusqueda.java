package Ventanas;

import Utiles.Propietario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class VentanaBusqueda extends Ventana{

    static JButton btnBack;
    static JLabel lblTitulo, lblID, lblRespuesta;
    static JTextField txtID;
    static JButton btnEnviarID;
    static DefaultTableModel model;
    static JTable tabla;
    static JScrollPane scrollpane;
    static Boolean ponerTabla;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)){
            // Reiniciar los campos
            txtID.setText("");
            lblRespuesta.setText("");
            model.setRowCount(0);

            // Volver a la ventana principal
            VentanaPrincipal.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource().equals(btnEnviarID)){
            String ingresadoID = txtID.getText();
            for (Propietario propietario: VentanaPrincipal.listaPropietarios){
                if (Objects.equals(ingresadoID, propietario.getId_Propietario())){
                    lblRespuesta.setText("El propietario con ID " + ingresadoID + " sí se encuentra: ");
                    actualizarTabla(propietario);
                    break;
                }
                else {
                    lblRespuesta.setText("Ese ID no ha sido ingresado ");
                    model.setRowCount(0);
                }
            }
        }

    }

    public VentanaBusqueda() {
        super();
        setTitle("Busqueda Propietarios");

        agregarComponentes();

    }

    private void agregarComponentes(){

        colocarBotones();
        colocarLabels();
        colocarTabla();

    }

    private void colocarBotones(){
        ImageIcon imgBack = new ImageIcon(".\\img\\back.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5,5,40,20);
        btnBack.addActionListener(this);

        btnEnviarID = new JButton("Buscar");
        btnEnviarID.setBounds(285, 117, 100,25);
        btnEnviarID.addActionListener(this);



        add(btnBack);
        add(btnEnviarID);
    }


    private void colocarLabels(){
        lblTitulo = new JLabel("Búsqueda de propietarios:", SwingConstants.CENTER);
        lblTitulo.setBounds(0,30,600,40);
        lblTitulo.setFont(new Font("constantia",Font.BOLD,27));

        lblID = new JLabel("Ingresa el ID del propietario a buscar:");
        lblID.setBounds(20,90,240,20);

        txtID = new JTextField();
        txtID.setBounds(20, 115, 200, 30);


        lblRespuesta = new JLabel("", SwingConstants.CENTER);
        lblRespuesta.setBounds(0,230, 600, 50);
        lblRespuesta.setFont(new Font("constantia", Font.ITALIC, 20));


        add(lblTitulo);
        add(lblID);
        add(txtID);
        add(lblRespuesta);

    }

    private void colocarTabla(){
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        model.addColumn("Documento");
        model.addColumn("ID");


        scrollpane = new JScrollPane(tabla);
        scrollpane.setLocation(40,300);
        scrollpane.setSize(500,100);
        add(scrollpane, BorderLayout.CENTER);
    }

    private void actualizarTabla(Propietario propietario){
        model.setRowCount(0);
        model.addRow(propietario.getInformacionPropietario());
    }

}
