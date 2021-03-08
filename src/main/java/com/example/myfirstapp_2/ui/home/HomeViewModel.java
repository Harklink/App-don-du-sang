package com.example.myfirstapp_2.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bienvenue sur l'application de don du sang cher donneur :)");
    }

    public LiveData<String> getText() {
        return mText;
    }
}