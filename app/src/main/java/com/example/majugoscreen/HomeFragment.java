package com.example.majugoscreen;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home,container, false);

        Button buttonOrder = (Button) view.findViewById(R.id.buttonOrder);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), OrderActivity.class);
                in.putExtra("Order", "Order Activity");
                startActivity(in);
            }
        });
        Button buttonTrack = (Button) view.findViewById(R.id.buttonTrack);
        buttonTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), TrackActivity.class);
                in.putExtra("Track", "Track Activity");
                startActivity(in);
            }
        });
        return view;

    }

}
