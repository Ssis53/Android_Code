package example.utils;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    private static final String TAG = "ActivityCollector";
    private static List<Activity> myList = new ArrayList<>();

    /**
     * 添加进当前活动队列
     * @param activity
     */
    public static void addActivity(Activity activity) {
        myList.add(activity);
        Log.d(TAG, String.valueOf(myList));
    }

    /**
     * 删除出当前活动队列
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        myList.remove(activity);
        Log.d(TAG, String.valueOf(myList));
    }

    /**
     * 结束所有活动
     */
    public static void finishAllActivity() {
        for (Activity ele: myList) {
            if(!ele.isFinishing()) {
                //如果该活动没有被销毁就手动销毁它
                ele.finish();
            }
        }
        //清空LIST
        myList.clear();
        //最后杀自己的进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
