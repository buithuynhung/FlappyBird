public class Pipes {

    private int x, y, width, height;

    public Pipes(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Pipes(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void scroll(int speed) {
        x -= speed;
    }

    public Boolean killBird(Bird bird) {
        if (bird.getX() + bird.getSize() >= x && bird.getX() <= x + width) {
            if (y == 0) {
                if (bird.getY() <= height) return true;
            } else if (bird.getY() + bird.getSize() >= y) return true;

        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

