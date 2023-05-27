package com.example.majugoscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.majugoscreen.Model.ParcelData;
import com.example.majugoscreen.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {
   private EditText Sname, Sphone,Semail, Rname, Rphone,Raddress, Iname, Iweight, Itype;
   private Button button;
   DatabaseReference ref;
   ParcelData parcelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        button= (Button)findViewById(R.id.confirm_btn);
        Sname= (EditText) findViewById(R.id.SenderName);
        Sphone= (EditText) findViewById(R.id.SenderPhone);
        Semail= (EditText) findViewById(R.id.SenderEmail);
        Rname= (EditText) findViewById(R.id.RecipientName);
        Rphone= (EditText) findViewById(R.id.RecipientPhone);
        Raddress= (EditText) findViewById(R.id.RecipientAddress);
        Iname= (EditText) findViewById(R.id.ItemName);
        Iweight= (EditText) findViewById(R.id.ItemWeight);
        Itype= (EditText) findViewById(R.id.ItemType);
        parcelData=new ParcelData();
        ref=FirebaseDatabase.getInstance().getReference().child("Parcel Data");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }
        });
    }

    private void Check() {
        if (TextUtils.isEmpty(Sname.getText().toString()))
        {
            Toast.makeText(this, "Please provide your full name.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Sphone.getText().toString()))
        {
            Toast.makeText(this, "Please provide your phone number.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Semail.getText().toString()))
        {
            Toast.makeText(this, "Please provide your email.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Rname.getText().toString()))
        {
            Toast.makeText(this, "Please provide your recipient full name.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Rphone.getText().toString()))
        {
            Toast.makeText(this, "Please provide your recipient phone number.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Raddress.getText().toString()))
        {
            Toast.makeText(this, "Please provide your recipient address.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Iname.getText().toString()))
        {
            Toast.makeText(this, "Please provide your item name.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Iweight.getText().toString()))
        {
            Toast.makeText(this, "Please provide your item weight.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Itype.getText().toString()))
        {
            Toast.makeText(this, "Please provide your item type.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ConfirmOrder();
        }
    }

    private void ConfirmOrder()
    {

        parcelData.setSendername(Sname.getText().toString().trim());
        parcelData.setSenderphone(Sphone.getText().toString().trim());
        parcelData.setSenderemail(Semail.getText().toString().trim());
        parcelData.setRpname(Rname.getText().toString().trim());
        parcelData.setRpphone(Rphone.getText().toString().trim());
        parcelData.setRpaddress(Raddress.getText().toString().trim());
        parcelData.setImname(Iname.getText().toString().trim());
        parcelData.setImweight(Iweight.getText().toString().trim());
        parcelData.setImtype(Itype.getText().toString().trim());
        ref.push().setValue(parcelData);
        Toast.makeText(OrderActivity.this, "Your order has been placed successfully", Toast.LENGTH_SHORT).show();

        String str0 = Sname.getText().toString();
        String str1 = Sphone.getText().toString();
        String str2 = Semail.getText().toString();
        String str3 = Rname.getText().toString();
        String str4 = Rphone.getText().toString();
        String str5 = Raddress.getText().toString();
        String str6 = Iname.getText().toString();
        String str7 = Iweight.getText().toString();
        String str8 = Itype.getText().toString();

        Intent i = new Intent(getApplicationContext(),Order3Activity.class);
        i.putExtra("Sender_Name", str0);
        i.putExtra("Sender_Phone", str1);
        i.putExtra("Sender_Email", str2);
        i.putExtra("Recipient_Name", str3);
        i.putExtra("Recipient_Phone", str4);
        i.putExtra("Recipient_Address", str5);
        i.putExtra("Item_Name", str6);
        i.putExtra("Item_Weight", str7);
        i.putExtra("Item_Type", str8);
        startActivity(i);


    }
}


