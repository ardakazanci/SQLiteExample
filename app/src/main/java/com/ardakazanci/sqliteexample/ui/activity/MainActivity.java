package com.ardakazanci.sqliteexample.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ardakazanci.sqliteexample.R;
import com.ardakazanci.sqliteexample.model.Person;
import com.ardakazanci.sqliteexample.ui.adapter.PersonAdapter;
import com.ardakazanci.sqliteexample.ui.data.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtId, edtName, edtEmail;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lstPersons;

    List<Person> data = new ArrayList<>();
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        btnAdd = findViewById(R.id.button_add);
        btnUpdate = findViewById(R.id.button_update);
        btnRemove = findViewById(R.id.button_remove);

        lstPersons = findViewById(R.id.listview_datalist);

        edtId = findViewById(R.id.edittext_id);
        edtName = findViewById(R.id.edittext_name);
        edtEmail = findViewById(R.id.edittext_email);

        refreshData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()), edtName.getText().toString(), edtEmail.getText().toString());
                databaseHelper.addPerson(person);
                refreshData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(Integer.parseInt(edtId.getText().toString()), edtName.getText().toString(), edtEmail.getText().toString());
                databaseHelper.updatePerson(person);
                refreshData();
            }
        });


        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Person person = new Person(Integer.parseInt(edtId.getText().toString()), edtName.getText().toString(), edtEmail.getText().toString());
                databaseHelper.deletePerson(person);
                refreshData();
            }
        });

    }

    private void refreshData(){
        data = databaseHelper.getAllPerson();
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,data,edtName,edtId,edtEmail);
        lstPersons.setAdapter(adapter);
    }
}
