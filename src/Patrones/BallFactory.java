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
                if (nueva){
                        Ball esfera = new Ball(color,velocidad,orientacion);
                        esfera.setNumBall(newNumEsfera);
                        PrototypeFactory.addPrototype(newNumEsfera, esfera);
                        return esfera;
                }else{
                        Ball esfera = (Ball) PrototypeFactory.getPrototype(numEsfera);
                        esfera.setPosX();
                        esfera.setPosY();
                        esfera.setNumBall(newNumEsfera);
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
            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
