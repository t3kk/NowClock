package com.ragglefraggle.polarclock;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

    float scale = 0.61f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Put in the xkcd icon as a placeholder
        ImageView imgView1 = (ImageView) findViewById(R.id.image1);
        Drawable drawable = getResources().getDrawable(R.drawable.nowtransparent);
        imgView1.setImageDrawable(drawable);

        //Load the earth image
        ImageView imgView2 = (ImageView) findViewById(R.id.image2);
        Drawable drawable2 = getResources().getDrawable(R.drawable.earth);
        //imgView2.setImageDrawable(drawable2);

        //Scale it to fit inside of the xkcd icon.
        imgView2.setScaleX(scale);
        imgView2.setScaleY(scale);

        /*Build a rotation to apply to the image view.
        it will start at 0 degrees and rotate to 360 and then start again.
        0.5f means .5 in float, which in this case is referring to the center of the x or y axis.
        Right now it seems to pause before the animation restarts because of how the frame rate lines up with the duration of the animation and our rotation
        If we were to do some calculations we can avoid this.
        */
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f );
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(-1);
        imgView2.startAnimation(rotateAnimation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//        public void submitClicked(View view) {
//            EditText helloWorldTextView = (EditText) findViewById(R.id.helloWorldTextView);
//            helloWorldTextView.setText(helloWorldTextView.getText() + " EXTRA!");
//        }




}
