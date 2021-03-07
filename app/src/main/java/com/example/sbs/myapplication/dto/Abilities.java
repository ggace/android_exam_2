package com.example.sbs.myapplication.dto;

import com.example.sbs.myapplication.dto.Ability;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abilities {
    Ability ability;
    Boolean is_hidden;
    int slot;

}
