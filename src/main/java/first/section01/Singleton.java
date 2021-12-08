package first.section01;

public class Singleton {
    static Singleton instance;
    static Singleton getInstance(){
      if(instance!=null){
        synchronized (Singleton.class){
          if(instance!=null){
            instance = new Singleton();
          }
        }
      }
      return instance;
    }
}