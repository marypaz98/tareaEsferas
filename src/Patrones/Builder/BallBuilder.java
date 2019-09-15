/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones.Builder;

import java.awt.Color;
import javax.swing.JFrame;
import pruebabolas.Ball;

/**
 *
 * @author maryp
 */


public class BallBuilder implements IBuilder {
    private Color color;
    private int velocidad;
    private int orientacion;
    public BallBuilder() {}
    

    public BallBuilder setVelocidad(int vx){
        this.velocidad=vx;
        return this;
    }

    public BallBuilder setColor (Color color){
        this.color=color;
        return this;
    }

    public BallBuilder setOrientacion(int orien){
        this.orientacion=orien;
        return this;
    }



    @Override
    public Ball build() {
        return new Ball(this.color, this.velocidad,this.orientacion);
    }
     
}
