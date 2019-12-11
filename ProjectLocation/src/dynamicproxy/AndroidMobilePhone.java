package dynamicproxy;

public class AndroidMobilePhone implements MobilePhone {
    private String name = "肖振川";
    private String phone = "15383465922";

    public AndroidMobilePhone(){

    }
    public AndroidMobilePhone(String name , String phone){
        this.name = name;
        this.phone = phone;
    }
    @Override
    public String CallXzc() {
        String result = "请给" + this.name + "回电" +
                "电话是：" + this.phone;
        return result;
    }
}
