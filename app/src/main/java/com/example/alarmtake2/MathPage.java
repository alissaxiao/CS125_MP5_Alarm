package com.example.alarmtake2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.widget.Button;
import android.widget.TextView;

public class MathPage extends AppCompatActivity {
    Random random = new Random();
    private int number1 = random.nextInt(100);
    private int number2 = random.nextInt(100);
    TextView question;
    TextView input;
    TextView clear;
    TextView sign;
    TextView enter;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView four;
    TextView five;
    TextView six;
    TextView one;
    TextView two;
    TextView three;
    TextView zero;
    TextView decimal;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);

        question = findViewById(R.id.equation);
        input = findViewById(R.id.ret);
        zero = findViewById(R.id.zero);
        decimal = findViewById(R.id.decimal);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        clear = findViewById(R.id.clear);
        sign = findViewById(R.id.sign);
        enter = findViewById(R.id.enter);
    }
}
