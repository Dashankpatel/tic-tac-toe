package com.example.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        setbtn(binding.one);
        setbtn(binding.two);
        setbtn(binding.three);
        setbtn(binding.four);
        setbtn(binding.five);
        setbtn(binding.six);
        setbtn(binding.seven);
        setbtn(binding.eight);
        setbtn(binding.nine);

        binding.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.one.setText("");
                binding.two.setText("");
                binding.three.setText("");
                binding.four.setText("");
                binding.five.setText("");
                binding.six.setText("");
                binding.seven.setText("");
                binding.eight.setText("");
                binding.nine.setText("");
                binding.txt.setText("");
            }
        });

    }

    int i = 1;

    private void setbtn(Button btn) {


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.txt.getText().toString().isEmpty() && btn.getText().toString().isEmpty()) {

//                    if (i == 1) {
//                        btn.setText("X");
//                        i = 0;
//                    } else {
//                        btn.setText("0");
//                        i = 1;
//                    }

                    btn.setText("0");

                    win(binding.one, binding.two, binding.three);
                    win(binding.four, binding.five, binding.six);
                    win(binding.seven, binding.eight, binding.nine);
                    win(binding.one, binding.four, binding.seven);
                    win(binding.two, binding.five, binding.eight);
                    win(binding.three, binding.six, binding.nine);
                    win(binding.one, binding.five, binding.nine);
                    win(binding.three, binding.five, binding.seven);

                    if (binding.txt.getText().toString().isEmpty()) {
                        checkdraw();
                    }

                    if ( binding.txt.getText().toString().isEmpty()) {
                        robotTurn();
                    }

                }
            }
        });
    }

    private void checkdraw() {

        if (!binding.one.getText().toString().isEmpty()&&
                !binding.two.getText().toString().isEmpty()&&
                !binding.three.getText().toString().isEmpty()&&
                !binding.four.getText().toString().isEmpty()&&
                !binding.five.getText().toString().isEmpty()&&
                !binding.six.getText().toString().isEmpty()&&
                !binding.seven.getText().toString().isEmpty()&&
                !binding.eight.getText().toString().isEmpty()&&
                !binding.nine.getText().toString().isEmpty())
        {
            binding.txt.setText("Match Draw");
        }

    }


    void win(Button first, Button second, Button third) {
        if (first.getText().toString().equals("X") && second.getText().toString().equals("X") && third.getText().toString().equals("X")) {
            binding.txt.setText("X is Win");
        } else if (first.getText().toString().equals("0") && second.getText().toString().equals("0") && third.getText().toString().equals("0")) {
            binding.txt.setText("0 is Win");
        }
    }

    private void robotTurn() {
        Random ran = new Random();
        while (true) {
            int number = ran.nextInt(9);
            Log.d("---------", "robotTurn:  ===> " + number);
            if (binding.txt.getText().toString().isEmpty()) {
                if (number == 0) {
                    if (binding.one.getText().toString().isEmpty()) {
                        binding.one.setText("X");
                        break;
                    }
                } else if (number == 1) {
                    if (binding.two.getText().toString().isEmpty()) {
                        binding.two.setText("X");
                        break;
                    }
                } else if (number == 2) {
                    if (binding.three.getText().toString().isEmpty()) {
                        binding.three.setText("X");
                        break;
                    }
                } else if (number == 3) {
                    if (binding.four.getText().toString().isEmpty()) {
                        binding.four.setText("X");
                        break;
                    }
                } else if (number == 4) {
                    if (binding.five.getText().toString().isEmpty()) {
                        binding.five.setText("X");
                        break;
                    }
                } else if (number == 5) {
                    if (binding.six.getText().toString().isEmpty()) {
                        binding.six.setText("X");
                        break;
                    }
                } else if (number == 6) {
                    if (binding.seven.getText().toString().isEmpty()) {
                        binding.seven.setText("X");
                        break;
                    }
                } else if (number == 7) {
                    if (binding.eight.getText().toString().isEmpty()) {
                        binding.eight.setText("X");
                        break;
                    }
                } else if (number == 8) {
                    if (binding.nine.getText().toString().isEmpty()) {
                        binding.nine.setText("X");
                        break;
                    }
                }
            }
        }
        win(binding.one, binding.two, binding.three);
        win(binding.four, binding.five, binding.six);
        win(binding.seven, binding.eight, binding.nine);
        win(binding.one, binding.four, binding.seven);
        win(binding.two, binding.five, binding.eight);
        win(binding.three, binding.six, binding.nine);
        win(binding.one, binding.five, binding.nine);
        win(binding.three, binding.five, binding.seven);
    }

}