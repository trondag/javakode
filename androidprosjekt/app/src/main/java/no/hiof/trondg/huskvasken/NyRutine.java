package no.hiof.trondg.huskvasken;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import no.hiof.trondg.huskvasken.model.Forbruksvare;

public class NyRutine extends AppCompatActivity {
    
    private Context context = this;
    private EditText endreIntervall;
    private int bytteFrekvens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ny_rutine);

        //GSON-klassen instansieres
        Gson gson = new Gson();

        try {

            //Leser filen
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.forbruksvarer)));

            //Konverterer JSON til Java-objekter
            Type listeType = new TypeToken<ArrayList<Forbruksvare>>(){}.getType();
            final List<Forbruksvare> forbruksvarer = new Gson().fromJson(reader, listeType);

            //Lager peker til spinner
            Spinner spinner = findViewById(R.id.rutineSpinner);

            //Legger arraylisten inn i spinner
            ArrayAdapter<Forbruksvare> adapter = new ArrayAdapter<>(
                    context,
                    android.R.layout.simple_spinner_dropdown_item,
                    forbruksvarer);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);

            // Lytter etter valgt element i spinner
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    final TextView anbIntervallTextView = (TextView) findViewById(R.id.bytteIntervall);
                    bytteFrekvens = forbruksvarer.get(adapterView.getSelectedItemPosition()).getBytteFrekvens();

                    //Setter teksten til å vise bytte-intervallet
                    if (bytteFrekvens <= 1){
                        anbIntervallTextView.setText("Anbefales å bytte daglig.");
                    } else {
                        anbIntervallTextView.setText("Anbefalt bytte-intervall: " + bytteFrekvens + " dager.");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            //Hvis man vil endre intervall

            endreIntervall = findViewById(R.id.endreIntervall);

            endreIntervall.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    endreIntervall.append(""+ bytteFrekvens);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    // Klasse for å lage en datepicker
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }
}
