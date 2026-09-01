package test.factoryPattern;

// 抽象产品：test.factoryPattern.CPU
interface CPU {
    void process();
}

// 具体产品：test.factoryPattern.PcCPU
class PcCPU implements CPU {
    public void process() {
        System.out.println("Processing with PC test.factoryPattern.CPU");
    }
}

// 具体产品：test.factoryPattern.MacCPU
class MacCPU implements CPU {
    public void process() {
        System.out.println("Processing with Mac test.factoryPattern.CPU");
    }
}

// 抽象产品：test.factoryPattern.RAM
interface RAM {
    void store();
}

// 具体产品：test.factoryPattern.PcRAM
class PcRAM implements RAM {
    public void store() {
        System.out.println("Storing data with PC test.factoryPattern.RAM");
    }
}

// 具体产品：test.factoryPattern.MacRAM
class MacRAM implements RAM {
    public void store() {
        System.out.println("Storing data with Mac test.factoryPattern.RAM");
    }
}

// 抽象工厂：test.factoryPattern.ComputerFactory
interface ComputerFactory {
    CPU createCPU();
    RAM createRAM();
}

// 具体工厂：PC工厂
class PcFactory implements ComputerFactory {
    public CPU createCPU() {
        return new PcCPU();
    }
    public RAM createRAM() {
        return new PcRAM();
    }
}

// 具体工厂：Mac工厂
class MacFactory implements ComputerFactory {
    public CPU createCPU() {
        return new MacCPU();
    }
    public RAM createRAM() {
        return new MacRAM();
    }
}

// 客户端代码
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // 创建 PC 设备
        ComputerFactory pcFactory = new PcFactory();
        CPU pcCPU = pcFactory.createCPU();
        RAM pcRAM = pcFactory.createRAM();
        pcCPU.process();
        pcRAM.store();

        // 创建 Mac 设备
        ComputerFactory macFactory = new MacFactory();
        CPU macCPU = macFactory.createCPU();
        RAM macRAM = macFactory.createRAM();
        macCPU.process();
        macRAM.store();
    }
}
