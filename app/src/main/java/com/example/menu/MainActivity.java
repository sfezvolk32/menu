package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
NavController navController;
    TextView textView;
    BlankFragmentProfile blankFragmentProfile = new BlankFragmentProfile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }


    private void setNewFragment(Fragment fragment) {
        FragmentTransaction fragmentT = getSupportFragmentManager().beginTransaction();
        fragmentT.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //получение идентификатора от меню

        int id = item.getItemId();

        switch (id) {
            case R.id.action_profile:
                //какое-то действие
               navController.navigate(R.id.blankFragmentProfile);
                textView.setText("Вы в своем профиле");
                return true;
            case R.id.action_logout:
                //какой-то действие
                this.finish();
                return true;
            case R.id.action_notifications:
                navController.navigate(R.id.blankFragmentNotification);
                textView.setText("Мои уведомления");
                return true;
            case R.id.action_settings:
                navController.navigate(R.id.blankFragmentSettings);
                textView.setText("Настройки");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}