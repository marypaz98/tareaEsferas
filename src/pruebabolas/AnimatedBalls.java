/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabolas;

/**
 *
 * @author maryp
 */

import java.awt.BorderLayout;

import java.awt.EventQueue;

import java.util.ArrayList;
import javax.swing.JFrame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AnimatedBalls {
    ArrayList<Ball1> arr = new ArrayList();      //arraylist que proviene de algun patron
    
    public static void main(String[] args) {      
        ArrayList<Ball1> array = new ArrayList();
        for(int i=0;i<500;i++){
            array.add(new Ball1("blue",30,90));           //color,velocid X, velocid Y, angulo
            array.add(new Ball1("green",10,180));
        }
        
        
        new AnimatedBalls(array);
    } 

    public AnimatedBalls(ArrayList<Ball1> array) {
        this.arr = array;
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {        
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                for (Ball1 i : arr){                     //agrega las bolitas al frame de la ventana
                    frame.add(i);
                    frame.add(i);
                }
                
                frame.setSize(800, 800);
                frame.setVisible(true);
            }
        }); 
    } 

}