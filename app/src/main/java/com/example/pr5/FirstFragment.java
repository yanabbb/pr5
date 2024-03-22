package com.example.pr5;

import static com.example.pr5.MainFragment.isNumber;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class FirstFragment extends Fragment {
    Button first_fragment_button;
    TextView first_fragment_text_view;
    EditText first_fragment_edit_text;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        first_fragment_button = (Button) getActivity().findViewById(R.id.fragment_first_button);
        first_fragment_text_view = (TextView) getActivity().findViewById(R.id.fragment_first_text_view2);
        first_fragment_edit_text = (EditText) getActivity().findViewById(R.id.fragment_first_edit_text);

        //String good_name = parseInputsGoods(this.getArguments().getStringArrayList("goodName"),
                //GoodParameterType.GOOD_NAME);
        //first_fragment_text_view.setText(date);
        Bundle bundle = getArguments();
        String date = bundle.getString("date");

        first_fragment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = first_fragment_edit_text.getText().toString();

                if ( isNumber(amount)) {
                    ArrayList<String> Data =  new ArrayList<String>();
                    Data.add(date);
                    Data.add(amount);

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("date&amount",  Data);
                    Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment, bundle);
                } else {
                    first_fragment_edit_text.setText("");
                    first_fragment_edit_text.setHint(getResources().getString(R.string.fragment_main_egit_text_hint));
                }
            }
        });
    }

}