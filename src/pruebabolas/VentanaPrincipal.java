/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabolas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author maryp
 */
public class VentanaPrincipal extends JFrame {
    public JLabel LabelCantidad;
    public JTextField txtCantidad;
    public JLabel LabelDireccion;
    public JComboBox comboDireccion;
    public JLabel LabelVelocidad;
    public JTextField txtVelocidad;
    public JLabel LabelColor;
    public JComboBox comboColor;
    public JLabel LabelPatron;
    public JComboBox comboPatron;
    public JButton btnAgregar;
    public JPanel panelMenu;
    public int windowWidth;
    public int windowHeight;
    public String windowLabel;
    public JLabel LabelTiempoEjecucion;
    public JLabel LabelTiempo;
    public VentanaPrincipal(){
        componentes();
        windowWidth = 200;
        windowHeight = 300;
        windowLabel = "Caso 2";
    }
    public void componentes(){
        panelMenu = new JPanel();
        panelMenu.setBackground(Color.WHITE);
        LabelCantidad = new JLabel();
        LabelCantidad.setText("Cantidad:");
        panelMenu.add(LabelCantidad);
        txtCantidad = new JTextField();
        panelMenu.add(txtCantidad);
        LabelDireccion = new JLabel();
        LabelDireccion.setText("Dirección:");
        panelMenu.add(LabelDireccion);
        comboDireccion = new JComboBox();
        comboDireccion.addItem("0");
        comboDireccion.addItem("45");
        comboDireccion.addItem("90");
        comboDireccion.addItem("135");
        comboDireccion.addItem("180");
        comboDireccion.addItem("225");
        comboDireccion.addItem("270");
        comboDireccion.addItem("315");
        panelMenu.add(comboDireccion);
        LabelVelocidad = new JLabel();
        LabelVelocidad.setText("Velocidad:");
        panelMenu.add(LabelVelocidad);
        txtVelocidad = new JTextField();
        panelMenu.add(txtVelocidad);
        LabelColor = new JLabel();
        LabelColor.setText("Color:");
        panelMenu.add(LabelColor);
        comboColor = new JComboBox();
        comboColor.setSize(60, 25);
        comboColor.addItem("negro");
        comboColor.addItem("gris");
        comboColor.addItem("rojo");
        comboColor.addItem("rosado");
        comboColor.addItem("amarillo");
        comboColor.addItem("naranja");
        comboColor.addItem("azul");
        comboColor.addItem("verde");
        panelMenu.add(comboColor);
        LabelPatron = new JLabel();
        LabelPatron.setSize(60, 60);
        LabelPatron.setText("Patron:");
        panelMenu.add(LabelPatron);
        comboPatron= new JComboBox();
        comboPatron.setSize(60,25);
        comboPatron.addItem("Builder");
        comboPatron.addItem("Factory");
        comboPatron.addItem("Prototype");
        comboPatron.addItem("Object pool");
        panelMenu.add(comboPatron);
        btnAgregar = new JButton();
        btnAgregar.setSize(60,25);
        btnAgregar.setText("Agregar");
        panelMenu.add(btnAgregar);
        LabelTiempoEjecucion = new JLabel();
        LabelTiempoEjecucion.setText("Tiempo de ejecucion: ");
        panelMenu.add(LabelTiempoEjecucion);
        LabelTiempo = new JLabel();
        LabelTiempo.setText("0 ms");
        panelMenu.add(LabelTiempo);
        panelMenu.setLayout(new BoxLayout(panelMenu,BoxLayout.PAGE_AXIS));
        this.add(panelMenu);
        
    }
    
}
