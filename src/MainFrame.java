import javax.swing.*;

public class MainFrame extends JFrame{
    private MainPanel panel;

    private MainFrame(String s) {
        super(s);
        setSize(400, 600);
        setLocation(500, 50);
        panel = new MainPanel();
        this.setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame("Flappy Bird"));
    }
}
