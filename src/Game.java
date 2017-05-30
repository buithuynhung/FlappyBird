import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final int xPipe, yPipe = 0, widthPipe = 90, space1 = 250, space2 = 150,
            xBird, yBird, sizeBird = 30, speed = 5, border, width;
    private final Color colorPipe = new Color(50, 235, 50),
            colorBird = Color.YELLOW;
    private List<Pipes> pipes = new ArrayList<>();
    private final Pipes pipe;
    private final Bird bird;
    private int score;
    private Random rd = new Random();

    public Game(int height, int width) {

        border = height - 100;
        this.width = width;

        xPipe = width + widthPipe + 300;
        pipe = new Pipes(xPipe, yPipe, widthPipe);

        xBird = width / 5;
        yBird = height / 3;
        bird = new Bird(xBird, yBird, sizeBird, colorBird);

        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);
    }

    public void step() {

        if (!gameOver()) {

            bird.moveDown();

            for (int i = 0; i < pipes.size(); i ++) {

                Pipes pipe = pipes.get(i);

                pipe.scroll(speed);

                if (pipe.getY() == 0
                        && bird.getX() + bird.getSize() > pipe.getX() + pipe.getWidth() - speed
                        && bird.getX() + bird.getSize() < pipe.getX() + pipe.getWidth() + speed)
                    score++;

                if (pipe.getX() + pipe.getWidth() < 0) {
                    pipes.remove(pipe);
                    if (pipe.getY() == 0) addPipe(false);
                }

            }
        }
    }

    public void addPipe(boolean start) {

        int height = 50 + rd.nextInt(250);

        if (start) {
            pipes.add(new Pipes(width + pipe.getWidth() + pipes.size() * space1 / 2, border - height, pipe.getWidth(), height));
            pipes.add(new Pipes(width + pipe.getWidth() + (pipes.size() - 1) * space1 / 2, 0, pipe.getWidth(), border - height - space2));
        } else {
            pipes.add(new Pipes(pipes.get(pipes.size() - 1).getX() + space1, border - height, pipe.getWidth(), height));
            pipes.add(new Pipes(pipes.get(pipes.size() - 1).getX(), 0, pipe.getWidth(), border - height - space2));
        }

    }

    public boolean gameOver() {

        for (Pipes pipe : pipes) {
            if (pipe.killBird(bird)) return true;
        }

        return (bird.getY() + bird.getSize() >= border);

    }

    public int getScore() {
        return score;
    }

    public Bird getBird() {
        return bird;
    }

    public int getBorder() {
        return border;
    }

    public void paintPipes(Graphics g) {
        for (Pipes pipe : pipes) {
            g.setColor(colorPipe);
            g.fillRect(pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight());
        }
    }
}

