package intervantial.positive.com.postiveintervantial;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class HealthandSafteyDetails extends AppCompatActivity {
    public static final String DES = "des";
    public static final String CODE = "code";
    public static final String TIME = "time";
    public static final String DATE = "date";
    public static final String NAMEOF = "nameof";
    public static final String NAME = "Health";
    Bitmap bitmap;
    String desc, time, date, code, name, image;
    Uri geturi;
    TextView sendmail;
    TextView d, c, t, da, nam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthand_saftey_details);


        d = (TextView) findViewById(R.id.description);
        c = (TextView) findViewById(R.id.code);
        t = (TextView) findViewById(R.id.time2);
        da = (TextView) findViewById(R.id.date);
        nam = (TextView) findViewById(R.id.name);
        sendmail = (TextView) findViewById(R.id.button1);
        sendmail.setText("Send Mail");


        String checkimg = getIntent().getExtras().getString("image");
        Toast.makeText(HealthandSafteyDetails.this, checkimg + "", Toast.LENGTH_SHORT).show();
        if (checkimg == "null") {

        } else {
            ImageView img = (ImageView) findViewById(R.id.image);
            geturi = Uri.parse(getIntent().getExtras().getString("image"));
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), geturi);

            } catch (IOException e) {

                e.printStackTrace();
            }

            img.setImageBitmap(bitmap);

        }

        desc = getIntent().getExtras().getString("desc");
        code = getIntent().getExtras().getString("code");
        time = getIntent().getExtras().getString("time");
        date = getIntent().getExtras().getString("date");
        name = getIntent().getExtras().getString("nameoff");
        d.setText(desc);
        c.setText(code);
        t.setText(time);
        da.setText(date);
        nam.setText(name);

        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs1 = getSharedPreferences("name", MODE_PRIVATE);

                if (prefs1.contains("num")) {
                    SharedPreferences.Editor editor = getSharedPreferences(NAME, MODE_PRIVATE).edit();
                    editor.putString(DES, desc);
                    editor.putString(CODE, code);
                    editor.putString(TIME, time);
                    editor.putString(DATE, date);
                    editor.putString(NAMEOF, name);
                    editor.commit();
                    String emailTo = "axcelstudio@gmail.com";
                    String emailSubject = "HEALH AND SAFETY";
                    String emailContent = "DESCRIPTION :" + desc + "\n TIME AND DATE : " + time + ", " + date + "\nNAME :" + name;

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);
                    emailIntent.setType("image/jpeg");
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Positive Intervention JOB CODE: " + code);
                    emailIntent.putExtra(Intent.EXTRA_STREAM, geturi);
                    emailIntent.setType("message/rfc822");
                    emailIntent.setData(Uri.parse("mailto:" + emailTo));
                    try {
                        startActivity(emailIntent);
                    } catch (ActivityNotFoundException e) {

                    }


                } else {
                    String emailTo = "axcelstudio@gmail.com";
                    String emailSubject = "HEALH AND SAFETY";
                    String emailContent = "DESCRIPTION :" + desc + "\n TIME AND DATE : " + time + ", " + date + "\nNAME :" + name;

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);
                    emailIntent.setType("image/jpeg");
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Positive Intervention JOB CODE: " + code);
                    emailIntent.putExtra(Intent.EXTRA_STREAM, geturi);
                    emailIntent.setType("message/rfc822");
                    emailIntent.setData(Uri.parse("mailto:" + emailTo));
                    try {
                        startActivity(emailIntent);
                    } catch (ActivityNotFoundException e) {

                    }
                }

            }
        });

        ImageView home = (ImageView) findViewById(R.id.img_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent i = new Intent(HealthandSafteyDetails.this, HomeScreen2.class);
                startActivity(i);
            }
        });

    }

}
