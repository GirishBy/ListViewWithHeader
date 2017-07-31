package com.mofosys.project.recyclerviewwithheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.test);

        Person john = new Person("John", "123 Fake Dr.");
        Person jane = new Person("Jane", "456 Unreal Ln.");
        Person james = new Person("James", "789 Notreal Circle");
        Person sally = new Person("Sally", "147 Seashell Place");
        Person mario = new Person("Mario", "135 Bayside Ct.");
        Person luigi = new Person("Luigi", "246 Bowser Castle");
        Person peach = new Person("Peach", "7911 Peach St.");
        Person toad = new Person("Toad", "81012 Blue Blvd");

        ArrayList<Object> people = new ArrayList<>();
        people.add("Real People");
        people.add(john);
        people.add(jane);
        people.add(james);
        people.add(sally);
        people.add("Fake People");
        people.add(mario);
        people.add(luigi);
        people.add(peach);
        people.add(toad);
        people.add("Real People");
        people.add(john);
        people.add(jane);
        people.add(james);
        people.add(sally);

        listView.setAdapter(new TestAdapter(this, people));

        //loadJSONFromAsset();

    }

    public void loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("sample.txt");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();

        }


        parseJson(json);

    }

    public void parseJson(String response) {

        try {

            Log.i("TEST", "res : " + response);
            JSONArray jsonArray = new JSONArray(response);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
