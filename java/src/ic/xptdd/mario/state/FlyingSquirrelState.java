package ic.xptdd.mario.state;

import ic.xptdd.mario.KeyCode;

public class FlyingSquirrelState implements State {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case DOWN:
                return crash();

            case JUMP:
                return glide();

            case ACTION:
                return run();

            default:
                return noop();
        }
    }

    private String crash() {
        return "Crashing";
    }

    private String glide() {
        return "Gliding";
    }

    private String run() {
        return "Running";
    }

    private String noop() {
        return "";
    }
}
