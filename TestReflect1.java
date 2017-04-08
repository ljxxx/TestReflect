package ljx;
import java.lang.reflect.Constructor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * Created by liujiaxing on 2017/4/7.
 */
public class TestReflect1 implements Serializable{
    private static final long serialVersionUID = -2862585049955236662L;
    public static void main(String[] args) throws Exception {
        System.out.println("����������ڲ���ͨ��һ�������������İ���������:");
        TestReflect1 testReflect = new TestReflect1();
        System.out.println(testReflect.getClass().getName());
        // ��� ljx.TestReflect1


        System.out.println("����������ڲ��Ի�ȡĳ�����е�ȫ�����캯��:");
        Class<?> class1 = null;
        class1 = Class.forName("ljx.User");
        // ��һ�ַ�����ʵ����Ĭ�Ϲ��췽��������set��ֵ
        User user = (User) class1.newInstance();
        user.setAge(20);
        user.setName("Rollen");
        System.out.println(user);
        // ��� User [age=20, name=Rollen]
        // �ڶ��ַ��� ȡ��ȫ���Ĺ��캯�� ʹ�ù��캯����ֵ
        Constructor<?> cons[] = class1.getConstructors();
        // �鿴ÿ�����췽����Ҫ�Ĳ���
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }
        System.out.println("����������ڲ��Ի�ͨ��һ�������������İ���������:");
        Class<?> clazz = Class.forName("ljx.TestReflect1");
        System.out.println("===============��������===============");
        // ȡ�ñ����ȫ������
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // Ȩ�����η�
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // ��������
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        System.out.println("==========ʵ�ֵĽӿڻ��߸��������==========");
        // ȡ��ʵ�ֵĽӿڻ��߸��������
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // Ȩ�����η�
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // ��������
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }

    }
}
class User {
    private int age;
    private String name;

    public User() {
        super();
    }

    public User(String name) {
        super();
        this.name = name;
    }

    public User(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}
