package com.example.myfirstapp_2.ui.recherchecentredon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RechercheViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RechercheViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Les centres les plus proches de chez vous s'afficheront ici");
    }

    public LiveData<String> getText() {
        return mText;
    }
}