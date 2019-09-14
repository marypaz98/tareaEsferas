/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.awt.Color;

/**
 *
 * @author maryp
 */
public interface IPoolableBall {
   // public void update();
    public void move180();
    public void move45();
    public void move90();
    public void move0();
    public void move135();
    public void move225();
    public void move270();
    public void move315();
    public Color getColor();
}
