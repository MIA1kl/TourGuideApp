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
 * ParksFragment is the Class that displays the Parks Tab in the Categories Activity.
 */
public class ParksFragment extends Fragment {

    public ParksFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Get String Array Resources from the Strings File
        String[] parksNames = getResources().getStringArray(R.array.parks_names);
        String[] parksAddresses = getResources().getStringArray(R.array.parks_addresses);
        String[] parksDescriptions = getResources().getStringArray(R.array.parks_descriptions);

        String[] parksPhones = getResources().getStringArray(R.array.parks_phones);

        // Add Google Maps URIs
        String[] parksMapUris = {
                "https://www.google.com/maps/place/Шлоссгартен+Шарлоттенбург/@52.5170534,13.2600827,13z/data=!4m9!1m2!2m1!1sCharlottenburg+Palace+Gardens!3m5!1s0x47a8512e2a56082d:0x311cbd01e3aab5b8!8m2!3d52.5238664!4d13.2924939!15sCh1DaGFybG90dGVuYnVyZyBQYWxhY2UgR2FyZGVuc1ooCgdnYXJkZW5zIh1jaGFybG90dGVuYnVyZyBwYWxhY2UgZ2FyZGVuc5IBBmdhcmRlbpoBJENoZERTVWhOTUc5blMwVkpRMEZuU1VNMFoxQmhTakpSUlJBQg",
                "https://www.google.com/maps/place/Парк+Гёрлицер/@52.4966553,13.4327271,16z/data=!4m9!1m2!2m1!1sGörlitzer+Park!3m5!1s0x47a84f4c8819b367:0xedafc45032d4521b!8m2!3d52.4965928!4d13.4374489!15sCg9Hw7ZybGl0emVyIFBhcmtaIgoPZ8O2cmxpdHplciBwYXJrIg9nw7ZybGl0emVyIHBhcmuSAQRwYXJr",
                "https://www.google.com/maps/place/Парк+Люстгартен/@52.4560514,13.0798901,11z/data=!4m9!1m2!2m1!1sLustgarten!3m5!1s0x47a851de91fd1bd9:0xa5f5cb2eae434d0a!8m2!3d52.5187!4d13.3992!15sCgpMdXN0Z2FydGVuWhgKCmx1c3RnYXJ0ZW4iCmx1c3RnYXJ0ZW6SAQRwYXJr",
                "https://www.google.com/maps/place/Парк+Виктория/@52.4558859,13.0798897,11z/data=!4m9!1m2!2m1!1sViktoriapark!3m5!1s0x47a850243fdf52ef:0x82843cdc34c8fc10!8m2!3d52.4880375!4d13.3816235!15sCgxWaWt0b3JpYXBhcmtaHAoMdmlrdG9yaWFwYXJrIgx2aWt0b3JpYXBhcmuSAQpzdGF0ZV9wYXJrmgEkQ2hkRFNVaE5NRzluUzBWSlEwRm5TVU13ZW1aUU1YUjNSUkFC",
                "https://www.google.com/maps/place/Britzer+Garten/@52.4320821,13.4100319,17z/data=!4m9!1m2!2m1!1sBritzer+Garten!3m5!1s0x47a84574f5c58261:0x8135de25ff1c3372!8m2!3d52.4323861!4d13.4118391!15sCg5Ccml0emVyIEdhcnRlbloYCgZnYXJ0ZW4iDmJyaXR6ZXIgZ2FydGVukgEGZ2FyZGVu",
                "https://www.google.com/maps/place/Большой+Тиргартен/@52.5124043,13.3366072,14z/data=!4m9!1m2!2m1!1sTiergarten!3m5!1s0x47a851ae4addd1e1:0x83c392f1dcd0ab7a!8m2!3d52.5141516!4d13.3591634!15sCgpUaWVyZ2FydGVuWhgKCnRpZXJnYXJ0ZW4iCnRpZXJnYXJ0ZW6SAQRwYXJrmgEkQ2hkRFNVaE5NRzluUzBWSlEwRm5TVU5KZGs1SVFXbG5SUkFC",
                "https://www.google.com/maps/place/Гертен+дер+Вельт/@52.5345154,13.5712213,15z/data=!4m9!1m2!2m1!1sGardens+of+the+world+(Gärten+der+Welt)!3m5!1s0x47a84bc3b6cd0c3b:0x15bb7278a83882e6!8m2!3d52.5379611!4d13.5692782!15sCidHYXJkZW5zIG9mIHRoZSB3b3JsZCAoR8OkcnRlbiBkZXIgV2VsdClaTgolZ2FyZGVucyBvZiB0aGUgd29ybGQgZ8OkcnRlbiBkZXIgd2VsdCIlZ2FyZGVucyBvZiB0aGUgd29ybGQgZ8OkcnRlbiBkZXIgd2VsdJIBBHBhcmuaASNDaFpEU1VoTk1HOW5TMFZKUTBGblNVTkRPRTFET0U5UkVBRQ",

        };

        // Add Images Resource IDs
        int[] parksImages = {
                R.drawable.charlottenburg,
                R.drawable.gorlitzer_park,
                R.drawable.lusgarten,
                R.drawable.victoriapark,
                R.drawable.britzer_garten,
                R.drawable.tier_garten,
                R.drawable.world_garten,
        };

        // Initialize ArrayList of Landmarks
        final ArrayList<Landmark> parks = new ArrayList<>();

        // Add All Landmarks to the ArrayList
        for (int i = 0; i < parksNames.length; i++) {
            parks.add(new Landmark(
                    parksNames[i],
                    parksDescriptions[i],
                    parksAddresses[i],
                    Utils.addPrefix(parksPhones[i]),
                    parksMapUris[i],
                    parksImages[i]));
        }

        // Set Custom List View Adapter
        ListView listView = (ListView) rootView.findViewById(R.id.cat_items_list);
        LandmarkAdapter adapter = new LandmarkAdapter(getActivity(), parks);
        listView.setAdapter(adapter);

        // Set Click Listeners for Each Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get Landmark Object at Current Position
                Landmark park = parks.get(position);

                // Start Intent and Send Landmark Object to DetailActivity
                Utils.openDetailActivity(getContext(), park);

            }
        });

        return rootView;
    }
}
