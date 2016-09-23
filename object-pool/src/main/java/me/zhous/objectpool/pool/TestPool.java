package me.zhous.objectpool.pool;

import android.support.v4.util.Pools;

/**
 * <p>Title: TestPool</p>
 * <p>Description: TestPool</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author zhouweida
 * @date: 2016-09-23
 * @time: 10:02
 */
public class TestPool {
    private static final Pools.SynchronizedPool<TestObject> sPool =
            new Pools.SynchronizedPool<>(10);

    public static TestObject obtain(String n,int c) {
        TestObject instance = sPool.acquire();
        if(null != instance){
            instance.reset(n,c);
        }else{
            instance = new TestObject(n,c);
        }
        return instance;
    }

    public static void recycle(TestObject obj) {
        obj.reset("",-1);
        sPool.release(obj);
    }
}
