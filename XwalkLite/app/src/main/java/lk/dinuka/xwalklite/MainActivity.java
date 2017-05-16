package lk.dinuka.xwalklite;

import android.os.Bundle;

import org.xwalk.core.XWalkActivity;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;

public class MainActivity extends XWalkActivity {
    private XWalkView xWalkWebView;
    @Override
    protected void onXWalkReady() {
        xWalkWebView.load("http://www.facebook.com",null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xWalkWebView = (XWalkView) findViewById(R.id.xwalkWebView);

        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, false);
    }
}
