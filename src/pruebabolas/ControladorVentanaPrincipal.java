/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabolas;

import Patrones.BallFactory;
import Patrones.BallPool;
import Patrones.PrototypeFactory;
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
       // System.out.println("Si entra");
       String c = (String)this.mainFrame.comboColor.getSelectedItem();
       Boolean nueva=true;
        /* Generate balls */
       for (int i = 0; i < cantidad; i++) {
         //  BallPool bp,Boolean nueva,String tipo,String c, Color color, int velocidad, int orientacion, int numEsfera, int newNumEsfera
      
            Ball ball=factory.crearEsfera(bp,nueva, patron, c,color, this.velocidad,this.direccion,1, PrototypeFactory.prototypes.size()+1);
       
            /* Ball ball = new Ball(
                    /* Random positions from 0 to windowWidth or windowHeight */
                    
                    /* Random size from 10 to 30 */
                    
                    /* Random RGB colors*/
                  /*  color,
                    /* Random velocities from -5 to 5 */
                 //   5,//(int) Math.floor((Math.random() * 10) - 5),
                   // 0,//(int) Math.floor((Math.random() * 10) - 5),
           //         420,480
         //   );

            balls.add(ball);
            nueva=false;
        }

        /* Initialize program */
       
      /*  this.drawPanel = new DrawPanel(balls); 
        this.drawPanel.setBounds(0, 0, 400, 450);
        this.mainFrame.add(drawPanel);
        //this.mainFrame.add(mainFrame.panelMenu);
        this.mainFrame.repaint();
        System.out.println("Si sale");
        
        
*/

 
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
         // this.patron=patronEscogido;
      }

      


 
        class StartAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            asignarCantidad();
            asignarColor();
            asignarVelocidad();
            asignarDireccion();
            System.out.println(color.getRGB());
            asignarPatron();
            run();
            if(ab!=null){
                //ab = new AnimatedBalls(balls);
               ab.frame.setVisible(false);
            }
             ab=new AnimatedBalls(balls);
           
          //  else{
            //    ab.arr=balls;
                
           // }
           // ab=new AnimatedBalls(balls);
           
        }
    }
}