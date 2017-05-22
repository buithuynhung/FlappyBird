import java.awt.*;

public class Game {
    private int xPipe, yPipe = 0, widthPipe = 90, space2 = 100,
            xBird, yBird, sizeBird = 30, speed = 5;
    private Color colorPipe = new Color(50, 235, 50),
            colorBird = Color.YELLOW;
    private Pipes pipe;
    private Bird bird;
    private Size size = new Size();
    private int score;
    private Boolean goOverpipe1 = false, goOverpipe2 = false, goOverpipe3 = false;


    public Game() {
        xPipe = size.widthScreen - widthPipe;
        pipe = new Pipes(xPipe, yPipe, widthPipe, colorPipe, space2);
        xBird = size.widthMFrame / 5;
        yBird = size.heightMFrame / 3;
        bird = new Bird(xBird, yBird, sizeBird, colorBird, pipe);
    }

    public int getScore() {
        if (bird.getX() + bird.getSize() > pipe.getX1()
                && bird.getX() < pipe.getX1() + pipe.getWidth())
            goOverpipe1 = false;
        if (!goOverpipe1 && bird.getX() - pipe.getX1() > pipe.getWidth()) {
            score++;
            goOverpipe1 = true;
        }

        if (bird.getX() + bird.getSize() > pipe.getX2()
                && bird.getX() < pipe.getX2() + pipe.getWidth())
            goOverpipe2 = false;
        if (!goOverpipe2 && bird.getX() - pipe.getX2() > pipe.getWidth()) {
            score++;
            goOverpipe2 = true;
        }

        if (bird.getX() + bird.getSize() > pipe.getX3()
                && bird.getX() < pipe.getX3() + pipe.getWidth())
            goOverpipe3 = false;
        if (!goOverpipe3 && bird.getX() - pipe.getX3() > pipe.getWidth()) {
            score++;
            goOverpipe3 = true;
        }
        return score;
    }

    public boolean gameOver() {
        boolean touchFloor = bird.touchFloor();
        boolean touchPipes = bird.touchPipes();
        if (touchFloor || touchPipes) return true;
        return false;
    }

    public void step() {
        if (!gameOver()) {
            pipe.scroll(speed);
            bird.moveDown();
        }
    }

    public Pipes getPipe() {
        return pipe;
    }

    public Bird getBird() {
        return bird;
    }
}
