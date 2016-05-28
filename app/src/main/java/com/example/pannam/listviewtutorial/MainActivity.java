package com.example.pannam.listviewtutorial;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2"};
        final ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,
                values);
//        assert listView != null;
//        listView.setAdapter(adapter);

      //  MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);

      //performance list view with view holder

     //   MyPerformanceArrayAdapter adapter = new MyPerformanceArrayAdapter(this, values);


        assert listView != null;
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, item + " selected", Toast.LENGTH_LONG).show();

            }
        });


    }
}
