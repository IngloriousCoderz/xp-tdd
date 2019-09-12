package ic.xptdd.mario.decorator;

import ic.xptdd.mario.KeyCode;
import ic.xptdd.mario.Mario;

public class SuperMario implements Mario {

    private Mario mario;

    public SuperMario(Mario mario) {
        this.mario = mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case DOWN:
                return crash();

            default:
                return mario.onKeyPressed(keyCode);
        }
    }

    private String crash() {
        return "Crashing";
    }
}
