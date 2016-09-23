package me.zhous.objectpool.activity;

import android.os.Bundle;

import me.zhous.base.activity.AppBaseActivity;
import me.zhous.objectpool.R;
import me.zhous.objectpool.runnable.TestObjectPoolRunnable;

public class ObjectPoolActivity extends AppBaseActivity {

    final int TheardSize = 5;
    boolean userObjectPool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doMenoryThrashing();
    }

    void doMenoryThrashing(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    for(int i = 0;i < TheardSize ;++i){
                        getBackgroundHandler().post(new TestObjectPoolRunnable("" + i,userObjectPool));
                    }
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
