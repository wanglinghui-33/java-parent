package com.dream.freedom.reflex;

import com.dream.freedom.annotation.MyAnnotation;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;

/**
 * 反射机制
 * 获取某个类的字节码的三种方式：
 * 1、第一种：Class c = Class.forName(“完整类名包含包名”); 只写这个，就是类加载的过程
 * 2、第二种：Class c = 对象引用.getClass();
 * 3、第三种：Class c = 任何类型.class;
 */
public class ReflexMode {

    public static void main(String[] args) {
        ReflexMode mode = new ReflexMode();
        mode.getFieldByReflex();
    }

    /**
     * 通过反射给属性赋值和获取属性值
     */
    private void operationField(){
        try {
            // 获取类
            Class c = Class.forName("com.dream.freedom.reflex.ReflexDO");
            Object o = c.newInstance();
            System.out.println("-------------操作非private修饰的属性都可以------------");
            // 获取指定属性的值
            Field f = c.getDeclaredField("name");
            // 给属性赋值
            f.set(o,"王二小");
            // 获取属性的值
            Object value = f.get(o);
            System.out.println(value);
            System.out.println("-------------操作private修饰的属性，必须要给Filed的accessible设置true------------");

            Field fs = c.getDeclaredField("age");
            // 操作私有属性要给accessible设置成true
            fs.setAccessible(true);
            fs.set(o,1000);
            System.out.println(fs.get(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 案例：反编译字节码文件的所有属性
     */
    private void decompile(){
        try {
            //Class c = Class.forName("com.dream.freedom.reflex.ReflexDO");
            Class c = Class.forName("java.util.Date");
            StringBuilder sd = new StringBuilder();
            sd.append(Modifier.toString(c.getModifiers())).append(" class ").append(c.getSimpleName()).append("{\n");
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                sd.append("\t");
                if (0 != field.getModifiers()){
                    sd.append(Modifier.toString(field.getModifiers()));
                    sd.append(" ");
                }
                sd.append(field.getType().getSimpleName());
                sd.append(" ");
                sd.append(field.getName());
                sd.append(";\n");
            }
            sd.append("}");
            System.out.println(sd.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射获取字节码的属性
     */
    private void getFieldByReflex(){
        try {
            // 获取类
            Class c = Class.forName("com.dream.freedom.reflex.ReflexDO");
            System.out.println("完整类名：" + c.getName() +  ";简化类名：" + c.getSimpleName());
            /*
                Field 属性名 = c.getField("属性名");      // 获取指定名称的公开属性
                Field[] fields = c.getFields();         // 获取所有公开的属性
                c.getDeclaredFields();      获取所有的属性
                c.getDeclaredField("属性名");  获取指定属性名
             */
            Field[] declaredFields = c.getDeclaredFields();
            for (Field field : declaredFields) {
                // field.getType();    // 获取的是类型的完整类名
                System.out.println("修饰符：" + Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName() + ";");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getClassForName() {
        try {
            /*
                第一种：Class c = Class.forName(“完整类名包含包名”); 只写这个，就是类加载的过程
             */
            Class<?> c = Class.forName("java.lang.String");
            /*
                第二种：Class c = 对象引用.getClass();
             */
            ReflexDO reflexDO = new ReflexDO();
            Class aClass = reflexDO.getClass();
            /*
                第三种：Class c = 任何类型.class;
             */
            Class<String> c1 = String.class;
            Class<?> c2 = "abc".getClass();
            Class c3 = ReflexDO.class;

            // 返回true，说明class是一个
            System.out.println((c == c1));
            System.out.println(c == c2);
            System.out.println(c3 == aClass);

            /*
                这一步相当于对象实例化，调用的是对象的无参构造，如果没有无参构造，会报异常(java.lang.InstantiationException 实例化异常)
                该方法在JDK1.9之后废弃
             */
            Object o = c3.newInstance();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射获取注解信息
     */
    private void getAnnotation() {
        try {
            // 找到对应的注解
            Class c = Class.forName("com.dream.freedom.annotation.AnnotationOne");
            // 判断这个类是否包含注解
            System.out.println(c.isAnnotationPresent(MyAnnotation.class));
            if (c.isAnnotationPresent(MyAnnotation.class)) {
                // 如果包含这个注解就获取这个注解的相关信息
                // 获取这个注解
                MyAnnotation annotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
                // 获取注解中的属性值
                System.out.println(annotation.value() + ":" + annotation.age());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类加载器
     * 类加载器有很多种
     */
    private void getLoader() {
        /*
            Thread.currentThread() 获取当前线程
            getContextClassLoader() 这个是线程对象的方法，可以获取当前线程的类加载对象
         */
        Thread.currentThread().getContextClassLoader();
        ReflexDO.class.getClassLoader();
    }

    /**
     * 获取文件路径
     */
    private void getPath() {
        // 如果getResource("") 参数传空字符串，返回的是Target/classes 路径信息
        URL resource = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(resource);
        /*
            Thread.currentThread() 获取当前线程
            getContextClassLoader() 这个是线程对象的方法，可以获取当前线程的类加载对象
            getResource() 【获取资源】这个是类加载器的方法，当前线程的类加载器默认从类的根目录下加载资源
            这样就可以获取文件的绝对路径
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("person.txt").getPath();
        System.out.println(path);
        // 直接以流的形式返回
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream("");
        /*
            这样就会报错，因为类加载getResource()获取资源的-法，是从类的根目录下加载资源的
            而property.properties 在io文件夹下，所以直接获取不到，
         */
        // String path2 = Thread.currentThread().getContextClassLoader().getResource("property.properties").getPath();

    }


}
