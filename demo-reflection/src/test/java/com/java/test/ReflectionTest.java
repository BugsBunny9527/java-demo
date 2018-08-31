package com.java.test;

import com.java.reflection.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by Luke Wang on 2018/8/31.
 * Java反射测试类
 */
public class ReflectionTest {

    /**
     * Class对象的newInstance()方法
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        String className = "com.java.reflection.Person";
        Class<?> aClass = Class.forName(className);
        //创建对应的运行时类的对象。使用newInstance()，实际上就是调用了运行时类的空参的构造器。
        //要想能够创建成功：①要求对应的运行时类要有空参的构造器。②构造器的权限修饰符的权限要足够。
        Object o = aClass.newInstance();
        Person person = (Person)o;
        System.out.println(person);
    }

    /**
     * 关于类的加载器：ClassLoader
     * @throws Exception
     */
    @Test
    public void test05() throws Exception{
        ClassLoader loader1 = ClassLoader.getSystemClassLoader();
        System.out.println(loader1);

        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);

        ClassLoader loader3 = loader2.getParent();
        System.out.println(loader3);

        Class clazz1 = Person.class;
        ClassLoader loader4 = clazz1.getClassLoader();
        System.out.println(loader4);

        String className = "java.lang.String";
        Class clazz2 = Class.forName(className);
        ClassLoader loader5 = clazz2.getClassLoader();
        System.out.println(loader5);

        //掌握如下
        //法一：从当前工程目录的包下获取
        ClassLoader loader = this.getClass().getClassLoader();

        //①读取类路径下的资源文件
        InputStream is01 = loader.getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is01);
        System.out.println("读取类路径下的资源文件:");
        System.out.println(pros.getProperty("user"));
        System.out.println(pros.getProperty("password"));

        //②读取类路径下特定包中的资源文件
        //对于maven项目来说，resources目录下的包结构会作为一个整体
        InputStream is02 = loader.getResourceAsStream("com.java.resources\\jdbc.properties");
        pros.load(is02);
        System.out.println("读取类路径下特定包中的资源文件:");
        System.out.println(pros.getProperty("user"));
        System.out.println(pros.getProperty("password"));

        //对于maven项目来说，java目录下的配置文件不会被解析到target中,所以下面的代码会报错
/*
        InputStream is03 = loader.getResourceAsStream("com\\java\\reflection\\jdbc.properties");
        pros.load(is03);
        System.out.println(pros.getProperty("user"));
        System.out.println(pros.getProperty("password"));

*/
        //法二：从当前工程根目录下获取
        FileInputStream is04 = new FileInputStream(new File("jdbc.properties"));
        pros.load(is04);
        System.out.println("从当前工程根目录下获取");
        System.out.println(pros.getProperty("user"));
        System.out.println(pros.getProperty("password"));

    }

    /**
     * 如何获取Class的实例（3种）
     * @throws ClassNotFoundException
     */
    @Test
    public void test04() throws ClassNotFoundException{
        //1.调用运行时类本身的.class属性
        Class clazz1 = Person.class;
        System.out.println(clazz1.getName());

        Class clazz2 = String.class;
        System.out.println(clazz2.getName());

        //2.通过运行时类的对象获取
        Person p = new Person();
        Class clazz3 = p.getClass();
        System.out.println(clazz3.getName());

        //3.通过Class的静态方法获取.通过此方式，体会一下，反射的动态性。
        String className = "com.java.reflection.Person";
        Class clazz4 = Class.forName(className);
        System.out.println(clazz4.getName());

        //4.（了解）通过类的加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz5 = classLoader.loadClass(className);
        System.out.println(clazz5.getName());

        System.out.println(clazz1 == clazz3);//true
        System.out.println(clazz1 == clazz4);//true
        System.out.println(clazz1 == clazz5);//true
    }

    /**
	 * java.lang.Class:是反射的源头。
	 * 我们创建了一个类，通过编译（javac.exe）,生成对应的.class文件。之后我们使用java.exe加载（JVM的类加载器完成的）
       此.class文件，此.class文件加载到内存以后，就是一个运行时类，存在在缓存区。那么这个运行时类本身就是一个Class的实例！
	 * 1.每一个运行时类只加载一次！
	 * 2.有了Class的实例以后，我们才可以进行如下的操作：
	 *     1）*创建对应的运行时类的对象
	 *     2）获取对应的运行时类的完整结构（属性、方法、构造器、内部类、父类、所在的包、异常、注解、...）
	 *     3）*调用对应的运行时类的指定的结构(属性、方法、构造器)
	 *     4）反射的应用：动态代理
     *
     * 输出结果：
     *          class com.java.reflection.Person
	 */
    @Test
    public void test03(){
        Person person = new Person();
        //通过运行时类的对象，调用其getClass()，返回其运行时类。
        Class<? extends Person> personClass = person.getClass();
        System.out.println(personClass);
    }

    /**
     * 有了反射，可以通过反射创建一个类的对象，并调用其中的结构
     * @throws Exception
     *
     * 输出结果：
     *          Person{name='null', age=0}
                Person{name='DaXiong', age=0}
                Person{name='DaXiong', age=17}
                我是一个人。
                我的国籍是：Japan
     */
    @Test
    public void test02() throws Exception {

        Class<Person> personClass = Person.class;

        //1.创建 personClass 对应的运行时类Person类的对象
        Person person = personClass.newInstance();
        System.out.println(person);

        //2.通过反射调用运行时类的指定的属性
        //2.1 获取 public 属性
        Field field01 = personClass.getField("name");
        field01.set(person, "DaXiong");
        System.out.println(person);
        //2.2 获取 private 属性
        Field field02 = personClass.getDeclaredField("age");
        field02.setAccessible(true);
        field02.set(person,17);
        System.out.println(person);

        //3.通过反射调用运行时类的指定的方法
        Method method01 = personClass.getMethod("show");
        method01.invoke(person);
        Method method02 = personClass.getMethod("display", String.class);
        method02.invoke(person, "Japan");


    }

    /**
     * 在有反射以前，创建一个类的对象，并调用其中的方法、属性
     *
     * 输出结果：
     *          Person{name='TangWei', age=10}
                我是一个人。
                我的国籍是：HK
     */
    @Test
    public void test01(){
        Person p = new Person();
        p.setAge(10);
        p.setName("TangWei");
        System.out.println(p);
        p.show();
		p.display("HK");
    }
}
