
package Patrones.ObjectPool;

import java.awt.Color;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import pruebabolas.Ball;

public  class BallPool implements IBallPool {
    private int size;
    private int timeout;
    private Boolean shutdown;
    private BlockingQueue objects;
    private BlockingQueue objectsDisponibles;
    private BlockingQueue objectsUsados;
    private IBallPoolFactory b;

    public BallPool(int size){
        this.size=size;
        shutdown=false;
        b= new BallPoolFactory();
        init();
    }
    private void init(){
     Color randomColor;
      objects = new LinkedBlockingQueue();
      objectsDisponibles = new LinkedBlockingQueue();
      objectsUsados = new LinkedBlockingQueue();
     int r,g,b;
      for (int i = 0; i < size; i++) {
        r = (int)Math.random()*256;
        g = (int)Math.random()*256;
        b = (int)Math.random()*256;
        randomColor = new Color(r, g, b);
        objects.add(this.b.createNew(randomColor));
        objectsDisponibles.add(this.b.createNew(randomColor));
      }
    }
    @Override
    public IPoolableBall getObject(Color color){
        IPoolableBall ball;
        if(!shutdown){
            ball=null;
            try{
                Iterator i= objectsDisponibles.iterator();
                Boolean bandera = true;
                IPoolableBall  ipb;
                while(i.hasNext()&&bandera==true){
                    ipb= (IPoolableBall)i.next();
                    if (ipb.getColor()==color){
                        ball=ipb;
                        this.objectsUsados.add(ipb);
                        this.objectsDisponibles.remove(ipb);
                        bandera=false;
                    }   
                }
                if(ball==null){
                    IPoolableBall ib=b.createNew(color);
                    objects.add(ib);
                    objectsUsados.add(ib);
                    ball=ib;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return ball;
        }
       throw new UnsupportedOperationException("Object pool is already shutdown."); 
    } 

    @Override
    public void releaceObject(IPoolableBall ball) {
      try {
            objectsUsados.offer(ball);
            objectsDisponibles.add(ball);
      } catch (Exception e) {
            e.printStackTrace();
      }
          }

    @Override
    public void shutdown() {
        objects.clear();
        objectsDisponibles.clear();
        objectsUsados.clear();
     
    }
}
