package me.zhous.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import me.zhous.app.activity.SecondActivity;

/**
 * <p>Title: NotificationReceiver</p>
 * <p>Description: NotificationReceiver</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author zhouweida
 * @date: 2016-11-04
 * @time: 17:08
 */
public class NotificationReceiver extends BroadcastReceiver {

    public static final String TAG = "not_rec";
    public static final String ACTION_RECEIVE_NOTIFICATION = "receiver.rec_notificaiton";
    public static final String ACTION_CANCEL_NOTIFICATION = "receiver.del_notification";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ACTION_RECEIVE_NOTIFICATION) ){
            Log.i(TAG,"receiver notification");
            Intent int1 = new Intent(context,SecondActivity.class);
            int1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(int1);
        }
        if(intent.getAction().equals(ACTION_CANCEL_NOTIFICATION)){
            Log.i(TAG,"delete notification");
        }
    }
}
