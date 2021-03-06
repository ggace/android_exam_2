package com.example.sbs.myapplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ability {

    String name;
    String url;

    public int getId(){
        String[] urlBits = url.split("/");

        return Integer.parseInt(urlBits[urlBits.length - 1]);
    }



    public Ability(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("id")int id){

        this.name = name;
        this.url = url;
    }
}
