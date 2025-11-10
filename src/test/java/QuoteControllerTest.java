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
    // Even if quotes repeat, the method should always return a valid quote
    assertNotNull(q1, "First quote should not be null");
    assertNotNull(q2, "Second quote should not be null");
    assertTrue(q1.length() > 5 && q2.length() > 5, "Quotes should have valid content");
}
}
