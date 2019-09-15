
package pruebabolas;

import Patrones.ObjectPool.IPoolableBall;
import Patrones.Prototype.IPrototype;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Ball extends JPanel implements IPrototype, IPoolableBall,Runnable {
       private int posX, posY;
        private Color color;
        private int velocidad;
        private int orientacion;
        private int diameter;
        private long delay;
        private int numBall;

        public Ball(Color color, int vel,int orient) {
            this.posX = (int) Math.floor(Math.random() * 500);
            this.posY =(int) Math.floor(Math.random() * 500);
           this.diameter=20;
           this.delay=100;
            this.color = color;
            this.orientacion=orient;
            this.velocidad=vel;
            new Thread(this).start();
        }
        public Ball(int posX, int posY, Color color, int vel,int orient) {
            this.posX = posX;
            this.posY =posY;
            this.color = color;
            this.diameter=20;
            this.velocidad=vel;
            this.orientacion=orient;
            this.delay=100;
            new Thread(this).start();
        }
        public Ball(Color color){
            this.color=color;
            this.posX = (int) Math.floor(Math.random() * 500);
            this.posY =(int) Math.floor(Math.random() * 500);
            this.diameter=20;
            this.delay=100;
            new Thread(this).start();
        }
        public void setNumBall(int numBall){
            this.numBall=numBall;
        }
        public void setPosX(){
            this.posX = (int) Math.floor(Math.random() * 500);
        }
        public void setPosY(){
            this.posY =(int) Math.floor(Math.random() * 500);
        }
        public void setColor(Color color){
            this.color=color;
        }
        public void setOrientacion(int vx){
            this.orientacion=vx;
        }

        public void setVelocidad(int vel){
            this.velocidad=vel;
        }
   
    protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               Graphics2D g2 = (Graphics2D) g;

               int x = getX();
               int y = getY();

               g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               g.setColor(color);
               g.fillOval(0, 0, 10, 10); //agrega color al circulo
               g.setColor(Color.black);
               g2.drawOval(0, 0, 10, 10); //dibuja circulo
           }
            @Override
        public Dimension getPreferredSize() {
            return new Dimension(20, 20);
        }
        
        public void run() {
            
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        setLocation(posX, posY);
                    }
                });
            } catch (InterruptedException exp) {
                exp.printStackTrace();
            } catch (InvocationTargetException exp) {
                exp.printStackTrace();
            }

            while (isVisible()) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }

                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            if(orientacion == 90 || orientacion == 270){
                                move90();
                                repaint();
                            }
                            if(orientacion == 180 || orientacion == 0){
                                move180();
                                repaint();
                            }
                            if(orientacion == 45 || orientacion == 225){
                                move45();
                                repaint();
                            }
                            if(orientacion == 135 || orientacion == 315){
                                move135();
                                repaint();
                            }
                        }
                    });
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                } catch (InvocationTargetException exp) {

                }
            }
        } 

       @Override
        public void move180() {

            int x = getX();
            int y = getY();

            if (x + velocidad < 0 || x + diameter + velocidad > getParent().getWidth()) {
                velocidad *= -1;
            }
            x += velocidad;

            setSize(getPreferredSize());
            setLocation(x, y);
        }
       @Override
        public void move90() {

            int x = getX();
            int y = getY();

            
            if (y + velocidad < 0 || y + diameter + velocidad > getParent().getHeight()) {
                velocidad *= -1;
            }
            y += velocidad;
            setSize(getPreferredSize());
            setLocation(x, y);

        }
       @Override
        public void move45() {

            int x = getX();
            int y = getY();

            
            if (y + velocidad < 0 || y + diameter + velocidad > getParent().getHeight()) {
                velocidad *= -1;
            }
            if (x + velocidad < 0 || x + diameter + velocidad > getParent().getWidth()) {
                velocidad *= -1;
            }
            x += velocidad;
            y += velocidad;
            setSize(getPreferredSize());
            setLocation(x, y);

        }
        
       @Override
        public void move135() {

            int x = getX();
            int y = getY();
            
            if(y + -velocidad < 0 || y + diameter + Math.abs(velocidad) > getParent().getHeight()){
                velocidad *= -1;
            }
            
            if (x + velocidad < 0 || x + diameter + velocidad > getParent().getWidth()) {
                velocidad *= -1;
            }
           
            x+= velocidad;
            y-= velocidad;
            
            setSize(getPreferredSize());
            setLocation(x, y);

        }
        

    @Override
    public IPrototype clone() {
        return new Ball(this.posX,this.posY,this.color,this.velocidad,this.orientacion);
    }

    @Override
    public IPrototype deepClone() {
        return clone(); 
    }

    @Override
    public Color getColor() {
        return this.color;
     }













 }

