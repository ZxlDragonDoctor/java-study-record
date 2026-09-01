package test1;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BMITest {


    @ParameterizedTest()
    public void getBMIType() {
    }
    @ParameterizedTest
    @ValueSource(strings = "1,2,3")
     void test01(String s){
        System.out.println(s);
    }

}