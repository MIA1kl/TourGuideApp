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
 * MonumentsFragment is the Class that displays the Monuments Tab in the Categories Activity.
 */
public class MonumentsFragment extends Fragment {

    public MonumentsFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get String Array Resources from the Strings File
        String[] monumentsNames = getResources().getStringArray(R.array.monuments_names);
        String[] monumentsAddresses = getResources().getStringArray(R.array.monuments_addresses);
        String[] monumentsDescriptions = getResources().getStringArray(R.array.monuments_descriptions);

        String[] monumentsPhones = getResources().getStringArray(R.array.monuments_phones);

        // Add Google Maps URIs
        String[] monumentsMapUris = {
                "https://www.google.com/maps/search/brandenburg+gate/@52.5154845,13.3780943,18z/data=!3m1!4b1?hl=ru",
                "https://www.google.com/maps/place/Колонна+Победы/@52.5145434,13.3479302,17z/data=!3m1!4b1!4m5!3m4!1s0x47a851af28d3f1c3:0x55627fdba380e5c9!8m2!3d52.5145621!4d13.350163?hl=ru",
                "https://www.google.com/maps/place/St+George+Slaying+The+Dragon/@52.5163225,13.4034262,17z/data=!3m1!4b1!4m5!3m4!1s0x47a84e20b1aee8e9:0x3a512bca3e740e56!8m2!3d52.5163225!4d13.4056149?hl=ru",
                "https://www.google.com/maps/place/Schillerbrunnen/@52.5136508,13.3904953,17z/data=!3m1!4b1!4m5!3m4!1s0x47a851da449443b3:0x385640d99504df8a!8m2!3d52.5136508!4d13.392684?hl=ru",
                "https://www.google.com/maps/place/Bismarck-Nationaldenkmal/@52.515895,13.3475615,17z/data=!3m1!4b1!4m5!3m4!1s0x47a851a8b3c14135:0xaead31004749aa3c!8m2!3d52.5158525!4d13.3497594?hl=ru"

        };

        // Add Images Resource IDs
        int[] monumentsImages = {
                R.drawable.brandenburg_gate,
                R.drawable.victory_column,
                R.drawable.dragon_statue,
                R.drawable.schiller_monument,
                R.drawable.nationaldenkmal,

        };

        // Initialize ArrayList of Landmarks
        final ArrayList<Landmark> monuments = new ArrayList<>();

        // Add All Landmarks to the ArrayList
        for (int i = 0; i < monumentsNames.length; i++) {
            monuments.add(new Landmark(
                    monumentsNames[i],
                    monumentsDescriptions[i],
                    monumentsAddresses[i],
                    Utils.addPrefix(monumentsPhones[i]),
                    monumentsMapUris[i],
                    monumentsImages[i]));
        }

        // Set Custom List View Adapter
        ListView listView = (ListView) rootView.findViewById(R.id.cat_items_list);
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), monuments);
        listView.setAdapter(adapter);

        // Set Click Listeners for Each Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get Landmark Object at Current Position
                Landmark monument = monuments.get(position);

                // Start Intent and Send Landmark Object to DetailActivity
                Utils.openDetailActivity(getContext(), monument);

            }
        });

        return rootView;
    }
}
