package com.ciamb.vcode.utility.date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SundayTest {

    Sunday sut;

    @BeforeEach
    public void setUp() {
        sut = new Sunday();
    }

    @Test
    void testGetLastSundayOf1() {
        var year = 2026;
        var month = Month.MARCH;

        var result = sut.getLastSundayOf(year, month);

        var expected = LocalDate.of(2026, 3, 29);
        assertEquals(expected, result);
    }

    @Test
    void testGetLastSundayOf2() {
        var year = 2025;
        var month = Month.MAY;

        var result = sut.getLastSundayOf(year, month);

        var expected = LocalDate.of(2025, 5, 25);
        assertEquals(expected, result);
    }

    
    @Test
    void testGetLastSundayOf3() {
        var year = 2027;
        var month = Month.OCTOBER;

        var result = sut.getLastSundayOf(year, month);

        var expected = LocalDate.of(2027, 10, 31);
        assertEquals(expected, result);
    }

    @Test
    void testGetLastSundayOf4() {
        var year = 2028;
        var month = Month.MARCH;

        var result = sut.getLastSundayOf(year, month);

        var expected = LocalDate.of(2028, 3, 26);
        assertEquals(expected, result);
    }

    @Test
    void testGetLastSundayOf5() {
        var year = 2030;
        var month = Month.MARCH;

        var result = sut.getLastSundayOf(year, month);

        var expected = LocalDate.of(2030, 3, 31);
        assertEquals(expected, result);
    }

}
