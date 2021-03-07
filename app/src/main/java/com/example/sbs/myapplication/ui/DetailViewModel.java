package com.example.sbs.myapplication.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sbs.myapplication.dto.Pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class DetailViewModel {
    public MutableLiveData<Pokemon> pokemon = new MutableLiveData<>();
    public MutableLiveData<String> lvDataImgUrl = new MutableLiveData<>();
}
