package me.zhous.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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
