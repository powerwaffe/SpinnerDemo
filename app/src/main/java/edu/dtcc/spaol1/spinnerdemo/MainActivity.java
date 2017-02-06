package edu.dtcc.spaol1.spinnerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create spinner object
        Spinner spinner = (Spinner) findViewById(R.id.fruitSpinner);

        // Create array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fruitArray, android.R.layout.simple_spinner_item);

        // Set spinner items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Create onItemSelected listener
        AdapterView.OnItemSelectedListener listener = new myOnItemSelectedListener();
        spinner.setOnItemSelectedListener(listener);
    }

    public class myOnItemSelectedListener implements AdapterView.OnItemSelectedListener
    {
        // Create textView object
        TextView textView = (TextView) findViewById(R.id.displaySelection);

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id)
        {
            // On selecting a spinner item
            String item = parent.getItemAtPosition(pos).toString();

            // Showing selected spinner item as a toast
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            // Show item selected in textView
            textView.setText(item);
        }

        public void onNothingSelected(AdapterView<?> parent)
        {
            // Another interface callback
        }
    }
}
