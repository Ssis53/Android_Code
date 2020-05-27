package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private EditText editText;
    private ImageView imgView;
    private ProgressBar loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.my_button);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.ur_button);
        button2.setOnClickListener(this);

        Button alertButton = (Button) findViewById(R.id.open_alert);
        alertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
//                alert.setTitle("微信炸了");
//                alert.setMessage("你的微信爆炸了，请重新启动。");
//                alert.setCancelable(false);//点击空白处是否允许关闭
//                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
////                        Toast.makeText(MainActivity.this, "OKOKOK", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                alert.show();
            }
        });

        editText = (EditText) findViewById(R.id.edit_text);
        imgView = (ImageView) findViewById(R.id.img_view);
        loadingBar = (ProgressBar) findViewById(R.id.loading_bar);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick:" + this);
        switch (v.getId()) {
            case R.id.my_button:
                imgView.setImageResource(R.drawable.two);
                if(loadingBar.getVisibility() == View.GONE) {
                    loadingBar.setVisibility(View.VISIBLE);
                } else {
                    loadingBar.setVisibility(View.GONE);
                }
                break;
            case R.id.ur_button:
                String val = this.editText.getText().toString();
                Toast.makeText(this, val, Toast.LENGTH_SHORT).show();
                int process = loadingBar.getProgress();
                if(process < 100) {
                    loadingBar.setProgress(process + 10);
                } else {
                    loadingBar.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }
}
