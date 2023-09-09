import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestInvoke implements InvocationHandler {
    private Object target;
    public TestInvoke(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before"+method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after"+method.getName());
        return result;
    }
}
class TargetObject {
    private String value;
    public TargetObject() {
        value = "JavaGuide";
    }
    public void publicmethod1(String s) {
        System.out.println("method1"+s);
    }
    private void privatemethod2() {
        System.out.println("method2");
    }
}
class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        /**
         * 获取 TargetObject 类的 Class 对象并且创建 TargetObject 类实例
         */
        Class<?> targetClass = Class.forName("TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance(); //这和new也没啥区别
        /**
         * 获取 TargetObject 类中定义的所有方法
         */
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        /**
         * 获取指定方法并调用
         */
        Method publicMethod = targetClass.getDeclaredMethod("publicmethod1", String.class);//后面是类型
        //获得方法。然后把这个方法和具体的对象关联起来，然后调用
        publicMethod.invoke(targetObject, "JavaGuide");

        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = targetClass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "JavaGuide");

        /**
         * 调用 private 方法
         */
        Method privateMethod = targetClass.getDeclaredMethod("privatemethod2");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}

