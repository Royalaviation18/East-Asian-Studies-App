package com.example.eastasiastudiesapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class CountryHome extends Fragment {

    private DatabaseReference countryRef,countryRef1,cCountryRef;
    TextView t1;
    CollapsingToolbarLayout ctl;
    FloatingActionButton i1;
    static String country,name1,home1;
    public boolean firstVisit;
    private MyViewModel myViewModel;


    @Override
    public void onStart() {
        super.onStart();

        MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        myViewModel.getData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String data) {
                // update UI with the new data
                country = data;
                Toast.makeText(getActivity().getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();

                if(country == "China"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("China");
//                    cCountryRef = countryRef.child("conferences").child("PG");
//                    countryRef.get()
                    countryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String name = snapshot.child("name").getValue().toString();
                                name1 = name;
                                ctl.setTitle(name);
                                String home = snapshot.child("home").getValue().toString();
                                home1 = home;
                                t1.setText(home);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "Japan"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("Japan");
//                    cCountryRef = countryRef.child("conferences").child("PG");
                    countryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String name = snapshot.child("name").getValue().toString();
                                name1 = name;
                                ctl.setTitle(name);
                                String home = snapshot.child("home").getValue().toString();
                                home1 = home;
                                t1.setText(home);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "Korea"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("Korea");
//                    cCountryRef = countryRef.child("conferences").child("PG");
                    countryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String name = snapshot.child("name").getValue().toString();
                                name1 = name;
                                ctl.setTitle(name);
                                String home = snapshot.child("home").getValue().toString();
                                home1 = home;
                                t1.setText(home);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "SouthEastAsia"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("SouthEastAsia");
//                    cCountryRef = countryRef.child("conferences").child("PG");
                    countryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String name = snapshot.child("name").getValue().toString();
                                name1 = name;
                                ctl.setTitle(name);
                                String home = snapshot.child("home").getValue().toString();
                                home1 = home;
                                t1.setText(home);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "IndoPacific"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("IndoPacific");
//                    cCountryRef = countryRef.child("conferences").child("PG");
                    countryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String name = snapshot.child("name").getValue().toString();
                                name1 = name;
                                ctl.setTitle(name);
                                String home = snapshot.child("home").getValue().toString();
                                home1 = home;
                                t1.setText(home);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });



    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        Toast.makeText(getActivity().getApplicationContext(), "Name:"+name1, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Toast.makeText(getActivity().getApplicationContext(), "onstop", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onResume() {
        super.onResume();
//        Toast.makeText(getActivity().getApplicationContext(), "Name:"+name1, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getActivity().getApplicationContext(), "Details:"+home1, Toast.LENGTH_SHORT).show();

    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Toast.makeText(getActivity().getApplicationContext(), "onsaveinstancestate", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        t1 = getActivity().findViewById(R.id.textViewCountryHome);
        ctl = getActivity().findViewById(R.id.collapsing_toolbar_countryhome);
        i1 = getActivity().findViewById(R.id.mailhome);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "eastasian.studies@christuniversity.in"));
                try
                {
                    startActivity(intent);
                }
                catch(ActivityNotFoundException e)
                {
                    //handle error
                }

            }

        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_country_home, container, false);

//        // Get a reference to the TextView
//        t1 = view.findViewById(R.id.textView);
//        Toast.makeText(getActivity().getApplicationContext(), "InsideViewModelData", Toast.LENGTH_SHORT).show();
//
//
//        // Observe the data stored in the ViewModel
//        myViewModel.getMyData().observe(getViewLifecycleOwner(), data -> {
//            Toast.makeText(getActivity().getApplicationContext(), "ViewModelData--"+data, Toast.LENGTH_SHORT).show();
//
//            t1.setText(data);
//        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
    }
}