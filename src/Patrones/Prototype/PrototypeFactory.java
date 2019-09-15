
package Patrones.Prototype;

import java.util.HashMap;


public class PrototypeFactory {
    public static  HashMap<Integer,IPrototype> prototypes = new HashMap<>();
    
    public static IPrototype getPrototype(Integer prototypeNum){
        return prototypes.get(prototypeNum).deepClone();
    }
    public static void addPrototype(Integer prototypeNum, IPrototype prototype){
        prototypes.put(prototypeNum, prototype);
    }
}
