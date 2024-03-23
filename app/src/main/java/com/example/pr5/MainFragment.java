package com.example.pr5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainFragment extends Fragment {


    Button main_fragment_button;
    EditText main_fragment_edit_text;
    public MainFragment() {
        super(R.layout.fragment_main);
    }


@Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    main_fragment_button = (Button) getActivity().findViewById(R.id.fragment_main_button);
    main_fragment_edit_text = (EditText) getActivity().findViewById(R.id.fragment_main_edit_text);

    main_fragment_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String date = main_fragment_edit_text.getText().toString();
            NavController navController = Navigation.findNavController(view);

            if (!date.isEmpty()) {
                ArrayList<String> Data =  new ArrayList<String>();
                Data.add(date);

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("date",  Data);
                navController.navigate(R.id.action_mainFragment_to_firstFragment, bundle);
                ;
            } else {
                main_fragment_edit_text.setText("");
                main_fragment_edit_text.setHint(getResources().getString(R.string.fragment_main_egit_text_hint));
            }
        }
    });
}
    public static boolean isNumber(String string_num) {
        try {
            Integer.parseInt(string_num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


}
