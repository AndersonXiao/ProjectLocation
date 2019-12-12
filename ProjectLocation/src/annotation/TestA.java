package annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE , ElementType.METHOD,ElementType.TYPE_USE,ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
//@Repeatable(TestA.class)
public @interface TestA {
        String xzc() default "哥哥";
        String xzk() default "弟弟";
        String path()default  "山西";

}
