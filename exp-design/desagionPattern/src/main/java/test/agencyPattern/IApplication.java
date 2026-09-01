package test.agencyPattern;

// IApplication接口：具体应用程序和代理类都实现这个接口
public interface IApplication {
    void run();
}

// Application类实现IApplication接口，代表实际的应用程序
class Application implements IApplication {
    @Override
    public void run() {
        System.out.println("test.agencyPattern.Application is running.");
    }
}

// Picture类，表示桌面快捷方式的图标
 class Picture {
    private String image;

    public Picture(String image) {
        this.image = image;
    }

    public void getImage() {
        System.out.println("Displaying image: " + image);
    }
}

// Shortcut类实现IApplication接口，作为代理类来代理实际应用程序
 class Shortcut implements IApplication {
    private IApplication application;
    private Picture picture;

    public Shortcut(Picture picture) {
        this.picture = picture;
    }

    public void setApplication(IApplication application) {
        this.application = application;
    }

    @Override
    public void run() {
        // 显示图片（图标）
        picture.getImage();
        // 代理调用应用程序的run()方法
        if (application != null) {
            application.run();
        } else {
            System.out.println("No application assigned to this shortcut.");
        }
    }
}

// 测试类，模拟桌面快捷方式的行为
class Test {
    public static void main(String[] args) {
        // 创建一个图片对象，模拟快捷方式的图标
        Picture picture = new Picture("test.agencyPattern.Application Icon");

        // 创建一个应用程序对象
        IApplication app = new Application();

        // 创建一个桌面快捷方式对象，并设置应用程序
        Shortcut shortcut = new Shortcut(picture);
        shortcut.setApplication(app);

        // 调用快捷方式的run()方法，间接启动应用程序
        shortcut.run();
    }
}
