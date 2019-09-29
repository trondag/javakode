package no.hiof.trondg.huskvasken;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Meny extends AppCompatActivity {

    TextView nyRutineTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Slidr.attach(this);
        // ENKEL SLIDER
        overridePendingTransition(R.xml.slide_in, R.xml.slide_out);
        setContentView(R.layout.activity_meny);

        nyRutineTextView = (TextView)findViewById(R.id.NyRutine);

        nyRutineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Meny.this, NyRutine.class));
            }
        });
    }


}
