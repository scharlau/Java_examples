package demo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HikerTest {
    @Test
    void life_the_universe_and_everything() {
        int expected = 42;
        int actual = Hiker.answer();
        assertEquals(expected, actual);
    }
    @Test
    void fizz_test(){
        int expected = 0;
        int actual = Hiker.fizz(3);
        assertEquals(expected, actual);

        int fail = 2;
        int fail_actual = Hiker.fizz(5);
        assertEquals(fail, fail_actual);
    }
    
    @Test
    void buzz_test(){
        int expected = 0;
        int actual = Hiker.buzz(5);
        assertEquals(expected, actual);

        int fail = 2;
        int fail_actual = Hiker.buzz(7);
        assertEquals(fail, fail_actual);
    }
    @Test
    void fizzbuzz_test(){
        boolean expected = true;
        boolean actual = Hiker.fizzbuzz(15);
        assertEquals(expected, actual);

        boolean fail = false;
        boolean fail_actual = Hiker.fizzbuzz(14);
        assertEquals(fail, fail_actual);
    }
}
