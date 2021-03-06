package com.example.sbs.myapplication.api;

import com.example.sbs.myapplication.Abilities;
import com.example.sbs.myapplication.Ability;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIncludeProperties("abilities")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeApi__getAbilities__ResponseBody {
    List<Abilities> abilities;



}
