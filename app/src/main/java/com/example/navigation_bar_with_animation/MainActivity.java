package com.example.navigation_bar_with_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.navigation_bar_with_animation.Navigation.Home_Fragment;
import com.example.navigation_bar_with_animation.Navigation.Menu_Fragment;
import com.example.navigation_bar_with_animation.Navigation.More_Fragment;
import com.example.navigation_bar_with_animation.Navigation.Offers_Fragment;
import com.example.navigation_bar_with_animation.Navigation.Profile_Fragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //initialize variable
    MeowBottomNavigation bottomNavigation;
//call duo with mute...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign variable
        bottomNavigation = findViewById(R.id.bottom_navigation);

        //add menu items
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_menu));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_offers));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_profile));
        bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.ic_more));

        //click event
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //Initialize Fragment
                Fragment fragment = null;
                //check condition to navigate
                switch (item.getId()){
                    case 1:
                        fragment = new Menu_Fragment();
                        break;
                    case 2:
                        fragment = new Offers_Fragment();
                        break;
                    case 3:
                        fragment = new Home_Fragment();
                        break;
                    case 4:
                        fragment = new Profile_Fragment();
                        break;
                    case 5:
                        fragment = new More_Fragment();
                        break;
                }
                loadfragment(fragment);
            }
        });
        //set notification count
        bottomNavigation.setCount(1,"10");
        //set home fragment initially set
        bottomNavigation.show(3,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(),""+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"You are already here",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadfragment(Fragment fragment) {
        //replace fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
}