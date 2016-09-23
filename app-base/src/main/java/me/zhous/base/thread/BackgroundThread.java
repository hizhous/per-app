package me.zhous.base.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * <p>Title: BackgroundThread</p>
 * <p>Description: BackgroundThread</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author zhouweida
 * @date: 2016-09-23
 * @time: 11:11
 */
public class BackgroundThread extends HandlerThread implements IBackgroundThread{

    private static BackgroundThread bgThread = null;
    private static Handler sHandler;

    private BackgroundThread(String name, int priority) {
        super(name, priority);
    }

    public static BackgroundThread getInstance() {
        if (null == bgThread) {
            synchronized (BackgroundThread.class) {
                if (null == bgThread) {
                    bgThread = new BackgroundThread("BackHandlerThread", android.os.Process.THREAD_PRIORITY_FOREGROUND);
                    bgThread.start();
                    sHandler = new Handler(bgThread.getLooper());
                }
            }
        }

        return bgThread;
    }

    public HandlerThread getBackgroundThread(){
        return bgThread;
    }

    public Looper getBackgroundLooper() {
        return getBackgroundThread().getLooper();
    }

    public Handler getBackgroundHandler() {
        return sHandler;
    }
}

