package com.example.majugoscreen;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import io.paperdb.Paper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Button buttonlogout = (Button) view.findViewById(R.id.buttonlogout);
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Paper.book().destroy();
                Intent in = new Intent(getActivity(), WelcomeScreen.class);
                startActivity(in);
            }
        });
        Button buttonEdit = (Button) view.findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(in);
            }
        });

        return view;
    }
}

