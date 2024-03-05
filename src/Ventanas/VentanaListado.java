package Ventanas;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaListado extends Ventana{
    static JButton btnBack;

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
    }

    private void colocarBotones(){
        ImageIcon imgBack = new ImageIcon(".\\img\\back.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5,5,40,20);
        btnBack.addActionListener(this);



        add(btnBack);
    }
}
