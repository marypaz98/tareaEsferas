
package Patrones;

import java.awt.Color;


public interface IBallPoolFactory {
    public IPoolableBall createNew(Color color);
}
