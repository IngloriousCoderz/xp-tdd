package ic.xptdd.mario.state;

import ic.xptdd.mario.KeyCode;

public class SuperState implements State {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case DOWN:
                return crash();

            case JUMP:
                return jump();

            case ACTION:
                return run();

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

    private String run() {
        return "Running";
    }

    private String noop() {
        return "";
    }
}
