package dynamicproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface InvocationHandler {

    void invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
