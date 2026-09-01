package test.decoratorPattern;

// Component 类：表示显示内容的组件
abstract class Component {
    public abstract void display();
}

// TextView 类：具体的文本显示组件
class TextView extends Component {
    @Override
    public void display() {
        System.out.println("展示文本组件");
    }
}

// PictureView 类：具体的图片显示组件
class PictureView extends Component {
    @Override
    public void display() {
        System.out.println("展示图片组件");
    }
}

// Decorator 类：装饰器类，用于包装 Component 类
abstract class Decorator extends Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}

// ScrollbarDecorator 类：为组件添加滚动条功能
class ScrollbarDecorator extends Decorator {
    public ScrollbarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("添加滚动条");
    }
}

// BorderDecorator 类：为组件添加黑色边框功能
class BorderDecorator extends Decorator {
    public BorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("添加边框");
    }
}

// 测试类
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // 创建一个普通的 TextView 组件
        Component textView = new TextView();
        textView.display();
        
        // 给 TextView 添加滚动条
        Component textViewWithScrollbar = new ScrollbarDecorator(textView);
        textViewWithScrollbar.display();
        
        // 给 TextView 添加黑色边框
        Component textViewWithBorder = new BorderDecorator(textView);
        textViewWithBorder.display();
        
        // 给 TextView 同时添加滚动条和黑色边框
        Component textViewWithScrollbarAndBorder = new BorderDecorator(textViewWithScrollbar);
        textViewWithScrollbarAndBorder.display();
        
        // 创建一个普通的 PictureView 组件
        Component pictureView = new PictureView();
        pictureView.display();
        
        // 给 PictureView 添加滚动条
        Component pictureViewWithScrollbar = new ScrollbarDecorator(pictureView);
        pictureViewWithScrollbar.display();
        
        // 给 PictureView 添加黑色边框
        Component pictureViewWithBorder = new BorderDecorator(pictureView);
        pictureViewWithBorder.display();
        
        // 给 PictureView 同时添加滚动条和黑色边框
        Component pictureViewWithScrollbarAndBorder = new BorderDecorator(pictureViewWithScrollbar);
        pictureViewWithScrollbarAndBorder.display();
    }
}
