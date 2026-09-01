package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;


public class StudentApplicationTest {

    private IMocksControl control;
    private IStudent mockStudent;
    private StudentApplication studentApplication;

    @BeforeEach
    public void setUp() {
        control = EasyMock.createControl();
        mockStudent = control.createMock(IStudent.class);
        studentApplication = new StudentApplication();
        studentApplication.setStudent(mockStudent);
    }

    @Test
    public void testDoMethod() {
        // 设置预期行为
        EasyMock.expect(mockStudent.doMethod1()).andReturn("Method1");
        EasyMock.expect(mockStudent.doMethod2()).andReturn("Method2");
        EasyMock.expect(mockStudent.doMethod3()).andReturn("Method3");

        // 激活预期行为
        control.replay();

        // 执行测试
        String result = studentApplication.doMethod();
        assertEquals("Method1Method2Method3", result);

        // 验证预期行为是否被正确调用
        control.verify();
        String
    }
}