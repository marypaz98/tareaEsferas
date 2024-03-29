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
    ArrayList<Ball> arr = new ArrayList();      //arraylist que proviene de algun patron
    JFrame frame;

    public AnimatedBalls(ArrayList<Ball> array) {
        this.arr = array;
        frame = new JFrame();
    }
    public void run(){
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

                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                for (Ball i : arr){                     //agrega las bolitas al frame de la ventana
                    frame.add(i);
                    frame.add(i);
                }
                
                frame.setSize(600, 600);
                frame.setVisible(true);
            }
        }); 
    } 

}