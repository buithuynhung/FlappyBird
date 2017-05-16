import java.awt.*;
import java.util.*;

public class Pipes {
    private final int space = 200;
    private int x1, x2, x3;
    private int h1, h2, h3;
    private boolean flag1 = false, flag2 = false, flag3 = false;
    private int y, width;
    private Color color;

    public Pipes(int x1, int y, int width, Color color) {
        this.color = color;
        this.x1 = x1;
        this.y = y;
        this.width = width;
        x2 = x1 + space + width;
        x3 = x2 + space + width;
    }

    public void scroll() {
        x1 -= 5;
        x2 -= 5;
        x3 -= 5;

        if (x1 == -width) {
            x1 = 780;
            flag1 = false;
        }

        if (x2 == -width) {
            x2 = 780;
            flag2 = false;
        }

        if (x3 == -width) {
            x3 = 780;
            flag3 = false;
        }
    }

    public int randomNumber(int min, int max) {
        try {
            Random rd = new Random();
            int range = max - min + 1;
            int randomNumb = min + rd.nextInt(range);
            return randomNumb;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void heightRandom() {
        if (!flag1) {
            h1 = randomNumber(50, 350);
            flag1 = true;
        }

        if (!flag2) {
            h2 = randomNumber(50, 350);
            flag2 = true;
        }

        if (!flag3) {
            h3 = randomNumber(50, 350);
            flag3 = true;
        }
    }

    public void paintPipes(Graphics g) {
        heightRandom();

        g.setColor(color);

        g.fillRect(x1, y, width, h1);
        g.fillRect(x1, h1 + 100, width, 400 - h1);

        g.fillRect(x2, y, width, h2);
        g.fillRect(x2, h2 + 100, width, 400 - h2);

        g.fillRect(x3, y, width, h3);
        g.fillRect(x3, h3 + 100, width, 400 - h3);
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getX3() {
        return x3;
    }

    public int getH1() {
        return h1;
    }

    public int getH2() {
        return h2;
    }

    public int getH3() {
        return h3;
    }

    public int getWidth() {
        return width;
    }

}
