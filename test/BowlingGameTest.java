import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    void setup() {
        game = new BowlingGame();
    }

    @Test
    void testAllMissedGame() {
        rollMany(0, 20);
        assertEquals(0, game.score());
    }

    @Test
    void testAllOneGame() {
        rollMany(1, 20);
        assertEquals(20, game.score());
    }

    @Test
    void testSpare() {
        rollSpare();
        game.roll(4);
        rollMany(0, 17);
        assertEquals(18, game.score());
    }

    @Test
    void testStrike() {
        rollStrike();
        game.roll(1);
        game.roll(2);
        rollMany(0, 16);
        assertEquals(16, game.score());
    }

    @Test
    void testPerfectGame() {
        rollMany(10, 12);
        assertEquals(300, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(3);
        game.roll(7);
    }

    private void rollMany(int pins, int times) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}