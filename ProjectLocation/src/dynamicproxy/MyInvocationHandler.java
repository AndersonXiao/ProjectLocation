package dynamicproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    public Object object;

    public  MyInvocationHandler(){

    }

    public MyInvocationHandler(Object object){
        this.object = object;
    }
    @Override
    public void invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {

        System.out.println("前置处理");
        Object object =  method.invoke(this.object, args);
        System.out.println("后置处理");

    }
}
