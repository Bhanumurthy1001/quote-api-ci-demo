import java.util.*;

public class QuoteController {
    private static final List<String> quotes = Arrays.asList(
        "Push yourself, because no one else is going to do it for you.",
        "Great things never come from comfort zones.",
        "Dream it. Wish it. Do it.",
        "Success doesn’t just find you. You have to go out and get it.",
        "Hard work beats talent when talent doesn’t work hard."
    );

    public String getRandomQuote() {
        Random rand = new Random();
        return quotes.get(rand.nextInt(quotes.size()));
    }
}
