package intervantial.positive.com.postiveintervantial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    EditText editText, email, passw;
    Button submit, enter;
    DatabaseReference rootRef, demoRef;
    TextView demoValue;
    String id = "axcelstudio@gmail.com";
    String pass = "123456";
    int i;
    String ida, passa;
    String userId, valuee;
    long maxl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.etValue);
        email = (EditText) findViewById(R.id.email);
        passw = (EditText) findViewById(R.id.pass);

        submit = (Button) findViewById(R.id.btnSubmit);
        enter = (Button) findViewById(R.id.enter);

        rootRef = FirebaseDatabase.getInstance().getReference();
        userId = rootRef.push().getKey();
        demoRef = rootRef.child("Code");


        rootRef.child("value").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
//                    // easy


//                    String value = dataSnapshot.getValue(String.class);
                long size = dataSnapshot.getChildrenCount();
                maxl = size;
                //  Toast.makeText(MainActivity.this, maxl + "size", Toast.LENGTH_SHORT).show();
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

                Toast.makeText(MainActivity.this, "onCancel", Toast.LENGTH_SHORT).show();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                i=20;
                String value = editText.getText().toString();
                if (value.length() < 4) {
                    Toast.makeText(MainActivity.this, "Enter 4 Digit code", Toast.LENGTH_SHORT).show();
                } else {


                    String valuee = String.valueOf(maxl);
                    maxl++;
                    demoRef = rootRef.child("value");
                    demoRef.child(valuee).setValue(value);

                    //     Toast.makeText(MainActivity.this, "Enter 4 Digit code", Toast.LENGTH_SHORT).show();
                }


                Toast.makeText(MainActivity.this, "Your Code is added", Toast.LENGTH_SHORT).show();
            }


        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ida = email.getText().toString();
                passa = passw.getText().toString();
                if (ida.equals(id) & passa.equals(pass)) {

                    editText.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                    email.setVisibility(View.GONE);
                    passw.setVisibility(View.GONE);
                    enter.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Email and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

