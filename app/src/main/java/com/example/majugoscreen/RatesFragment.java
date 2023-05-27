package com.example.majugoscreen;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class RatesFragment extends Fragment {
    EditText kgInput;
    Button calcButton;
    Spinner spinner;


    private static final String ARG_SECTION_NUMBER = "section_number";


    public static RatesFragment newInstance(int sectionNumber) {
        RatesFragment fragment = new RatesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public RatesFragment() {

    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rates, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //set up package spinner
        packageSpinner();
        createCalcButton();
        kgInput = (EditText) getView().findViewById(R.id.weight);
    }

    public void packageSpinner() {
        spinner = (Spinner) getView().findViewById(R.id.package_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.goodtypelist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        kgInput.setHint("0-3.5 kg");
                        break;
                    case 1:
                        kgInput.setHint("0-50 kg");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }

    public void createCalcButton() {
        calcButton = (Button) getView().findViewById(R.id.check);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float kgCalc;
                try {
                    kgCalc = Float.parseFloat(kgInput.getText().toString());
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                    switch (spinner.getSelectedItemPosition()) {
                        case 0:
                            if (kgCalc > 3.5 || kgCalc < 0) {
                                builder.setTitle("Invalid Weight")
                                        .setIcon(R.drawable.doc_wrong)
                                        .setMessage("Document weight must be between " +
                                                "0-3.5 kg.")
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            } else {
                                int roundkgCalc = (int) Math.ceil(kgCalc);
                                float postTotal = 0;
                                switch (roundkgCalc) {
                                    case 0:
                                        postTotal = 0.46f;
                                        break;
                                    case 1:
                                        postTotal = 0.46f;
                                        break;
                                    case 2:
                                        postTotal = 0.66f;
                                        break;
                                    case 3:
                                        postTotal = 0.86f;
                                        break;
                                    case 4:
                                        postTotal = 1.06f;
                                        break;
                                }
                                if (roundkgCalc == 4) {
                                    builder.setTitle("Price: RM" + postTotal)
                                            .setIcon(R.drawable.doc_wrong)
                                            .setMessage("Goods Type: Document\nWeight Class: 3.5 kg")
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                } else {
                                    builder.setTitle("Price: RM" + postTotal)
                                            .setIcon(R.drawable.doc_right)
                                            .setMessage("Goods Type: Document\nWeight Class: " + roundkgCalc + " kg")
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            }
                            break;
                        case 1:
                            if (kgCalc > 50 || kgCalc < 0) {
                                builder.setTitle("Invalid Weight")
                                        .setIcon(R.drawable.parcel_wrong)
                                        .setMessage("Parcel weight must be between " +
                                                "0-50 kg.")
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            } else {
                                int roundkgCalc = (int) Math.ceil(kgCalc);
                                float postTotal = 0;
                                switch (roundkgCalc) {
                                    case 0:
                                        postTotal = 0.92f;
                                        break;
                                    case 1:
                                        postTotal = 0.92f;
                                        break;
                                    case 2:
                                        postTotal = 1.12f;
                                        break;
                                    case 3:
                                        postTotal = 1.32f;
                                        break;
                                    case 4:
                                        postTotal = 1.52f;
                                        break;
                                    case 5:
                                        postTotal = 1.72f;
                                        break;
                                    case 6:
                                        postTotal = 1.92f;
                                        break;
                                    case 7:
                                        postTotal = 2.12f;
                                        break;
                                    case 8:
                                        postTotal = 2.32f;
                                        break;
                                    case 9:
                                        postTotal = 2.52f;
                                        break;
                                    case 10:
                                        postTotal = 2.72f;
                                        break;
                                    case 11:
                                        postTotal = 2.92f;
                                        break;
                                    case 12:
                                        postTotal = 3.12f;
                                        break;
                                    case 13:
                                        postTotal = 3.32f;
                                        break;
                                    case 14:
                                        postTotal = 0.92f;
                                        break;
                                    case 15:
                                        postTotal = 0.92f;
                                        break;
                                    case 16:
                                        postTotal = 1.12f;
                                        break;
                                    case 17:
                                        postTotal = 1.32f;
                                        break;
                                    case 18:
                                        postTotal = 1.52f;
                                        break;
                                    case 19:
                                        postTotal = 1.72f;
                                        break;
                                    case 20:
                                        postTotal = 1.92f;
                                        break;
                                    case 21:
                                        postTotal = 2.12f;
                                        break;
                                    case 22:
                                        postTotal = 2.32f;
                                        break;
                                    case 23:
                                        postTotal = 2.52f;
                                        break;
                                    case 24:
                                        postTotal = 2.72f;
                                        break;
                                    case 25:
                                        postTotal = 2.92f;
                                        break;
                                    case 26:
                                        postTotal = 3.12f;
                                        break;
                                    case 27:
                                        postTotal = 3.32f;
                                        break;
                                    case 28:
                                        postTotal = 0.92f;
                                        break;
                                    case 29:
                                        postTotal = 0.92f;
                                        break;
                                    case 30:
                                        postTotal = 1.12f;
                                        break;
                                    case 31:
                                        postTotal = 1.32f;
                                        break;
                                    case 32:
                                        postTotal = 1.52f;
                                        break;
                                    case 33:
                                        postTotal = 1.72f;
                                        break;
                                    case 34:
                                        postTotal = 1.92f;
                                        break;
                                    case 35:
                                        postTotal = 2.12f;
                                        break;
                                    case 36:
                                        postTotal = 2.32f;
                                        break;
                                    case 37:
                                        postTotal = 2.52f;
                                        break;
                                    case 38:
                                        postTotal = 2.72f;
                                        break;
                                    case 39:
                                        postTotal = 2.92f;
                                        break;
                                    case 40:
                                        postTotal = 3.12f;
                                        break;
                                    case 41:
                                        postTotal = 3.32f;
                                        break;
                                    case 42:
                                        postTotal = 0.92f;
                                        break;
                                    case 43:
                                        postTotal = 0.92f;
                                        break;
                                    case 44:
                                        postTotal = 1.12f;
                                        break;
                                    case 45:
                                        postTotal = 1.32f;
                                        break;
                                    case 46:
                                        postTotal = 1.52f;
                                        break;
                                    case 47:
                                        postTotal = 1.72f;
                                        break;
                                    case 48:
                                        postTotal = 1.92f;
                                        break;
                                    case 49:
                                        postTotal = 2.12f;
                                        break;
                                    case 50:
                                        postTotal = 2.32f;
                                        break;

                                }
                                builder.setTitle("Price: RM" + postTotal)
                                        .setIcon(R.drawable.parcel_right)
                                        .setMessage("Goods Type: Parcel\nWeight Class: " + roundkgCalc + " kg")
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                            break;
                    }
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Invalid Input")
                            .setIcon(R.drawable.doc_wrong)
                            .setMessage("Please enter valid weight in kg.")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}
