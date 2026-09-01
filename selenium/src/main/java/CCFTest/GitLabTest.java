package CCFTest;

import ch.qos.logback.core.joran.conditional.ThenAction;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.WeakHashMap;

public class GitLabTest {
    private static WebDriver webDriver;
    private static WebDriverWait wait;
    @BeforeAll
    public static void began(){
        webDriver = new EdgeDriver();
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(3));
        webDriver.get("https://contest.gitlab.ceba.ceshiren.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement user = webDriver.findElement(By.id("user_login"));
        user.sendKeys("2252406579@qq.com");
        WebElement password = webDriver.findElement(By.id("user_password"));
        password.sendKeys("Hogwarts2024");
        webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[2]/div[1]/form/button"))
                .click();
    }
    @AfterAll
    public static void tear(){
        webDriver.quit();
    }
    @Test
    void Group() throws InterruptedException {
        //点击群组
        webDriver.manage().window().maximize();
        WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"super-sidebar\"]/div[2]/div[1]/div[4]/ul/li[2]/a/div[3]"));
        ele.click();

        Thread.sleep(1000);
        //点击新建
        webDriver.findElement(By.xpath("//*[@id=\"content-body\"]/div[2]/div/a[2]/span"))
                .click();
        //新建
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"content-body\"]/div[2]/div[1]/div[2]/div/div[1]/a/div[2]/h3"))
                .click();

        //输入组名
        webDriver.findElement(By.xpath("//*[@id=\"group_name\"]"))
                .sendKeys("group_zxl6443");

        //选择just me
        webDriver.findElement(By.xpath("//*[@id=\"new_group\"]/div[5]/div/div/div[2]/div/label/span"))
                .click();
        //选择
        Thread.sleep(1000);
        webDriver.findElement(By.id("group_jobs_to_be_done")).click();
        webDriver.findElement(By.xpath("//*[@id=\"group_jobs_to_be_done\"]/option[2]"))
                .click();
        //提交
        webDriver.findElement(By.xpath("//*[@id=\"new_group\"]/div[8]/div/button/span")).click();
        Thread.sleep(1000);
    }

    @Test
    void manage() throws InterruptedException {
        webDriver.get("https://contest.gitlab.ceba.ceshiren.com/group_zxl64431");
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        wait.until((webDriver1 -> {
            webDriver.findElement(By.xpath("//*[@id=\"menu-section-button-管理\"]")).click();
            return     webDriver.findElement(By.xpath("//*[@id=\"menu-section-button-管理\"]"));

        })).click();
     //   webDriver.findElement(By.xpath("//*[@id=\"menu-section-button-管理\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"管理\"]/ul/li[2]/a/div[3]")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[@id=\"content-body\"]/div[2]/div/div[1]/div/button[2]/span"))
                .click();
        webDriver.findElement(By.xpath("//*[@id=\"invite-members-modal-57_search\"]"))
                .click();
        webDriver.findElement(By.xpath("//*[@id=\"token-selector56-dropdown-item-3434\"]/div/p/div/div/div/span"))
                .click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[@id=\"invite-members-modal-57_expires_at\"]"))
                .click();

        webDriver.findElement(By.xpath("//*[@id=\"invite-members-modal-57___BV_modal_footer_\"]/div/button[1]/span"))
                .click();
        Thread.sleep(1000);
    }
    @Test
    void delete() throws InterruptedException {
        webDriver.get("https://contest.gitlab.ceba.ceshiren.com/group_zxl6443");
        webDriver.manage().window().maximize();
        Thread.sleep(3000);

        webDriver.findElement(By.xpath("//*[@id=\"menu-section-button-设置\"]/span[3]"))
                .click();
        webDriver.findElement(By.xpath("//*[@id=\"设置\"]/ul/li[1]/a/div[3]"))
                .click();

        webDriver.findElement(By.xpath("//*[@id=\"js-advanced-settings\"]/div[1]/button"))
                .click();
        webDriver.findElement(By.xpath("//*[@id=\"js-remove-group-form\"]/div/button")).click();

        webDriver.findElement(By.xpath("//*[@id=\"confirm_name_input\"]")).sendKeys("group_zxl64431");
        webDriver.findElement(By.xpath("//*[@id=\"confirm-danger-modal___BV_modal_footer_\"]/button[2]/span")).click();
        Thread.sleep(1000);
    }

}
