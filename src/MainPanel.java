import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel {
    private boolean died, started = false;
    private int score;
    private Size size = new Size();
    private Game game = new Game();

    public MainPanel() {
        setBackground(new Color(0, 191, 255));

        ActionListener timerListener = (ActionEvent e) -> {
            if (started) {
                score = 0;
                died = false;
                game.step();
                score = game.getScore();
                died = game.gameOver();
                if (died) {
                    started = false;
                    game = new Game();
                }
            }
            repaint();
        };

        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!started) {
                    started = true;
                }
                game.getBird().moveUp();
            }
        };


        this.addMouseListener(mouseListener);
        Timer timer = new Timer(25, timerListener);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.getBird().paintBird(g);
        game.getPipe().paintPipes(g);
        paintBackground(g);
    }


    public void paintBackground(Graphics g) {

        g.setColor(new Color(205, 133, 63));
        g.fillRect(0, size.heightMFrame - size.heightForeground, size.widthScreen, 10);

        g.setColor(new Color(67, 50, 33));
        g.fillRect(0, size.heightMFrame - size.heightForeground + 10, size.widthScreen, 500);

        g.setColor(Color.orange.brighter());
        g.setFont(new Font("Jokerman", Font.PLAIN, 35));

        if (!started) {
            if (died) {
                g.drawString("Game Over!", size.widthMFrame / 4, size.heightMFrame / 8);
                g.drawString("Score: " + String.valueOf(score), size.widthMFrame / 4 + 20, size.heightMFrame / 8 + 75);
            } else g.drawString("Click to start!", size.widthMFrame / 5, size.heightMFrame / 6);
        } else  g.drawString(String.valueOf(score), size.widthMFrame / 2, size.heightMFrame / 10);

    }
}