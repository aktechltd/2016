package com.home.content.test.beans;

import lombok.Data;

import java.util.List;

@Data
public class VideoAsset {
    public String duration;
    public List<Part> parts = null;
    public String videoType;
}
