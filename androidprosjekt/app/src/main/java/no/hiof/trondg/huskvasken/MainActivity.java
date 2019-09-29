package no.hiof.trondg.huskvasken;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import no.hiof.trondg.huskvasken.model.Forbruksvare;

public class MainActivity extends AppCompatActivity {

    ScrollView aktivitetsListe;
    ImageButton menyKnapp;
    ScrollView meny;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listen med aktiviteter som skal gjøres
        aktivitetsListe = (ScrollView)findViewById(R.id.aktivitetsListe);

        //Knapp for meny
        menyKnapp = (ImageButton)findViewById(R.id.imageButton2);

        //Hent meny-activity hvis man trykker på knappen
        menyKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("knapp trykket" + this);
                startActivity(new Intent(MainActivity.this, Meny.class));
            }
        });
        System.out.println(this);
    }

    private Forbruksvare forbruksvare = new Forbruksvare("Tannbørste", 14);
}
