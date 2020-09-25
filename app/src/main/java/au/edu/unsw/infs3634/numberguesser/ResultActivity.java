package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Grab info from the Intent in Main
        Intent intent = getIntent();
        //Assign variable to number passes
        int numberUser = intent.getIntExtra(MainActivity.EXTRA_NUMBER_USER, 0);
        int numberRandom = intent.getIntExtra(MainActivity.EXTRA_NUMBER_RANDOM, 0);

        TextView myText = (TextView)findViewById(R.id.idResultText);
        if (numberUser == numberRandom) {
            String myString = String.valueOf("Congratulations! You guessed it right");
            myText.setText(myString);
        } else if (numberUser < numberRandom) {
            String myString = String.valueOf("Incorrect! Try guessing a little higher");
            myText.setText(myString);
        } else {
            String myString = String.valueOf("Incorrect! Try guessing a little lower");
            myText.setText(myString);
        }
        //Display random number in MainActivity
        /*
        TextView myText = (TextView)findViewById(R.id.idResultText);
        String myString = String.valueOf(numberUser);
        myText.setText(myString);
        */
    }
}