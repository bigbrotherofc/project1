import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TestDecorator {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./module2/src/readme.txt"))) {
            int content;
            HashSet<Integer> set = new HashSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            long skip = bis.skip(2);
            while ((content = bis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
