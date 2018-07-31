package sg.edu.rp.c346.reservationenhanced;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView Vname;
    EditText Ename;
    TextView Vnumber;
    EditText Enumber;
    TextView Vsize;
    EditText Esize;
    CheckBox CBsmoke;
    TextView Vday;
    EditText Eday;
    TextView Vtime;
    EditText Etime;
    Button RSV;
    Button RST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vname = findViewById(R.id.textViewName);
        Ename = findViewById(R.id.editTextName);
        Vnumber = findViewById(R.id.textViewNo);
        Enumber = findViewById(R.id.editTextNo);
        Vsize = findViewById(R.id.textViewSize);
        Esize = findViewById(R.id.editTextSize);
        CBsmoke = findViewById(R.id.checkBox);
        Vday = findViewById(R.id.textViewDay);
        Eday = findViewById(R.id.editTextDay);
        Vtime = findViewById(R.id.textViewTime);
        Etime = findViewById(R.id.editTextTime);
        RSV = findViewById(R.id.buttonReserve);
        RST = findViewById(R.id.buttonReset);

        Eday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Eday.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, mYear, mMonth, mDay);
                myDateDialog.show();
            }
        });

        Etime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Etime.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
                Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, mHour, mMinute, true);

                myTimeDialog.show();
            }
        });

        RSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = Ename.getText().toString();
                Integer number = Integer.parseInt(Enumber.getText().toString());
                Integer size = Integer.parseInt(Esize.getText().toString());
                String smoke = CBsmoke.getText().toString();
                Calendar C = Calendar.getInstance();
                String c = Eday.getText().toString();
                String time = Etime.getText().toString();
                int year = C.get(Calendar.YEAR);
                int monthOfYear = C.get (Calendar.MONTH);
                int dayOfMonth = C.get (Calendar.DAY_OF_MONTH);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Confirm Your Order");
                myBuilder.setMessage("New Reservation" + "\n" + "Name: " + name + "\n" + "Smoking: " + smoke + "\n" + "Size: " + size + "\n" +  c + "\n" +  time  );
                myBuilder.setCancelable(true);

                // Configure the 'positive' button
                myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });
    }
}
