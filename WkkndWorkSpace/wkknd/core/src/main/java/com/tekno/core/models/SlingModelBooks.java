package com.tekno.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.*;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SlingModelBooks {
    private static final Logger log = LoggerFactory.getLogger(SlingModelBooks.class);

   @Inject
   @Named(value = "books")
   Resource books;

    @Inject
    @Default(values = "AEM")
    private  String authorName;


    private List<Books> bookslist;


    @PostConstruct
    protected void  init(){
        bookslist = new ArrayList<>();
        try {
           Iterator<Resource> iterator =  books.listChildren();
           while(iterator.hasNext()){
              Books book = iterator.next().adaptTo(Books.class);
               bookslist.add(book);
           }

        }catch (Exception e){

        }

    }

    public String getAuthorName() {
        return authorName;
    }

    public List<Books> getBookslist() {
        return bookslist;
    }

    @Override
    public String toString() {
        return "BooksImpl{" +
                "textbook=" + books +
                ", authorName='" + authorName + '\'' +
                ", bookslist=" + bookslist +
                '}';
    }

}
