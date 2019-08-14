package com.ardakazanci.sqliteexample.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.ardakazanci.sqliteexample.R;
import com.ardakazanci.sqliteexample.model.Person;

import java.util.List;

public class PersonAdapter extends BaseAdapter {


    Activity context;
    List<Person> listPerson;
    LayoutInflater layoutInflater;
    EditText edtName, edtId, edtEmail;

    public PersonAdapter(Activity context, List<Person> listPerson, EditText edtName, EditText edtId, EditText edtEmail) {
        this.context = context;
        this.listPerson = listPerson;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.edtName = edtName;
        this.edtId = edtId;
        this.edtEmail = edtEmail;
    }


    @Override
    public int getCount() {
        return listPerson.size();
    }

    @Override
    public Object getItem(int position) {
        return listPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listPerson.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Custom List tasarımında yer alan view elemanlarını final olarak tanımladık.

        View rowView;
        rowView = layoutInflater.inflate(R.layout.list_item, null);
        final TextView txtRowId, txtRowName, txtRowEmail;

        txtRowId = rowView.findViewById(R.id.textview_row_id);
        txtRowName = rowView.findViewById(R.id.textview_row_name);
        txtRowEmail = rowView.findViewById(R.id.textview_row_email);

        txtRowId.setText("" + listPerson.get(position).getId());
        txtRowName.setText("" + listPerson.get(position).getName());
        txtRowEmail.setText("" + listPerson.get(position).getEmail());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtId.setText("" + txtRowId.getText());
                edtEmail.setText("" + txtRowEmail.getText());
                edtName.setText("" + txtRowName.getText());
            }
        });


        return rowView;
    }
}
