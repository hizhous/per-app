package me.zhous.base.util.phone;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhous on 2016/10/28.
 */
public class PhoneUtil implements IPhone {

    private static PhoneUtil mPhoneUtil = null;
    private PhoneUtil(){}

    public static PhoneUtil getInstance(){
        if(null == mPhoneUtil){
            synchronized (PhoneUtil.class){
                if(null == mPhoneUtil){
                    mPhoneUtil = new PhoneUtil();
                }
            }
        }
        return mPhoneUtil;
    }

    public List<String[]> getInfos(Activity ctx){
        List<String[]> mInfos = new ArrayList<>();
        mInfos.add(new String[]{"ScreenHeight", String.valueOf(getWindowHeight(ctx))});
        mInfos.add(new String[]{"ScreenWidth", String.valueOf(getWindowWidth(ctx))});
        mInfos.add(new String[]{"AvailMemory",getAvailMemory(ctx)});
        mInfos.add(new String[]{"TotalMemory",getTotalMemory(ctx)});
        mInfos.add(new String[]{"IMEI",getIMEI(ctx)});
        mInfos.add(new String[]{"IMSI",getIMSI(ctx)});
        mInfos.add(new String[]{"LineNumber",getLineNum(ctx)});
        mInfos.add(new String[]{"SoftwareVersion",getDeviceSoftwareVersion(ctx)});
        mInfos.add(new String[]{"NetworkCountryIso",getNetworkCountryIso(ctx)});
        mInfos.add(new String[]{"NetworkOperator",getNetworkOperator(ctx)});
        mInfos.add(new String[]{"NetworkOperatorName",getNetworkOperatorName(ctx)});
        mInfos.add(new String[]{"NetworkType", String.valueOf(getNetworkType(ctx))});//TODO
        mInfos.add(new String[]{"PhoneType", String.valueOf(getPhoneType(ctx))});//TODO
        mInfos.add(new String[]{"SimCountryIso",getSimCountryIso(ctx)});
        mInfos.add(new String[]{"SimOperator",getSimOperator(ctx)});
        mInfos.add(new String[]{"SimOperatorName",getSimOperatorName(ctx)});
        mInfos.add(new String[]{"SimSerialNumber",getSimSerialNumber(ctx)});
        mInfos.add(new String[]{"SimState", String.valueOf(getSimState(ctx))});//TODO
        mInfos.add(new String[]{"VoiceMailNumber",getVoiceMailNumber(ctx)});
        return mInfos;
    }

    @Override
    public ActivityManager.MemoryInfo getMemoryInfo(Context ctx) {
        ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);
        return mi;
    }

    @Override
    public int getWindowHeight(Activity act) {
//        return act.getWindowManager().getDefaultDisplay().getHeight();
        DisplayMetrics outMetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    @Override
    public int getWindowWidth(Activity act) {
//        return act.getWindowManager().getDefaultDisplay().getWidth();
        DisplayMetrics outMetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    @Override
    public String getAvailMemory(Context ctx) {
        //mi.availMem; 当前系统的可用内存
        return Formatter.formatFileSize(ctx, getMemoryInfo(ctx).availMem);// 将获取的内存大小规格化
    }

    @Override
    public String getTotalMemory(Context ctx) {
        long totalMem = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            totalMem = getMemoryInfo(ctx).totalMem;// Byte转换为KB或者MB，内存大小规格化
        }else{
            String str1 = "/proc/meminfo";// 系统内存信息文件
            String str2;
            String[] arrayOfString;

            try {
                FileReader localFileReader = new FileReader(str1);
                BufferedReader localBufferedReader = new BufferedReader(
                        localFileReader, 8192);
                str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小

                arrayOfString = str2.split("\\s+");
                for (String num : arrayOfString) {
                    Log.i(str2, num + "\t");
                }
                totalMem = Integer.valueOf(arrayOfString[1]).intValue() * 1024;// 获得系统总内存，单位是KB，乘以1024转换为Byte
                localBufferedReader.close();

            } catch (IOException e) {
            }
        }
        return Formatter.formatFileSize(ctx, totalMem);// Byte转换为KB或者MB，内存大小规格化
    }

    @Override
    public String getIMEI(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    @Override
    public String getIMSI(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
    }

    @Override
    public String getLineNum(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
    }

    @Override
    public String getDeviceSoftwareVersion(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceSoftwareVersion();
    }

    @Override
    public String getNetworkCountryIso(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkCountryIso();
    }

    @Override
    public String getNetworkOperator(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperator();
    }

    @Override
    public String getNetworkOperatorName(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName();
    }

    @Override
    public int getNetworkType(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkType();
    }

    @Override
    public int getPhoneType(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getPhoneType();
    }

    @Override
    public String getSimCountryIso(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getSimCountryIso();
    }

    @Override
    public String getSimOperator(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getSimOperator();
    }

    @Override
    public String getSimOperatorName(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getSimOperatorName();
    }

    @Override
    public String getSimSerialNumber(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getSimSerialNumber();
    }

    @Override
    public int getSimState(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getSimState();
    }

    @Override
    public String getVoiceMailNumber(Context ctx) {
        return ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)).getVoiceMailNumber();
    }
}
