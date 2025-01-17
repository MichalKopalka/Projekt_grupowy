package com.example.projekt_grupowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Collections;

public class DocumentExportPick extends AppCompatActivity {

    public static int documentPositionInUserDocumentsArrayList;

    Button BExport;
    Spinner spinner;
    AutoCompleteTextView ACTV;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_pick);

        BExport = (Button) findViewById(R.id.BExport);

        //spiner i ACTV robią to samo, wybrac jeden
        spinner = (Spinner) findViewById(R.id.spinner);
        ACTV = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        populateSpinner();


        BExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentExport.documentFormat = spinner.getSelectedItem().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                DocumentExport.exportTo = (String) radioButton.getText();

                DocumentExport.documentPositionInUserDocumentsArrayList = documentPositionInUserDocumentsArrayList;

                Intent intent = new Intent(getApplicationContext(), DocumentExport.class);
                startActivity(intent);
            }
        });
    }

    private void populateSpinner() {
        String [] formats = getResources().getStringArray(R.array.formats);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_actv_format, formats);
        ACTV.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.formats));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
    }
}