import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PipesTest {

    @Test
    void killBird() {

        Pipes pipeNorth = new Pipes(300, 250, 90, 250);
        Pipes pipeSouth = new Pipes(300, 0, 90, 100);

        Bird bird = new Bird(270, 50, 30, Color.YELLOW, 500);
        assertTrue(pipeSouth.killBird(bird));

        bird = new Bird(250, 220, 30, Color.YELLOW, 500);
        assertFalse(pipeSouth.killBird(bird));
        assertFalse(pipeNorth.killBird(bird));

        bird = new Bird(290, 90, 30, Color.YELLOW, 500);
        assertTrue(pipeSouth.killBird(bird));

        bird = new Bird(280, 150, 30, Color.YELLOW, 500);
        assertFalse(pipeSouth.killBird(bird));
        assertFalse(pipeNorth.killBird(bird));

        bird = new Bird(320, 100, 30, Color.YELLOW, 500);
        assertTrue(pipeSouth.killBird(bird));

        bird = new Bird(390, 100, 30, Color.YELLOW, 500);
        assertTrue(pipeSouth.killBird(bird));

        bird = new Bird(290, 250, 30, Color.YELLOW, 500);
        assertTrue(pipeNorth.killBird(bird));

        bird = new Bird(320, 260, 30, Color.YELLOW, 500);
        assertTrue(pipeNorth.killBird(bird));

        bird = new Bird(390, 250, 30, Color.YELLOW, 500);
        assertTrue(pipeNorth.killBird(bird));

        bird = new Bird(265, 260, 30, Color.YELLOW, 500);
        assertFalse(pipeNorth.killBird(bird));
        assertFalse(pipeSouth.killBird(bird));

        bird = new Bird(290, 350, 30, Color.YELLOW, 500);
        assertTrue(pipeNorth.killBird(bird));
    }

}