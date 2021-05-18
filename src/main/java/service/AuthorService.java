package service;

import com.google.gson.Gson;
import model.Author;
import repository.AuthorRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AuthorService {
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(String authorString) throws AuthorException, MissingParameterException {
        Gson gson = new Gson();
        Author author = gson.fromJson(authorString, Author.class);
        checkRequest(author);

        if (authorRepository.checkIfAuthorAvailable(author)) {
            throw new AuthorException("Already existing author");
        } else {
            authorRepository.save(author);
        }
    }

    private void checkRequest(Author author) throws MissingParameterException {
        if (author.name.isBlank() || author.establishedDate.isBlank() || !validateJavaDate(author)) {
            throw new MissingParameterException("Missing parameter(s)");
        }
    }

    public static boolean validateJavaDate(Author author) {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
        sdfrmt.setLenient(false);
        try {
            sdfrmt.parse(author.establishedDate);
        }
        catch (ParseException e) {
            System.out.println(author.establishedDate + " is Invalid Date format");
            return false;
        }
        return true;
    }
}


