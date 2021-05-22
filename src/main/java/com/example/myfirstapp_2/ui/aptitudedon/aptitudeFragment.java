package com.example.myfirstapp_2.ui.aptitudedon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfirstapp_2.R;

/**
 * The type Aptitude fragment.
 */
public class aptitudeFragment extends Fragment {
    /**
     * The Text view.
     */
//CheckBox checkBox1,checkBox2;
    TextView textView;
    private CheckBox checkBoxYes;
    private CheckBox checkBoxNo;

    private aptitudeViewModel objetAvm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        objetAvm =
                new ViewModelProvider(this).get(aptitudeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_aptitude_don, container, false);
        checkBoxNo = (CheckBox) root.findViewById(R.id.checkBox1);
        checkBoxYes = (CheckBox) root.findViewById(R.id.checkBox2);
        checkBoxYes.setOnClickListener(this::onCheckboxClickedY);
        checkBoxNo.setOnClickListener(this::onCheckboxClickedN);
        TextView textView1 = root.findViewById(R.id.text_home1);
        TextView textView2 = root.findViewById(R.id.text_home2);

        objetAvm.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView1.setText(s);
            }
        });

        objetAvm.getText2().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView2.setText(s);
            }
        });

        objetAvm.getHide().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean b) {
                if(b) {
                    checkBoxYes.setVisibility(View.INVISIBLE);
                    checkBoxNo.setVisibility(View.INVISIBLE);
                }
                else{
                    checkBoxYes.setVisibility(View.VISIBLE);
                    checkBoxNo.setVisibility(View.VISIBLE);
                }
            }
        });


        return root;
    }


    /**
     * Comportement de la checkBox Oui quand elle est cliquée : ne permet pas de donner son sang
     *
     * @param view the view
     */
//Comportement de la checkBox Oui
    public void onCheckboxClickedY(View view) {

        Toast.makeText(getContext(), "Vous ne pouvez pas donner votre sans, merci de revenir à l'accueil", Toast.LENGTH_LONG).show();

        // Si c'est check, le questionnaire doit être stoppé, car cela indique que la personne ne peut pas donner son sang
    }

    /**
     * Comportement de la checkbox Non quand elle est cliquée : permet de passer à la question suivante
     *
     * @param view the view
     */
//
    //Comportement de la checkBox Non
    public void onCheckboxClickedN(View view) {
        //final CheckBox checkBox_oui = (CheckBox)findViewById(R.id.checkBox1);
        //final CheckBox checkBox_non = (CheckBox) root.findViewById(R.id.checkBox2);
        // Is the view now checked?
        boolean checked = checkBoxNo.isChecked();
        // Check which checkbox was clicked
        if (checked){
            objetAvm.increment();
            ((CheckBox) view).setChecked(false);
            //Cela passe automatiquement à la question suivante
        }

    }
}