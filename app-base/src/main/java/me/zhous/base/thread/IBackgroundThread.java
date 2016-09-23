package me.zhous.base.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * <p>Title: IBackgroundThread</p>
 * <p>Description: IBackgroundThread</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author zhouweida
 * @date: 2016-09-23
 * @time: 11:15
 */
public interface IBackgroundThread {
    HandlerThread getBackgroundThread();

    Looper getBackgroundLooper();

    Handler getBackgroundHandler();
}
