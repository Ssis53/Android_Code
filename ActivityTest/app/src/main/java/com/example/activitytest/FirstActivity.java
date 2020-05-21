package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.BlockingDeque;

public class FirstActivity extends BaseActivity {
    private static final String TAG = "FirstActivity";

    /**
     * 创建下拉菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 菜单响应事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected111: " + FirstActivity.this);
        Log.d(TAG, "onOptionsItemSelected222: " + this);
        Log.d(TAG, "onOptionsItemSelected333: " + (this == FirstActivity.this));
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "新增", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.esc:
                finish();
                break;
        }
        return true;
    }

    /**
     * 用于监听下一个活动返回这个活动时传的信息
     * @param requestCode  启动下个活动传入的请求码
     * @param resultCode   子活动处理返回数据时的处理结果
     * @param data         数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 5300:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Toast.makeText(this, returnData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is: " + getTaskId());
        setContentView(R.layout.first_layout);
        /**
         * 按钮1事件处理
         */
        Button buttonInstance = (Button) findViewById(R.id.button_1);
        buttonInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注意跟js一样事件处理函数中的上下文，this不是FirstActivity.this。
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                String data = "我来自FirstActivity";
                //给下个活动传值
                intent.putExtra("myData", data);
                startActivity(intent);
                //用准备接受下个活动传参的方式启动下个活动
//                startActivityForResult(intent, 5300);

//                Log.d(TAG, "onClick: 111"+ FirstActivity.this);
//                Log.d(TAG, "onClick: 22"+ this);
//                Log.d(TAG, "onClick: 33"+ this.getClass());
//                Log.d(TAG, "onClick: 44"+ FirstActivity.this.getClass());
            }
        });

        /**
         * 按钮2事件处理
         */
        Button buttonToThird = (Button) findViewById(R.id.button_to_thirdpage);
        buttonToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
            
        });

        /**
         * 打开网页按钮事件
         */
        Button buttonOpenUrl = (Button) findViewById(R.id.button_open_url);
        buttonOpenUrl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                打开网页
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.zhihu.com"));
//                拨打电话
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        /**
         * 启动自己的按钮事件
         */
        Button buttonSelf = (Button) findViewById(R.id.button_start_self);
        buttonSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
        
        
        
    }
}
