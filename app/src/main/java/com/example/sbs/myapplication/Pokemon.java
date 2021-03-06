package com.example.sbs.myapplication;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    private String name;
    private String url;


    public int getId(){
        String[] urlBits = url.split("/");

        return Integer.parseInt(urlBits[urlBits.length - 1]);
    }

    public String getImgUrl(){
        return "https://pokeres.bastionbot.org/images/pokemon/" + getId() + ".png";
    }

    public Pokemon(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("id")int id, @JsonProperty("imgUrl") String imgUrl){

        this.name = name;
        this.url = url;
    }


}
