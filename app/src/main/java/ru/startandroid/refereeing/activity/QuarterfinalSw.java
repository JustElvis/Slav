package ru.startandroid.refereeing.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ru.startandroid.refereeing.R;

/**
 * Created by Slav on 21.12.2016.
 */

public class QuarterfinalSw extends AppCompatActivity {
    TextView judgeName;
    final String JUDGENAME = "judgeName";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarterfinalsw);
        judgeName = (TextView)findViewById(R.id.judgeName);
        String text1 = getIntent().getExtras().getString(JUDGENAME);
        judgeName.setText(text1);
    }
}
