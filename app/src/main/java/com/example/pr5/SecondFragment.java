package com.example.pr5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SecondFragment extends Fragment {

    TextView second_fragment_text_view;

    public SecondFragment() {

        super(R.layout.fragment_second);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        second_fragment_text_view = (TextView) getActivity().findViewById(R.id.fragment_second_text_view2);


        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<String> Data = bundle.getStringArrayList("date&amount");
            if (Data != null && Data.size() >= 1) {
                String date = Data.get(0).toString();
                String amount = Data.get(1).toString();

                String result = date + " числа на " + amount + " человек";

                second_fragment_text_view.setText(result);
            }
        }
    }

}