package com.example.eastasiastudiesapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Conferences extends Fragment {

    private DatabaseReference countryRef,cCountryRef,ug_reference,ug_reference1,pg_reference,pg_reference1,phd_reference,phd_reference1;
    TextView t1,t2,h1,l1,h2,l2,h3,l3,h4,l4,h5,l5,h6,h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21,h22,h23,h24,h25,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25;
    FloatingActionButton ug,pg,phd;
    static String country;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        t1 = getActivity().findViewById(R.id.textViewConference);
        t2 = getActivity().findViewById(R.id.textViewConference1);
        h1 = getActivity().findViewById(R.id.textViewConferenceH1);
        l1 = getActivity().findViewById(R.id.textViewConferenceL1);
        h2 = getActivity().findViewById(R.id.textViewConferenceH2);
        l2 = getActivity().findViewById(R.id.textViewConferenceL2);
        h3 = getActivity().findViewById(R.id.textViewConferenceH3);
        l3 = getActivity().findViewById(R.id.textViewConferenceL3);
        h4 = getActivity().findViewById(R.id.textViewConferenceH4);
        l4 = getActivity().findViewById(R.id.textViewConferenceL4);
        h5 = getActivity().findViewById(R.id.textViewConferenceH5);
        l5 = getActivity().findViewById(R.id.textViewConferenceL5);
        h6 = getActivity().findViewById(R.id.textViewConferenceH6);
        h7 = getActivity().findViewById(R.id.textViewConferenceH7);
        h8 = getActivity().findViewById(R.id.textViewConferenceH8);
        h9 = getActivity().findViewById(R.id.textViewConferenceH9);
        h10 = getActivity().findViewById(R.id.textViewConferenceH10);
        h11 = getActivity().findViewById(R.id.textViewConferenceH11);
        h12 = getActivity().findViewById(R.id.textViewConferenceH12);
        h13 = getActivity().findViewById(R.id.textViewConferenceH13);
        h14 = getActivity().findViewById(R.id.textViewConferenceH14);
        h15 = getActivity().findViewById(R.id.textViewConferenceH15);
        h16 = getActivity().findViewById(R.id.textViewConferenceH16);
        h17 = getActivity().findViewById(R.id.textViewConferenceH17);
        h18 = getActivity().findViewById(R.id.textViewConferenceH18);
        h19 = getActivity().findViewById(R.id.textViewConferenceH19);
        h20 = getActivity().findViewById(R.id.textViewConferenceH20);
        h21 = getActivity().findViewById(R.id.textViewConferenceH21);
        h22 = getActivity().findViewById(R.id.textViewConferenceH22);
        h23 = getActivity().findViewById(R.id.textViewConferenceH23);
        h24 = getActivity().findViewById(R.id.textViewConferenceH24);
        h25 = getActivity().findViewById(R.id.textViewConferenceH25);

        l6 = getActivity().findViewById(R.id.textViewConferenceL6);
        l7 = getActivity().findViewById(R.id.textViewConferenceL7);
        l8 = getActivity().findViewById(R.id.textViewConferenceL8);
        l9 = getActivity().findViewById(R.id.textViewConferenceL9);
        l10 = getActivity().findViewById(R.id.textViewConferenceL10);
        l11 = getActivity().findViewById(R.id.textViewConferenceL11);
        l12 = getActivity().findViewById(R.id.textViewConferenceL12);
        l13 = getActivity().findViewById(R.id.textViewConferenceL13);
        l14 = getActivity().findViewById(R.id.textViewConferenceL14);
        l15 = getActivity().findViewById(R.id.textViewConferenceL15);
        l16 = getActivity().findViewById(R.id.textViewConferenceL16);
        l17 = getActivity().findViewById(R.id.textViewConferenceL17);
        l18 = getActivity().findViewById(R.id.textViewConferenceL18);
        l19 = getActivity().findViewById(R.id.textViewConferenceL19);
        l20 = getActivity().findViewById(R.id.textViewConferenceL20);
        l21 = getActivity().findViewById(R.id.textViewConferenceL21);
        l22 = getActivity().findViewById(R.id.textViewConferenceL22);
        l23 = getActivity().findViewById(R.id.textViewConferenceL23);
        l24 = getActivity().findViewById(R.id.textViewConferenceL24);
        l25 = getActivity().findViewById(R.id.textViewConferenceL25);

        ug = getActivity().findViewById(R.id.ug_conference);
        pg = getActivity().findViewById(R.id.pg_conference);
        phd = getActivity().findViewById(R.id.phd_conference);

        ug.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    ug_reference = FirebaseDatabase.getInstance().getReference().child("Countries").child(""+country);
                    ug_reference1 = ug_reference.child("conferences").child("UG");
                    ug_reference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                t2.setText("Upcoming UG Conferences");
                                t1.setText("");

                                String data = snapshot.child("head1").getValue().toString();
                                h1.setText("⚫ "+data);
                                String data1 = snapshot.child("link1").getValue().toString();
                                l1.setText(data1);

                                String data3 = snapshot.child("head2").getValue().toString();
                                h2.setText("⚫ "+data3);
                                l2.setText(snapshot.child("link2").getValue().toString());

                                String data4 = snapshot.child("head3").getValue().toString();
                                h3.setText("⚫ "+data4);
                                l3.setText(snapshot.child("link3").getValue().toString());

                                String data5 = snapshot.child("head4").getValue().toString();
                                h4.setText("⚫ "+data5);
                                l4.setText(snapshot.child("link4").getValue().toString());

                                String data6 = snapshot.child("head5").getValue().toString();
                                h5.setText("⚫ "+data6);
                                l5.setText(snapshot.child("link5").getValue().toString());

                                String data7 = snapshot.child("head6").getValue().toString();
                                h6.setText("⚫ "+data7);
                                l6.setText(snapshot.child("link6").getValue().toString());

                                String data8 = snapshot.child("head7").getValue().toString();
                                h7.setText("⚫ "+data8);
                                l7.setText(snapshot.child("link6").getValue().toString());

                                String data9 = snapshot.child("head8").getValue().toString();
                                h8.setText("⚫ "+data9);
                                l8.setText(snapshot.child("link8").getValue().toString());

                                String data10 = snapshot.child("head9").getValue().toString();
                                h9.setText("⚫ "+data10);
                                l9.setText(snapshot.child("link9").getValue().toString());

                                String data11 = snapshot.child("head10").getValue().toString();
                                h10.setText("⚫ "+data11);
                                l10.setText(snapshot.child("link10").getValue().toString());

                                String data12 = snapshot.child("head11").getValue().toString();
                                h11.setText("⚫ "+data12);
                                l11.setText(snapshot.child("link11").getValue().toString());

                                String data13 = snapshot.child("head12").getValue().toString();
                                h12.setText("⚫ "+data13);
                                l12.setText(snapshot.child("link12").getValue().toString());

                                String data14 = snapshot.child("head13").getValue().toString();
                                h13.setText("⚫ "+data14);
                                l13.setText(snapshot.child("link13").getValue().toString());

                                String data15 = snapshot.child("head14").getValue().toString();
                                h14.setText("⚫ "+data15);
                                l14.setText(snapshot.child("link14").getValue().toString());

                                String data16 = snapshot.child("head15").getValue().toString();
                                h15.setText("⚫ "+data16);
                                l15.setText(snapshot.child("link15").getValue().toString());

                                String data17 = snapshot.child("head16").getValue().toString();
                                h16.setText("⚫ "+data17);
                                l16.setText(snapshot.child("link16").getValue().toString());

                                String data18 = snapshot.child("head17").getValue().toString();
                                h17.setText("⚫ "+data18);
                                l17.setText(snapshot.child("link17").getValue().toString());

                                String data19 = snapshot.child("head18").getValue().toString();
                                h18.setText("⚫ "+data19);
                                l18.setText(snapshot.child("link18").getValue().toString());

                                String data20 = snapshot.child("head19").getValue().toString();
                                h19.setText("⚫ "+data20);
                                l19.setText(snapshot.child("link19").getValue().toString());

                                String data21 = snapshot.child("head20").getValue().toString();
                                h20.setText("⚫ "+data21);
                                l20.setText(snapshot.child("link20").getValue().toString());

                                String data22 = snapshot.child("head21").getValue().toString();
                                h21.setText("⚫ "+data22);
                                l21.setText(snapshot.child("link21").getValue().toString());

                                String data23 = snapshot.child("head22").getValue().toString();
                                h22.setText("⚫ "+data23);
                                l22.setText(snapshot.child("link22").getValue().toString());

                                String data24 = snapshot.child("head23").getValue().toString();
                                h23.setText("⚫ "+data24);
                                l23.setText(snapshot.child("link23").getValue().toString());

                                String data25 = snapshot.child("head24").getValue().toString();
                                h24.setText("⚫ "+data25);
                                l24.setText(snapshot.child("link24").getValue().toString());

                                String data26 = snapshot.child("head25").getValue().toString();
                                h25.setText("⚫ "+data26);
                                l25.setText(snapshot.child("link25").getValue().toString());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
        });

        pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pg_reference = FirebaseDatabase.getInstance().getReference().child("Countries").child(""+country);
                pg_reference1 = pg_reference.child("conferences").child("PG");
                pg_reference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            t2.setText("Upcoming PG Conferences");
                            t1.setText("");

                            String data = snapshot.child("head1").getValue().toString();
                            h1.setText("⚫ "+data);
                            String data1 = snapshot.child("link1").getValue().toString();
                            l1.setText(data1);

                            String data3 = snapshot.child("head2").getValue().toString();
                            h2.setText("⚫ "+data3);
                            l2.setText(snapshot.child("link2").getValue().toString());

                            String data4 = snapshot.child("head3").getValue().toString();
                            h3.setText("⚫ "+data4);
                            l3.setText(snapshot.child("link3").getValue().toString());

                            String data5 = snapshot.child("head4").getValue().toString();
                            h4.setText("⚫ "+data5);
                            l4.setText(snapshot.child("link4").getValue().toString());

                            String data6 = snapshot.child("head5").getValue().toString();
                            h5.setText("⚫ "+data6);
                            l5.setText(snapshot.child("link5").getValue().toString());

                            String data7 = snapshot.child("head6").getValue().toString();
                            h6.setText("⚫ "+data7);
                            l6.setText(snapshot.child("link6").getValue().toString());

                            String data8 = snapshot.child("head7").getValue().toString();
                            h7.setText("⚫ "+data8);
                            l7.setText(snapshot.child("link6").getValue().toString());

                            String data9 = snapshot.child("head8").getValue().toString();
                            h8.setText("⚫ "+data9);
                            l8.setText(snapshot.child("link8").getValue().toString());

                            String data10 = snapshot.child("head9").getValue().toString();
                            h9.setText("⚫ "+data10);
                            l9.setText(snapshot.child("link9").getValue().toString());

                            String data11 = snapshot.child("head10").getValue().toString();
                            h10.setText("⚫ "+data11);
                            l10.setText(snapshot.child("link10").getValue().toString());

                            String data12 = snapshot.child("head11").getValue().toString();
                            h11.setText("⚫ "+data12);
                            l11.setText(snapshot.child("link11").getValue().toString());

                            String data13 = snapshot.child("head12").getValue().toString();
                            h12.setText("⚫ "+data13);
                            l12.setText(snapshot.child("link12").getValue().toString());

                            String data14 = snapshot.child("head13").getValue().toString();
                            h13.setText("⚫ "+data14);
                            l13.setText(snapshot.child("link13").getValue().toString());

                            String data15 = snapshot.child("head14").getValue().toString();
                            h14.setText("⚫ "+data15);
                            l14.setText(snapshot.child("link14").getValue().toString());

                            String data16 = snapshot.child("head15").getValue().toString();
                            h15.setText("⚫ "+data16);
                            l15.setText(snapshot.child("link15").getValue().toString());

                            String data17 = snapshot.child("head16").getValue().toString();
                            h16.setText("⚫ "+data17);
                            l16.setText(snapshot.child("link16").getValue().toString());

                            String data18 = snapshot.child("head17").getValue().toString();
                            h17.setText("⚫ "+data18);
                            l17.setText(snapshot.child("link17").getValue().toString());

                            String data19 = snapshot.child("head18").getValue().toString();
                            h18.setText("⚫ "+data19);
                            l18.setText(snapshot.child("link18").getValue().toString());

                            String data20 = snapshot.child("head19").getValue().toString();
                            h19.setText("⚫ "+data20);
                            l19.setText(snapshot.child("link19").getValue().toString());

                            String data21 = snapshot.child("head20").getValue().toString();
                            h20.setText("⚫ "+data21);
                            l20.setText(snapshot.child("link20").getValue().toString());

                            String data22 = snapshot.child("head21").getValue().toString();
                            h21.setText("⚫ "+data22);
                            l21.setText(snapshot.child("link21").getValue().toString());

                            String data23 = snapshot.child("head22").getValue().toString();
                            h22.setText("⚫ "+data23);
                            l22.setText(snapshot.child("link22").getValue().toString());

                            String data24 = snapshot.child("head23").getValue().toString();
                            h23.setText("⚫ "+data24);
                            l23.setText(snapshot.child("link23").getValue().toString());

                            String data25 = snapshot.child("head24").getValue().toString();
                            h24.setText("⚫ "+data25);
                            l24.setText(snapshot.child("link24").getValue().toString());

                            String data26 = snapshot.child("head25").getValue().toString();
                            h25.setText("⚫ "+data26);
                            l25.setText(snapshot.child("link25").getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        phd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "PhD clicked for country : "+country, Toast.LENGTH_SHORT).show();

                phd_reference = FirebaseDatabase.getInstance().getReference().child("Countries").child(""+country);
                phd_reference1 = phd_reference.child("conferences").child("PHD");
                phd_reference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            t2.setText("Upcoming PhD Conferences");
                            t1.setText("");

                            String data = snapshot.child("head1").getValue().toString();
                            h1.setText("⚫ "+data);
                            String data1 = snapshot.child("link1").getValue().toString();
                            l1.setText(data1);

                            String data3 = snapshot.child("head2").getValue().toString();
                            h2.setText("⚫ "+data3);
                            l2.setText(snapshot.child("link2").getValue().toString());

                            String data4 = snapshot.child("head3").getValue().toString();
                            h3.setText("⚫ "+data4);
                            l3.setText(snapshot.child("link3").getValue().toString());

                            String data5 = snapshot.child("head4").getValue().toString();
                            h4.setText("⚫ "+data5);
                            l4.setText(snapshot.child("link4").getValue().toString());



                            String data6 = snapshot.child("head5").getValue().toString();
                            h5.setText("⚫ "+data6);
                            l5.setText(snapshot.child("link5").getValue().toString());

//                            String data7 = snapshot.child("head6").getValue().toString();
//                            h6.setText("⚫ "+data7);
//                            l6.setText(snapshot.child("link6").getValue().toString());
//
//                            String data8 = snapshot.child("head7").getValue().toString();
//                            h7.setText("⚫ "+data8);
//                            l7.setText(snapshot.child("link6").getValue().toString());
//
//                            String data9 = snapshot.child("head8").getValue().toString();
//                            h8.setText("⚫ "+data9);
//                            l8.setText(snapshot.child("link8").getValue().toString());
//
//                            String data10 = snapshot.child("head9").getValue().toString();
//                            h9.setText("⚫ "+data10);
//                            l9.setText(snapshot.child("link9").getValue().toString());
//
//                            String data11 = snapshot.child("head10").getValue().toString();
//                            h10.setText("⚫ "+data11);
//                            l10.setText(snapshot.child("link10").getValue().toString());
//
//                            String data12 = snapshot.child("head11").getValue().toString();
//                            h11.setText("⚫ "+data12);
//                            l11.setText(snapshot.child("link11").getValue().toString());
//
//                            String data13 = snapshot.child("head12").getValue().toString();
//                            h12.setText("⚫ "+data13);
//                            l12.setText(snapshot.child("link12").getValue().toString());
//
//                            String data14 = snapshot.child("head13").getValue().toString();
//                            h13.setText("⚫ "+data14);
//                            l13.setText(snapshot.child("link13").getValue().toString());
//
//                            String data15 = snapshot.child("head14").getValue().toString();
//                            h14.setText("⚫ "+data15);
//                            l14.setText(snapshot.child("link14").getValue().toString());
//
//                            String data16 = snapshot.child("head15").getValue().toString();
//                            h15.setText("⚫ "+data16);
//                            l15.setText(snapshot.child("link15").getValue().toString());
//
//                            String data17 = snapshot.child("head16").getValue().toString();
//                            h16.setText("⚫ "+data17);
//                            l16.setText(snapshot.child("link16").getValue().toString());
//
//                            String data18 = snapshot.child("head17").getValue().toString();
//                            h17.setText("⚫ "+data18);
//                            l17.setText(snapshot.child("link17").getValue().toString());
//
//                            String data19 = snapshot.child("head18").getValue().toString();
//                            h18.setText("⚫ "+data19);
//                            l18.setText(snapshot.child("link18").getValue().toString());
//
//                            String data20 = snapshot.child("head19").getValue().toString();
//                            h19.setText("⚫ "+data20);
//                            l19.setText(snapshot.child("link19").getValue().toString());
//
//                            String data21 = snapshot.child("head20").getValue().toString();
//                            h20.setText("⚫ "+data21);
//                            l20.setText(snapshot.child("link20").getValue().toString());
//
//                            String data22 = snapshot.child("head21").getValue().toString();
//                            h21.setText("⚫ "+data22);
//                            l21.setText(snapshot.child("link21").getValue().toString());
//
//                            String data23 = snapshot.child("head22").getValue().toString();
//                            h22.setText("⚫ "+data23);
//                            l22.setText(snapshot.child("link22").getValue().toString());
//
//                            String data24 = snapshot.child("head23").getValue().toString();
//                            h23.setText("⚫ "+data24);
//                            l23.setText(snapshot.child("link23").getValue().toString());
//
//                            String data25 = snapshot.child("head24").getValue().toString();
//                            h24.setText("⚫ "+data25);
//                            l24.setText(snapshot.child("link24").getValue().toString());
//
//                            String data26 = snapshot.child("head25").getValue().toString();
//                            h25.setText("⚫ "+data26);
//                            l25.setText(snapshot.child("link25").getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        myViewModel.getData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String data) {
                country = data;

                if(country == "China"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("China");
                    cCountryRef = countryRef.child("conferences");
                    cCountryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String data = snapshot.child("ehome").getValue().toString();
                                t1.setText(data);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "Japan"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("Japan");
                    cCountryRef = countryRef.child("conferences");
                    cCountryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String data = snapshot.child("ehome").getValue().toString();
                                t1.setText(data);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "Korea"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("Korea");
                    cCountryRef = countryRef.child("conferences");
                    cCountryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String data = snapshot.child("ehome").getValue().toString();
                                t1.setText(data);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "IndoPacific"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("IndoPacific");
                    cCountryRef = countryRef.child("conferences");
                    cCountryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String data = snapshot.child("ehome").getValue().toString();
                                t1.setText(data);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                if(country == "SouthEastAsia"){
                    countryRef = FirebaseDatabase.getInstance().getReference().child("Countries").child("SouthEastAsia");
                    cCountryRef = countryRef.child("conferences");
                    cCountryRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String data = snapshot.child("ehome").getValue().toString();
                                t1.setText(data);
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


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_conferences, container, false);
    }

}