package co.com.k4soft.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoComplete;
    private String[] lenguages = {"C", "C#", "Java","Python","PHP","Swift"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        loadInfo();
        seletedListener();
    }

    private void seletedListener() {
        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),getLenguage(i),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getLenguage(int i) {
        return lenguages[i];
    }

    private void loadInfo() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,lenguages);
        autoComplete.setThreshold(1);
        autoComplete.setAdapter(arrayAdapter);
    }

    private void initComponents() {
        autoComplete = findViewById(R.id.autoComplete);
    }
}
