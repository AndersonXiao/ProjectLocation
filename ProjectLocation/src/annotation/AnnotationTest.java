package annotation;

@TestA
public class AnnotationTest {

    private String name;
    public AnnotationTest(){}
    public AnnotationTest(String name){
        this.name = name;
    }
    @TestA(xzc = "xzc")
    public void Hello(){
        System.out.println("Hello Annotation!");
    }
    
    @TestA(xzk = "xzk")
    public String findName(){

        return "哈哈哈";
    }
    @TestA(path = "niucun")
    public int TestAdd(int a , int b){
        int c = a + b;
        return c;
    }

}
