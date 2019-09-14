/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.awt.Color;
import pruebabolas.Ball;

/**
 *
 * @author maryp
 */
public class BallMiniFactory implements IBallMiniFactoryMethod {

    @Override
    public Ball crearBall(String color, int velocidad, int orientacion) {
        Color c;
        switch(color){
            case "negro":
                c = new Color(0,0,0);
                return new Ball(c,velocidad,orientacion);
            case "gris":
                c= new Color(128,128,128);
                return new Ball(c,velocidad,orientacion);
            case "rojo":
                c = new Color(255,0,0);
                return new Ball(c,velocidad,orientacion);
            case "rosado":
                c = new Color(255,175,175);
                return new Ball(c,velocidad,orientacion);
            case "naranja":
                c = new Color(255,200,0);
                return new Ball(c,velocidad,orientacion);
            case "amarillo":
                c = new Color(255,255,0);
                return new Ball(c,velocidad,orientacion);
            case "verde":
                c= new Color(0,255,0);
                return new Ball(c,velocidad,orientacion);
            case "azul":
                c = new Color(0,0,255);
                return new Ball(c,velocidad,orientacion);
            default:
                throw new UnsupportedOperationException("Not supported yet.");
                
        }
       //  //To change body of generated methods, choose Tools | Templates.
    }
    
}
