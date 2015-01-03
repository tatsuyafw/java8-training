package chapter9.exercise03;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MultipleExceptionTypesTest {
    private MultipleExceptionTypes exTypes;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        exTypes = new MultipleExceptionTypes();
    }

    @Test
    public void testThrowsFirstException() throws FirstException, SecondException {
        thrown.expect(FirstException.class);
        exTypes.process("First");
    }

    @Test
    public void testThrowsSecondException() throws FirstException, SecondException {
        thrown.expect(SecondException.class);
        exTypes.process("Second");
    }

}
