import javax.swing.JOptionPane;

public class Driver {
    public static void main(String[] args) {
        try {
            LOGINPAGE form = new LOGINPAGE();
            form.setSize(500, 400);
            form.setVisible(true);
            form.invalidate();
            form.validate();
            form.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
