package ic.xptdd.mario.decorator;

import ic.xptdd.mario.KeyCode;
import ic.xptdd.mario.Mario;

public class FireballMario implements Mario {

    private Mario mario;

    public FireballMario(Mario mario) {
        this.mario = mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case ACTION:
                return shoot();

            default:
                return mario.onKeyPressed(keyCode);
        }
    }

    private String shoot() {
        return "Shooting";
    }
}
