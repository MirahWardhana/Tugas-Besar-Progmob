package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.SeekBar;

import java.util.Locale;

public class ColorPicker extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    public static int color_red, color_green,color_blue, color_alfa;
    View v_Color;
    TextView tCode, tValue;
    TextView input_red, input_green, input_blue, input_alfa;
    SeekBar sRed,sGreen,sBlue,sAlfa;
    int red=0, green=0, blue=0, alfa=255;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        v_Color=findViewById(R.id.view);
        tCode=findViewById(R.id.textRGBA2);
        tValue=findViewById(R.id.textHexValue2);

        input_red=findViewById(R.id.textRed);
        input_green=findViewById(R.id.textGreen);
        input_blue=findViewById(R.id.textBlue);

        sAlfa=findViewById(R.id.sbAlfa);
        sRed=findViewById(R.id.sbRed);
        sGreen=findViewById(R.id.sbGreen);
        sBlue=findViewById(R.id.sbBlue);

        button=findViewById(R.id.buttonOkay);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openFinal();
                red=Integer.parseInt(input_red.getText().toString());
                green=Integer.parseInt(input_green.getText().toString());
                blue=Integer.parseInt(input_blue.getText().toString());

                v_Color.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });
        sAlfa.setOnSeekBarChangeListener(this);
        sRed.setOnSeekBarChangeListener(this);
        sGreen.setOnSeekBarChangeListener(this);
        sBlue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.sbRed:
                red=i;
                color_red=red;
                break;
            case R.id.sbGreen:
                green=i;
                color_green=green;
                break;
            case R.id.sbBlue:
                blue=i;
                color_blue=blue;
                break;
            case R.id.sbAlfa:
                alfa=i;
                color_alfa=alfa;
                break;
        }
        v_Color.setBackgroundColor((Color.argb(alfa,red,green,blue)));
        String code= HexCode(alfa,red,green,blue);
        tValue.setText(String.format("(%d,%d,%d,%d)",alfa,red,green,blue));
        tCode.setText(code.toUpperCase());
    }

    private String HexCode(int alfa, int red, int green, int blue) {
        String code;
        code="#";
        code+=Integer.toHexString(alfa);
        code+=Integer.toHexString(red);
        code+=Integer.toHexString(green);
        code+=Integer.toHexString(blue);
        return code;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    public void openFinal(){
        Intent intent = new Intent(this,Final.class);
        startActivity(intent);
    }

}