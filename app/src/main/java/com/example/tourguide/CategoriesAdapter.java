package com.example.tourguide;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * The CategoriesAdapter Class creates the Tabs for the ViewPager in the Categories Activity.
 */
public class CategoriesAdapter extends FragmentPagerAdapter {

    // Set the number of pages and initiate the Tab Titles Array
    private final int PAGE_COUNT = 3;
    private String[] tabTitles = new String[PAGE_COUNT];

    /**
     * The CategoriesAdapter Constructor. Takes 2 parameters.
     * @param fragmentManager The FragmentManager.
     * @param context The Context.
     */
    public CategoriesAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);

        // Set Tab Titles
        tabTitles[0] = context.getString(R.string.cat_monuments);
        tabTitles[1] = context.getString(R.string.cat_parks);
        tabTitles[2] = context.getString(R.string.cat_hotels);
    }

    /** @return Returns the number of pages. */
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /** @return Returns the Fragment associated with specific page. */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MonumentsFragment();
            case 1:
                return new ParksFragment();
            case 2:
                return new HotelsFragment();
        }
        return null;
    }

    /** @return Returns the Tab Title at certain position. */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
