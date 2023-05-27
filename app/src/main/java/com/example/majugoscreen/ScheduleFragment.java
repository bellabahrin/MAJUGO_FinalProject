package com.example.majugoscreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ScheduleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_schedule,container, false);


        Button buttonP = (Button) view.findViewById(R.id.buttonP);
        buttonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), PerakActivity.class);
                in.putExtra("Order", "Order Activity");
                startActivity(in);
            }
        });
        Button buttonPA = (Button) view.findViewById(R.id.buttonPA);
        buttonPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), PahangActivity.class);
                in.putExtra("Order", "Order Activity");
                startActivity(in);
            }
        });
        Button buttonW = (Button) view.findViewById(R.id.buttonW);
        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), WilayahActivity.class);
                in.putExtra("Order", "Order Activity");
                startActivity(in);
            }
        });

 return view;
    }

}
