package intervantial.positive.com.postiveintervantial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class PhoneNumber extends AppCompatActivity {


    EditText num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        num = (EditText) findViewById(R.id.editText2);


        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mynum = num.getText().toString();

                TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                int simState = telMgr.getSimState();
                switch (simState) {
                    case TelephonyManager.SIM_STATE_ABSENT:
                        Toast.makeText(PhoneNumber.this, "Unable To Send Code", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                        Toast.makeText(PhoneNumber.this, "Unable To Send Code", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                        Toast.makeText(PhoneNumber.this, "Unable To Send Code", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                        Toast.makeText(PhoneNumber.this, "Unable To Send Code", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.SIM_STATE_READY:
                        if (mynum.equals("")) {
                            Toast.makeText(PhoneNumber.this, "Please Enter Your number", Toast.LENGTH_SHORT).show();
                        } else {
                            Random r = new Random();
                            int i1 = r.nextInt(9999 - 1000) + 1000;
                            SmsManager sms = SmsManager.getDefault();
                            sms.sendTextMessage(mynum, null, "your Verification code is  " + i1, null, null);
                            Intent i = new Intent(PhoneNumber.this, Verification.class);
                            String code = i1 + "";
                            i.putExtra("code", code);
                            i.putExtra("number", mynum);
                            startActivity(i);
                        }
                        break;
                    case TelephonyManager.SIM_STATE_UNKNOWN:
                        Toast.makeText(PhoneNumber.this, "Unable To Send Code", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }
}
