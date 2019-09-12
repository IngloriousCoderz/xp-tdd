package ic.xptdd.mario.state;

import ic.xptdd.mario.KeyCode;

public interface State {

    public String onKeyPressed(KeyCode keyCode);
}
