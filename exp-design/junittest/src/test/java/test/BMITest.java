package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import test.BMI;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BMITest {

//    @ParameterizedTest(name = "体重:{0}kg, 身高:{1}m => 预期:{2}, BMI≈{3}")
    @ParameterizedTest(name = "{0},{1},{2},{3}")
    @MethodSource("provideSpecificTestCases")
    public void testGetBMITypeWithSpecificCases(double weight, double height, String expectedType, double expectedBMI) {
        BMI bmi = new BMI(weight, height);
        assertEquals(expectedType, bmi.getBMIType());
    }

    private static Stream<Arguments> provideSpecificTestCases() {
        return Stream.of(
                // 格式：Arguments.of(体重, 身高, 预期输出, BMI值)
                Arguments.of(45, 1.6, "偏瘦", 17.58),
                Arguments.of(55, 1.6, "正常", 21.48),
                Arguments.of(68, 1.6, "偏胖", 26.56),
                Arguments.of(80, 1.6, "肥胖", 31.25)
        );
    }

}