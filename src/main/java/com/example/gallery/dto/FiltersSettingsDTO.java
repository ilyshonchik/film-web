package com.example.gallery.dto;
import lombok.Data;

@Data
public class FiltersSettingsDTO {
    public String genre; 
    public int yearMin;
    public int yearMax;
    public boolean nsfw;
}
