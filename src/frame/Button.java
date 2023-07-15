package frame;

import javax.swing.*;

public class Button extends JButton {
    private int value = -1;

    public Button() {

    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
