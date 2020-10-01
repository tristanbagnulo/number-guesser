package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button guessAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Grab info from the Intent in Main
        Intent intent = getIntent();
        //Assign variable to number passes
        int numberUser = intent.getIntExtra(MainActivity.EXTRA_NUMBER_USER, 0);
        int numberRandom = intent.getIntExtra(MainActivity.EXTRA_NUMBER_RANDOM, 0);

        //Declare and allocate variable to "result of guess" text box
        TextView myText = (TextView)findViewById(R.id.idResultText);

        //Declare and allocate variable to "number of tries remaining" text box
        TextView guessesLeft = (TextView)findViewById(R.id.idGuessesRemaining);

        int guessNumber = numberOfGuesses();
        if (guessNumber <= 5) {
            if (numberUser == numberRandom) {
                String myString = String.valueOf("Congratulations! You guessed it RIGHT!");
                myText.setText(myString);
                //Set "number of tries remaining" text box text to nothing
                String guessesLeftString = String.valueOf("");
                guessesLeft.setText(guessesLeftString);
            } else if (numberUser < numberRandom) {
                String myString = String.valueOf("Incorrect! You guessed too LOW.");
                myText.setText(myString);
                //Get new number of tries and display it
                String guessesLeftString = String.valueOf("You have " + (5 - guessNumber) + " guesses remaining");
                guessesLeft.setText(guessesLeftString);
            } else {
                String myString = String.valueOf("Incorrect! You guesses too HIGH.");
                myText.setText(myString);
                //Get new number of tries and display it
                String guessesLeftString = String.valueOf("You have " + (5 - guessNumber) + " guesses remaining");
                guessesLeft.setText(guessesLeftString);
            }
        } else {
            //Launch the Termination screen
            launchTerminateActivity();
        }

    guessAgainButton = (Button) findViewById(R.id.idGuessAgainButton);
        guessAgainButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    private void launchTerminateActivity() {
    //Launch it with an intent
    Intent intent = new Intent(ResultActivity.this, TerminateActivity.class);
    startActivity(intent);
    }

    private static int numberOfGuesses = 0;

    //Increase number of guesses by 1
    public int numberOfGuesses() {
        //Declare the original number of tries to be 0
        numberOfGuesses++;
        return numberOfGuesses;
    }
}