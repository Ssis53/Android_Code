package com.example.activitylifecycletest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NormalActivity extends AppCompatActivity {
    private static final String TAG = "NormalActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_layout);
        if(savedInstanceState != null) {
            /**
             * 取出临时保存的数据
             */
            String msg = savedInstanceState.getString("tempData");
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        Button escButton = (Button) findViewById(R.id.esc_normal_activity);
        escButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "退出了NormalActivity");
                finish();
            }
        });
    }

    /**
     * 活动被系统Destroy前会调用这个方法
     * 用于保存数据
     * 用户手动退出活动则不会调用
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putString("tempData", "我是被保存的临时数据");
    }

}
