package ic.xptdd.mario.decorator;

import ic.xptdd.mario.KeyCode;
import ic.xptdd.mario.Mario;

public class FlyingSquirrelMario implements Mario {

    private Mario mario;

    public FlyingSquirrelMario(Mario mario) {
        this.mario = mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case JUMP:
                return glide();

            default:
                return mario.onKeyPressed(keyCode);
        }
    }

    private String glide() {
        return "Gliding";
    }
}
