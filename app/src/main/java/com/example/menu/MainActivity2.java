package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //получение идентификатора от меню

        int id = item.getItemId();

        switch (id) {
            case R.id.action_profile:
                //какое-то действие
                textView.setText("Вы в своем профиле");
                return true;
            case R.id.action_logout:
                //какой-то действие
                textView.setText("Вы хотите выйти?");

                //startActivity(new Intent(MainActivity2.this, MainActivity2.class));
                return true;
            case R.id.action_notifications:
                textView.setText("Мои уведомления");
                return true;
            case R.id.action_settings:
                textView.setText("Настройки");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}