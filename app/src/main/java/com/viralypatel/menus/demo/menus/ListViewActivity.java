package com.viralypatel.menus.demo.menus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    ArrayList<String> planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.mainListView );

        // Create and populate a List of planet names.
        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_simplerow, planetList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );



    }

    // delete selected items from list view
    private void deleteSelectedItems() {
        /** Getting the checked items from the listview */
        SparseBooleanArray checkedItemPositions = mainListView.getCheckedItemPositions();
        int itemCount = mainListView.getCount();

        for (int i = itemCount - 1; i >= 0; i--) {
            if (checkedItemPositions.get(i)) {
                listAdapter.remove(planetList.get(i));
            }
        }
        checkedItemPositions.clear();
        listAdapter.notifyDataSetChanged();
    }

}
