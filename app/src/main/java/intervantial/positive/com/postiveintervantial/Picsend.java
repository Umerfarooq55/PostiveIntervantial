package intervantial.positive.com.postiveintervantial;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;

public class Picsend extends AppCompatActivity {
    String image;
    Uri geturi;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picsend);


        image = getIntent().getExtras().getString("image");


        ImageView img = (ImageView) findViewById(R.id.image_picsend);
        geturi = Uri.parse(getIntent().getExtras().getString("image"));
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), geturi);

        } catch (IOException e) {

            e.printStackTrace();
        }

        img.setImageBitmap(bitmap);

    }


}

