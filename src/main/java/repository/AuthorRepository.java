package repository;

import model.Author;
import service.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorRepository {

    List<Author> authors = new ArrayList<>();
    public void save(Author author) {
        authors.add(author);
        System.out.println(authors);
    }

//    public List<Author> getAuthors() {
//        return authors;
//    }

    //checking if the collection already contains the author:
    public boolean checkIfAuthorAvailable(Author author){
        return authors.contains(author);
    }
}
