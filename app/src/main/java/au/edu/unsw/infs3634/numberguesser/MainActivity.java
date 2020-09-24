package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Create a random number at the beginning
    //RN - final TextView textGenerateNumber = (TextView)findViewById(R.id.idRandomNumber);
    // Declaring the input number, EditText and Button.
    int number;
    EditText numberInput;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create and display the random number
        Random myRandom = new Random();
        final int randomNumber = myRandom.nextInt(100)+1;
        TextView myText = (TextView)findViewById(R.id.idRandomNumber);
        String myString = String.valueOf(randomNumber);
        myText.setText(myString);
            //TO DO - Find out what setText means.

        //Assign the EditText widget the user input to the variable "numberInput"
        numberInput = (EditText) findViewById(R.id.idNumberInput);
            // TO DO - Research "findViewByID" and how it works
            // TO DO Find out what this EditText class thing is

        //Assign Button widget to a the variable "submitButton".
        submitButton = (Button) findViewById(R.id.idSubmitButton);

        // Below we add an OnClickListener to allow us to react when the user clicks the
        // "Submit" button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.valueOf(numberInput.getText().toString());

                // Check whether number is equal, higher or lower...
                if (number == randomNumber){

                }

                //Toast to show input data
                showToast(String.valueOf(number));
                // RN - showToast(String.valueOf(myRandom));
            }

        });
            //TO DO - Find out what "onClick(View v)" does.
            //TO DO - Research "setOnClickListener", "new" and "View" (this required its own class).
    }


    private void showToast (String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

    }

}