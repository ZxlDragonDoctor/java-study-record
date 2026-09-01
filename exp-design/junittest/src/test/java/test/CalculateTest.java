package test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.Random.class)
class CalculateTest {
    private Calculate calculate;

    @BeforeEach
    void setUp() {
        calculate = new Calculate();
    }

    @AfterEach
    void tearDown() {
        calculate.CalAdd();
    }

    @Order(2)
    @Test
    void add() {
        calculate.CalAdd(2,3);
        assertEquals(5,calculate.add());
    }
    @Order(1)
    @Test
    void substract() {
        calculate.CalAdd(2,3);
        assertEquals(-1,calculate.substract());
    }
}