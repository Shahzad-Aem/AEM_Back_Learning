package com.tekno.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Dwg2Headline {

    @Inject
    @Named(value = "eyebrowText")
     private String  firstTitle;

    @Inject
    private String headlineText;

    @Inject
    private String text;

    @Inject
    Resource resource;


    public String getFirstTitle() {
        return firstTitle;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public String getText() {
        return text;
    }

    public List<Map<String,String>> getButtonoptional(){
        Resource ctaButton = resource.getChild("buttonoptional");
        List<Map<String,String>> ctaArray = new ArrayList<>();
        for (Resource cta : ctaButton.getChildren()){
            Map<String,String> ctaDetail = new HashMap<>();
            ctaDetail.put("buttonText",cta.getValueMap().get("buttonText",String.class));
            ctaDetail.put("buttonURL",cta.getValueMap().get("buttonURL",String.class));
            ctaArray.add(ctaDetail);
        }
        return ctaArray;
    }
}
