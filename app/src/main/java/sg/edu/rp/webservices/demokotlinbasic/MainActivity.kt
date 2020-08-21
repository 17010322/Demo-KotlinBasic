package sg.edu.rp.webservices.demokotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetAge.setOnClickListener {
            val userDOB = etDOB.text.toString()
            if(userDOB.isNotEmpty()){
                val year = Calendar.getInstance().get(Calendar.YEAR)
                val age = year - userDOB.toInt()

                var category = ""
               /* if (age<18){
                    category = "Underage"
                } else if (age in 18 .. 65){
                    category = "Young People"
                } else if(age in 66 .. 79){
                    category = "Middle Aged"
                } else if(age in 80 .. 99){
                    category = "Elderly"
                } else{
                    category = "Long Lived Elderly"
                }*/

                when (age) {
                    in 0 .. 17 -> category = "Underage"
                    in 18 .. 65 -> category = "Young People"
                    in 66 .. 79 -> category = "Middle Aged"
                    in 80 .. 99 -> category = "Elderly"
                    else -> {
                        category = "Long-lived Elderly"
                    }

                }

                tvShowAge.text = "Your age is $age"
                tvShowCategory.text = "Your category is $category"
            }else{
                Toast.makeText(this,"Please enter your birth year",Toast.LENGTH_SHORT).show()
            }

        }
    }
}