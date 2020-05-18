package sg.edu.rp.c346.id18015362.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reset_btn;
    Button reserve_btn;
    EditText nameEdit;
    EditText mobileEdit;
    EditText paxEdit;
    CheckBox smokingCheckBox;
    DatePicker dp;
    TimePicker tp;
    boolean error = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset_btn = findViewById(R.id.btn_reset);
        reserve_btn = findViewById(R.id.reserve_btn);
        nameEdit = findViewById(R.id.nameEdit);
        mobileEdit = findViewById(R.id.phoneEdit);
        paxEdit = findViewById(R.id.paxEdit);
        smokingCheckBox = findViewById(R.id.smokeCheckBox);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        reserve_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = nameEdit.getText().toString();
                String mobile = mobileEdit.getText().toString();
                String pax = paxEdit.getText().toString();
                String message = "";

                if(name.length() == 0) {
                    message = "Please fill in your Name";
                    error = true;
                } else if(mobile.length() == 0){
                    message = "Please fill in your Phone Number";
                    error = true;
                } else if(pax.length() == 0){
                    message = "Please enter the number of pax";
                    error = true;
                }

                String smokeArea = "";
                int month = dp.getMonth() + 1;
                if(smokingCheckBox.isChecked()) {
                    smokeArea = "Located at Smoking Area";
                } else{
                    smokeArea = "Located at non-Smoking Area";
                }

                if(error == false) {
                    message = String.format("Reservation registered on %s/%s/%s %s:%s for %s pax under %s (MOBILE:%s) %s ", dp.getDayOfMonth(), month, dp.getYear(), tp.getCurrentHour(), tp.getCurrentMinute(), pax, name, mobile, smokeArea);
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }

        });

        reset_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                nameEdit.setText("");
                mobileEdit.setText("");
                paxEdit.setText("");
                smokingCheckBox.setChecked(false);
                error = false;

                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });

    }
}
