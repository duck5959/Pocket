package com.example.pocket.class_.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pocket.R;

public class ChatTestActivity extends AppCompatActivity {

    EditText etUserName, etRoomNumber;
    Button btnChatJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_test);

        etUserName = findViewById(R.id.etUserName);
        etRoomNumber = findViewById(R.id.etRoomNumber);
        btnChatJoin = findViewById(R.id.btnChatJoin);

        btnChatJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChatTestActivity.class);
                intent.putExtra("userName", etRoomNumber.getText().toString());
                intent.putExtra("roomNumber", etRoomNumber.getText().toString());
                startActivity(intent);
            }
        });
    }
}