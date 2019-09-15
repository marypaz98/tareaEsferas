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
public class BallFactory implements BallFactoryMethod {

    @Override
    public Ball crearEsfera(BallPool bp,Boolean nueva,String tipo,String c, Color color, int velocidad, int orientacion, int numEsfera, int newNumEsfera) {
        switch(tipo){
            case "Builder":
                BallBuilder bb = new BallBuilder();
                return bb.setColor(color).setOrientacion(orientacion).setVelocidad(velocidad).build();
            case "Prototype":
                if (newNumEsfera==1){
                    //int posX, int posY, int size, Color color, int vx, int vy,int height, int width
                        Ball esfera = new Ball(color,velocidad,orientacion);
                        esfera.setNumBall(newNumEsfera);
                        PrototypeFactory.addPrototype(newNumEsfera, esfera);
                        //System.out.println("nueva");
                        return esfera;
                }else{
                        Ball esfera = (Ball) PrototypeFactory.getPrototype(numEsfera);
                        esfera.setNumBall(newNumEsfera);
                        esfera.setColor(color);
                        esfera.setVelocidad(velocidad);
                        esfera.setOrientacion(orientacion);
                        esfera.setPosX();
                        esfera.setPosY();
                        //System.out.println("no nueva");
                        PrototypeFactory.addPrototype(newNumEsfera, esfera);
                        return esfera;
                }
            case "Factory":
                BallMiniFactory bmf = new BallMiniFactory();
                return bmf.crearBall(c, velocidad,orientacion);
            case "Object pool":
                Ball esfera = (Ball) bp.getObject(color);
                esfera.setVelocidad(velocidad);
                esfera.setOrientacion(orientacion);
                return esfera;
                //throw new UnsupportedOperationException("Not supported yet.");
            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
        // //To change body of generated methods, choose Tools | Templates.
    }
    
}
