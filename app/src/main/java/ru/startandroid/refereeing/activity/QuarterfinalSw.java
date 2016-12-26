package ru.startandroid.refereeing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.startandroid.refereeing.R;
import ru.startandroid.refereeing.couple.Couple;
import ru.startandroid.refereeing.couple.CouplesCreate;

/**
 * Created by Slav on 21.12.2016.
 */

public class QuarterfinalSw extends AppCompatActivity {
    Button btnEndDance;
    TextView judgeName, tvDanceName;
    final String JUDGENAME = "judgeName";
    String[] couples1 = {"1", "2","3" ,"4" ,"5" ,"6" ,"7", "8", "9", "10", "11", "12"};
    String[] couples2 = {"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    GridView gl_event1, gl_event2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarterfinaldance);

        tvDanceName = (TextView)findViewById(R.id.tvDanceName);
        tvDanceName.setText("Повільний вальс");

        judgeName = (TextView)findViewById(R.id.judgeName);
        final String text1 = getIntent().getExtras().getString(JUDGENAME);
        judgeName.setText(text1);

        gl_event1 = (GridView)findViewById(R.id.gl_event1);
        gl_event2 = (GridView)findViewById(R.id.gl_event2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, couples1);
        gl_event1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, couples2);
        gl_event2.setAdapter(adapter2);
        adjustGridView(gl_event1);
        adjustGridView(gl_event2);

        btnEndDance = (Button)findViewById(R.id.btnEndDance);
        btnEndDance.setText("Наступний танець");
        final Intent intent = new Intent(this, QuarterfinalTg.class);
        btnEndDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(JUDGENAME, text1);
                startActivity(intent);
            }
        });
    }
    private void adjustGridView(GridView gridView) {
        gridView.setNumColumns(6);
        gridView.setColumnWidth(80);
        gridView.setVerticalSpacing(5);
        gridView.setHorizontalSpacing(5);
    }
    public void onclick (View view){
        view.setBackgroundResource(R.drawable.rectdark);
    }
}
