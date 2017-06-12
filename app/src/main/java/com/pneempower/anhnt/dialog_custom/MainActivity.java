package com.pneempower.anhnt.dialog_custom;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewLoggin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLoggin = (TextView) findViewById(R.id.texviewLoggin);
        textViewLoggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLogin();
            }
        });
    }
    private  void DialogLogin(){


        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);
//        khi đang điền vào dòng text mà click ra ngoài. lúc quay lại vẫn còn dòng text trc đó
        dialog.setCanceledOnTouchOutside(false);


        final EditText edtUsername = (EditText) dialog.findViewById(R.id.editTextusername);
        final EditText edtPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
        Button btnDongy            = (Button) dialog.findViewById(R.id.buttonDongy);
        Button btnHuy              = (Button) dialog.findViewById(R.id.buttonHuy);

        btnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String userpassword = edtPassword.getText().toString().trim();
                if (username.equals("tuan") && userpassword.equals("000")){
                    Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialog.cancel();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
