package com.home.content.test.beans;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Title {

    public String accessChannel;
    public String adiVersion;
    public List<Advisory> advisory = null;
    public List<AlternateId> alternateId = null;
    public Boolean audioDescribed;
    public String contentId;
    public List<String> contentSegments = null;
    public String vcmId;
    public Boolean deleted;
    public List<String> genre = null;
    public List<Image> images = null;
    public List<LinkedObjects> linkedObjects = null;
    public List<LocalizableInformation> localizableInformation = null;
    public Integer priority;
    public String productionYear;
    public String providerId;
    public String titleMedium;
    public String descriptionShort;
    public List<Rating> ratings = null;
    public Rights rights;
    public List<ParentalRating> parentalRatings = null;
    public String runtime;
    public String seasonVcmId;
    public String seriesVcmId;
    public Boolean signed;
    public Integer socMilliseconds;
    public Integer durationMilliseconds;
    public Object soundMouse;
    public String studioCode;
    public List<VideoAsset> videoAssets = null;
    public String type;
    public String uriId;


}
