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

public class FirstProxy {

    public static Object newProxyInstance(Class classInfo) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        TypeSpec.Builder classType = TypeSpec.classBuilder("$Proxy0")
                .addSuperinterface(classInfo);
        FieldSpec fieldSpec = FieldSpec.builder(classInfo, "mobilePhone", Modifier.PUBLIC).build();
        classType.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(classInfo, "mobilePhone")
                .addStatement("this.mobilePhone = mobilePhone")
                .build();
        classType.addMethod(constructorMethodSpec);

        Method[] methods = classInfo.getMethods();
        for(Method method : methods){
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addStatement("$T.out.println(1)", System.class)
                    .addCode("\n")
                    .addStatement("this.mobilePhone." + method.getName() + "()")
                    .addCode("\n")
                    .addStatement("$T.out.println(2)", System.class)
                    .addStatement("return null")
                    .build();
            classType.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile.builder("dynamicproxy.proxy", classType.build()).build();

        String sourcePath = "C:/Users/JXY/Desktop/";
        javaFile.writeTo(new File(sourcePath));
        //proxyCompiler.compile(new File(sourcePath + "/dynamicproxy/proxy/MobileProxy.java"));

        //loadClass(classInfo);

        return null;
    }

    public static void loadClass(Class classInfo) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String sourcePath = "C:/Users/JXY/Desktop/";
        URL[] urls = new URL[] {new URL("file:/" + sourcePath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("dynamicproxy.proxy.MobileProxy");
        Constructor constructor = clazz.getConstructor(classInfo);
        MobilePhone mobilePhone = (MobilePhone) constructor.newInstance(new AndroidMobilePhone());
        mobilePhone.CallXzc();
    }
}
