package UIutils;

import java.awt.*;
import javax.swing.*;

public class OpaqueButton extends JButton {
    public OpaqueButton(String text) {
        super(text);
        final Color[] loginButtonColors = {UtilsClass.COLOR_INTERACTIVE, Color.white};

        setBackground(loginButtonColors[0]);
        setFont(UtilsClass.FONT_GENERAL_UI);

    }
}
