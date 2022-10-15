package _20_string_incrementer;

import _20_string_incrementer.StringIncrementer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringIncrementerTest {

    @Test
    void stringIncrementer() {
        StringIncrementer stringIncrementer = new StringIncrementer();
        assertEquals("foo1", stringIncrementer.stringIncrementer("foo"));
        assertEquals("foobar24", stringIncrementer.stringIncrementer("foobar23"));
        assertEquals("foo0043", stringIncrementer.stringIncrementer("foo0042"));
        assertEquals("foo10", stringIncrementer.stringIncrementer("foo9"));
        assertEquals("foo100", stringIncrementer.stringIncrementer("foo099"));
        assertEquals("foo1000000000000000000000000000000000000000000",
                stringIncrementer.stringIncrementer("foo999999999999999999999999999999999999999999"));
        assertEquals("foo100aaa000000000000000000111666666778865433456277897654vvvvv1900000",
                stringIncrementer.stringIncrementer("foo100aaa000000000000000000111666666778865433456277897654vvvvv1899999"));
        assertEquals("1", stringIncrementer.stringIncrementer(""));
    }
}