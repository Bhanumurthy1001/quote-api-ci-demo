import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        QuoteController quoteController = new QuoteController();

        // Create HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/quote", new QuoteHandler(quoteController));
        server.createContext("/health", new HealthHandler()); // ✅ Added health route
        server.setExecutor(null);

        System.out.println("🚀 Quote API running at http://localhost:" + port + "/quote");
        System.out.println("💓 Health endpoint at http://localhost:" + port + "/health");
        server.start();
    }

    // --- Quote Endpoint ---
    static class QuoteHandler implements HttpHandler {
        private final QuoteController quoteController;

        public QuoteHandler(QuoteController quoteController) {
            this.quoteController = quoteController;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String quote = quoteController.getRandomQuote();
                byte[] response = quote.getBytes();
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }

    // --- Health Endpoint ---
    static class HealthHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "OK";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
