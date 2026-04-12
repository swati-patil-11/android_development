package com.example.project1;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.selectcontact);

        btn.setOnClickListener(v -> {

            Intent i = new Intent(Intent.ACTION_PICK,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI);

            startActivityForResult(i,1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == 1 && resultCode == RESULT_OK){

            Uri uri = data.getData();

            Cursor c = getContentResolver().query(uri,null,null,null,null);

            if(c != null){
                c.moveToFirst();

                String number = c.getString(
                        c.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));

                Intent i = new Intent();
                i.setClassName("com.example.project2",
                        "com.example.project2.MainActivity");

                i.putExtra("phone",number);

                startActivity(i);

                c.close();
            }
        }
    }
}