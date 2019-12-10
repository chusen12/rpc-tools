package it.chusen.tools.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chusen
 * @date 2019/12/10 16:12
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
        Class<UserTest> clazz = UserTest.class;
        UserTest userTest = clazz.newInstance();
        Method method = clazz.getMethod("eat", String.class);
        method.invoke(userTest,"屎");

        Field[] fields = clazz.getDeclaredFields();
        Field[] fieldAll = clazz.getFields();
        for (Field field : fieldAll) {
            System.out.println(field);
        }
        System.out.println("------------------------------");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("+====================================================");

        Method[] methods = clazz.getMethods();
        for (Method method1 : methods) {
            System.out.println(method1.getName());
        }
        System.out.println("------------------------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        System.out.println("------------------------------");

        Field userName = clazz.getField("userName");
        userName.setAccessible(true);
        userName.set(userTest,"huxueru");

        System.out.println(userTest.getUserName());
        System.out.println("#######################################################");


        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.getClass().getName());
        }


    }
}
