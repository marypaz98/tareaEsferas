
package Patrones;

import java.awt.Color;


public interface IBallPool {
    public IPoolableBall getObject(Color color);
    public void releaceObject(IPoolableBall ball);
    public void shutdown();
}
