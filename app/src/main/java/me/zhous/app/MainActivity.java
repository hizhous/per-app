package me.zhous.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import me.zhous.app.receiver.NotificationReceiver;
import me.zhous.app.ui.adapter.NameValueAdapter;
import me.zhous.base.activity.BaseActivity;
import me.zhous.base.util.DialogUtil;
import me.zhous.base.util.phone.PhoneUtil;
import me.zhous.base.util.sys.SysUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b_show_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recIntent = new Intent(MainActivity.this,NotificationReceiver.class);
                recIntent.setAction(NotificationReceiver.ACTION_RECEIVE_NOTIFICATION);
                PendingIntent contentIntent = PendingIntent.getBroadcast(MainActivity.this,0,
                        recIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                Intent delIntent = new Intent(MainActivity.this,NotificationReceiver.class);
                delIntent.setAction(NotificationReceiver.ACTION_CANCEL_NOTIFICATION);
                PendingIntent deleteIntent = PendingIntent.getBroadcast(MainActivity.this,0,delIntent,PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setContentText("IamContent").setTicker("IamTicker").setContentTitle("IamTitle")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(contentIntent).setDeleteIntent(deleteIntent);

                NotificationManager manager = (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(1001,builder.build());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        View view;
        switch (item.getItemId()){
            case R.id.m_p:
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_name_value,null);
                ((ListView)view.findViewById(R.id.l_list)).setAdapter(new NameValueAdapter(MainActivity.this,PhoneUtil.getInstance().getInfos(MainActivity.this)));
                DialogUtil.showMakeSureDialog(MainActivity.this,"PhoneInfo",view,null);
                break;
            case R.id.m_s:
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_name_value,null);
                ((ListView)view.findViewById(R.id.l_list)).setAdapter(new NameValueAdapter(MainActivity.this,SysUtil.getInstance().getInfos()));
                DialogUtil.showMakeSureDialog(MainActivity.this,"SystemInfo",view,null);
                break;
        }
        return true;
    }
}
