package com.college.quiz1_question;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.college.quiz1_question.util.MyFileReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*

 This application decodes a JSON file
 and displays the results on a textview.

 The application reads a restaurants JSON file
 and builds a list of restaurants.

 We then display the list of the names of the restaurants
 in the TextView.

 A button is available to clear the TextView and do it again.

 The TODOs below provide step by step instructions
 to complete the implementation.


 Challenge 1:
 Convert the TextView into a ListView and display
 the result accordingly.


 Challenge 2:
 Convert the clear button into a menu item on the Options Menu.
 You can implement it as an Action item with an icon

*/

public class MainActivity extends AppCompatActivity {

    static private final String TAG = "MainActivity";

    // Declare a List of restaurants
    ArrayList<Restaurant> listOfRestaurants;

    // TextView where we display the result on the screen
    private TextView descriptionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view
        descriptionTv = findViewById(R.id.description);

        // When we click on btn_read_json, we call the readData
        // and decode the results
        Button btnJson = findViewById(R.id.btn_read_json);

        // When the button is presssed, call readData
        // With the results, populate the textview
        // Put on the TextView the names of the restaurants.
        btnJson.setOnClickListener(v -> {
            // Read the file
            listOfRestaurants = readData( "restaurants.json");

            // TODO (1): Extract the restaurants names
            // You can use StringBuilder to build the
            // desired result string:
            //      StringBuilder sb = new StringBuilder();
            // Add an item to a StringBuilder:
            //      sb.append(resto.getName());
            // Extract the string:
            //      sb.toString()

            // TODO (2): Display the result on the TextView

        });
    }

    //TODO (6): Clear the output textview
    public void clear(View v) {

    }

    // Deserialize a list of states from a file in JSON format
    public ArrayList<Restaurant> readData(String fileName){

        final ArrayList<Restaurant> mylist = new ArrayList<>();

        try {
            // load the data in an ArrayList
            String jsonString     = MyFileReader.readJson(this, fileName);
            JSONObject json       = new JSONObject(jsonString);
            JSONArray items = json.getJSONArray("restaurants");

            // Loop through the list in the json array
            for (int i = 0; i < items.length(); i++){

                //TODO (3): Extract the name and description

                //TODO (4) : create a Restaurant object

                //TODO (5): Add the restaurant object to the lisat

            }
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
        }
        return mylist;
    }
}