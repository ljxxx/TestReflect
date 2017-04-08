package ljx;

/**
 * Created by liujiaxing on 2017/4/8.
 * ���������Ӧ���ڹ���ģʽ
 */
interface fruit {
    public abstract void eat();
}
class Apple implements fruit {
    public void eat() {
        System.out.println("eat Apple");
    }
}
class Orange implements fruit {
    public void eat() {
        System.out.println("eat Orange");
    }
}
class Factory {
    public static fruit getInstance(String ClassName) {
        fruit f = null;
        try {
            f = (fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
/**
 * ������ͨ�Ĺ���ģʽ�����������һ�������ʱ�򣬾���Ҫ��Ӧ���޸Ĺ����ࡣ ��������Ӻܶ�������ʱ�򣬻���鷳��
 * Java ����ģʽ���Բο�
 * http://baike.xsoftlab.net/view/java-factory-pattern
 *
 * �����������÷������ʵ�ֹ���ģʽ�������ڲ��޸Ĺ�����������������������ࡣ
 *
 * ������һ����Ȼ���鷳��������Ҫ֪�������İ������������������ʹ��properties�����ļ�����ɡ�
 *
 * java ��ȡ properties �����ļ� �ķ������Բο�
 * http://baike.xsoftlab.net/view/java-read-the-properties-configuration-file
 *
 * @author xsoftlab.net
 */
public class TestReflect6 {
    public static void main(String[] args) throws Exception {
        fruit f = Factory.getInstance("ljx.Apple");
        if (f != null) {
            f.eat();
        }
        fruit f2=Factory.getInstance(("ljx.Orange"));
        if(f2 !=null){
            f2.eat();
        }
    }
}
