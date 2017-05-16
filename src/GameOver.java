
public class GameOver {
    private Bird bird ;

    public GameOver(Bird bird) {
        this.bird = bird;
    }

    public boolean gameOver() {
        boolean touchFloor = bird.touchFloor();
        boolean touchPipes = bird.touchPipes();
        if (touchFloor || touchPipes) return true;
        return false;
    }


}
