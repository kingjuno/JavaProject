package UIutils;

import javax.swing.*;

public class transparentButton extends JButton {
    public transparentButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}