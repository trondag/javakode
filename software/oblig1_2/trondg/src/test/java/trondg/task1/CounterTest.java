package trondg.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class CounterTest {
    @Test
    void getNumbers(){
        assertEquals(1, Counter.count(1));
        assertEquals(2, Counter.count(2));
        assertEquals(3, Counter.count(3));
    }
}
