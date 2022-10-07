package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Button num1;
    private TextView answerBox;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button decimal;
    private Button equals;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button clear;
    private Button delete;
    private String finalstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNames();
        Vector<Character> op = new Vector<Character>();
        Vector<Double> numbers = new Vector<Double>();
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"9");
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText(answerBox.getText().toString() +"0");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Strlength()<1){}
                else if (!Foradddivmult()) {
                    answerBox.setText(answerBox.getText().toString() + "/");
                } else {
                    Toast.makeText(MainActivity.this, "Can't Use Two operators together", Toast.LENGTH_SHORT).show();
                }
            }});
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Strlength()<1){}
                else if (!Foradddivmult()){
                    answerBox.setText(answerBox.getText().toString() +"*");}
                else{
                    Toast.makeText(MainActivity.this, "Can't Use Two operators together", Toast.LENGTH_SHORT).show();
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Strlength()<1){
                    answerBox.setText(answerBox.getText().toString() +"+");}
                else if (!Foradddivmult()){
                answerBox.setText(answerBox.getText().toString() +"+");}
                else{
                    Toast.makeText(MainActivity.this, "Can't Use Two operators together", Toast.LENGTH_SHORT).show();
                }
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Strlength()<1){
                    answerBox.setText(answerBox.getText().toString() +"-");}
                else if ((!Forsub())){
                answerBox.setText(answerBox.getText().toString() +"-");}
                else{
                    Toast.makeText(MainActivity.this, "Can't Use Two operators together", Toast.LENGTH_SHORT).show();
                }
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Lindex('.')<Lindex('+')||Lindex('.')<Lindex('-')||Lindex('.')<Lindex('*')||Lindex('.')<Lindex('/')||Lindex('.')==-1){
                answerBox.setText(answerBox.getText().toString() +".");}
                else{
                    Toast.makeText(MainActivity.this, "Can't Use Two decimals", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerBox.setText("");
            }

            private void buttonNames() {
                num1 = findViewById(R.id.button_1);
                answerBox = findViewById(R.id.textView);
                num2 = findViewById(R.id.button_2);
                num3 = findViewById(R.id.button_3);
                num4 = findViewById(R.id.button_4);
                num5 = findViewById(R.id.button_5);
                num6 = findViewById(R.id.button_6);
                num7 = findViewById(R.id.button_7);
                num8 = findViewById(R.id.button_8);
                num9 = findViewById(R.id.button_9);
                num0 = findViewById(R.id.button_0);
                decimal = findViewById(R.id.button_decimal);
                divide = findViewById(R.id.button_divide);
                equals = findViewById(R.id.button_equals);
                multiply = findViewById(R.id.button_multiply);
                subtract = findViewById(R.id.button_minus);
                clear = findViewById(R.id.button_clear);
                add = findViewById(R.id.button_plus);
                delete = findViewById(R.id.delete);
            }

            public boolean addentifier(int i) {
                return (finalstring.charAt(i) == '+' || finalstring.charAt(i) == '-' || finalstring.charAt(i) == '*' || finalstring.charAt(i) == '/' || Strlength() != 0);
            }

            public boolean dividentifier(int i) {
                return ((int) finalstring.charAt(i) == (int) '*' || (int) finalstring.charAt(i) == (int) '/' || Strlength() != 0);
            }

            public int Lindex(char symb) {
                return answerBox.getText().toString().lastIndexOf(symb);
            }

            public int Strlength() {
                return answerBox.getText().toString().length();
            }

            public char lastchar(int k) {
                return answerBox.getText().toString().charAt(Strlength() - k);
            }

            public boolean Foradddivmult() {
                return ((int) lastchar(1) == (int) '+' || (int) lastchar(1) == (int) '*' || (int) lastchar(1) == (int) '-' || (int) lastchar(1) == (int) '/' || Strlength() == 0);
            }

            public boolean Forsub() {
                return ((int) lastchar(1) == (int) '+' || (int) lastchar(1) == (int) '-') || Strlength() == 0;
            }

            public int rrcalc(char koo) {
                if (koo == '+' || koo == '-') return 0;
                else if (koo == '*') return 1;
                else if (koo == '/') return 2;
                else {
                    return -1;
                }
            }

            public String calculations(String foo) {
                int index = 0;
                int rr = 0;
                boolean subs = false;
                double storager = 0;
                double ter = 0;
                double answ = 0;
                for (int i = 0; i < foo.length(); i++) {
                    if (foo.charAt(i) == '-'&&i!=0) {
                        if (foo.charAt(i - 1) == '/' || foo.charAt(i - 1) == '*') {
                            continue;
                        }
                    }
                    if(i==0){
                        if(foo.charAt(i)=='-'||foo.charAt(i)=='+'){
                        continue;}
                    }
                    if (foo.charAt(i) == '+' || foo.charAt(i) == '-' || foo.charAt(i) == '*' || foo.charAt(i) == '/') {
                        storager = Double.parseDouble(foo.substring(index, i ));
                        index=i+1;
                        if (rr == 0) {
                            ter = storager;
                            rr = rrcalc(foo.charAt(i));
                        } else if (rr == 1) {
                            ter *= storager;
                            rr = rrcalc(foo.charAt(i));
                        } else if (rr == 2) {
                            ter /= storager;
                            rr = rrcalc(foo.charAt(i));
                        }
                        if (rr == 0) {
                            if (subs) {
                                answ -= ter;
                            } else {
                                answ += ter;
                            }
                        }
                    }
                    if(foo.charAt(i) == '-')
                    {
                        subs = true;
                    }
                    else if(foo.charAt(i)=='+'){
                        subs= false;
                    }
                }
                storager = Double.parseDouble(foo.substring(index));
                if (rr == 0) {
                    ter = storager;
                } else if (rr == 1) {
                    ter *= storager;
                } else if (rr == 2) {
                    ter /= storager;
                }
                if (subs) {
                    answ -= ter;
                } else {
                    answ += ter;
                }
                return (String.valueOf(answ));
            }
    }