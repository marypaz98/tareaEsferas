/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import java.util.HashMap;

/**
 *
 * @author maryp
 */
public class PrototypeFactory {
    public static  HashMap<Integer,IPrototype> prototypes = new HashMap<>();
    
    public static IPrototype getPrototype(Integer prototypeNum){
        return prototypes.get(prototypeNum).deepClone();
    }
    public static void addPrototype(Integer prototypeNum, IPrototype prototype){
        prototypes.put(prototypeNum, prototype);
    }
}
