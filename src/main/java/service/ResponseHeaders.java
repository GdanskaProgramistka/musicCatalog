package service;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.stream.Collectors;

public class ResponseHeaders {

    public void doResponseExistingAuthor(HttpExchange exchange) throws IOException {
        String response = "Already existing author";
        exchange.sendResponseHeaders(409, response.length());
    }

    public void doResponseMissingParameters(HttpExchange exchange) throws IOException {
        String response = "Missing parameter(s)";
        exchange.sendResponseHeaders(201, response.length());
    }
}
