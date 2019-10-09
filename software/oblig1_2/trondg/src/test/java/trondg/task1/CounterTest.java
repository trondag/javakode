package trondg.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CounterTest {
    @Test
    void testNumbers() throws TooNegativeException {
        assertEquals("1", Counter.count(1));
        assertEquals("2", Counter.count(2));
        assertEquals("100", Counter.count(120));

        assertEquals("Hi", Counter.count(3));
        assertEquals("Hi", Counter.count(6));
        assertEquals("Hi", Counter.count(9));

        assertEquals("Of", Counter.count(5));
        assertEquals("Of", Counter.count(10));

        assertEquals("HiOf", Counter.count(15));
        assertEquals("HiOf", Counter.count(30));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12})
    void testSeveralNumbers(int argument) throws TooNegativeException {
        assertEquals("Hi", Counter.count(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10,20,25})
    void testWidthMoreNumbers(int argument) throws TooNegativeException {
        assertEquals("Of", Counter.count(argument));
    }

    @Test
    void testNegativeNumber() throws TooNegativeException{
        assertEquals("1", Counter.count(-1));
    }
}
