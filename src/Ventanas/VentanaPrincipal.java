package Ventanas;

import Utiles.Propietario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends Ventana {

    static JLabel lblTitulo;
    static JButton btnRegistrar, btnListar, btnBuscar;
    static VentanaRegistro ventanaRegistro;
    static VentanaBusqueda ventanaBusqueda;
    static VentanaListado ventanaListado;
    public static ArrayList<Propietario> listaPropietarios = new ArrayList<>();
    public static VentanaPrincipal ventanaPrincipal;

    static Font fuenteButtons = new Font("constantia",Font.BOLD,18);

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegistrar)) {
            ventanaRegistro.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnListar)){
            ventanaListado.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnBuscar)){
            ventanaRegistro.setVisible(true);
            this.setVisible(false);
        }
    }

    public VentanaPrincipal() {
        super();
        this.setTitle("Sistema Información - Propietarios (W&H)");
        agregarComponentes();

        ventanaRegistro = new VentanaRegistro();
        ventanaBusqueda = new VentanaBusqueda();
        ventanaListado = new VentanaListado();

        setVisible(true);
    }

    private void agregarComponentes(){
        colocarBotones();
        colocarLabels();
    }

    private void colocarLabels(){
        lblTitulo = new JLabel("Bienvenido, elige la opción que deseas realizar:");
        lblTitulo.setBounds(98,20,1000,20);
        lblTitulo.setFont(new Font("constantia",Font.BOLD,18));


        add(lblTitulo);
    }

    private void colocarBotones(){

        ImageIcon imgRegistrar = new ImageIcon(".\\img\\add.png");
        btnRegistrar = new JButton("Registrar propietario", imgRegistrar);
        btnRegistrar.setBounds(130, 60, 300, 50);
        btnRegistrar.setFont(fuenteButtons);
        btnRegistrar.addActionListener(this);

        ImageIcon imgListar = new ImageIcon(".\\img\\list.png");
        btnListar = new JButton("Listar propietarios", imgListar);
        btnListar.setBounds(130, 120, 300, 50);
        btnListar.setFont(fuenteButtons);
        btnListar.addActionListener(this);

        ImageIcon imgBuscar = new ImageIcon(".\\img\\search.png");
        btnBuscar = new JButton("Buscar propietarios", imgBuscar);
        btnBuscar.setBounds(130,180,300,50);
        btnBuscar.setFont(fuenteButtons);
        btnBuscar.addActionListener(this);

        add(btnRegistrar);
        add(btnListar);
        add(btnBuscar);
    }

    public static void main(String[] args) {

        ventanaPrincipal = new VentanaPrincipal();

    }



}
