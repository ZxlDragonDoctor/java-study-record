package com.zxl.RestAssured;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class TestCase {
    @Test
    void test(){
        given()
                .when()
                .get("https://vip.ceshiren.com/#/ui_study/frame")
                .then()
                .log().all();
    }
}
