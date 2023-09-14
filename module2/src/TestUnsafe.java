

//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
//public class TestUnsafe {
//    private static Unsafe reflectGetUnsafe() {
//        try {
//            //这只是单独的字段类
//            Field field = Unsafe.class.getDeclaredField("theUnsafe");
//            //反射有修改安全检查的能力
//            field.setAccessible(true);
//            //字段后的get才是获取字段的值
//            return (Unsafe) field.get(null);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        Unsafe unsafe = reflectGetUnsafe();
//        System.out.println(unsafe);
//    }
//}
