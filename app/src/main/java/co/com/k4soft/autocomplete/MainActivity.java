package co.com.k4soft.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoComplete;
    private Spinner spinnerDiasSemana;
    private String[] lenguages = {"C", "C#", "Java","Python","PHP","Swift"};

    private String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes","Sábado","Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        loadInfoAutomComplete();
        loadInfoSpinner();
        seletedAutocompleteListener();
        selectedSpinnerItem();
    }

    private void selectedSpinnerItem() {
        spinnerDiasSemana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),getDia(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private String getDia(int i) {
        return dias[i];
    }

    private void loadInfoSpinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,dias);
        spinnerDiasSemana.setAdapter(arrayAdapter);
    }

    private void seletedAutocompleteListener() {
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

    private void loadInfoAutomComplete() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,lenguages);
        autoComplete.setThreshold(1);
        autoComplete.setAdapter(arrayAdapter);
    }

    private void initComponents() {
        autoComplete = findViewById(R.id.autoComplete);
        spinnerDiasSemana = findViewById(R.id.spinnerDiasSemana);
    }
}
