package com.example.myfirstapp_2.ui.recherchecentredon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfirstapp_2.R;

public class RechecheFragment extends Fragment {

    private RechercheViewModel rechercheViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rechercheViewModel =
                new ViewModelProvider(this).get(RechercheViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recherche_centre, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        rechercheViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}