package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottom_navigation;
    private Fragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu,new FragmentBirinci()).commit();// ilk baslyacak fragment


        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_birinci) {
                    Toast.makeText(getApplicationContext(), "birinci tılandı", Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentBirinci();
                }
                if (item.getItemId() == R.id.action_ikinci) {
                    Toast.makeText(getApplicationContext(), "ikini tılandı", Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentIkinci();
                }
                if (item.getItemId() == R.id.action_ucuncu) {
                    Toast.makeText(getApplicationContext(), "ucnucu tılandı", Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentUcuncu();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu,tempFragment).commit();// ilk baslyacak fragment

            }
        });

    }
}