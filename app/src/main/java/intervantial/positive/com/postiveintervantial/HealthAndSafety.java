package intervantial.positive.com.postiveintervantial;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HealthAndSafety extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String DES = "des";
    public static final String CODE = "code";
    public static final String TIME = "time";
    public static final String DATE = "date";
    public static final String NAMEOF = "nameof";
    public static final String NAME = "Health";
    private static final String IMAGE_DIRECTORY = "/demonuts";
    TextView mSelectCode, btn;
    Spinner spinner;
    EditText desc, nameof;
    int hour;
    int min;
    String label;
    Uri uriSavedImage;
    Uri contentURI;
    Bitmap bitmap, bitmap2;
    boolean cam = false, gal = false;
    Uri pngUri;
    long i, b, c;
    String cb;
    long maxq, size;
    List<String> myList;
    List<String> myList1;
    String x, y, z;
    ArrayAdapter<String> adapter;
    int count = 0;
    //    ArrayAdapter<CharSequence> adapter;
    DatabaseReference rootRef, demoRef;//  demoRef = rootRef.child("Code");
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private TimePicker timePicker1;
    private TextView time;
    private String format = "";
    private int GALLERY = 1, CAMERA = 2;
    private Button send;
    private ImageView imageview;
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

                label = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(label);
                break;
            case 1:

                label = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(label);
                break;
            case 2:

                label = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(label);
                break;
            case 3:

                label = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(label);
                break;
            case 4:

                label = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(label);
            case 5:

                label = parent.getItemAtPosition(pos).toString();
                mSelectCode.setText(label);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_and_safety);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mSelectCode = (TextView) findViewById(R.id.selectcode);

        setSupportActionBar(myToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_black_24dp);
//
//        Spinner spinner = (Spinner) findViewById(R.id.healthy_spinner);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, R.layout.customspin);
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
////                android.R.layout.simple_spinner_item, myList);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
        rootRef = FirebaseDatabase.getInstance().getReference();

        demoRef = rootRef.child("value");

//b = i++;
        rootRef.child("value").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
//                    // easy


//                    String value = dataSnapshot.getValue(String.class);
                size = dataSnapshot.getChildrenCount();
                maxq = size;

//                setval(size);
////                Toast.makeText(HealthAndSafety.this, maxq+"onCancel", Toast.LENGTH_SHORT).show();
//                Toast.makeText(HealthAndSafety.this, maxq + "", Toast.LENGTH_SHORT).show();
//                }


//                for (DataSnapshot snap: dataSnapshot.getChildren()) {
//                    Log.e(snap.getKey(),snap.getChildrenCount() + "");
//                    Toast.makeText(HealthAndSafety.this, snap.getChildrenCount() + "", Toast.LENGTH_SHORT).show();

//                List<String> lst = new ArrayList<String>(); // Result will be holded Here
//                String valuee = dataSnapshot.getValue(String.class);
//                lst.add(valuee);
//                for(DataSnapshot dsp : dataSnapshot.getChildren()){
//                    lst.add(String.valueOf(dsp.getkey())); //add result into array list

//                    Toast.makeText(HealthAndSafety.this,  ""+ valuee, Toast.LENGTH_SHORT).show();

                //  String value = dataSnapshot.getKey();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(HealthAndSafety.this, "onCancel", Toast.LENGTH_SHORT).show();
            }
        });


////        Toast.makeText(HealthAndSafety.this, getva() + "onCancel", Toast.LENGTH_SHORT).show();
//        for (c = 0; c < 4; c++) {
//
//
//            cb = String.valueOf(c);


        rootRef.child("value").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
//                    // easy
                ArrayList<String> myList = new ArrayList<String>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String university = postSnapshot.getValue(String.class);
                    myList.add(university);
//                            String cb = dataSnapshot.getValue(String.class);
//                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
//                            myList.add(String.valueOf(dsp.getValue()));
//                       Toast.makeText(HealthAndSafety.this,  ""+ value, Toast.LENGTH_SHORT).show();

//                            ArrayList<String> myList = new ArrayList<String>();
////                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
//                            myList.add(String.valueOf(dsp.getValue())); //add r
//                            myList.add(cb);
                    Toast.makeText(HealthAndSafety.this, "" + myList.get(0), Toast.LENGTH_SHORT).show();
//                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(HealthAndSafety.this,
//              R.array.planets_array, R.layout.customspin);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(HealthAndSafety.this,
                            R.layout.customspin, myList);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        try
                    Spinner spinner = (Spinner) findViewById(R.id.healthy_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, R.layout.customspin);

// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                    spinner.setAdapter(adapter);
//                            {
//                                File root = new File(Environment.getExternalStorageDirectory()+File.separator+"Music_Folder", "Report Files");
//                                //File root = new File(Environment.getExternalStorageDirectory(), "Notes");
//                                if (!root.exists())
//                                {
//                                    root.mkdirs();
//                                }
//                                File gpxfile = new File(root, "notes.txt");
//
//
//                                FileWriter writer = new FileWriter(gpxfile,true);
//                                writer.append(value+"\n\n");
//                                writer.flush();
//                                writer.close();
//                                //Toast.makeText(HealthAndSafety.this, "Data has been written to Report File", Toast.LENGTH_SHORT).show();
//                            }
//                            catch(IOException e)
//                            {
//
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Toast.makeText(HealthAndSafety.this, "onCancel", Toast.LENGTH_SHORT).show();
            }
        });
//        }
//        }


        Spinner spinner = (Spinner) findViewById(R.id.healthy_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, R.layout.customspin);

// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        desc = (EditText) findViewById(R.id.desc);
        nameof = (EditText) findViewById(R.id.n_of);

        dateView = (TextView) findViewById(R.id.selectcode_three);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        time = (TextView) findViewById(R.id.selectcode_two);
        calendar = Calendar.getInstance();

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);

        btn = (TextView) findViewById(R.id.sendreport);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendtonext();


            }
        });
        RelativeLayout camera = (RelativeLayout) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i = new Intent(HealthAndSafety.this, CameraActivity.class);
                // startActivity(i);
                showPictureDialog();


            }
        });
        ImageView cam = (ImageView) findViewById(R.id.img_camera);

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
                // Intent b = new Intent(HealthAndSafety.this, CameraActivity.class);
                //startActivity(b);

            }
        });
        ImageView call = (ImageView) findViewById(R.id.img_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                int simState = telMgr.getSimState();
                switch (simState) {
                    case TelephonyManager.SIM_STATE_ABSENT:
                        Toast.makeText(HealthAndSafety.this, "Unable to call", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                        Toast.makeText(HealthAndSafety.this, "Unable to call", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                        Toast.makeText(HealthAndSafety.this, "Unable to call", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                        Toast.makeText(HealthAndSafety.this, "Unable to call", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_READY:

                        Intent intentc = new Intent(Intent.ACTION_DIAL);
                        intentc.setData(Uri.parse("tel:+92 42 35941084"));
                        startActivity(intentc);

                        break;
                    case TelephonyManager.SIM_STATE_UNKNOWN:
                        Toast.makeText(HealthAndSafety.this, "Unable to call", Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });
        ImageView home = (ImageView) findViewById(R.id.img_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent i = new Intent(HealthAndSafety.this, HealthAndSafety.class);
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

        SharedPreferences prefs = getSharedPreferences(NAME, MODE_PRIVATE);

        SharedPreferences prefs1 = getSharedPreferences("name", MODE_PRIVATE);

        if (prefs1.contains("num")) {
            if (prefs.contains(DES)) {
                // String name = prefs.getString("munum", "");//"No name defined" is the default value.

                desc.setText(prefs.getString(DES, ""));
                nameof.setText(prefs.getString(NAMEOF, ""));
                dateView.setText(prefs.getString(DATE, ""));
                String hou = prefs.getString(TIME, "").substring(0, 2);
                String min = prefs.getString(TIME, "").substring(3);
                int a = Integer.parseInt(hou);
                int b = Integer.parseInt(min);


                //  t.setText(prefs.getString(CODE, ""));

            } else {
                //  Toast.makeText(HealthAndSafety.this, "no", Toast.LENGTH_SHORT).show();

            }


        } else {

        }
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
        hour = timePicker1.getCurrentHour();
        min = timePicker1.getCurrentMinute();
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

    void sendtonext() {

        String description = desc.getText().toString();
        String Contrac_code = label;
        String time = timePicker1.getCurrentHour() + ":" + timePicker1.getCurrentMinute();

        String Date = dateView.getText().toString();

        String nameoff = nameof.getText().toString();

        if (description.equals("") || time.equals("") || Date.equals("") || nameoff.equals("") || Contrac_code.equals("Select Code...")) {
            Toast.makeText(HealthAndSafety.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();

        } else {

            if (cam && !gal) {
                Intent i = new Intent(HealthAndSafety.this, HealthandSafteyDetails.class);
                i.putExtra("desc", description);
                i.putExtra("code", Contrac_code);
                i.putExtra("time", time);
                i.putExtra("date", Date);
                i.putExtra("nameoff", nameoff);
                i.putExtra("image", pngUri.toString());
                startActivity(i);
                //Toast.makeText(HealthAndSafety.this, uriSavedImage + "cam", Toast.LENGTH_SHORT).show();

            } else if (gal && !cam) {
                Intent i = new Intent(HealthAndSafety.this, HealthandSafteyDetails.class);
                i.putExtra("desc", description);
                i.putExtra("code", Contrac_code);
                i.putExtra("time", time);
                i.putExtra("date", Date);
                i.putExtra("nameoff", nameoff);
                i.putExtra("image", contentURI.toString());
                startActivity(i);

                //  Toast.makeText(HealthAndSafety.this, contentURI + "gal", Toast.LENGTH_SHORT).show();
            } else if (!gal && !cam) {
                Intent i = new Intent(HealthAndSafety.this, HealthandSafteyDetails.class);
                i.putExtra("desc", description);
                i.putExtra("code", Contrac_code);
                i.putExtra("time", time);
                i.putExtra("date", Date);
                i.putExtra("nameoff", nameoff);

                i.putExtra("image", "null");
                startActivity(i);
                Toast.makeText(HealthAndSafety.this, "No Pic Is attached", Toast.LENGTH_SHORT).show();
            }


        }

    }

    public void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
    //////////////////////////functions

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    public void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
        imagesFolder.mkdirs();

        File image = new File(imagesFolder, "QR12" + ".jpg");
        uriSavedImage = Uri.fromFile(image);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        //Toast.makeText(HealthAndSafety.this, android.os.Environment.getExternalStorageDirectory().toString(), Toast.LENGTH_LONG).show();

        startActivityForResult(intent, CAMERA);
    }



    /*
    *Hamdulla
     * My Activity Result
      *
      * */

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            contentURI = data.getData();
            if (data != null) {


                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    gal = true;
                    cam = false;


                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(HealthAndSafety.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {


            File pngDir = new File(

                    Environment.getExternalStorageDirectory(),
                    "MyImages");

            if (!pngDir.exists())
                pngDir.mkdirs();

            File pngFile = new File(pngDir, "QR12.jpg");
            pngUri = Uri.fromFile(pngFile);//yad rakhna

            gal = false;
            cam = true;


        }
    }

    public void setval(long i) {
        maxq += i;

    }

    public long getva() {
        return maxq;
    }
}


