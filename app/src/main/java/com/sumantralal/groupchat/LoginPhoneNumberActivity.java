package com.sumantralal.groupchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class LoginPhoneNumberActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText login_mobile_number;
    Button send_otp_btn;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_number);

        countryCodePicker=findViewById(R.id.login_country_code);
        login_mobile_number=findViewById(R.id.login_mobile_number);
        send_otp_btn=findViewById(R.id.send_otp_btn);
        progressBar=findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(login_mobile_number);
        send_otp_btn.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()) {
                login_mobile_number.setError("Phone number is not Valid");
                return;
            }
            Intent intent=new Intent(LoginPhoneNumberActivity.this,LoginOtpActivity.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });
    }
}