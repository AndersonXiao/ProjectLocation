package dynamicproxy;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Proxy {

    public static Object newProxyInstance(Class classInfo, InvocationHandler hander) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        TypeSpec.Builder classType = TypeSpec.classBuilder("MobileProxy")
                .addSuperinterface(classInfo);
        /*FieldSpec fieldSpec = FieldSpec.builder(classInfo, "mobilePhone", Modifier.PRIVATE).build();
        classType.addField(fieldSpec);*/

        FieldSpec fieldSpec = FieldSpec.builder(InvocationHandler.class, "handler", Modifier.PUBLIC).build();
        classType.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(InvocationHandler.class, "handler")
                .addStatement("this.handler = handler")
                .build();
        classType.addMethod(constructorMethodSpec);

        Method[] methods = classInfo.getMethods();
        for(Method method : methods){
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addCode("try {\n")
                    .addStatement("\t$T method = " + classInfo.getName() + ".class.getMethod(\"" + method.getName() + "\")", Method.class)
                    .addStatement("\tthis.handler.invoke(this, method, null)")
                    .addCode("} catch(Exception e) {\n")
                    .addCode("\te.printStackTrace();\n")
                    .addCode("}\n")
                    .addStatement("return null")
                    .build();
            classType.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile.builder("dynamicproxy.proxy", classType.build()).build();

        String sourcePath = "C:/Users/JXY/Desktop/";
        javaFile.writeTo(new File(sourcePath));
        proxyCompiler.compile(new File(sourcePath + "/dynamicproxy/proxy/MobileProxy.java"));


        URL[] urls = new URL[] {new URL("file:/" + sourcePath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("dynamicproxy.proxy.MobileProxy");
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        Object object = constructor.newInstance(hander);

        return object;
    }

    /*public static Object loadClass(InvocationHandler handler) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String sourcePath = "C:/Users/JXY/Desktop/";
        URL[] urls = new URL[] {new URL("file:/" + sourcePath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("dynamicproxy.proxy.MobileProxy");
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        //MobilePhone mobilePhone = (MobilePhone) constructor.newInstance(new AndroidMobilePhone());
        Object object = constructor.newInstance(handler);
        return object;
    }*/
}
