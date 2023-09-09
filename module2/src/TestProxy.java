import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

interface sendMessage{
    String send(String Message);
}
class sendMessageImpl implements sendMessage{
    @Override
    public String send(String Message) {
        return Message;
    }
}
class DebugInvocationHandler implements InvocationHandler {
    private Object target;
    public DebugInvocationHandler(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable {
        System.out.println("before"+method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after"+method.getName());
        return result;
    }
}
class JdkproxyFactory{
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new DebugInvocationHandler(target));
    }
}
public class TestProxy{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("hello");
    }
    static void TestLinkedList(String[] args){
        sendMessage sendMessage = (sendMessage) JdkproxyFactory.getProxy(new sendMessageImpl());
        System.out.println(sendMessage.send("hello"));
        // 创建 LinkedList 对象
        LinkedList<String> list = new LinkedList<>();

// 添加元素到链表末尾
        list.add("apple");
        list.add("banana");
        list.add("pear");
        System.out.println("链表内容：" + list);

// 在指定位置插入元素
        list.add(1, "orange");
        System.out.println("链表内容：" + list);

// 获取指定位置的元素
        String fruit = list.get(2);
        System.out.println("索引为 2 的元素：" + fruit);

// 修改指定位置的元素
        list.set(3, "grape");
        System.out.println("链表内容：" + list);

// 删除指定位置的元素
        list.remove(0);
        System.out.println("链表内容：" + list);

// 删除第一个出现的指定元素
        list.remove("banana");
        System.out.println("链表内容：" + list);

// 获取链表的长度
        int size = list.size();
        System.out.println("链表长度：" + size);

// 清空链表
        list.clear();
        System.out.println("清空后的链表：" + list);

    }
}
