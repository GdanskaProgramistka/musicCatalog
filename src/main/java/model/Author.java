package model;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author {

       public String name;
       public String establishedDate;

       public Author(String name, String establishedDate){
           name = this.name;
           establishedDate = this.establishedDate;
       }
       

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", establishedDate='" + establishedDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(establishedDate, author.establishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, establishedDate);
    }
}

