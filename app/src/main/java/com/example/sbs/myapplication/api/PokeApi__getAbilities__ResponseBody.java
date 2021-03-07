package com.example.sbs.myapplication.api;

import com.example.sbs.myapplication.dto.Abilities;
import com.example.sbs.myapplication.dto.Ability;
import com.example.sbs.myapplication.dto.Pokemon;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeApi__getAbilities__ResponseBody {
    List<Abilities> abilities;


}
