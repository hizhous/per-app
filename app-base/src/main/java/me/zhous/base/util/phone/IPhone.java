package me.zhous.base.util.phone;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by zhous on 2016/10/28.
 */
public interface IPhone {
    ActivityManager.MemoryInfo getMemoryInfo(Context ctx);
    int getWindowHeight(Activity act);
    int getWindowWidth(Activity act);
    String getAvailMemory(Context ctx);
    String getTotalMemory(Context ctx);
    String getIMEI(Context ctx);
    String getIMSI(Context ctx);
    String getLineNum(Context ctx);
    String getDeviceSoftwareVersion(Context ctx);
    String getNetworkCountryIso(Context ctx);
    String getNetworkOperator(Context ctx);
    String getNetworkOperatorName(Context ctx);
    int getNetworkType(Context ctx);
    int getPhoneType(Context ctx);
    String getSimCountryIso(Context ctx);
    String getSimOperator(Context ctx);
    String getSimOperatorName(Context ctx);
    String getSimSerialNumber(Context ctx);
    int getSimState(Context ctx);
    String getVoiceMailNumber(Context ctx);
}
