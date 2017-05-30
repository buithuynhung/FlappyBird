import javax.swing.*;

public class MainFrame extends JFrame {
    private MainPanel panel;
    private final int height = 600, width = 400;

    private MainFrame(String s) {
        super(s);
        setSize(width, height);
        panel = new MainPanel(height, width);
        this.setContentPane(panel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame("Flappy Bird"));
    }
}
