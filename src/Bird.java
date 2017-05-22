import java.awt.*;

public class Bird {
    private int x, y, size;
    private Color color;
    public Pipes pipe;
    private int ticks, yMotion;
    private Size frame = new Size();

    public Bird(int x, int y, int size, Color color, Pipes pipe) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.pipe = pipe;
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

    public Boolean touchFloor() {
        if (y + size >= frame.heightMFrame - frame.heightForeground) return true;
        return false;
    }

    public Boolean touchPipes() {

        int deltaX1 = pipe.getX1() - x;
        if (-size <= deltaX1 && deltaX1 <= pipe.getWidth()) {
            if (y <= pipe.getH1() || y - pipe.getH1() >= pipe.getSpace2() - size)
                return true;
        }

        int deltaX2 = pipe.getX2() - x;
        if (-size <= deltaX2 && deltaX2 <= pipe.getWidth()) {
            if (y < pipe.getH2() || y - pipe.getH2() > pipe.getSpace2() - size)
                return true;
        }

        int deltaX3 = pipe.getX3() - x;
        if (-size <= deltaX3 && deltaX3 <= pipe.getWidth()) {
            if (y < pipe.getH3() || y - pipe.getH3() > pipe.getSpace2() - size)
                return true;
        }

        return false;
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

}
