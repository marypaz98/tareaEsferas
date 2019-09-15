/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.awt.Color;


public interface IPoolableBall {
    public void move180();
    public void move45();
    public void move90();
    public void move135();
    public Color getColor();
}
