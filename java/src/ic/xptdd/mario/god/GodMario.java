package ic.xptdd.mario.god;

import ic.xptdd.mario.KeyCode;
import ic.xptdd.mario.Mario;

public class GodMario implements Mario {

    private Type type;

    public GodMario() {
        type = Type.BASE;
    }

    public GodMario(Type type) {
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case LEFT:
                return moveLeft();
            case RIGHT:
                return moveRight();
            case DOWN:
                switch (type) {
                    case SUPER:
                    case FIREBALL:
                    case FLYING_SQUIRREL:
                        return crash();
                    default:
                        return noop();
                }
            case JUMP:
                switch (type) {
                    case FLYING_SQUIRREL:
                        return glide();
                    default:
                        return jump();
                }
            case ACTION:
                switch (type) {
                    case FIREBALL:
                        return shoot();
                    default:
                        return run();

                }
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

    private String crash() {
        return "Crashing";
    }

    private String jump() {
        return "Jumping";
    }

    private String glide() {
        return "Gliding";
    }

    private String run() {
        return "Running";
    }

    private String shoot() {
        return "Shooting";
    }

    private String noop() {
        return "";
    }
}
