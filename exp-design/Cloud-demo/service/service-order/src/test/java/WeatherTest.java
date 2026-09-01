import com.zxl.OrderMainApplication;
import com.zxl.feign.WeatherFeignClient;
import com.zxl.order.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OrderMainApplication.class)
public class WeatherTest {

    @Autowired
    WeatherFeignClient weatherFeignClient;
    @Test
    public void test() {
        String weather = weatherFeignClient.getWeather("自己的AppCode",
                "50b53ff8dd7d9fa320d3d3ca32cf8ed1","2182");
        System.out.println("weather = " + weather);
    }

}