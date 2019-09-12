package ic.xptdd.mario.inheritance;

import ic.xptdd.mario.KeyCode;

public class FireballMario extends SuperMario {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case ACTION:
                return shoot();

            default:
                return super.onKeyPressed(keyCode);
        }
    }

    private String shoot() {
        return "Shooting";
    }
}
