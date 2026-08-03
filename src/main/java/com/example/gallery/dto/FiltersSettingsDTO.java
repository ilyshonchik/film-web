package com.example.gallery.dto;
import lombok.Data;

@Data
public class FiltersSettingsDTO {
    public String[] genres; 
    public int yearfrom;
    public int yearmax;
    public int minRating;
}
