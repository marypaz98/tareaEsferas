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
public class BallBuilder implements IBuilder {
    private Color color;
    private int vx;
    private int vy;
    private int height;
    private int width;
    public BallBuilder() {}
    

    public BallBuilder setVx(int vx){
        this.vx=vx;
        return this;
    }
    public BallBuilder setVy(int vy){
        this.vy=vy;
        return this;
    }
    public BallBuilder setColor (Color color){
        this.color=color;
        return this;
    }

    public BallBuilder setHeight(int height){
        this.height=height;
        return this;
    }
    public BallBuilder setWidth(int width){
        this.width=width;
        return this;
    }


    @Override
    public Ball build() {
        return new Ball(this.color, this.vx, this.vy,this.width, this.height);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
