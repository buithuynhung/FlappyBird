import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel {

    private boolean died, started = false;
    private final int height, width;
    private int score;
    private Game game;

    public MainPanel(int height, int width) {

        this.height = height;
        this.width = width;

        game = new Game(height, width);

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
                    game = new Game(height, width);
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
        game.paintPipes(g);
        paintGame(g);
    }


    public void paintGame(Graphics g) {

        Color brown = new Color(205, 133, 63);
        g.setColor(brown);
        g.fillRect(0, game.getBorder(), width, 10);

        Color black = new Color(67, 50, 33);
        g.setColor(black);
        g.fillRect(0, game.getBorder() + 10, width, height - game.getBorder() - 10);

        g.setColor(Color.orange.brighter());
        g.setFont(new Font("Jokerman", Font.PLAIN, 35));

        if (!started) {
            if (died) {
                g.drawString("Game Over!", width / 4, height / 8);
                g.drawString("Score: " + String.valueOf(score), width / 4 + 20, height / 8 + 75);
            } else g.drawString("Click to start!", width / 5, height / 6);
        } else g.drawString(String.valueOf(score), width / 2, height / 10);

    }
}