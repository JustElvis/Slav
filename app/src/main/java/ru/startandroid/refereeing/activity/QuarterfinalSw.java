package ru.startandroid.refereeing.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ru.startandroid.refereeing.MainActivity;
import ru.startandroid.refereeing.R;
import ru.startandroid.refereeing.couple.Couple;
import ru.startandroid.refereeing.couple.CouplesCreate;
import ru.startandroid.refereeing.couple.DBcouples;

/**
 * Created by Slav on 21.12.2016.
 */

public class QuarterfinalSw extends AppCompatActivity {
    Button btnEndDance;
    TextView judgeName, tvDanceName;
    final String JUDGENAME = "judgeName";
    GridView gl_event1, gl_event2;
    DBcouples dbcouples;
    Cursor cursor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarterfinaldance);

        dbcouples = new DBcouples(this);
        dbcouples.open();

        cursor = dbcouples.getAllData();

        tvDanceName = (TextView)findViewById(R.id.tvDanceName);
        tvDanceName.setText("Повільний вальс");

        judgeName = (TextView)findViewById(R.id.judgeName);
        final String text1 = getIntent().getExtras().getString(JUDGENAME);
        judgeName.setText(text1);

        gl_event1 = (GridView)findViewById(R.id.gl_event1);
        gl_event2 = (GridView)findViewById(R.id.gl_event2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, dbcouples.getFirstNumbers());
        gl_event1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, dbcouples.getSecondNumbers());
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundResource(R.drawable.rectdark);
                String checkNumber = String.valueOf(parent.getItemAtPosition(position));
                if (checkNumber.equals(String.valueOf())){

                Toast.makeText(QuarterfinalSw.this, checkNumber, Toast.LENGTH_LONG).show();}
            }
        });
    }

}
