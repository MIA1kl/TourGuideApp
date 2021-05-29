package com.example.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * MuseumsFragment is the Class that displays the Museums Tab in the Categories Activity.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get String Array Resources from the Strings File
        String[] hotelsNames = getResources().getStringArray(R.array.hotels_names);
        String[] hotelsAddresses = getResources().getStringArray(R.array.hotels_addresses);
        String[] hotelsDescriptions = getResources().getStringArray(R.array.hotels_descriptions);

        String[] hotelsPhones = getResources().getStringArray(R.array.hotels_phones);

        // Add Google Maps URIs
        String[] hotelsMapUris = {
                "https://www.google.com/maps/place/Park+Inn+by+Radisson/@52.5230261,13.4101259,17z/data=!3m1!4b1!4m8!3m7!1s0x47a84e1f1ee20ee1:0xad6a5dfdfd4c87a1!5m2!4m1!1i2!8m2!3d52.5230261!4d13.4123146",
                "https://www.google.com/maps/place/SANA+Berlin+Hotel/@52.4990685,13.3322356,17z/data=!3m1!4b1!4m8!3m7!1s0x47a85057d3b1e6dd:0x45151315b13746af!5m2!4m1!1i2!8m2!3d52.4990685!4d13.3344243",
                "https://www.google.com/maps/place/Hotel+nhow+Berlin/@52.50138,13.4474513,17z/data=!3m1!4b1!4m8!3m7!1s0x47a84e513f05dea3:0xaa6f98f87980299d!5m2!4m1!1i2!8m2!3d52.50138!4d13.44964",
                "https://www.google.com/maps/place/Living+Hotel+Großer+Kurfürst/@52.5122679,13.406665,17z/data=!3m2!4b1!5s0x47a84e26669968bd:0xd14f044e4c05e8c1!4m8!3m7!1s0x47a84e26661fd849:0x9b40adf69721b5a6!5m2!4m1!1i2!8m2!3d52.5122679!4d13.4088537",
                "https://www.google.com/maps/place/ARCOTEL+John+F+Berlin/@52.5152463,13.3954912,17z/data=!3m2!4b1!5s0x47a851d96b8a747d:0xbee5b82707e4c57a!4m8!3m7!1s0x47a851d96b7a848f:0x72cf771d170d285d!5m2!4m1!1i2!8m2!3d52.5152463!4d13.3976799",
                "https://www.google.com/maps/place/Steigenberger+Hotel+Berlin/@52.5152308,13.3626605,13z/data=!4m13!1m6!2m5!1sSteigenberger+Hotel+Berlin!5m3!5m2!4m1!1i2!3m5!1s0x47a85055ffdb06d5:0x945a4791c53c564a!5m2!4m1!1i2!15sChpTdGVpZ2VuYmVyZ2VyIEhvdGVsIEJlcmxpbiIDiAEBWjEKE3N0ZWlnZW5iZXJnZXIgaG90ZWwiGnN0ZWlnZW5iZXJnZXIgaG90ZWwgYmVybGlukgEFaG90ZWw",
        };

        // Add Images Resource IDs
        int[] hotelsImages = {
                R.drawable.hotel1,
                R.drawable.hotel2,
                R.drawable.hotel3,
                R.drawable.hotel4,
                R.drawable.hotel5,
                R.drawable.hotel6,

        };

        // Initialize ArrayList of Landmarks
        final ArrayList<Landmark> hotels = new ArrayList<>();

        // Add All Landmarks to the ArrayList
        for (int i = 0; i < hotelsNames.length; i++) {
            hotels.add(new Landmark(
                    hotelsNames[i],
                    hotelsDescriptions[i],
                    hotelsAddresses[i],
                    Utils.addPrefix(hotelsPhones[i]),
                    hotelsMapUris[i],
                    hotelsImages[i]));
        }

        // Set Custom List View Adapter
        ListView listView = (ListView) rootView.findViewById(R.id.cat_items_list);
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), hotels);
        listView.setAdapter(adapter);

        // Set Click Listeners for Each Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get Landmark Object at Current Position
                Landmark hotel = hotels.get(position);

                // Start Intent and Send Landmark Object to DetailActivity
                Utils.openDetailActivity(getContext(), hotel);

            }
        });

        return rootView;
    }
}
