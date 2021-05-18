package web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class OptionsAuthorHandler {

    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, 0);
    }
}
