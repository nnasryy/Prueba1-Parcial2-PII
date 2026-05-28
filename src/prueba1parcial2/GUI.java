/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1parcial2;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends JFrame {

    private Color fondoBase = new Color(204, 233, 240);

    private JLabel lblRuta;
    private JLabel lblBusqueda;

    private JTextField txtRuta;
    private JTextField txtBusqueda;

    private JButton btnAnalizar;

    private JTextArea areaResultados;

    private JScrollPane scroll;

    public GUI() {

        setTitle("Manager de Archivos");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondoBase);

        setLayout(null);

    
        lblRuta = new JLabel("Ruta:");
        lblRuta.setBounds(20, 20, 100, 25);

        lblBusqueda = new JLabel("Buscar:");
        lblBusqueda.setBounds(20, 90, 100, 25);


        txtRuta = new JTextField();
        txtRuta.setBounds(20, 45, 330, 30);

        txtBusqueda = new JTextField();
        txtBusqueda.setBounds(20, 115, 330, 30);

   
        btnAnalizar = new JButton("Analizar");
        btnAnalizar.setBounds(120, 170, 120, 35);

    
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);

        scroll = new JScrollPane(areaResultados);
        scroll.setBounds(20, 230, 330, 180);

       
        add(lblRuta);
        add(lblBusqueda);

        add(txtRuta);
        add(txtBusqueda);

        add(btnAnalizar);

        add(scroll);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}