package Ventanas;

import Utiles.Propietario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaListado extends Ventana{
    static JButton btnBack;
    static DefaultTableModel model;
    static JTable tabla;
    static JScrollPane scrollpane;
    static JLabel lblTitulo;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)){
            VentanaPrincipal.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }

    public VentanaListado() {
        super();
        setTitle("Listado Propietarios");

        agregarComponentes();
    }

    private void agregarComponentes(){
        colocarBotones();
        colocarTabla();
        colocarEtiquetas();
    }

    private void colocarBotones(){
        ImageIcon imgBack = new ImageIcon(".\\img\\back.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5,5,40,20);
        btnBack.addActionListener(this);



        add(btnBack);
    }

    private void colocarEtiquetas(){
        lblTitulo = new JLabel("Lista de propietarios:", SwingConstants.CENTER);
        lblTitulo.setBounds(0,30,600,40);
        lblTitulo.setFont(new Font("constantia",Font.BOLD,27));
        add(lblTitulo);


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
        scrollpane.setLocation(40,80);
        scrollpane.setSize(500,400);
        add(scrollpane, BorderLayout.CENTER);



    }

    public static void actualizarTabla(){
        model.setRowCount(0);
        for (Propietario elPropietario: VentanaPrincipal.listaPropietarios ){
            model.addRow(elPropietario.getInformacionPropietario());
        }
    }
}
