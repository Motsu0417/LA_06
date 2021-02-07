package app.motsu.hiromoto.primequiz

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val QUESTION_COUNT : Int = 10
    }

    var random: Random = Random()
    var questions: IntArray = IntArray(QUESTION_COUNT)
    var point : Int = 0
    var answerCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until QUESTION_COUNT){
            val number =  random.nextInt(1000);
            Log.d("Number", "Question_" + i + ":" + number.toString())
            questions[i] = number;
        }
        point = 0
        answerCount = 0

        textView.text = questions[answerCount].toString()
        textView.setTextColor(Color.BLACK)
    }

    fun change(view: View?){
        answerCount++;
        textView.text = questions[answerCount].toString()
    }

    fun maru(view: View?){
        var answer = true
        val number = questions[answerCount]

        for (i in 2 until number/2 + 1){
            if (number % i == 0){
                answer = false
                break
            }
        }
        if(answer){
            Toast.makeText(this, "正解",Toast.LENGTH_SHORT).show()
            point++
            Log.d( "maru","正解:" + point.toString())
        }else{
            Toast.makeText(this, "不正解",Toast.LENGTH_SHORT).show()
            Log.d( "maru","不正解:" + point.toString())
        }
        answerCount++;
        if(answerCount == QUESTION_COUNT){
            textView.text = point.toString() + "点"
            textView.setTextColor(Color.RED)

            point = 0
            answerCount = 0
        }else{
            textView.text = questions[answerCount].toString()
            textView.setTextColor(Color.BLACK)
        }
    }

    fun batu(view: View?){
        var answer = true
        val number = questions[answerCount]

        for (i in 2 until number/2 + 1){
            if (number % i == 0){
                answer = false
                break
            }
        }
        if(!answer){
            Toast.makeText(this, "正解",Toast.LENGTH_SHORT).show()
            point++
            Log.d( "maru","正解:" + point.toString())
        }else{
            Toast.makeText(this, "不正解",Toast.LENGTH_SHORT).show()
            Log.d( "maru","不正解:" + point.toString())
        }
        answerCount++;
        if(answerCount == QUESTION_COUNT){
            textView.text = point.toString() + "点"
            textView.setTextColor(Color.RED)

            point = 0
            answerCount = 0
        }else{
            textView.text = questions[answerCount].toString()
            textView.setTextColor(Color.BLACK)
        }
    }
}