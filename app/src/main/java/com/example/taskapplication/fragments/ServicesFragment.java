package com.example.taskapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskapplication.R;
import com.example.taskapplication.utils.ServiceAdapter;
import com.example.taskapplication.utils.ServicesModel;


public class ServicesFragment extends Fragment {

    RecyclerView serviceRv;

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
        View v = inflater.inflate(R.layout.fragment_services, container, false);
        serviceRv = v.findViewById(R.id.serviceRv);

        ServicesModel[] servicesModel = new ServicesModel[]
                {
                    new ServicesModel("Working with Government", image1),
                    new ServicesModel("Working with Government", image2),
                    new ServicesModel("Working with Government", image3),
                    new ServicesModel("Working with Government", image4),
                    new ServicesModel("Working with Government", img1),
                    new ServicesModel("Working with Government", img2),
                    new ServicesModel("Working with Government", img3),
                    new ServicesModel("Working with Government", img4),
                    new ServicesModel("Working with Government", image1),
                    new ServicesModel("Working with Government", image2),
                    new ServicesModel("", ""),
                    new ServicesModel("", ""),

                        new ServicesModel("Working with Government", image1),
                        new ServicesModel("Working with Government", image2),
                        new ServicesModel("Working with Government", image3),
                        new ServicesModel("Working with Government", image4),
                        new ServicesModel("Working with Government", img1),
                        new ServicesModel("Working with Government", img2),
                        new ServicesModel("Working with Government", img3),
                        new ServicesModel("Working with Government", img4),
                        new ServicesModel("Working with Government", image1),
                        new ServicesModel("Working with Government", image2),
                        new ServicesModel("", ""),
                        new ServicesModel("", ""),

                        new ServicesModel("Working with Government", image1),
                        new ServicesModel("Working with Government", image2),
                        new ServicesModel("Working with Government", image3),
                        new ServicesModel("Working with Government", image4),
                        new ServicesModel("Working with Government", img1),
                        new ServicesModel("Working with Government", img2),
                        new ServicesModel("Working with Government", img3),
                        new ServicesModel("Working with Government", img4),
                        new ServicesModel("Working with Government", image1),
                        new ServicesModel("Working with Government", image2),
                        new ServicesModel("", ""),
                        new ServicesModel("", ""),

                        new ServicesModel("Working with Government", image1),
                        new ServicesModel("Working with Government", image2),
                        new ServicesModel("Working with Government", image3),
                        new ServicesModel("Working with Government", image4),
                        new ServicesModel("Working with Government", img1),
                        new ServicesModel("Working with Government", img2),
                        new ServicesModel("Working with Government", img3),
                        new ServicesModel("Working with Government", img4),
                        new ServicesModel("Working with Government", image1),
                        new ServicesModel("Working with Government", image2),
                        new ServicesModel("", ""),
                        new ServicesModel("", ""),

                };

        ServiceAdapter adapter = new ServiceAdapter(servicesModel, getContext());
        int numberOfColumns = 4;
        serviceRv.setHasFixedSize(true);
        serviceRv.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        serviceRv.setAdapter(adapter);


        return v;
    }
}