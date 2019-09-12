package ic.xptdd.mario.inheritance;

import ic.xptdd.mario.KeyCode;

public class SuperMario extends BaseMario {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case DOWN:
                return crash();

            default:
                return super.onKeyPressed(keyCode);
        }
    }

    private String crash() {
        return "Crashing";
    }
}
