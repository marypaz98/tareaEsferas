
package Patrones;

import java.awt.Color;
import javax.swing.JFrame;
import pruebabolas.Ball;

/**
 *
 * @author maryp
 */
public interface BallFactoryMethod {
    public Ball crearEsfera(BallPool bp,Boolean nueva,String tipo,String c, Color color, int velocidad, int orientacion, int numEsfera, int newNumEsfera);
    

}
