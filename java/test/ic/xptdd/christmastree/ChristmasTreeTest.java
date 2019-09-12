package ic.xptdd.christmastree;

import java.util.List;
import org.junit.Test;

import ic.xptdd.christmastree.ChristmasAngelDecorator;
import ic.xptdd.christmastree.ChristmasBallsDecorator;
import ic.xptdd.christmastree.ChristmasCandlesDecorator;
import ic.xptdd.christmastree.HeightTooSmallException;
import ic.xptdd.christmastree.OakTree;
import ic.xptdd.christmastree.PineTree;
import ic.xptdd.christmastree.Tree;

import static org.junit.Assert.*;

public class ChristmasTreeTest {

    private final static String PINE_WITH_BALLS_AND_CANDLES_REGEX = "^\\s*ì/[\\so\\*]+\\\\ì$";
    private final static String OAK_WITH_BALLS_AND_CANDLES_REGEX = "^ì\\|[\\so\\*]+\\|ì$";

    @Test
    public void testDefault() {
        Tree tree = new PineTree(7);
        String[] expected = new String[]{
            "    /\\",
            "   /  \\",
            "  /    \\",
            " /      \\",
            "/        \\",
            "----------",
            "    ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testMinimalHeight() {
        Tree tree = new PineTree(3);
        String[] expected = new String[]{
            "/\\",
            "--",
            "||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testEvenHeight() {
        Tree tree = new PineTree(8);
        String[] expected = new String[]{
            "     /\\",
            "    /  \\",
            "   /    \\",
            "  /      \\",
            " /        \\",
            "/          \\",
            "------------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test(expected = HeightTooSmallException.class)
    public void testImpossibleHeight() {
        Tree tree = new PineTree(2);
        tree.build();
    }

    @Test
    public void testAngel() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "    qp",
            "    /\\",
            "   /  \\",
            "  /    \\",
            " /      \\",
            "/        \\",
            "----------",
            "    ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testCandles() {
        Tree tree = new PineTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        String[] expected = new String[]{
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/    \\ì",
            " ì/      \\ì",
            "ì/        \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testCandlesAndAngel() {
        Tree tree = new PineTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "     qp",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/    \\ì",
            " ì/      \\ì",
            "ì/        \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testAngelAndCandles() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        String[] expected = new String[]{
            "    ìqpì",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/    \\ì",
            " ì/      \\ì",
            "ì/        \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testWholeChristmasTree() {
        Tree tree = new PineTree(7);
        tree = new ChristmasBallsDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "     qp",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/ o  \\ì",
            " ì/   *  \\ì",
            "ì/   o*** \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        int length = expected.length;
        int startOfRandomRows = 2;
        int afterRandomRows = length - 2;

        for (int i = 0; i < startOfRandomRows; i++) {
            assertEquals(expected[i], result.get(i));
        }
        for (int i = startOfRandomRows; i < afterRandomRows; i++) {
            assertTrue(result.get(i).matches(PINE_WITH_BALLS_AND_CANDLES_REGEX));
        }
        for (int i = afterRandomRows; i < length; i++) {
            assertEquals(expected[i], result.get(i));
        }
    }

    @Test
    public void testWholeChristmasTreeBuiltDifferently() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasBallsDecorator(tree);
        String[] expected = new String[]{
            "    ìqpì",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/ o  \\ì",
            " ì/   *  \\ì",
            "ì/   o*** \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        int length = expected.length;
        int startOfRandomRows = 2;
        int afterRandomRows = length - 2;

        for (int i = 0; i < startOfRandomRows; i++) {
            assertEquals(expected[i], result.get(i));
        }
        for (int i = startOfRandomRows; i < afterRandomRows; i++) {
            assertTrue(result.get(i).matches(PINE_WITH_BALLS_AND_CANDLES_REGEX));
        }
        for (int i = afterRandomRows; i < length; i++) {
            assertEquals(expected[i], result.get(i));
        }
    }

    @Test
    public void testOakTree() {
        Tree tree = new OakTree(10, 7);
        String[] expected = new String[]{
            "/--------\\",
            "|        |",
            "|        |",
            "\\--------/",
            "   \\\\//",
            "    ||",
            "    ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testMinimalHeightOnOak() {
        Tree tree = new OakTree(8, 5);
        String[] expected = new String[]{
            "/------\\",
            "\\------/",
            "  \\\\//",
            "   ||",
            "   ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test(expected = HeightTooSmallException.class)
    public void testImpossibleHeightOnOak() {
        Tree tree = new OakTree(8, 4);
        tree.build();
    }

    @Test
    public void testChristmasTreeFromOak() {
        Tree tree = new OakTree(10, 7);
        tree = new ChristmasBallsDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "     qp",
            "ì/--------\\ì",
            "ì| o   oo |ì",
            "ì|   *oo  |ì",
            "ì\\--------/ì",
            "    \\\\//",
            "     ||",
            "     ||"
        };

        List<String> result = tree.build();
        int length = expected.length;
        int startOfRandomRows = 2;
        int afterRandomRows = length - 4;

        for (int i = 0; i < startOfRandomRows; i++) {
            assertEquals(expected[i], result.get(i));
        }
        for (int i = startOfRandomRows; i < afterRandomRows; i++) {
            assertTrue(result.get(i).matches(OAK_WITH_BALLS_AND_CANDLES_REGEX));
        }
        for (int i = afterRandomRows; i < length; i++) {
            assertEquals(expected[i], result.get(i));
        }
    }
}
