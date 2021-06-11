package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class NumberGame : AppCompatActivity() {
    private var count = 0
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_game)

        number = Random.nextInt(101);
        count=0;
    }


    fun buttonClicked(view: View) {
        //TextView nb = (TextView)findViewById(R.id.textInput);
        //TextView communicate = (TextView)findViewById(R.id.infoText);
        //TextView cnt = (TextView)findViewById(R.id.cntText);

        try {

            var textViewInput = findViewById<TextView>(R.id.textInput)
            var textViewCounter = findViewById<TextView>(R.id.textInput)
            var textViewInfo = findViewById<TextView>(R.id.cntText)


            var gs = Integer.parseInt(textViewInput.text.toString());

            if(gs != number){
                count++;
                textViewCounter.text = "Counter: " + count
                if(gs>number){
                    textViewInfo.text =  "LESS THAN " + gs
                }
                else {
                    textViewInfo.text = "MORE THAN " + gs
                }
            }
            else{
                count++;
                //Toast.makeText(this, "Congratulation, you guessed after " + count +  " tries!\nYou can continue game with new random number", Toast.LENGTH_SHORT).show();
                //communicate.setText("Congratulation!\nYou guessed after " + count +  " tries.\nYou can continue game\n with new random number.");
                textViewInfo.text = "Congratulation!\nYou guessed after " + count +  " tries.\nYou can continue game\n with new random number."
                number = Random.nextInt(101);
                count = 0;
                //cnt.setText("Counter: " + Integer.toString(count));
                textViewCounter.text = "Counter: " + count
                Toast.makeText(this,"!!!", Toast.LENGTH_SHORT).show();
            }
            textViewInput.text = null
            //nb.setText("");
        }catch (e: Exception){
            //communicate.setText("INVALID INPUT");
            Toast.makeText(this,"INVALID INPUT", Toast.LENGTH_SHORT).show()
        }
    }


    fun resetClicked(view: View) {
        var textViewCounter = findViewById<TextView>(R.id.textInput)
        var textViewInfo = findViewById<TextView>(R.id.cntText)
        textViewInfo.text = "Game has been reset"
        count = 0;
        textViewCounter.text = "Counter: " + count
        number = Random.nextInt(101);
        Toast.makeText(this,"Reset", Toast.LENGTH_SHORT).show();
    }

}