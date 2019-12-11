package annotation;

import java.lang.reflect.Method;

public class MainTest {

    public static void main(String[] args){
        Class testClass = AnnotationTest.class;
        Class subClass = SubAnnotationTest.class;

        Method[] methods = testClass.getMethods();
        for(Method m : methods){
            TestA str = m.getAnnotation(TestA.class);
            System.out.println(str);
        }
    }
}
