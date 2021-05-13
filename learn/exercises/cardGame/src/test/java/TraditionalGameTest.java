import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TraditionalGameTest {
    Game testGame;

    @BeforeEach
    void setUp() {
        testGame = new TraditionalGame();
        testGame.run();
    }

    @Test
    void run() {
        assertTrue(testGame.running());
    }

    @Test
    void winner() {

        assertNotNull(testGame.winner());
    }

    @Test
    void cards() {
        assertTrue(testGame.cards().size()>0);
    }

    @Test
    void players() {
        assertTrue(testGame.players().size()>0);
    }

    @Test
    void topCard() {
        assertTrue(testGame.topCard()!=null);
    }

    @Test
    void currentPlayer() {
        assertTrue(testGame.currentPlayer()!=null);
    }
}