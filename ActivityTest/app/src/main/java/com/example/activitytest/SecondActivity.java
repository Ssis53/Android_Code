package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is: " + getTaskId());
        setContentView(R.layout.activity_second);
        /**
         * 取得上个活动传的值
         */
        Intent intent = getIntent();
        String myData = intent.getStringExtra("myData");
        Toast.makeText(this, myData, Toast.LENGTH_SHORT).show();

        /**
         * 返回按钮点击事件
         */
        Button buttonEle = (Button) findViewById(R.id.button_2);
        buttonEle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /**
                 * 结束当前活动并传递参数给上个活动
                 */
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                intent.putExtra("data_return", "我来自子活动");
                setResult(RESULT_OK, intent);
//                finish();
                startActivity(intent);

            }
        });

        /**
         * 从活动二打开活动三
         */
        Button buttonEle2 = (Button) findViewById(R.id.secon_to_third);
        buttonEle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
