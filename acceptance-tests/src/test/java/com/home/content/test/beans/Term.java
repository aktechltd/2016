package com.home.content.test.beans;

import lombok.Data;

import java.util.List;

@Data
public class Term {
    private List<Object> categoryTags = null;
    private String startDateTime;
    private String endDateTime;
    private String mediaType;
    private Object offeringType;
    private List<Offer> offers = null;
    private String platformName;
    private SuggestedPrice suggestedPrice;
    private List<Device> devices = null;
}
