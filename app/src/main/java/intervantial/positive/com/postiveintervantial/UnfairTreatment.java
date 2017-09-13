package intervantial.positive.com.postiveintervantial;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class UnfairTreatment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView mSelectCode;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private TimePicker timePicker1;
    private TextView time;
    private String format = "";
    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        switch (pos) {
            case 0:
                mSelectCode = (TextView) findViewById(R.id.selectcode);
                String label = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(label);
                break;
            case 1:
                mSelectCode = (TextView) findViewById(R.id.selectcode);
                String labelone = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(labelone);
                break;
            case 2:
                mSelectCode = (TextView) findViewById(R.id.selectcode);
                String labelthree = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(labelthree);
                break;
            case 3:
                mSelectCode = (TextView) findViewById(R.id.selectcode);
                String labelfour = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(labelfour);
                break;
            case 4:
                mSelectCode = (TextView) findViewById(R.id.selectcode);
                String labelfive = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(labelfive);
            case 5:
                mSelectCode = (TextView) findViewById(R.id.selectcode);
                String labelsix = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(labelsix);
        }
    }
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    Intent b = new Intent(UnfairTreatment.this,HomeScreen2.class);
//                    startActivity(b);
//                    return true;
//                case R.id.camera:
//                    Intent ba = new Intent(UnfairTreatment.this,CameraActivity.class);
//                    startActivity(ba);
//                    return true;
//                case R.id.Exit:
//                    Intent intent = new Intent(Intent.ACTION_MAIN);
//                    intent.addCategory(Intent.CATEGORY_HOME);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                    return true;
//                case R.id.telephone:
//                    Intent intentc = new Intent(Intent.ACTION_DIAL);
//                    intentc.setData(Uri.parse("tel:0123456789"));
//                    startActivity(intentc);
//                    return true;
//
//            }
//            return false;
//        }
//
//    };

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unfair_treatment);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_black_24dp);

        Spinner spinner = (Spinner) findViewById(R.id.healthy_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, R.layout.customspin);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        dateView = (TextView) findViewById(R.id.selectcode_three);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        time = (TextView) findViewById(R.id.selectcode_two);
        calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);

        RelativeLayout camera = (RelativeLayout) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UnfairTreatment.this, CameraActivity.class);
                startActivity(i);
            }
        });
        ImageView cam = (ImageView) findViewById(R.id.img_camera);

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent b = new Intent(UnfairTreatment.this, CameraActivity.class);
                startActivity(b);

            }
        });
        ImageView call = (ImageView) findViewById(R.id.img_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentc = new Intent(Intent.ACTION_DIAL);
                intentc.setData(Uri.parse("tel:+92 42 35941084"));
                startActivity(intentc);


            }
        });
        ImageView home = (ImageView) findViewById(R.id.img_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent i = new Intent(UnfairTreatment.this, HomeScreen2.class);
                startActivity(i);
            }
        });
        ImageView exit = (ImageView) findViewById(R.id.stopme);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
//        Toast.makeText(getApplicationContext(), "ca",
//                Toast.LENGTH_SHORT)
//                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
    public void setTime(View view) {
        int hour = timePicker1.getCurrentHour();
        int min = timePicker1.getCurrentMinute();
        showTime(hour, min);
    }

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

//        time.setText(new StringBuilder().append(hour).append(" : ").append(min)
//                .append(" ").append(format));
    }


}


