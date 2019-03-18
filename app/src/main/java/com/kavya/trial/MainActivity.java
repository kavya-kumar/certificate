package com.kavya.trial;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText name3, peadd4;
    EditText fn4;
    EditText mn4,dob;
    Button button;
    String str, str1, str2,str4,strrg,strdob;
    RadioButton radioButton;
    RadioGroup radioGroup;
    ImageButton ibutton;
    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name3 = (EditText) findViewById(R.id.name4);
        button = (Button) findViewById(R.id.button);
        fn4 = findViewById(R.id.fn4);
        mn4 = findViewById(R.id.mn4);
        radioGroup = findViewById(R.id.rdgroup);
        peadd4 = findViewById(R.id.peadd4);
        ibutton=findViewById(R.id.ibutton);
        dob=findViewById(R.id.dob4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strdob=dob.getText().toString();
                str1 = fn4.getText().toString().toUpperCase();
                str2 = mn4.getText().toString().toUpperCase();
                str = name3.getText().toString().toUpperCase();
                str4=peadd4.getText().toString().toUpperCase();
                int radioid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);
                strrg = radioButton.getText().toString();
                Intent in = new Intent(MainActivity.this, IntentActivity.class);
                in.putExtra("dob",strdob);
                in.putExtra("peadd",str4);
                in.putExtra("name", str);
                in.putExtra("fname", str1);
                in.putExtra("mname", str2);
                in.putExtra("rname", strrg);
                startActivity(in);
            }
        });
        ibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int myear, int mmonth, int mday) {
                        dob.setText(mday + "-" + c.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH).toUpperCase() + "-" + myear);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
//        dob.addTextChangedListener(textWatcher);
//        fn4.addTextChangedListener(textWatcher);
//        mn4.addTextChangedListener(textWatcher);
//        name3.addTextChangedListener(textWatcher);
//        peadd4.addTextChangedListener(textWatcher);

    }
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                button.setEnabled(!str.isEmpty()&&!str1.isEmpty()&&!str4.isEmpty()&&!str2.isEmpty()&&!strrg.isEmpty()&&!strdob.isEmpty());
            Log.d("check","working");
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}
