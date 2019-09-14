/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabolas;

import Patrones.IPoolableBall;
import Patrones.IPrototype;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author maryp
 */
public class Ball extends JPanel implements IPrototype, IPoolableBall,Runnable {
       private int posX, posY;
        private Color color;
      //  private int width, height;
        
       // private int vx;
       // private int vy;
        private int velocidad;
        private int orientacion;
        private int diameter;
        private long delay;
        private int numBall;

        public Ball(Color color, int vel,int orient) {
            this.posX = (int) Math.floor(Math.random() * 500);
            this.posY =(int) Math.floor(Math.random() * 500);
           // this.size = 20;
           this.diameter=20;
           this.delay=100;
            this.color = color;
            this.orientacion=orient;
            this.velocidad=vel;
           // this.vx = vx;
           // this.vy = vy;
          //  this.width=width;
          //  this.height=height;
            new Thread(this).start();
        }
        public Ball(int posX, int posY, Color color, int vel,int orient) {
            this.posX = posX;
            this.posY =posY;
           // this.size = 20;
            this.color = color;
            this.diameter=20;
            this.velocidad=vel;
            this.orientacion=orient;
            this.delay=100;
           // this.vx = vx;
           // this.vy = vy;
           // this.width=width;
           // this.height=height;
            new Thread(this).start();
        }
        public Ball(Color color){
            this.color=color;
            this.posX = (int) Math.floor(Math.random() * 500);
            this.posY =(int) Math.floor(Math.random() * 500);
            this.diameter=20;
            this.delay=100;
            //this.size=20;
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
     /*  @Override
        public void update() {
            
            if (posX > width || posX < 0) {
                vx *= -1;
            }

            if (posY > height || posY < 0) {
                vy *= -1;
            }

            if (posX > width) {
                this.posX = width;
            }

            if (posX < 0) {
                this.posX = 0;
            }

            if (posY > height) {
                this.posY = height;
            }

            if (posY < 0) {
                this.posY = 0;
            }
            
            this.posX =this.posX+ vx;
            this.posY =this.posY+ vy;

        }*/
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
             //  System.out.println("AQUIIIIIIIIIII  1111111");
                SwingUtilities.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        
                      //  int x = (int) (Math.round(Math.random() * 500));
                       // int y = (int) (Math.round(Math.random() * 500));
                        
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
                            if(orientacion == 90){
                                move90();
                                repaint();
                            }
                            if(orientacion == 180){
                                move180();
                                repaint();
                            }
                            if(orientacion == 45){
                                move45();
                                repaint();
                            }
                            if(orientacion == 0){
                              //  move0();
                                repaint();
                            }
                            if(orientacion ==135){
                               // move135();
                                repaint();
                            }
                            if(orientacion ==225){
                                //move225();
                                repaint();
                            }
                        }
                    });
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                } catch (InvocationTargetException exp) {
                    exp.printStackTrace();
                }
            }
        } 

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
    public IPrototype clone() {
        return new Ball(this.posX,this.posY,this.color,this.velocidad,this.orientacion);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPrototype deepClone() {
        return clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        return this.color;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void move135() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move225() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move270() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move315() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void move0() {
            int x = getX();
            int y = getY();

            if (x + velocidad < 0 || x + diameter + velocidad > getParent().getWidth()) {
                velocidad *= -1;
            } 
            x += velocidad;

            setSize(getPreferredSize());
            setLocation(x, y);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




 }

