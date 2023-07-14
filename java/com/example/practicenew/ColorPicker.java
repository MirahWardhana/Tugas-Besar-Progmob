package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Locale;

public class ColorPicker extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    public static int color_red, color_green, color_blue, color_alfa;
    View v_Color;
    TextView tCode, tValue;
    TextView input_red, input_green, input_blue, input_alfa;
    SeekBar sRed, sGreen, sBlue, sAlfa;
    int red = 0, green = 0, blue = 0, alfa = 255;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        v_Color = findViewById(R.id.view);
        tCode = findViewById(R.id.textRGBA2);
        tValue = findViewById(R.id.textHexValue2);

        input_red = findViewById(R.id.textRed);
        input_green = findViewById(R.id.textGreen);
        input_blue = findViewById(R.id.textBlue);
        input_alfa = findViewById(R.id.textAlfa);

        sAlfa = findViewById(R.id.sbAlfa);
        sRed = findViewById(R.id.sbRed);
        sGreen = findViewById(R.id.sbGreen);
        sBlue = findViewById(R.id.sbBlue);

        button = findViewById(R.id.buttonOkay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFinal();
                v_Color.setBackgroundColor(Color.rgb(color_red, color_green, color_blue));
            }
        });

        sAlfa.setOnSeekBarChangeListener(this);
        sRed.setOnSeekBarChangeListener(this);
        sGreen.setOnSeekBarChangeListener(this);
        sBlue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.sbRed:
                red = i;
                color_red = red;
                break;
            case R.id.sbGreen:
                green = i;
                color_green = green;
                break;
            case R.id.sbBlue:
                blue = i;
                color_blue = blue;
                break;
            case R.id.sbAlfa:
                alfa = i;
                color_alfa = alfa;
                break;
        }
        v_Color.setBackgroundColor(Color.rgb(color_red, color_green, color_blue));
        String code = HexCode(color_alfa, color_red, color_green, color_blue);
        tValue.setText(String.format(Locale.US, "(%d,%d,%d,%d)", color_alfa, color_red, color_green, color_blue));
        tCode.setText(code.toUpperCase());
        input_alfa.setText(String.valueOf(color_alfa));
        input_red.setText(String.valueOf(color_red));
        input_green.setText(String.valueOf(color_green));
        input_blue.setText(String.valueOf(color_blue));
    }

    private String HexCode(int alfa, int red, int green, int blue) {
        return String.format("#%02X%02X%02X%02X", alfa, red, green, blue);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Empty implementation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Empty implementation
    }

    public void openFinal() {
        Intent intent = new Intent(this, Final.class);
        startActivity(intent);
    }
}
