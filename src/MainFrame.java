import javax.swing.*;

public class MainFrame extends JFrame {
    private MainPanel panel;
    private Size size = new Size();

    private MainFrame(String s) {
        super(s);
        setSize(size.widthMFrame, size.heightMFrame);
        panel = new MainPanel();
        this.setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame("Flappy Bird"));
    }
}
