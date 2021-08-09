package com.be.custom_toast_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView ;
    private Button btn  , validate;
    private EditText email , password , phone ;
    private CustomDialog customDialog ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view  = inflater.inflate(R.layout.custom_taost,null);
        imageView = view.findViewById(R.id.image);
        textView = view.findViewById(R.id.txtvw);
        btn = findViewById(R.id.show_toast);
        customDialog = new CustomDialog(this);
        validate  = findViewById(R.id.button_validate);
        email = findViewById(R.id.email_edit_text);
        password = findViewById(R.id.password_edit_text);
        phone = findViewById(R.id.phone_edit_text);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.showProgress();
                if (!validateEmail(email.getText().toString())| !validatePAssword(password.getText().toString()) | !validatePhone(phone.getText().toString()))
                {
                    customDialog.showProgress();
                    customDialog.setProgressBar("Please Wait..","InComplete Information");

                }
                else
                {
                    customDialog.showProgress();
                    customDialog.setProgressBar("Please Wait..","Success");
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,100);
                toast.setView(view);
                toast.show();
            }
        });
    }

    private boolean validatePAssword(String s) {
         if (s.isEmpty())
        {
            password.setError("Field is Empty");
            password.setFocusable(true);
            return false;
        }
        else if (s.length()>6)
        {
            password.setError("Password Count is less then Six");
            password.setFocusable(true);
            return false;
        }
        else
        {
            password.setError(null);
            password.setFocusable(false);
            return true;
        }
    }

    public boolean validateEmail(String s)
    {
         if (s.isEmpty())
        {
            email.setError("Field is Empty");
            email.setFocusable(true);
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(s).matches())
        {
            email.setError("Incorrect Format");
            email.setFocusable(true);
            return false;
        }
        else
        {
            email.setError(null);
            email.setFocusable(false);
            return true;
        }
    }


    public boolean validatePhone(String s)
    {
        if (s.isEmpty())
        {
            phone.setError("Field is Empty");
            phone.setFocusable(true);
            return false;
        }
        else if (!Patterns.PHONE.matcher(s).matches())
        {
            phone.setError("Incorrect Format");
            phone.setFocusable(true);
            return false;
        }
        else
        {
            phone.setError(null);
            phone
                    .setFocusable(false);
            return true;
        }
    }




}