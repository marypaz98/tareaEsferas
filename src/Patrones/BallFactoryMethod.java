/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.awt.Color;
import javax.swing.JFrame;
import pruebabolas.Ball;

/**
 *
 * @author maryp
 */
public interface BallFactoryMethod {
    public Ball crearEsfera(Boolean nueva,String tipo,String c, Color color, int vx, int vy,int width, int height,int numEsfera, int newNumEsfera);
    

}
