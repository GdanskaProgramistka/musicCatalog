package web;

import com.sun.net.httpserver.HttpExchange;
import service.AuthorException;
import service.AuthorService;
import service.MissingParameterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.stream.Collectors;

public class PostAuthorHandler {

    public void handle(HttpExchange exchange, AuthorService authorService) throws IOException {
        String authorString = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))
                .lines().collect(Collectors.joining("\n"));
        String response = "Author added";
        try {
            authorService.addAuthor(authorString);
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        catch (AuthorException e){
            exchange.sendResponseHeaders(409, 0);
            System.out.println(e.getMessage());
        }
        catch (MissingParameterException e){
            exchange.sendResponseHeaders(400,0);
            System.out.println(e.getMessage());
        }

    }
}
