public class App {
    public static void main(String[] args) {
        QuoteController qc = new QuoteController();
        System.out.println("✨ Random Quote: " + qc.getRandomQuote());
    }
}
