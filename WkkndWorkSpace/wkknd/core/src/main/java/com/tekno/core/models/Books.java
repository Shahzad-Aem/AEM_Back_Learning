package com.tekno.core.models;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Books {
    @Inject
   String book;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
