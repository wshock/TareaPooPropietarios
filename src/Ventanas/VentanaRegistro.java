package Ventanas;


import Utiles.Propietario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class VentanaRegistro extends Ventana{

    static JButton btnBack, btnRealizarRegistro;
    static JLabel lblTitulo, txtNombres, txtApellidos, txtDocumento, txtIdPropietario, txtEdad;
    static JTextField tfNombres, tfApellidos, tfDocumento, tfIdPropietario, tfEdad;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)){
            VentanaPrincipal.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnRealizarRegistro)){
            Propietario currentRegister = new Propietario(tfNombres.getText(),tfApellidos.getText(),tfDocumento.getText(),Integer.parseInt(tfEdad.getText()),tfIdPropietario.getText());
            VentanaPrincipal.listaPropietarios.add(currentRegister);
            VentanaListado.actualizarTabla();

            tfNombres.setText("");
            tfDocumento.setText("");
            tfApellidos.setText("");
            tfEdad.setText("");
            tfIdPropietario.setText("");


            VentanaPrincipal.ventanaPrincipal.setVisible(true);
            this.setVisible(false);

            VentanaPrincipal.listaPropietarios.forEach(x -> System.out.println(x.getNombres()));
        }
    }

    public VentanaRegistro() {
        super();
        setTitle("Registro Propietarios");

        agregarComponentes();
    }

    private void agregarComponentes(){
        colocarBotones();
        colocarLabels();

    }

    private void colocarLabels(){
        lblTitulo = new JLabel("Ingresa los datos para realizar el registro:");
        lblTitulo.setBounds(100,20,1000,20);
        lblTitulo.setFont(new Font("constantia",Font.BOLD,18));


        txtNombres = new JLabel("Nombres:");
        txtNombres.setBounds(20,60,100,20);
        tfNombres = new JTextField();
        tfNombres.setBounds(20,90,200,30);


        txtApellidos = new JLabel("Apellidos:");
        txtApellidos.setBounds(20,140,100,20);
        tfApellidos = new JTextField();
        tfApellidos.setBounds(20,170,200,30);

        txtDocumento = new JLabel("Documento:");
        txtDocumento.setBounds(20,220,100,20);
        tfDocumento = new JTextField();
        tfDocumento.setBounds(20,250,200,30);

        txtEdad = new JLabel("Edad:");
        txtEdad.setBounds(20,300,100,20);
        tfEdad = new JTextField();
        tfEdad.setBounds(20,330,200,30);

        txtIdPropietario = new JLabel("ID de Propietario:");
        txtIdPropietario.setBounds(20,380,100,20);
        tfIdPropietario = new JTextField();
        tfIdPropietario.setBounds(20,410,200,30);



        add(lblTitulo);

        add(txtNombres);
        add(tfNombres);

        add(txtApellidos);
        add(tfApellidos);

        add(txtDocumento);
        add(tfDocumento);

        add(txtEdad);
        add(tfEdad);

        add(txtIdPropietario);
        add(tfIdPropietario);
    }

    private void colocarBotones(){
        ImageIcon imgBack = new ImageIcon(".\\img\\back.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5,5,40,20);
        btnBack.addActionListener(this);

        btnRealizarRegistro = new JButton("Realizar registro");
        btnRealizarRegistro.setBounds(350,250, 200, 40);
        btnRealizarRegistro.addActionListener(this);

        add(btnBack);
        add(btnRealizarRegistro);
    }
}
