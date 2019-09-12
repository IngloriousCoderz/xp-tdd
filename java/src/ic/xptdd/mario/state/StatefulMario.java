package ic.xptdd.mario.state;

import ic.xptdd.mario.KeyCode;
import ic.xptdd.mario.Mario;

public class StatefulMario implements Mario {

    private State state;

    public StatefulMario() {
        state = new BaseState();
    }

    public StatefulMario(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case LEFT:
                return moveLeft();

            case RIGHT:
                return moveRight();

            default:
                return this.state.onKeyPressed(keyCode);
        }
    }

    private String moveLeft() {
        return "Moving left";
    }

    private String moveRight() {
        return "Moving right";
    }
}
