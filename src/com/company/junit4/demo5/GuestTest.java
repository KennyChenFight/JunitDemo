package com.company.junit4.demo5;


// 需額外加入的工具包
import static org.hamcrest.Matchers.*;

import static com.company.junit4.demo5.FirstOddItems.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class GuestTest {

    @Test
    public void testGenerate1() {
        Guest guest = new Guest();
        List<String> guests = guest.generate();
        assertTrue(guests.contains("Kenny") &&
                            guests.contains("Nicole"));
    }

    @Test
    public void testGenerate2() {
        Guest guest = new Guest();
        List<String> guests = guest.generate();
        assertThat(guests, hasItems("Kenny", "Nicole"));
    }

    @Test
    public void testGenerate3() {
        List<Integer> numbers = generate(5);
        assertTrue(numbers.get(0) < 5 &&
                numbers.get(1) < 5 &&
                numbers.get(2) < 5 &&
                numbers.get(3) < 5 &&
                numbers.get(4) < 5);
    }

    @Test
    public void testGenerate4() {
        List<Integer> numbers = generate(5);
        assertThat(numbers, everyItem(lessThan(5)));
    }

    private List<Integer> generate(int limit) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            list.add(i);
        }
        return list;
    }

    @Test
    public void testGenerate5() {
        Guest guest = new Guest();
        List<String> guests = guest.generate();
        assertThat(guests, firstOddItems("Kenny", "Nicole"));
    }
}
