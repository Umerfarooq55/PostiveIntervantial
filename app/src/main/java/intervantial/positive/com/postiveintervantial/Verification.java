package intervantial.positive.com.postiveintervantial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Verification extends AppCompatActivity {
    public static final String NUM = "num";
    public static final String NAME = "name";
    EditText codeprovide;
    String code;
    String mynum;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        code = getIntent().getExtras().getString("code");
        mynum = getIntent().getExtras().getString("number");
        codeprovide = (EditText) findViewById(R.id.editText);
        Button done = (Button) findViewById(R.id.done);
        //   Toast.makeText(Verification.this, code+mynum+"", Toast.LENGTH_SHORT).show();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code.equals(codeprovide.getText().toString())) {
                    SharedPreferences.Editor editor = getSharedPreferences(NAME, MODE_PRIVATE).edit();
                    editor.putString(NUM, mynum);
                    editor.commit();
                    Intent i = new Intent(Verification.this, HomeScreen2.class);
                    startActivity(i);

                } else {
                    Toast.makeText(Verification.this, "Could Not verify this time ,Try later", Toast.LENGTH_SHORT).show();

                }



            }
        });
    }
}
