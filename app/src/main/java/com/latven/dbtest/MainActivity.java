package com.latven.dbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new MyDBHandler(this, null, null, 1);
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        // dbHandler.add needs an object parameter.
        //Coins coin = new Coins("Test name");
        //dbHandler.addCoin(coin);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        //recordsTextView.setText(dbString);
        //userInput.setText("");
        Toast.makeText(this, dbString, Toast.LENGTH_SHORT).show();
    }
}
