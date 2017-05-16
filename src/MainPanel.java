import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel {
    private Pipes pipe = new Pipes(500, 0, 90, new Color(50, 235, 50));
    private Bird bird = new Bird(80, 200, 30, Color.YELLOW, pipe);
    private Score result = new Score(pipe, bird);
    private volatile boolean died, started = false;
    private GameOver game = new GameOver(bird);
    private int score;

    public MainPanel() {
        setBackground(new Color(0, 191, 255));

        ActionListener timerListener = (ActionEvent e) -> {
            if (started) {
                score = 0;
                died = false;
                pipe.scroll();
                bird.moveDown();
                score = result.getScore();
                died = game.gameOver();
                if (died) {
                    started = false;
                    pipe = new Pipes(500, 0, 90, new Color(50, 235, 50));
                    bird = new Bird(80, 200, 30, Color.YELLOW, pipe);
                    result = new Score(pipe, bird);
                    game = new GameOver(bird);
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
                bird.moveUp();
            }
        };


        this.addMouseListener(mouseListener);
        Timer timer = new Timer(25, timerListener);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        bird.paintBird(g);
        pipe.paintPipes(g);
        paintMFrame(g);
    }


    public void paintMFrame(Graphics g) {

        g.setColor(new Color(205, 133, 63));
        g.fillRect(0, 500, 1500, 10);

        g.setColor(new Color(67, 50, 33));
        g.fillRect(0, 510, 1500, 500);

        g.setColor(Color.orange.brighter());
        g.setFont(new Font("Jokerman", Font.PLAIN, 35));

        if (!started) {
//            g.drawString("Score: " + String.valueOf(score), 120, 130);
            if (died) {
                g.drawString("Game Over!", 100, 80);
                g.drawString("Score: " + String.valueOf(score), 120, 130);
            } else g.drawString("Click to start!", 75, 100);
        } else  g.drawString(String.valueOf(score), 180, 50);

    }
}