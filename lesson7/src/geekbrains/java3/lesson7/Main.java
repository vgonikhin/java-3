package geekbrains.java3.lesson7;

import java.io.File;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception{
        Class testClass = TestClass.class;
        Method[] methods = testClass.getDeclaredMethods();

        if(checkSuites(methods)) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    method.invoke(null);
                }
            }

            for (int i = 0; i < 10; i++) {
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Test.class)) {
                        if (method.getAnnotation(Test.class).order() == i)
                            method.invoke(null, method.getAnnotation(Test.class).order());
                    }
                }
            }

            for (Method method : methods) {
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    method.invoke(null);
                }
            }
        } else throw new RuntimeException();
    }

    static boolean checkSuites(Method[] methods){
        int beforeCounter=0;
        int afterCounter=0;
        for (Method method : methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)) {
                beforeCounter++;
            } else if(method.isAnnotationPresent(AfterSuite.class)) {
                afterCounter++;
            }
        }
        return (beforeCounter<=1)&&(afterCounter<=1);

//        File f = new File("1.txt");
//        f.mkdir();
    }
}
