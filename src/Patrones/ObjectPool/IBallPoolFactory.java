
package Patrones.ObjectPool;

import java.awt.Color;


public interface IBallPoolFactory {
    public IPoolableBall createNew(Color color);
}
