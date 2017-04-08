package ljx;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by liujiaxing on 2017/4/7.
 * ʵ����Class�����
 */
public class TestReflect2 {
    private String proprety = null;
    public static void main(String[] args) throws Exception {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // һ�����������ʽ
        class1 = Class.forName("ljx.TestReflect2");
        class2 = new TestReflect2().getClass();
        class3 = TestReflect2.class;
        System.out.println("������1   " + class1.getName());
        System.out.println("������2   " + class2.getName());
        System.out.println("������3   " + class3.getName());
        //������
        //������1   ljx.TestReflect2
        //������2   ljx.TestReflect2
        //������3   ljx.TestReflect2
        System.out.println();
        System.out.println("����������ڲ���ͨ��ͨ��������Ƶ���ĳ����ķ���:");
        Class<?> clazz = Class.forName("ljx.TestReflect2");
        // ����TestReflect���е�reflect1����
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        // Java ������� - ����ĳ����ķ���1.
        // ����TestReflect��reflect2����
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "����");
        // Java ������� - ����ĳ����ķ���2.
        // age -> 20. name -> ����
        System.out.println();
        System.out.println("����������ڲ���ͨ��������Ʋ���ĳ���������:");
        Object obj = clazz.newInstance();
        // ����ֱ�Ӷ� private �����Ը�ֵ
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java�������");
        System.out.println(field.get(obj));
        System.out.println();
        System.out.println("����������ڲ����ڷ���ΪInteger��ArrayList�д��һ��String���͵Ķ���:");
        ArrayList<Integer> list = new ArrayList<Integer>();
        Method method2 = list.getClass().getMethod("add", Object.class);
        method2.invoke(list, "String���͵Ķ���,Java�������ʵ��");
        System.out.println(list.get(0));
    }
    public void reflect1() {
        System.out.println("Java ������� - ����ĳ����ķ���1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java ������� - ����ĳ����ķ���2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }
}