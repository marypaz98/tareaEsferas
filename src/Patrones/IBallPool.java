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
public interface IBallPool {
    public IPoolableBall getObject(Color color);
    public void releaceObject(IPoolableBall ball);
    public void shutdown();
}
