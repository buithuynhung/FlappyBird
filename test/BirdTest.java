import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {

    @Test
    void touchBorder() {

        Bird bird = new Bird(200, 469, 30, Color.YELLOW, 500);
        assertFalse(bird.touchBorder());

        bird = new Bird(200, 470, 30, Color.YELLOW, 500);
        assertTrue(bird.touchBorder());

        bird = new Bird(300, 490, 30, Color.YELLOW, 500);
        assertTrue(bird.touchBorder());

        bird = new Bird(100, 200, 30, Color.YELLOW, 500);
        assertFalse(bird.touchBorder());

        bird = new Bird(150, 0, 30, Color.YELLOW, 500);
        assertFalse(bird.touchBorder());

        bird = new Bird(150, -5, 30, Color.YELLOW, 500);
        assertTrue(bird.touchBorder());

    }

}