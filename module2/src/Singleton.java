public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton(){

    }
    public static Singleton getSingleton(){
        if(uniqueInstance==null){
            synchronized(Singleton.class){
                if(uniqueInstance==null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
