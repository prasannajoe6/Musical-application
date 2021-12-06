package com.example.a4t4wmlv4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import Database.DBHelper;

public class level04_int04 extends AppCompatActivity {

    private Button home;
    private int presCounter = 0;
    private int maxPresCounter = 4;
    private String[] keys = {"G", "D#", "A♭", "D", "E#" , "F#"};
    private String textAnswer = "A♭DGE#";
    TextView textScreen, textQuestion, textTitle , point;
    Animation smallbigforth;
    private int points = 0;
    CountDownTimer ctdown;
    MediaPlayer mp;
    String userName;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_level04_int04);
            userName = getIntent().getStringExtra("uName");

            final TextView time = (TextView) findViewById(R.id.time4);
             ctdown = new CountDownTimer(30000,1000) {
                @Override
                public void onTick(long l) {

                    TextView time = (TextView) findViewById(R.id.time4);

                    time.setText("Seconds remaining : " + DateUtils.formatElapsedTime(l/1000));
                }

                @Override
                public void onFinish() {
                    Intent a = new Intent(level04_int04.this,timesup.class);
                    a.putExtra("From_activity","4");
                    startActivity(a);

                }
            }.start();

        mp = new MediaPlayer();
        mp = MediaPlayer.create(this, R.raw.background);
        //player.setLooping(true);
        mp.start();

        Button home = findViewById(R.id.home4);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(level04_int04.this,level04Main.class);
                startActivity(x);
            }
        });


        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

            keys = shuffleArray(keys);

            for (String key : keys) {
                addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
            }

            maxPresCounter = 4;



        }


        private String[] shuffleArray(String[] ar) {
            Random rnd = new Random();
            for (int i = ar.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                String a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            return ar;
        }


        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        private void addView(LinearLayout viewParent, final String text, final EditText editText) {
            LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            linearLayoutParams.rightMargin = 20;

            final TextView textView = new TextView(this);

            textView.setLayoutParams(linearLayoutParams);
            textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
            textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
            textView.setGravity(Gravity.CENTER);
            textView.setText(text);
            textView.setClickable(true);
            textView.setFocusable(true);
            textView.setTextSize(28);

            Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

            // textQuestion = (ImageView) findViewById(R.id.staff2);
            textScreen = (TextView) findViewById(R.id.textScreen);
            textTitle = (TextView) findViewById(R.id.textTitle);

            // textQuestion.setTypeface(typeface);
            textScreen.setTypeface(typeface);
            textTitle.setTypeface(typeface);
            editText.setTypeface(typeface);
            textView.setTypeface(typeface);

            textView.setOnClickListener(new View.OnClickListener() {

                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    if(presCounter < maxPresCounter) {
                        if (presCounter == 0)
                            editText.setText("");

                        editText.setText(editText.getText().toString() + text);
                        textView.startAnimation(smallbigforth);
                        textView.animate().alpha(0).setDuration(300);
                        presCounter++;

                        if (presCounter == maxPresCounter)
                            doValidate();
                    }
                }
            });


            viewParent.addView(textView);


        }


        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        private void doValidate() {
            presCounter = 0;

            EditText editText = findViewById(R.id.editText);
            LinearLayout linearLayout = findViewById(R.id.layoutParent);

            if(editText.getText().toString().equals(textAnswer)) {
                points = 40;
                Intent intent = new Intent(level04_int04.this, CorrectAnswer01.class);
                intent.putExtra("From_activity","04");
                intent.putExtra("points", points);
                intent.putExtra("uName", userName);
                int result = db.insertRound4Score(points, userName);
                if(result > 0){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
                ctdown.cancel();
                mp.stop();
                editText.setText("");
            } else {
                Toast.makeText(level04_int04.this, "Wrong", Toast.LENGTH_SHORT).show();
                editText.setText("");
                Vibratee();
            }

            keys = shuffleArray(keys);
            linearLayout.removeAllViews();
            for (String key : keys) {
                addView(linearLayout, key, editText);
            }

        }
    private void Vibratee() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }
}


