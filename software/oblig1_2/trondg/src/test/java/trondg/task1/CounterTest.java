package trondg.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class CounterTest {
    @Test
    void getNumbers(){
        assertEquals(1, Counter.count(1));
    }
}
