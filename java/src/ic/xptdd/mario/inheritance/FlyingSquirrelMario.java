package ic.xptdd.mario.inheritance;

import ic.xptdd.mario.KeyCode;

public class FlyingSquirrelMario extends SuperMario {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case JUMP:
                return glide();

            default:
                return super.onKeyPressed(keyCode);
        }
    }

    private String glide() {
        return "Gliding";
    }
}
