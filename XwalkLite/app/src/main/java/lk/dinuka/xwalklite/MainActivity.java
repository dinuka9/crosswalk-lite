package lk.dinuka.xwalklite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.xwalk.core.XWalkActivity;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;

public class MainActivity extends XWalkActivity {
    private XWalkView xWalkWebView;

    @Override
    protected void onXWalkReady() {
        xWalkWebView.load("http://www.facebook.com", null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xWalkWebView = (XWalkView) findViewById(R.id.xwalkWebView);

        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, false);

        xWalkWebView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    public void showAletDialog() {
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
        final EditText input = new EditText(MainActivity.this);
        input.setText("http://www.");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        input.setImeOptions(EditorInfo.IME_ACTION_DONE);
        dialog.setView(input);
        dialog.setMessage("Enter URL");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                xWalkWebView.load(input.getText().toString(), null);
            }
        });
        dialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            showAletDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
