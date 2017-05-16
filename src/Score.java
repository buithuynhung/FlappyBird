
public class Score {
    private Pipes pipes;
    private Bird bird;
    private int result;
    private Boolean goOverpipe1 = false,goOverpipe2 = false,goOverpipe3 = false;

    public Score(Pipes pipes, Bird bird) {
        this.pipes = pipes;
        this.bird = bird;
    }

    public int getScore() {

        if (bird.getX() + bird.getSize() > pipes.getX1()
                && bird.getX() < pipes.getX1() + pipes.getWidth())
            goOverpipe1 = false;
        if (!goOverpipe1 && bird.getX() - pipes.getX1() > pipes.getWidth()) {
            result++;
            goOverpipe1 = true;
        }

        if(bird.getX() + bird.getSize() > pipes.getX2()
                && bird.getX() < pipes.getX2() + pipes.getWidth())
            goOverpipe2 = false;
        if (!goOverpipe2 && bird.getX() - pipes.getX2() > pipes.getWidth()) {
            result++;
            goOverpipe2 = true;
        }

        if (bird.getX() + bird.getSize() > pipes.getX3()
                && bird.getX() < pipes.getX3() + pipes.getWidth())
            goOverpipe3 = false;
        if (!goOverpipe3 && bird.getX() - pipes.getX3() > pipes.getWidth()) {
            result++;
            goOverpipe3 = true;
        }

        return result;
    }

}
