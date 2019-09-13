/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabolas;

import Patrones.IPoolableBall;
import Patrones.IPrototype;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author maryp
 */
public class Ball implements IPrototype, IPoolableBall,Runnable {
       private int posX, posY, size;
        private Color color;
        private int width, height;
        private int vx;
        private int vy;
        private int numBall;

        public Ball(Color color, int vx, int vy,int width, int height) {
            this.posX = (int) Math.floor(Math.random() * 400);
            this.posY =(int) Math.floor(Math.random() * 410);
            this.size = 20;
            this.color = color;
            this.vx = vx;
            this.vy = vy;
            this.width=width;
            this.height=height;
        }
        public Ball(int posX, int posY, Color color, int vx, int vy,int width, int height) {
            this.posX = posX;
            this.posY =posY;
            this.size = 20;
            this.color = color;
            this.vx = vx;
            this.vy = vy;
            this.width=width;
            this.height=height;
        }
        public Ball(Color color){
            this.color=color;
            this.posX = (int) Math.floor(Math.random() * 400);
            this.posY =(int) Math.floor(Math.random() * 410);
            this.size=20;
        }
        public void setNumBall(int numBall){
            this.numBall=numBall;
        }
        public void setPosX(){
            this.posX = (int) Math.floor(Math.random() * 400);
        }
        public void setPosY(){
            this.posY =(int) Math.floor(Math.random() * 410);
        }
        public void setColor(Color color){
            this.color=color;
        }
        public void setVx(int vx){
            this.vx=vx;
        }
        public void setVy(int vy){
            this.vy=vy;
        }
        public void setWidth(int width){
            this.width=width;
        }
        public void setHeight(int height){
            this.height=height;
        }
       @Override
        public void update() {
            
            if (posX > width || posX < 0) {
                vx *= -1;
            }

            if (posY > height || posY < 0) {
                vy *= -1;
            }

            if (posX > width) {
                this.posX = width;
            }

            if (posX < 0) {
                this.posX = 0;
            }

            if (posY > height) {
                this.posY = height;
            }

            if (posY < 0) {
                this.posY = 0;
            }
            
            this.posX =this.posX+ vx;
            this.posY =this.posY+ vy;

        }

        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(posX, posY, size, size);
        }

    @Override
    public IPrototype clone() {
        return new Ball(this.posX,this.posY,this.color,this.vx,this.vy,this.width,this.height);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPrototype deepClone() {
        return clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        return this.color;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

