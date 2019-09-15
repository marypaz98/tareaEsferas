
package Patrones;

import java.awt.Color;
import pruebabolas.Ball;


public interface IBallMiniFactoryMethod {
    public Ball crearBall(String color, int velocidad, int orientacion);
}
