package ic.xptdd.mario;

import org.junit.Test;

import ic.xptdd.mario.Mario;
import ic.xptdd.mario.state.BaseState;
import ic.xptdd.mario.state.FireballState;
import ic.xptdd.mario.state.FlyingSquirrelState;
import ic.xptdd.mario.state.StatefulMario;
import ic.xptdd.mario.state.SuperState;

public class StatefulMarioTest {

    @Test
    public void testBaseMario() {
        Mario mario = new StatefulMario(new BaseState());

        MarioTestHelper.testBaseMario(mario);
    }

    @Test
    public void testSuperMario() {
        Mario mario = new StatefulMario(new SuperState());

        MarioTestHelper.testSuperMario(mario);
    }

    @Test
    public void testFireballMario() {
        Mario mario = new StatefulMario(new FireballState());

        MarioTestHelper.testFireballMario(mario);
    }

    @Test
    public void testFlyingSquirrelMario() {
        Mario mario = new StatefulMario(new FlyingSquirrelState());

        MarioTestHelper.testFlyingSquirrelMario(mario);
    }
}
