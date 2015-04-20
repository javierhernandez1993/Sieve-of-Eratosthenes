package com.example.javierh.sieveoferatosthenes;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    TextView output;
    EditText input;
    Button run;
    boolean check;
    boolean[] A;
    int maxPrime, squareRootofMax;
    StringBuilder outputText = new StringBuilder();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        output = (TextView) findViewById(R.id.textView3);
        input = (EditText) findViewById(R.id.editText);

        run = (Button) findViewById(R.id.button);

        if (input.getText().toString().matches("")) {
            run.setEnabled(false);
        }

        if (!input.getText().toString().matches("")) {
            run.setEnabled(true);
        }

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                outputText.delete(0, outputText.length());

                if (input.getText().toString().matches("")) {
                    check = false;
                } else {
                    check = true;
                }

                if (check == true) {
                    run.setEnabled(true);

                    maxPrime = Integer.parseInt(input.getText().toString());

                    squareRootofMax = (int) Math.sqrt(maxPrime);

                    //boolean array A: all values defaults to false
                    //boolean[] vs Boolean[] --> boolean is better since Boolean has a larger complexity
                    A = new boolean[maxPrime + 1];

                    for (int i = 2; i < squareRootofMax + 1; i++) {
                        if (A[i] == false) {

                            //using a while loop
                            //int j = i*2;
                            //while (j < maxPrime+1) {
                            //    A[j] = Boolean.FALSE;
                            //    j = j+i;
                            //}

                            //using a for loop
                            for (int j = i * 2; j < maxPrime + 1; j = j + i) {
                                A[j] = true;
                            }
                        }
                    }

                    for (int i = 2; i < A.length; i++) {
                        if (A[i] == false) {
                            outputText.append(i + " ");
                        }
                    }

                    output.setText(outputText.toString());
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
