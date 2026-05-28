/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1parcial2;

/**
 *
 * @author nasry
 */
import java.awt.Color;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends JFrame {

    ManagerdeArchivos manager = new ManagerdeArchivos();
    private Color fondoBase = new Color(204, 233, 240);
    private JLabel lblRuta;
    private JLabel lblBusqueda;
    private JTextField txtRuta;
    private JTextField txtBusqueda;
    private JButton btnNext;
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

        btnNext = new JButton("Next");
        btnNext.setBounds(120, 170, 120, 35);

        btnNext.addActionListener(e -> {
            String rutaTexto = txtRuta.getText().trim();
            String busqueda = txtBusqueda.getText().trim();

            if (rutaTexto.isEmpty() || busqueda.isEmpty()) {
                areaResultados.setText("Error: Debe ingresar una ruta y un texto de busqueda.");
                return;
            }

            File carpeta = new File(rutaTexto);

            if (!carpeta.exists()) {
                areaResultados.setText("Error: La ruta no existe en el sistema de archivos.");
                return;
            }
            if (!carpeta.isDirectory()) {
                areaResultados.setText("Error: La ruta no corresponde a un directorio valido.");
                return;
            }

            manager.reset();
            manager.contar(carpeta);

            String resultado = "";
            resultado += "TXT: " + manager.getTxt() + " archivos\n";
            resultado += "JAVA: " + manager.getJavaFiles() + " archivos\n";
            resultado += "PDF: " + manager.getPdf() + " archivos\n";
            resultado += "OTROS: " + manager.getOtros() + " archivos\n\n";

            String encontrados = manager.buscar(carpeta, busqueda);
            if (encontrados.isEmpty()) {
                resultado += "No se encontraron archivos que coincidan con los criterios.";
            } else {
                resultado += encontrados;
            }

            areaResultados.setText(resultado);
        });

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        scroll = new JScrollPane(areaResultados);
        scroll.setBounds(20, 230, 330, 180);

        add(lblRuta);
        add(lblBusqueda);
        add(txtRuta);
        add(txtBusqueda);
        add(btnNext);
        add(scroll);
        setVisible(true);
    }

}