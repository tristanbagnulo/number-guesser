package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button guessAgainButton;
    //declare instance variable
    private static int numberOfGuesses = 0;

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

        //Increase the guesses counter
        setNumberOfGuesses(numberOfGuesses);
        if (getNumberOfGuesses() <= 4) {
            if (numberUser == numberRandom) {
                launchSuccessActivity();
                setNumberOfGuesses(-1);
                finish();
            } else if (numberUser < numberRandom) {
                String myString = String.valueOf("Incorrect! You guessed too LOW.");
                myText.setText(myString);
                //Get new number of tries and display it
                String guessesLeftString = String.valueOf("You have " + (5 - getNumberOfGuesses()) + " guesses remaining");
                guessesLeft.setText(guessesLeftString);
            } else {
                String myString = String.valueOf("Incorrect! You guesses too HIGH.");
                myText.setText(myString);
                //Get new number of tries and display it
                String guessesLeftString = String.valueOf("You have " + (5 - getNumberOfGuesses()) + " guesses remaining");
                guessesLeft.setText(guessesLeftString);
            }
        } else {
            //Launch the Termination screen
            launchTerminateActivity();
            setNumberOfGuesses(-1);
            finish();
        }

    guessAgainButton = (Button) findViewById(R.id.idGuessAgainButton);
        guessAgainButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                /*
                Intent intent = new Intent(ResultActivity.this, TerminateActivity.class);
                startActivity(intent);
                */
                finish();
            }
        });
    }

    //Launches the activity suitable for reaching maximum guesses
    private void launchTerminateActivity() {
    //Launch it with an intent
    Intent intent = new Intent(ResultActivity.this, TerminateActivity.class);
    startActivity(intent);
    }

    //Launches the activity suitable for the user guessing correctly
    private void launchSuccessActivity() {
        //Launch it with an intent
        Intent intent = new Intent(ResultActivity.this, SuccessActivity.class);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    //Increase number of guesses by 1
    public void setNumberOfGuesses(int numberOfGuesses){
        this.numberOfGuesses = numberOfGuesses + 1;
    }
    //Make the number of guesses available
    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }
}