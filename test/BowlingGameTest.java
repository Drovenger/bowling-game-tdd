import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    @Test
    void testAllMissedGame() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }
}