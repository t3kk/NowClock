package com.ragglefraggle.nowclock;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends Activity {

    private static final int MINUTES_IN_A_DAY = 60*24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Put in the xkcd icon as a placeholder
        ImageView imgView1 = (ImageView) findViewById(R.id.image1);
        Drawable drawable = getResources().getDrawable(R.drawable.time_transparent);
        imgView1.setImageDrawable(drawable);



        //Load the earth image
        ImageView imgView2 = (ImageView) findViewById(R.id.image2);
        Drawable drawable2 = getResources().getDrawable(R.drawable.world_transparent);
        imgView2.setImageDrawable(drawable2);
        Log.d("WOOO", "PivotX: "+imgView2.getPivotX()+" PivotY "+imgView2.getPivotY());

        //Rotate the earth to match current time
        Matrix matrix=new Matrix();
        imgView2.setScaleType(ImageView.ScaleType.MATRIX);   //required
        matrix.postRotate(calculateRotationOffset());
        imgView2.setImageMatrix(matrix);







        /*Build a rotation to apply to the image view.
        it will start at 0 degrees and rotate to 360 and then start again.
        0.5f means .5 in float, which in this case is referring to the center of the x or y axis.
        Right now it seems to pause before the animation restarts because of how the frame rate lines up with the duration of the animation and our rotation
        If we were to do some calculations we can avoid this.
        */
        Animation linearRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.linear_rotation);
        //imgView2.startAnimation(linearRotateAnimation);
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

    private float calculateRotationOffset(){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        long now = cal.getTimeInMillis();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long minutesPassedMidnight = now - cal.getTimeInMillis();
        double fractionOfDay = (double)minutesPassedMidnight/(double)MINUTES_IN_A_DAY;
        float degrees = (float)(fractionOfDay*360);
        return degrees;
    }

}
