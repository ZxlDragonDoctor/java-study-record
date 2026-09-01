package chaoxintest.practice_11;

public interface WeatherState {   //接口
    public void showState();
}
 class Weather {
    WeatherState  state;//接口变量作为Weather类的成员变量
    public void show() {
        state.showState();
    }
    public void setState(WeatherState s) {
        state = s;
    }
}
