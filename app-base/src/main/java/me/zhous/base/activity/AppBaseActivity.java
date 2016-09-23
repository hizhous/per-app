package me.zhous.base.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;

import me.zhous.base.thread.BackgroundThread;
import me.zhous.base.thread.IBackgroundThread;

public class AppBaseActivity extends AppCompatActivity implements IBackgroundThread {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    @Override
    public HandlerThread getBackgroundThread() {
        return BackgroundThread.getInstance().getBackgroundThread();
    }

    @Override
    public Looper getBackgroundLooper() {
        return BackgroundThread.getInstance().getBackgroundLooper();
    }

    @Override
    public Handler getBackgroundHandler() {
        return BackgroundThread.getInstance().getBackgroundHandler();
    }
}
