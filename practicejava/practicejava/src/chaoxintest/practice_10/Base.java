package chaoxintest.practice_10;

public class Base {
    private int privateVarOfBase = 1;
    public int publicVarOfBase = 1;
     int defaultVarOfBase = 1;
    protected void methodOfBase(){};
}
class Sub extends Base{
    public void methodOfSub(){
        publicVarOfBase = 2;
        defaultVarOfBase = 2;
//        privateVarOfBase = 2;
        methodOfBase();
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.publicVarOfBase = 3;
        sub.defaultVarOfBase = 3;
//        sub.privateVarOfBase = 3;
        sub.methodOfBase();
        sub.methodOfSub();
    }
}

