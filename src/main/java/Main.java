import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        server.createContext("/musicCatalog/example", new ExampleHandler());
        server.setExecutor(null);
        server.start();
        LOGGER.info(server.getAddress().getHostName());
        LOGGER.info("Server started on port 8080");
        int a = 5;
    }

//    Materiały:
//    1. http://www.json.org/json-pl.html
//    2. https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
//    3. https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
//    4. https://www.baeldung.com/java-logging-intro
//    5. https://restfulapi.net/
//    6. https://www.baeldung.com/jackson-vs-gson
//    7. https://blog.sapiensworks.com/post/2014/06/02/The-Repository-Pattern-For-Dummies.aspx

//    Wymagania:
//    1. Aplikacja powinna komunikować się z FrontEndem za pomocą RESTAPI.
//    2. Aplikacja powinna komunikować się z FrontEndem za pomocą obiektów typu JSON.
//    3. Serwer aplikacji powinien uruchamiać sie pod adresem http://localhost:8080
//    4. Jeżeli dany adres jest niedostępny aplikacja powinna zwrócić odpowiedni błąd
//    5. W pierwszym kroku katalog muzyki ma być przechowywany w ramach jednokrotnego uruchomienia aplikacji,
//      gdy wszystkie funkcjonalności zostaną pokryte, w drugim kroku należy zachowywać dane do pliku i przy kolejnym
//      uruchomieniu aplikacji korzystać z wcześniejszych danych tam zapisanych
//    6. Aplikacja powinna obsługiwać logowanie akcji wykonywanych od strony FrontEndu
//    7. Aplikacja powinna zawierać testy jednostkowe dla każdego obsługiwanego żądania
//    8. Piszemy przy pomocy tylko pakietów z JDK, jedyny wyjątek to biblioteki testowe oraz parsery JSONów

//    Aktualny FrontEnd (będzie rozwijany, a może poprawiony ;) ):
//      https://editor.swagger.io/?_ga=2.27098621.139862542.1529283950-1958724428.1521772135
}
