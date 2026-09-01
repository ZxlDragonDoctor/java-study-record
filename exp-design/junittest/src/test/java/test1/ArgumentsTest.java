package test1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ArgumentsTest {
    @BeforeAll
    static void test02(){

    }
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
     void test01(String s){
        System.out.println(s);
    }

    @ParameterizedTest
    @MethodSource("providedTestCase")
    void test03(String a,Integer b,Double c){
        System.out.println();
    }
    static Stream<Arguments> providedTestCase(){
        return Stream.of(
                Arguments.of("a",1,1.0)
                ,Arguments.of("b",2,2.0)
        );
    }

}
