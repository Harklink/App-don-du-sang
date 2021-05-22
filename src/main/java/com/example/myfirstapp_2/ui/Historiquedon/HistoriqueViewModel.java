package com.example.myfirstapp_2.ui.Historiquedon;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myfirstapp_2.R;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Historique view model.
 */
public class HistoriqueViewModel extends ViewModel {
    private int compteurDonSang = 0;
    private int compteurDonPlasma = 0;
    private long temps;
    private List<Event> LDonsSang = new ArrayList<>();
    private List<Event> LDonsPlasma = new ArrayList<>();
    private MutableLiveData<String> mText;

    /**
     * Instantiates a new Historique view model.
     */
    public HistoriqueViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Dates importantes");
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public LiveData<String> getText() {
        return mText;
    }

    /**
     * Compte le nombre de dons.
     *
     * @param typeDon type de don
     * @return the int
     */
    public int compteurdon (String typeDon){
        if (typeDon == "Sang"){
            compteurDonSang ++;
            return compteurDonSang;
        }
        if (typeDon == "Plasma"){
            compteurDonPlasma ++;
            return compteurDonPlasma;
        }
        return 0;
    }

    /**
     * Permet de savoir si la personne peut donner
     *
     * @param typeDon   type du don(sang/plasma)
     * @param sexe      sexe du donneur (Femme/Homme)
     * @param evenement l'événement qu'on souhaite ajouter dans le calendrier
     * @return the boolean
     */
    public boolean ajouterDon (String typeDon, String sexe, Event evenement){
        int lSang = LDonsSang.size();
        int lPlasma = LDonsPlasma.size();
        if ((typeDon == "Sang") && ((sexe == "Femme" && lSang < 4) || (sexe == "Homme" && lSang < 6))){
            LDonsSang.add(evenement);
            return true;
        }
        if ((typeDon == "Plasma") && lPlasma < 24){
            LDonsPlasma.add(evenement);
            return true;
        }
        return false;
    }

    private long convertWeekToMillis(int nbrWeek){
        long weeksToMillis = 7*24*60*60*1000;
        return weeksToMillis*nbrWeek;
    }

    /**
     * Calcule la prochaine date possible pour un don de sang ou de plasma.
     *
     * @param typeDon le type de don (sang/plasma)
     * @return the string
     */
// Fonction qui permet de calculer le temps à écouler avant le prochain don
    public String tempsdon(String typeDon){
        Calendar calendar = Calendar.getInstance();
        int lSang = LDonsSang.size();
        int lPlasma = LDonsPlasma.size();
        if (typeDon == "Sang"){
            temps += LDonsSang.get(lSang-1).getTime() + convertWeekToMillis(8);
            calendar.setTimeInMillis(temps);
            return calendar.get(Calendar.MONTH) + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        }
        if (typeDon == "Plasma"){
            temps += LDonsPlasma.get(lPlasma-1).getTime() + convertWeekToMillis(2);
            calendar.setTimeInMillis(temps);
            return calendar.get(Calendar.MONTH) + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        }
        return "";
    }


}