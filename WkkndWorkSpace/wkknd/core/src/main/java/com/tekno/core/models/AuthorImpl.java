package com.tekno.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


import javax.annotation.PostConstruct;

import javax.inject.Inject;

@Model(adaptables = Resource.class, adapters = Author.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorImpl implements Author{


    @Inject
    @Default(values = "Kuch Bhi")
    String fname;

    @Inject
    @Default(values = "Ho sakta hai bhaii")
    String lname;

   @Inject
   boolean athr;

    @PostConstruct
    protected void init(){

    }

  @Override
    public String getFname() {
        return fname;
    }
    @Override
    public String getLname() {
        return lname;
    }

    @Override
    public boolean getDeveloper() {
        return athr;
    }

    @Override
    public String toString() {
        return "AuthorImpl{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", athr=" + athr +
                '}';
    }

    //    @Override
//    public boolean getAuthorIsDeveloper() {
//        return author;
//    }
}
