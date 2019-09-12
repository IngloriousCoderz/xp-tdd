package ic.xptdd.mario;

import static org.junit.Assert.assertEquals;

import ic.xptdd.mario.KeyCode;
import ic.xptdd.mario.Mario;

class MarioTestHelper {

    static void testBaseMario(Mario mario) {
        assertEquals("", mario.onKeyPressed(KeyCode.DOWN));
        assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
        assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
    }

    static void testSuperMario(Mario mario) {
        assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
        assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
        assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
    }

    static void testFireballMario(Mario mario) {
        assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
        assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
        assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
    }

    static void testFlyingSquirrelMario(Mario mario) {
        assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
        assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
        assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
    }
}
