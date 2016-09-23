package me.zhous.objectpool.runnable;

import android.util.Log;

import java.util.Random;

import me.zhous.objectpool.pool.TestObject;
import me.zhous.objectpool.pool.TestPool;

/**
 * <p>Title: TestObjectPoolRunnable</p>
 * <p>Description: TestObjectPoolRunnable</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author zhouweida
 * @date: 2016-09-23
 * @time: 10:52
 */
public class TestObjectPoolRunnable implements Runnable {

    Random r = new Random();
    // 是否使用对象池
    boolean isUseObjectPool;
    String mThreadName;

    public TestObjectPoolRunnable(String name,boolean userObjectPool){
        mThreadName = name;
        isUseObjectPool = userObjectPool;
    }

    @Override
    public void run() {
        if(isUseObjectPool){
            TestObject obj = TestPool.obtain("Pool_" + mThreadName,r.nextInt());
            Log.i("pool",obj.getName() + " : " + obj.getCount());
            TestPool.recycle(obj);
        }else{
            TestObject obj = new TestObject("Pool_" + mThreadName,r.nextInt());
            Log.i("pool",obj.getName() + " : " + obj.getCount());
        }
    }
}
