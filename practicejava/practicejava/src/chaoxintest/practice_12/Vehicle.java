    package chaoxintest.practice_12;

    public interface Vehicle {
    //    3、创建一个名称为Vehicle的接口，在接口中添加两个方法start()和stop()。
    //    在两个名称分别为Bike和Bus的类中实现Vehicle接口。创建一个名称为InterfaceDemo的类，
    //    在InterfaceDemo的main()方法中创建Bike和Bus对象，并访问start()和stop()方法。
        public void start();
        public void stop();
    }
    class Bike implements Vehicle{
        public void start(){
            System.out.println("自行车开始");
        }
        public void stop(){
            System.out.println("自行车停止");
        }
    }
    class Bus implements Vehicle{
        public void start(){
            System.out.println("公交车开始");
        }
        public void stop(){
            System.out.println("公交车车停止");
        }
    }
    class InterfaceDemo{
        public static void main(String[] args) {
            Vehicle vehicle;
            vehicle =new Bike();
            vehicle.start();
            vehicle.stop();
            vehicle = new Bus();
            vehicle.start();
            vehicle.stop();
        }
    }