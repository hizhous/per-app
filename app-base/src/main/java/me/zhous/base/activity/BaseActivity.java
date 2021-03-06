package me.zhous.base.activity;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import me.zhous.base.thread.BackgroundThread;
import me.zhous.base.thread.IBackgroundThread;

/**
 * Created by zhous on 2016/10/28.
 */
public class BaseActivity extends AppCompatActivity implements IBackgroundThread{
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
