package com.example.myfirstapp_2.ui.aptitudedon;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import java.lang.Object;
import java.util.List;

/**
 * The type Aptitude view model.
 */
public class aptitudeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> qText;
    private int compteur;
    private MutableLiveData<Boolean> hide;
    private String[] QList = {"Avez vous moins de 18 ans ?","Avez-vous été testé(e) positif pour le VIH (sida), ou VHB (hépatite B) ou VHC (hépatite C) ou la syphilis ?","Pesez vous moins de 50 kg ?","Avez-vous eu un cancer ?","Avez-vous été opéré(e) dans les 4 derniers mois ?"};

    public int increment(){
        compteur ++;
        if (compteur == QList.length+1){
            mText.setValue("Felicitations");
            qText.setValue("Vous êtes bien éligible au don du sang ! :)");
            hide.setValue(true);
        }
        else {
            mText.setValue(generateTextTop());
            qText.setValue(generateTextBas());
        }
        return compteur;
    }
    /**
     * Fonction de génération de la question numérotée
     *
     * @return the string
     */
    public String generateTextTop(){
        // Fonction permettant d'avoir les nouvelles valeurs des deux textes affichés (question et intitulé de la Q)
        String t1 = "Question " + compteur;
        return t1;
    }


    /**
     * Fonction de génération de l'intitulé des questions (texte en bas de page)
     *
     * @return String string
     */
    public String generateTextBas(){
        String t2 = QList[compteur-1];
        return t2;
    }

    /**
     * Instantiates a new Aptitude view model.
     *
     * @param compteur the compteur
     */
    public aptitudeViewModel(int compteur) {
        hide = new MutableLiveData<>(false);
        this.compteur = compteur;
        // Modification des valeurs de texte en public pour être réutilisables dans le Fragment
        mText = new MutableLiveData<>();
        qText = new MutableLiveData<>();
        mText.setValue(generateTextTop());
        qText.setValue(generateTextBas());
    }

    public aptitudeViewModel() {
        hide = new MutableLiveData<>(false);
        compteur = 1;
        // Modification des valeurs de texte en public pour être réutilisables dans le Fragment
        mText = new MutableLiveData<>();
        qText = new MutableLiveData<>();
        mText.setValue(generateTextTop());
        qText.setValue(generateTextBas());
    }

    /**
     * Obtient le numéro de la question : "Question n°.."
     *
     * @return la question numérotée
     */
    public LiveData<String> getText() {
        // Obtention de la valeur du texte : "Question + compteur"
        return mText;
    }

    /**
     * Obtient le second texte (intitulé de la question) initialisée grâce au compteur
     *
     * @return la question
     */
    public LiveData<String> getText2() {
        // Obtention de la valeur du texte : "[Intitulé de la question]"
        return qText;
    }

    public LiveData<Boolean> getHide() {
        // Obtention de la valeur du texte : "[Intitulé de la question]"
        return hide;
    }
}