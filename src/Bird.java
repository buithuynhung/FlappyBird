import java.awt.*;

public class Bird {

    private int x, y, size, ticks, yMotion;
    private Color color;
    private final int border;

    public Bird(int x, int y, int size, Color color, int border) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.border = border;
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

    public boolean touchBorder() {
        return (y + size >= border || y < 0);
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

