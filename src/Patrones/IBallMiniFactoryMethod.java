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
public interface IBallMiniFactoryMethod {
    public Ball crearBall(String color,int vx, int vy, int width, int height);
}
