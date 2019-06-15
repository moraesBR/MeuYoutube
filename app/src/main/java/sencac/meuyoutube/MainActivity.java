package sencac.meuyoutube;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton animais = findViewById(R.id.rbAnimais);
                RadioButton beleza = findViewById(R.id.rbBeleza);
                RadioButton culinaria = findViewById(R.id.rbCulinaria);
                RadioButton esporte = findViewById(R.id.rbEsporte);
                RadioButton tecnologia = findViewById(R.id.rbTecnologia);

                String link = "https://www.youtube.com/embed/";
                if(animais.isChecked())
                    link += "weBk238xnik";
                else
                if(beleza.isChecked())
                    link += "mG8vCbBw1jQ";
                else
                if(culinaria.isChecked())
                    link += "-klBdv6-iEE";
                else
                if(esporte.isChecked())
                    link += "XKfsPa37mS8";
                else
                if(tecnologia.isChecked())
                    link += "pVddfLf-mnA";

                link += "?autoplay=1&vq=small";

                /*
                try {
                    VideoView video = findViewById(R.id.video);
                    video.setVideoURI(Uri.parse(link));
                    video.start();
                }
                catch (Exception ex){
                    Log.e("onClick fab", ex.getMessage());
                    Toast.makeText(getApplicationContext(),"Houve um erro...", Toast.LENGTH_LONG).show();
                }
                */

                try {
                    WebView video = findViewById(R.id.video);
                    video.getSettings().setJavaScriptEnabled(true);
                    video.getSettings().setPluginState(WebSettings.PluginState.ON);
                    video.loadUrl(link);
                    video.setWebChromeClient(new WebChromeClient());
                }
                catch (Exception ex){
                    Log.e("onClick fab", ex.getMessage());
                    Toast.makeText(getApplicationContext(),"Houve um erro...", Toast.LENGTH_LONG).show();
                }

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
