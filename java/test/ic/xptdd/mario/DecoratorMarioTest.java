package ic.xptdd.mario;

import org.junit.Test;

import ic.xptdd.mario.Mario;
import ic.xptdd.mario.decorator.BaseMario;
import ic.xptdd.mario.decorator.FireballMario;
import ic.xptdd.mario.decorator.FlyingSquirrelMario;
import ic.xptdd.mario.decorator.SuperMario;

public class DecoratorMarioTest {

    @Test
    public void testBaseMario() {
        Mario mario = new BaseMario();

        MarioTestHelper.testBaseMario(mario);
    }

    @Test
    public void testSuperMario() {
        Mario mario = new BaseMario();
        mario = new SuperMario(mario);

        MarioTestHelper.testSuperMario(mario);
    }

    @Test
    public void testFireballMario() {
        Mario mario = new BaseMario();
        mario = new SuperMario(mario);
        mario = new FireballMario(mario);

        MarioTestHelper.testFireballMario(mario);
    }

    @Test
    public void testFlyingSquirrelMario() {
        Mario mario = new BaseMario();
        mario = new SuperMario(mario);
        mario = new FlyingSquirrelMario(mario);

        MarioTestHelper.testFlyingSquirrelMario(mario);
    }
}
