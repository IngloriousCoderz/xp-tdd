package ic.xptdd.button;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

import ic.xptdd.button.ASCIIButton;

public class ASCIIButtonTest {

    @Test
    public void testBase() {
        // given
        ASCIIButton button = new ASCIIButton(10, 10, "ciao");
        String[] expected = new String[]{
            "* * * * * * * * * * ",
            "*                 * ",
            "*                 * ",
            "*                 * ",
            "*       ciao      * ",
            "*                 * ",
            "*                 * ",
            "*                 * ",
            "*                 * ",
            "* * * * * * * * * * "
        };

        // when
        List<String> result = button.build();

        // then
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testOddRows() {
        // given
        ASCIIButton button = new ASCIIButton(7, 10, "ciao");
        String[] expected = new String[]{
            "* * * * * * * * * * ",
            "*                 * ",
            "*                 * ",
            "*       ciao      * ",
            "*                 * ",
            "*                 * ",
            "* * * * * * * * * * "
        };

        // when
        List<String> result = button.build();

        // then
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testOddColumns() {
        // given
        ASCIIButton button = new ASCIIButton(10, 7, "ciao");
        String[] expected = new String[]{
            "* * * * * * * ",
            "*           * ",
            "*           * ",
            "*           * ",
            "*    ciao   * ",
            "*           * ",
            "*           * ",
            "*           * ",
            "*           * ",
            "* * * * * * * "
        };

        // when
        List<String> result = button.build();

        // then
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testOddPhrase() {
        // given
        ASCIIButton button = new ASCIIButton(10, 10, "hello");
        String[] expected = new String[]{
            "* * * * * * * * * * ",
            "*                 * ",
            "*                 * ",
            "*                 * ",
            "*      hello      * ",
            "*                 * ",
            "*                 * ",
            "*                 * ",
            "*                 * ",
            "* * * * * * * * * * "
        };

        // when
        List<String> result = button.build();

        // then
        assertArrayEquals(expected, result.toArray());
    }
    
    @Test
    public void testOddPhraseInOddColumns() {
        // given
        ASCIIButton button = new ASCIIButton(10, 9, "hello");
        String[] expected = new String[]{
            "* * * * * * * * * ",
            "*               * ",
            "*               * ",
            "*               * ",
            "*     hello     * ",
            "*               * ",
            "*               * ",
            "*               * ",
            "*               * ",
            "* * * * * * * * * "
        };

        // when
        List<String> result = button.build();

        // then
        assertArrayEquals(expected, result.toArray());
    }
}
