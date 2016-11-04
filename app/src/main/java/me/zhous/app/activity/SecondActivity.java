package me.zhous.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.zhous.app.R;
import me.zhous.base.activity.BaseActivity;

/**
 * <p>Title: SecondActivity</p>
 * <p>Description: SecondActivity</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author zhouweida
 * @date: 2016-11-04
 * @time: 18:16
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
    }
}
