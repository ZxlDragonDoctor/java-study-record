package test.origanizationPattern;// OrganizationDemo.java

import java.util.ArrayList;
import java.util.List;

// 抽象组件
abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public abstract void distributeDocument(String document);
}

// 组合节点：可以包含下级机构
class OrganizationComposite extends OrganizationComponent {
    private List<OrganizationComponent> children = new ArrayList<>();

    public OrganizationComposite(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    @Override
    public void distributeDocument(String document) {
        System.out.println(name + " received and is distributing: " + document);
        for (OrganizationComponent component : children) {
            component.distributeDocument(document);
        }
    }
}

// 叶子节点：办公室
class OrganizationLeaf extends OrganizationComponent {
    public OrganizationLeaf(String name) {
        super(name);
    }

    @Override
    public void distributeDocument(String document) {
        System.out.println(name + " received the document: " + document);
    }
}

// 客户端模拟下发公文
public class OrganizationDemo {
    public static void main(String[] args) {
        // 根节点
        OrganizationComponent headquarters = new OrganizationComposite("北京总部");

        // 一级部门
        OrganizationComponent eduOffice = new OrganizationComposite("教务办公室");
        OrganizationComponent hnBranch = new OrganizationComposite("湖南分校");
        OrganizationComponent adminOffice = new OrganizationLeaf("行政办公室");

        // 教务办公室下属
        eduOffice.add(new OrganizationLeaf("教务办公室"));

        // 湖南分校下属
        OrganizationComponent changsha = new OrganizationComposite("长沙教学点");
        changsha.add(new OrganizationLeaf("教务办公室"));
        changsha.add(new OrganizationLeaf("行政办公室"));

        OrganizationComponent xiangtan = new OrganizationComposite("湘潭教学点");
        xiangtan.add(new OrganizationLeaf("教务办公室"));
        xiangtan.add(new OrganizationLeaf("行政办公室"));

        hnBranch.add(changsha);
        hnBranch.add(xiangtan);

        // 构建总部结构
        headquarters.add(eduOffice);
        headquarters.add(hnBranch);
        headquarters.add(adminOffice);

        // 模拟下发公文
        String document = "关于2024年秋季学期教学安排的通知";
        headquarters.distributeDocument(document);
    }
}
