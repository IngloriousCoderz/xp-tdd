package ic.xptdd.mario.inheritance;

import ic.xptdd.mario.KeyCode;
import ic.xptdd.mario.Mario;

public class BaseMario implements Mario {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case LEFT:
                return moveLeft();

            case RIGHT:
                return moveRight();

            case JUMP:
                return jump();

            case ACTION:
                return run();

            default:
                return noop();
        }
    }

    private String moveLeft() {
        return "Moving left";
    }

    private String moveRight() {
        return "Moving right";
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
