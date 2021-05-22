package com.example.myfirstapp_2.ui.Historiquedon;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfirstapp_2.Login;
import com.example.myfirstapp_2.R;
import com.example.myfirstapp_2.User;
import com.example.myfirstapp_2.UserLocalStore;
import com.google.android.material.snackbar.Snackbar;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.listener.CalenderDayClickListener;
import com.skyhope.eventcalenderlibrary.model.DayContainerModel;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * The type Historique fragment.
 */
public class HistoriqueFragment extends Fragment {
    //Context thisContext;
    private HistoriqueViewModel historiqueViewModel;
    //UserLocalStore userLocalStore = new UserLocalStore(thisContext);
    //User storedUser = userLocalStore.getLoggedInUser();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //thisContext = container.getContext();
        //Cas où la personne n'est pas connectée : redirigée vers la page pour s'identifier
        UserLocalStore userLocalStore = new UserLocalStore(getContext());
        User storedUser = userLocalStore.getLoggedInUser();
        String sex = storedUser.sexe;
        if (!userLocalStore.getUserLoggedIn()){
            Intent myIntent = new Intent(getContext(), Login.class);
            myIntent.putExtra("previousActivity", "Historique");
            startActivity(myIntent);

        }
        //

        historiqueViewModel =
                new ViewModelProvider(this).get(HistoriqueViewModel.class);
        View root = inflater.inflate(R.layout.fragment_historique, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        CalenderEvent calenderEvent = root.findViewById(R.id.calender_event);
        Calendar calendar = Calendar.getInstance();

        Button boutonSang = root.findViewById(R.id.buttonBloodGift);
        Button boutonPlasma = root.findViewById(R.id.buttonPlasmaGift);
        // Définition des deux boutons pour choisir la nature du don, défini à la date cliquée sur le calendrier
        boutonSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "Sang";
                calenderEvent.initCalderItemClickCallback(new CalenderDayClickListener() {
                    @Override
                    public void onGetDay(DayContainerModel dayContainerModel) {
                        Event event = new Event(dayContainerModel.getTimeInMillisecond(), "S", Color.RED);
                        if(historiqueViewModel.ajouterDon(type,"Femme",event)){
                            Log.d("TAG", dayContainerModel.getDate());
                            historiqueViewModel.compteurdon(type);
                            calenderEvent.addEvent(event);
                            Toast.makeText(getContext(),"Votre don sera affiché sur calendrier quand vous reviendrez sur l'application", Toast.LENGTH_LONG);
                        }
                        //Log.d("TAG", dayContainerModel.getDate());
                    }
                });

            }
        });
        boutonPlasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "Plasma";
                calenderEvent.initCalderItemClickCallback(new CalenderDayClickListener() {
                    @Override
                    public void onGetDay(DayContainerModel dayContainerModel) {
                        Event event = new Event(dayContainerModel.getTimeInMillisecond(), "P", Color.BLUE);
                        if(historiqueViewModel.ajouterDon(type,"Femme",event)){
                            Log.d("TAG", dayContainerModel.getDate());
                            historiqueViewModel.compteurdon(type);
                            calenderEvent.addEvent(event);
                            Toast.makeText(getContext(),"Votre don sera affiché sur calendrier quand vous reviendrez sur l'application", Toast.LENGTH_LONG);
                        }
                        //Log.d("TAG", dayContainerModel.getDate());
                    }
                });

            }
        });
        //


        historiqueViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });

        return root;
    }



}