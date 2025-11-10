import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuoteControllerTest {

    @Test
    void testQuoteNotNull() {
        QuoteController qc = new QuoteController();
        assertNotNull(qc.getRandomQuote(), "Quote should not be null");
    }

    @Test
    void testQuoteLength() {
        QuoteController qc = new QuoteController();
        assertTrue(qc.getRandomQuote().length() > 5, "Quote should have more than 5 characters");
    }

    @Test
    void testQuoteRandomness() {
        QuoteController qc = new QuoteController();
        String q1 = qc.getRandomQuote();
        String q2 = qc.getRandomQuote();
        assertNotEquals(q1, q2, "Quotes should differ occasionally");
    }
}
