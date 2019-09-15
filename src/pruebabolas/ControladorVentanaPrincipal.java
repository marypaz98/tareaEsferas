/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabolas;

import Patrones.FactorySupremo.BallFactory;
import Patrones.ObjectPool.BallPool;
import Patrones.Prototype.PrototypeFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author maryp
 */
class ControladorVentanaPrincipal   {
    private VentanaPrincipal mainFrame;
    
 //   private DrawPanel drawPanel;
    private ArrayList<Ball> balls;
    private Timer time;
    private int interval;
    private Color color;
    private String patron;
    private int cantidad;
    private int velocidad;
    private int direccion;
    private BallFactory factory;
    private BallPool bp;
    private AnimatedBalls ab;
    public ControladorVentanaPrincipal(){
        this.bp= new BallPool(500);
        balls = new ArrayList<>();
        this.mainFrame = new VentanaPrincipal();
        this.mainFrame.setTitle(this.mainFrame.windowLabel);
        this.mainFrame.setSize(this.mainFrame.windowWidth, this.mainFrame.windowHeight);
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setVisible(true);
        this.mainFrame.btnAgregar.addActionListener(new StartAction());
        this.interval=35;
      this.factory= new BallFactory();
    }

    void run() {
       long tiempoInicial = System.currentTimeMillis();
       String c = (String)this.mainFrame.comboColor.getSelectedItem();
       Boolean nueva=true;
        int numBola= PrototypeFactory.prototypes.size()+1;
       for (int i = 0; i < cantidad; i++) {     
            Ball ball=factory.crearEsfera(bp,nueva, patron, c,color, this.velocidad,this.direccion,numBola, PrototypeFactory.prototypes.size()+1);
            balls.add(ball);
            nueva=false;
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoDiferencia = tiempoFinal - tiempoInicial;
        this.mainFrame.LabelTiempo.setText(Long.toString(tiempoDiferencia) + " ms");
    }
      public void asignarCantidad(){
          int cantidad = Integer.parseInt(this.mainFrame.txtCantidad.getText());
          this.cantidad=cantidad;
      }
      public void asignarPatron(){
          String patronEscogido = (String) this.mainFrame.comboPatron.getSelectedItem();
          this.patron=patronEscogido;
      }
      public void asignarColor(){
        String colorEscogido = (String)this.mainFrame.comboColor.getSelectedItem();
        switch(colorEscogido){
            case "negro":
                this.color = new Color(0,0,0);
                break;
            case "gris":
                this.color = new Color(128,128,128);
                break;
            case "rojo":
                this.color = new Color(255,0,0);
                break;
            case "rosado":
                this.color = new Color(255,175,175);
                break;
            case "naranja":
                this.color = new Color(255,200,0);
                break;
            case "amarillo":
                this.color = new Color(255,255,0);
                break;
            case "verde":
                this.color= new Color(0,255,0);
                break;
            case "azul":
                this.color = new Color(0,0,255);
                break;
        }
    }
      public void asignarVelocidad(){
          int vel = Integer.parseInt(this.mainFrame.txtVelocidad.getText());
          this.velocidad=vel;
      }
      public void asignarDireccion(){
          String direc= (String) this.mainFrame.comboDireccion.getSelectedItem();
          this.direccion = Integer.parseInt(direc);
      }

      


 
        class StartAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            asignarCantidad();
            asignarColor();
            asignarVelocidad();
            asignarDireccion();
            asignarPatron();
            run();
            if(ab==null){
               ab = new AnimatedBalls(balls);
               ab.run();
            }
            else{
             ab.arr=balls;
             ab.run();
            }
           
        }
    }
}
