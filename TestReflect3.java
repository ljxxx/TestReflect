package ljx;

/**
 * Created by liujiaxing on 2017/4/7.
 * ��ȡһ������ĸ�����ʵ�ֵĽӿ�
 */
import java.io.Serializable;
public class TestReflect3 implements Serializable {
    private static final long serialVersionUID = -2862585049955236662L;
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ljx.TestReflect3");
        // ȡ�ø���
        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("clazz�ĸ���Ϊ��" + parentClass.getName());
        // clazz�ĸ���Ϊ�� java.lang.Object
        // ��ȡ���еĽӿ�
        Class<?> intes[] = clazz.getInterfaces();
        System.out.println("clazzʵ�ֵĽӿ��У�");
        for (int i = 0; i < intes.length; i++) {
            System.out.println((i + 1) + "��" + intes[i].getName());
        }
        // clazzʵ�ֵĽӿ��У�
        // 1��java.io.Serializable
    }
}
