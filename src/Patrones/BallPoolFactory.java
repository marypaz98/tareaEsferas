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
public class BallPoolFactory implements IBallPoolFactory {

    @Override
    public IPoolableBall createNew(Color color, int vx, int vy, int width, int height) {
        return new Ball(color,vx,vy,width,height);
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
