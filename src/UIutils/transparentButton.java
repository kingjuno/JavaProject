package UIutils;

import java.awt.*;
import javax.swing.*;

import UIutils.*;

public class transparentButton extends JButton {
    public transparentButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}