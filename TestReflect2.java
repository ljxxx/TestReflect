package ljx;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by liujiaxing on 2017/4/7.
 * 实例化Class类对象
 */
public class TestReflect2 {
    private String proprety = null;
    public static void main(String[] args) throws Exception {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // 一般采用这种形式
        class1 = Class.forName("ljx.TestReflect2");
        class2 = new TestReflect2().getClass();
        class3 = TestReflect2.class;
        System.out.println("类名称1   " + class1.getName());
        System.out.println("类名称2   " + class2.getName());
        System.out.println("类名称3   " + class3.getName());
        //输出结果
        //类名称1   ljx.TestReflect2
        //类名称2   ljx.TestReflect2
        //类名称3   ljx.TestReflect2
        System.out.println();
        System.out.println("下面输出用于测试通过通过反射机制调用某个类的方法:");
        Class<?> clazz = Class.forName("ljx.TestReflect2");
        // 调用TestReflect类中的reflect1方法
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        // Java 反射机制 - 调用某个类的方法1.
        // 调用TestReflect的reflect2方法
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "张三");
        // Java 反射机制 - 调用某个类的方法2.
        // age -> 20. name -> 张三
        System.out.println();
        System.out.println("下面输出用于测试通过反射机制操作某个类的属性:");
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));
        System.out.println();
        System.out.println("下面输出用于测试在泛型为Integer的ArrayList中存放一个String类型的对象:");
        ArrayList<Integer> list = new ArrayList<Integer>();
        Method method2 = list.getClass().getMethod("add", Object.class);
        method2.invoke(list, "String类型的对象,Java反射机制实例");
        System.out.println(list.get(0));
    }
    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }
}