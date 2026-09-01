package test.bridgePattern;// BridgePatternDemo.java

interface Brand {
    void produce(String applianceType);
}

// 实现部分：品牌
class Haier implements Brand {
    public void produce(String applianceType) {
        System.out.println("Haier is producing a " + applianceType + ".");
    }
}

class TCL implements Brand {
    public void produce(String applianceType) {
        System.out.println("TCL is producing a " + applianceType + ".");
    }
}

class Hisense implements Brand {
    public void produce(String applianceType) {
        System.out.println("Hisense is producing a " + applianceType + ".");
    }
}

// 抽象部分：电器
abstract class Appliance {
    protected Brand brand;

    public Appliance(Brand brand) {
        this.brand = brand;
    }

    public abstract void produce();
}

class Television extends Appliance {
    public Television(Brand brand) {
        super(brand);
    }

    public void produce() {
        brand.produce("Television");
    }
}

class AirConditioner extends Appliance {
    public AirConditioner(Brand brand) {
        super(brand);
    }

    public void produce() {
        brand.produce("Air Conditioner");
    }
}

class Refrigerator extends Appliance {
    public Refrigerator(Brand brand) {
        super(brand);
    }

    public void produce() {
        brand.produce("Refrigerator");
    }
}

// 测试类
public class BridgePatternDemo {
    public static void main(String[] args) {
        Appliance tv1 = new Television(new Haier());
        Appliance ac1 = new AirConditioner(new TCL());
        Appliance fridge1 = new Refrigerator(new Hisense());

        tv1.produce();      // Haier is producing a Television.
        ac1.produce();      // TCL is producing an Air Conditioner.
        fridge1.produce();  // Hisense is producing a Refrigerator.
    }
}
