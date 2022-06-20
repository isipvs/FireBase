package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editPhone = findViewById(R.id.phone);
        EditText editEmail = findViewById(R.id.email);
        EditText editPassword =findViewById(R.id.password);
        EditText reenterPSW = findViewById(R.id.password2);//повтор пароля
        Button btn = findViewById(R.id.ok);



        btn.setOnClickListener(view ->{

            String phone = editPhone.getText().toString();
            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();
            String password2 = reenterPSW.getText().toString();

            CheckData cd = new CheckData();
            //Check(String email, String password, String password2, String phone)
            boolean isVal = cd.Check(email,password,password2,phone);
            if(isVal==false)
            {
                Toast.makeText(this, cd.getInfo().toString(), Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Продолжаем!", Toast.LENGTH_SHORT).show(); //https://fir-c089a-default-rtdb.firebaseio.com/
            database = FirebaseDatabase.getInstance("https://fir-292be-default-rtdb.firebaseio.com").getReference().child("Users");

            User user = new User(phone,email,password);

            database.child(phone).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    editPhone.getText().clear();
                    editEmail.getText().clear();
                    editPassword.getText().clear();
                    reenterPSW.getText().clear();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Щищь", Toast.LENGTH_SHORT).show();
                    Log.e("qwe","onFailure: ",e);
                }
            });
        });
    }
}