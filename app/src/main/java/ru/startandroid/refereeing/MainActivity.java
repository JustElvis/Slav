package ru.startandroid.refereeing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.startandroid.refereeing.activity.CategoryListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclick(View v){
        switch (v.getId()){
            case R.id.btnProgram:
                Intent intent = new Intent(this, CategoryListActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
