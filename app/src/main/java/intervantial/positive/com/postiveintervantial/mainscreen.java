package intervantial.positive.com.postiveintervantial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class mainscreen extends AppCompatActivity {
    public static final String NUM = "num";
    public static final String NAME = "name";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        Button signup = (Button) findViewById(R.id.signup);
        Button skip = (Button) findViewById(R.id.skip);
        Button admin = (Button) findViewById(R.id.admin);
        SharedPreferences prefs = getSharedPreferences(NAME, MODE_PRIVATE);
        admin.setVisibility(View.GONE);

        if (prefs.contains(NUM)) {
            //  String name = prefs.getString("munum", "");//"No name defined" is the default value.

            Intent i = new Intent(mainscreen.this, HomeScreen2.class);
            startActivity(i);

        } else {
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i = new Intent(mainscreen.this, PhoneNumber.class);
                    startActivity(i);
                }
            });

            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mainscreen.this, HomeScreen2.class);
                    startActivity(i);
                }
            });

            admin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mainscreen.this, MainActivity.class);
                    startActivity(i);
                }
            });




        }

    }
}
