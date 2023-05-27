package com.example.majugoscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Order3Activity extends AppCompatActivity {

    TextView sender_name, sender_phone, sender_email, recipient_name, recipient_phone, recipient_address, item_name, item_weight, item_type;
    Button button_ship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order3);


        sender_name = (TextView)findViewById(R.id.receive_s_name);
        sender_phone = (TextView)findViewById(R.id.receive_s_phone);
        sender_email = (TextView)findViewById(R.id.receive_s_email);
        recipient_name = (TextView)findViewById(R.id.receive_r_name);
        recipient_phone = (TextView)findViewById(R.id.receive_r_phone);
        recipient_address = (TextView)findViewById(R.id.receive_r_address);
        item_name = (TextView)findViewById(R.id.receive_i_name);
        item_weight = (TextView)findViewById(R.id.receive_i_weight);
        item_type = (TextView)findViewById(R.id.receive_i_type);
        button_ship = (Button)findViewById(R.id.ship_btn);

        Intent i = getIntent();
        String str0 = i.getStringExtra("Sender_Name");
        String str1 = i.getStringExtra("Sender_Phone");
        String str2 = i.getStringExtra("Sender_Email");
        String str3= i.getStringExtra("Recipient_Name");
        String str4= i.getStringExtra("Recipient_Phone");
        String str5 = i.getStringExtra("Recipient_Address");
        String str6 = i.getStringExtra("Item_Name");
        String str7 = i.getStringExtra("Item_Weight");
        String str8 = i.getStringExtra("Item_Type");


        sender_name.setText(str0);
        sender_phone.setText(str1);
        sender_email.setText(str2);
        recipient_name.setText(str3);
        recipient_phone.setText(str4);
        recipient_address.setText(str5);
        item_name.setText(str6);
        item_weight.setText(str7);
        item_type.setText(str8);


        button_ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(Order3Activity.this, MainActivity.class);
                Toast.makeText(Order3Activity.this, "Your order has been placed successfully", Toast.LENGTH_SHORT).show();
                startActivity(s);
            }
        });

    }

}
