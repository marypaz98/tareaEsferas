/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabolas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author maryp
 */
public class DrawPanel extends JPanel {
        private Timer time;
        private int interval;
        private java.util.List<Ball> balls;
        public DrawPanel(List<Ball> balls){
            this.balls=balls;
            interval=35;
          //  super.setBounds(0, 0, 410, 450);
            time= new Timer(interval,new TimerAction());
        }
        public DrawPanel(){
            balls = new ArrayList<>();
            interval=35;
         //   super.setBounds(0, 0, 410, 450);
         //   super.setBackground(Color.red);
            time= new Timer(interval,new TimerAction());
        }
        public void setAnimation(boolean turnOnOff) {
            if (turnOnOff) {
                time.start();  // start animation by starting the timer.
            } else {
                time.stop();   // stop timer
            }
        }
        
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            for (Ball b: balls) {
                 b.draw(graphics);
            }

        }

        
     class TimerAction implements ActionListener{
        
        public void mover(){
           // while (true) {
                for (Ball b: balls) {
                    b.update();
                    revalidate();
                    repaint();
                   // System.out.println("Siii");
                }


                /* Give Swing 10 milliseconds to see the update! */
               /* try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
               // System.out.println("Me cago en la puta");
              
    //    }
        
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mover();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
    }
}