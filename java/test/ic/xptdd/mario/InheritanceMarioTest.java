package ic.xptdd.mario;

import org.junit.Test;

import ic.xptdd.mario.Mario;
import ic.xptdd.mario.inheritance.BaseMario;
import ic.xptdd.mario.inheritance.FireballMario;
import ic.xptdd.mario.inheritance.FlyingSquirrelMario;
import ic.xptdd.mario.inheritance.SuperMario;

public class InheritanceMarioTest {

    @Test
    public void testBaseMario() {
        Mario mario = new BaseMario();
        
        MarioTestHelper.testBaseMario(mario);
    }

    @Test
    public void testSuperMario() {
        Mario mario = new SuperMario();
        
        MarioTestHelper.testSuperMario(mario);
    }

    @Test
    public void testFireballMario() {
        Mario mario = new FireballMario();
        
        MarioTestHelper.testFireballMario(mario);
    }

    @Test
    public void testFlyingSquirrelMario() {
        Mario mario = new FlyingSquirrelMario();
        
        MarioTestHelper.testFlyingSquirrelMario(mario);
    }
}
