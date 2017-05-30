import java.awt.*;

public class Bird {

    private int x, y, size, ticks, yMotion;
    private Color color;

    public Bird(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void moveDown() {
        ticks++;
        if (ticks % 2 == 0 && yMotion < 16) {
            yMotion += 1;
        }
        y += yMotion;
    }

    public void moveUp() {
        if (yMotion > 0) {
            yMotion = 0;
        }
        yMotion -= 7;
    }

    public void paintBird(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public int getX() {
        return x;
    }

    public int getSize() {
        return size;
    }

    public int getY() {
        return y;
    }
}

