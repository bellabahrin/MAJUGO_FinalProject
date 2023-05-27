package com.example.majugoscreen;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stripe.model.Recipient;

import java.util.HashMap;

public class Order2Activity extends AppCompatActivity {
    private EditText c1, c2, c3, c4, c5;
    private Button r1;
    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        r1 = (Button) findViewById(R.id.com2);
        c1 = (EditText) findViewById(R.id.editText2);
        c2 = (EditText) findViewById(R.id.foneBut);
        c3 = (EditText) findViewById(R.id.editText3);
        c4 = (EditText) findViewById(R.id.butCity);
        c5 = (EditText) findViewById(R.id.dresBut);
        loadingbar = new ProgressDialog(this);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipientData();
            }
        });

    }

    private void RecipientData() {
        String name =  c1.getText().toString();
        String tel =  c2.getText().toString();
        String code =  c3.getText().toString();
        String  city =  c4.getText().toString();
        String address = c5.getText().toString();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please Write Recipient Name..", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(tel))
        {
            Toast.makeText(this, "Please Write Recipient Phone Number..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(code))
        {
            Toast.makeText(this, "Please Write Recipient Postcode..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(city))
        {
            Toast.makeText(this, "Please Recipient Sender City..", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(address))
        {
            Toast.makeText(this, "Please Recipient Sender Address..", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingbar.setTitle("Confirmation");
            loadingbar.setMessage("Please wait while we are checking the credentials.");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            Validatename(name, tel, code, city, address);
        }

    }

    private void Validatename (final String name, final String tel, final String code, final String city, final String address) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(name).exists()))
                {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("Sender name", name);
                    userdataMap.put("Sender No. Phone", tel);
                    userdataMap.put("Sender Postcode", code);
                    userdataMap.put("Sender City", city);
                    userdataMap.put("Sender Address", address);

                    RootRef.child("Users").child(name).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Order2Activity.this, "Congratulations, your Data has been save.", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();

                                        Intent intent = new Intent(Order2Activity.this, Order3Activity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        loadingbar.dismiss();
                                        Toast.makeText(Order2Activity.this, "Network Error : Please try again after some time..", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else
                {
                    Intent intent = new Intent(Order2Activity.this, Order3Activity.class );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
