package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name="Shows")
public class Show extends BaseModel{
    private String startTime;
    private String endTime;
    private Movie movie;
    private Screen screen;
    private List<Feature> features;
}
