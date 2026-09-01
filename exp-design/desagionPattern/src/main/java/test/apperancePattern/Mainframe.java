package test.apperancePattern;

class Memory {
    public boolean check() {
        System.out.println("test.agency.Memory check passed.");
        return true; // 假设内存自检通过
    }
}
class CPUI {
    public boolean run() {
        System.out.println("CPU is running.");
        return true; // 假设CPU启动成功
    }
}
class HardDisk {
    public boolean read() {
        System.out.println("test.agency.HardDisk read operation successful.");
        return true; // 假设硬盘读取成功
    }
}

class OS {
    public boolean load() {
        System.out.println("Operating System is loading.");
        return true; // 假设操作系统加载成功
    }
}

public class Mainframe {
    private Memory memory;
    private CPUI cpu;
    private HardDisk hardDisk;
    private OS os;

    public Mainframe() {
        memory = new Memory();
        cpu = new CPUI();
        hardDisk = new HardDisk();
        os = new OS();
    }

    public void on() {
        System.out.println("Starting the test.agency.Mainframe...");
        
        if (memory.check() && cpu.run() && hardDisk.read() && os.load()) {
            System.out.println("test.agency.Mainframe started successfully.");
        } else {
            System.out.println("test.agency.Mainframe failed to start.");
        }
    }
    public static void main(String[] args) {
        Mainframe mainframe = new Mainframe();
        mainframe.on(); // 启动主机
    }
}


