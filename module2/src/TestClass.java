import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> linkedList = new LinkedList<>();
        List<String> list = new ArrayList<>();
    }
    public static void printArray() {
        // 初始化一个 String 类型的数组
        String[] stringArr = new String[]{"hello", "world", "!"};
        // 修改数组元素的值
        stringArr[0] = "goodbye";
        System.out.println(Arrays.toString(stringArr));// [goodbye, world, !]
        // 删除数组中的元素，需要手动移动后面的元素
        for (int i = 0; i < stringArr.length - 1; i++) {
            stringArr[i] = stringArr[i + 1];
        }
        stringArr[stringArr.length - 1] = null;
        System.out.println(Arrays.toString(stringArr));// [world, !, null]

    }
    public static <E> void printArray(E[] inputArray) throws FileNotFoundException {
        String filename = "./module2/src/readme.txt";
        FileReader file = null;
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] stringArray = { "Hello", "World" };
        printArray(intArray);
        printArray(stringArray);
        Scanner sc = new Scanner(new File(filename));
        System.out.println(sc.nextLine());
        for (E element : inputArray) {
            System.out.println( element);
        }
    }
}
