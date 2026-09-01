package chaoxintest.practice_11;

public class WeatherForecast {  //主类
    public static void main(String args[]) {
        Weather weatherBeijing =new Weather();
        System.out.print("\n今天白天:");
        weatherBeijing.setState(new CloudyDayState());
        weatherBeijing.show();
        System.out.print("\n今天夜间:");
        weatherBeijing.setState(new LightRainState());
        weatherBeijing.show();
        System.out.print("转:");
        weatherBeijing.setState(new HeavyRainState());
        weatherBeijing.show();
        System.out.print("\n明天白天:");
        weatherBeijing.setState(new LightRainState());
        weatherBeijing.show();
        System.out.print("\n明天夜间:");
        weatherBeijing.setState(new CloudyLittleState());
        weatherBeijing.show();
    }
}
class CloudyLittleState implements WeatherState {
    public void showState() {
        System.out.print("少云,有时晴.");
    }
}
class CloudyDayState implements WeatherState {
    //重写public void showState()
    public void showState(){
        System.out.println("多云，晴");
    }
}
class HeavyRainState implements WeatherState{
    //重写public void showState()
    public void showState(){
        System.out.println("暴雨， 阴");
    }
}
class LightRainState implements WeatherState {
     //重写public void showState()方法
     public void showState(){
         System.out.println("小雨，阴");
     }
}