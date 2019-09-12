package ic.xptdd.mario.state;

import ic.xptdd.mario.KeyCode;

public class FireballState implements State {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
    switch (keyCode) {
            case DOWN:
                return crash();

            case JUMP:
                return jump();

            case ACTION:
                return shoot();

            default:
                return noop();
        }
    }
    
    private String crash() {
        return "Crashing";
    }

    private String jump() {
        return "Jumping";
    }

    private String shoot() {
        return "Shooting";
    }

    private String noop() {
        return "";
    }
}
