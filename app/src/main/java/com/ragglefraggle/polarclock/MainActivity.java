package com.ragglefraggle.polarclock;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgView = (ImageView) findViewById(R.id.image1);
        Drawable drawable = getResources().getDrawable(R.drawable.polarclock);
        imgView.setImageDrawable(drawable);

        ImageView imgView2 = (ImageView) findViewById(R.id.image2);
        Drawable drawable2 = getResources().getDrawable(R.drawable.smile);
        imgView2.setImageDrawable(drawable2);

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
