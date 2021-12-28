package ng.org.hikmahtechis.studentswingcng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

import ng.org.hikmahtechis.studentswingcng.R;

public class Leadership extends AppCompatActivity {
    private WebView mwebView;
    ProgressBar loadingProgressBar;
    private View inflatedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflatedView = LayoutInflater.from(this).inflate(R.layout.activity_leadership, null, false);
        setContentView(inflatedView);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }
    public void onStart() {
        super.onStart();
        mwebView = (WebView)findViewById(R.id.webViewforum);
        this.loadingProgressBar = (ProgressBar) findViewById(R.id.progressbar_forum);
        mwebView.getSettings().setAppCacheEnabled(true);
        mwebView.getSettings().setLoadsImagesAutomatically(true);
        mwebView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        mwebView.getSettings().setAppCachePath(Leadership.this.getCacheDir().getAbsolutePath());
        mwebView.getSettings().setAllowFileAccess(true);
        mwebView.getSettings().setJavaScriptEnabled(true);
        mwebView.setFocusableInTouchMode(true);
        mwebView.setScrollbarFadingEnabled(true);
        mwebView.getSettings().setLoadsImagesAutomatically(true);
        mwebView.getSettings().setDomStorageEnabled(true);
        mwebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        NetworkInfo nInfo = ((ConnectivityManager)Leadership.this.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if(nInfo == null || !nInfo.isConnected()) {

            Snackbar.make(inflatedView, "Failed to load. Please Check your Internet Connection and Try Again!", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            loadingProgressBar.setVisibility(ProgressBar.INVISIBLE);
            //Load an Image as an error page
            //oops no internet connction
            mwebView.setVisibility(View.GONE);
            //View.setVisibility(ImageView.VISIBLE);
        }else{
            mwebView.loadUrl("https://www.meetshehu.com.ng/sw-cng/exco/");
        }
        mwebView.setWebChromeClient(new WebChromeClient());
        mwebView.setWebViewClient(new WebViewClient());
        mwebView.setWebChromeClient(new WebChromeClient(){


            public void onProgressChanged(WebView view, int newProgress){
                super.onProgressChanged(view,newProgress);
                Leadership.this.loadingProgressBar.setProgress(newProgress);
                if(newProgress == 100) {
                    Leadership.this.loadingProgressBar.setVisibility(View.GONE);
                }else{
                    Leadership.this.loadingProgressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        mwebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mwebView.canGoBack()) {
                    mwebView.goBack();
                    return true;
                }
                return false;
            }
        });
    }
    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}