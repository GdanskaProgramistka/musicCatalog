import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import service.AuthorService;
import web.OptionsAuthorHandler;
import web.PostAuthorHandler;

import java.io.IOException;

public class AuthorHandler implements HttpHandler {

    public AuthorService authorService;

    public AuthorHandler(AuthorService authorService) {
        this.authorService = authorService;
    }

//    public OptionsAuthorHandler(HttpExchange exchange){
//        exchange.sendResponseHeaders(200, response.length());
//        exchange.close();
//    }

    @Override
        public void handle (HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, Auth");

            switch (exchange.getRequestMethod()) {
                case "OPTIONS":
                    new OptionsAuthorHandler().handle(exchange);
                    break;
                case "POST":
                    new PostAuthorHandler().handle(exchange, authorService);
                    break;
            }
            exchange.close();
        }
}
