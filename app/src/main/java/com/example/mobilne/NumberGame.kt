package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.sql.Types.NULL
import kotlin.random.Random

class NumberGame : AppCompatActivity() {
    private var count = 0
    private var number = 0
    private lateinit var firebase: DatabaseReference
    private lateinit var database : NumberDatabase
    private lateinit var newMove : NumberEnt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_game)

        number = Random.nextInt(101);
        count=0;
        firebase = Firebase.database.reference


        var a1 : String
        firebase.child("numberCount").get().addOnSuccessListener{
            a1 = "${it.value}"
            //a1= it.value as String
            //findViewById<TextView>(com.google.firebase.database.R.id.textViewZ).text = (a1.toInt()+1).toString()
            //increaseNOP(a1.toInt())
            //postPost(findViewById<TextView>(com.google.firebase.database.R.id.inputText).text.toString(),a1.toInt())
            //findViewById<TextView>(com.google.firebase.database.R.id.inputText).text = ""
            a1 = (a1.toInt() + 1).toString()

            firebase.child("numberCount").setValue(a1.toString())

        }.addOnFailureListener{
            Log.e("klawiatur", "Error getting data", it)
        }

        GlobalScope.launch {
            try {
                database = Room.databaseBuilder(
                    applicationContext,
                    NumberDatabase::class.java,
                    "NumberTable.db"
                ).build()
            }catch (e: Exception){
                Log.d("am2021","base")
                finish()
            }
            database.NumberDAO().delete()
            database.NumberDAO().insertAll(NumberEnt(NULL,number))



        }


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


            GlobalScope.launch {
                try {
                    database = Room.databaseBuilder(
                        applicationContext,
                        NumberDatabase::class.java,
                        "NumberTable.db"
                    ).build()
                }catch (e: Exception){
                    Log.d("am2021","base")
                    finish()
                }
                database.NumberDAO().insertAll(NumberEnt(NULL,gs))
            }

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
                textViewInfo.text = "Congratulations!\nYou guessed after " + count +  " attempts.\nYou can continue the game\n with a new random number."
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