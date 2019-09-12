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
    public Ball crearEsfera(Boolean nueva,String tipo,String c, Color color, int vx, int vy, int width, int height, int numEsfera, int newNumEsfera) {
        switch(tipo){
            case "Builder":
                BallBuilder bb = new BallBuilder();
                return bb.setColor(color).setHeight(height).setWidth(width).setVx(vx).setVy(vy).build();
            case "Prototype":
                if (newNumEsfera==1){
                    //int posX, int posY, int size, Color color, int vx, int vy,int height, int width
                        Ball esfera = new Ball(color,vx,vy,width,height);
                        esfera.setNumBall(newNumEsfera);
                        PrototypeFactory.addPrototype(newNumEsfera, esfera);
                        System.out.println("nueva");
                        return esfera;
                }else{
                        Ball esfera = (Ball) PrototypeFactory.getPrototype(numEsfera);
                        esfera.setNumBall(newNumEsfera);
                        esfera.setColor(color);
                        esfera.setHeight(height);
                        esfera.setVx(vx);
                        esfera.setPosX();
                        esfera.setPosY();
                        esfera.setVy(vy);
                        esfera.setWidth(width);
                        System.out.println("no nueva");
                        PrototypeFactory.addPrototype(newNumEsfera, esfera);
                        return esfera;
                }
            case "Factory":
                BallMiniFactory bmf = new BallMiniFactory();
                return bmf.crearBall(c, vx, vy, width, height);
            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
        // //To change body of generated methods, choose Tools | Templates.
    }
    
}
