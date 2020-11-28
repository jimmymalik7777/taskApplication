package com.example.taskapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.taskapplication.BaseActivity;
import com.example.taskapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {


    ImageView govtImg1,govtImg2, govtImg3, govtImg4;

    ImageView otherImg1, otherImg2, otherImg3, otherImg4;

    LinearLayout govt_menu_item;

    String image1 = "https://images.vexels.com/media/users/3/190861/isolated/lists/b64c5b6cdb9f9e3b6a73c1ac163e3c3b-building-government-house-flat-illustration.png";
    String image2 = "https://pngwebicons.com/uploads/car/256/car_icon3955.png";
    String image3 = "https://cdn0.iconfinder.com/data/icons/free-business-desktop-icons/256/Home.png";
    String image4 = "https://images.vexels.com/media/users/3/153403/isolated/lists/f55be2069e45f4bb7a1bc13b310e004d-vintage-movie-camera-flat-icon-multimedia-icons.png";


    String img1 = "https://cdn.iconscout.com/icon/premium/png-128-thumb/utility-meter-501707.png";
    String img2 = "https://image.flaticon.com/icons/png/128/2781/2781256.png";
    String img3 = "https://cdn.iconscout.com/icon/free/png-256/medical-127-129383.png";
    String img4 = "https://lh3.googleusercontent.com/proxy/TFcjk9vMIkcPiODdwJ8b150iJr5QSCV6Cd_Y-HYiyJvdQhJHlmZ123FmaTO24a4BhxmHjfatShJM1Vvi0IxvFF4jvkiG_TYbItguzWlIG6ZlRs6n3Ync4DEBYoEfqNWWtoePgTMTyIA84u-WSZv7VYduQ0Us98y4YCl0W2HBzHCreuLiTLzVcZFuiqE";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        govtImg1 = v.findViewById(R.id.govtImg1);
        govtImg2 = v.findViewById(R.id.govtImg2);
        govtImg3 = v.findViewById(R.id.govtImg3);
        govtImg4 = v.findViewById(R.id.govtImg4);

        otherImg1 = v.findViewById(R.id.otherImg1);
        otherImg2 = v.findViewById(R.id.otherImg2);
        otherImg3 = v.findViewById(R.id.otherImg3);
        otherImg4 = v.findViewById(R.id.otherImg4);

        govt_menu_item = v.findViewById(R.id.govt_menu_item);

        BottomNavigationView bottomNav = v.findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Glide.with(getContext())
                .load(image1)
                .into(govtImg1);
        Glide.with(getContext())
                .load(image2)
                .into(govtImg2);
        Glide.with(getContext())
                .load(image3)
                .into(govtImg3);
        Glide.with(getContext())
                .load(image4)
                .into(govtImg4);

        Glide.with(getContext())
                .load(img1)
                .into(otherImg1);
        Glide.with(getContext())
                .load(img2)
                .into(otherImg2);
        Glide.with(getContext())
                .load(img3)
                .into(otherImg3);
        Glide.with(getContext())
                .load(img4)
                .into(otherImg4);

        govt_menu_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        new ServicesFragment()).commit();
                ((BaseActivity)getActivity()).mToolbar.setTitle("Government Services");
            }
        });

        return v;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home_bottom:
                            selectedFragment = new HomeFragment();
                            ((BaseActivity)getActivity()).mToolbar.setTitle("Home");
                            break;
                        case R.id.nav_services_bottom:
                            selectedFragment = new ServicesFragment();
                            ((BaseActivity)getActivity()).mToolbar.setTitle("Government Services");
                            break;
                        case R.id.nav_post_bottom:
                            selectedFragment = new PostsFragment();
                            ((BaseActivity)getActivity()).mToolbar.setTitle("Posts");
                            break;


                    }
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

}