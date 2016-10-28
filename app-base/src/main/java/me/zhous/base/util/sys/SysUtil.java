package me.zhous.base.util.sys;

import android.app.Activity;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhous on 2016/10/28.
 */
public class SysUtil implements ISys {

    private static SysUtil mSysUtil = null;
    private SysUtil(){
        mInfos.add(new String[]{"PRODUCT",getProduct()});
        mInfos.add(new String[]{"CPU_ABI",getCpuAbi()});
        mInfos.add(new String[]{"TAGS",getTags()});
        mInfos.add(new String[]{"VERSION.CODE.BASE","" + getVersionCodeBase()});
        mInfos.add(new String[]{"MODEL",getModel()});
        mInfos.add(new String[]{"VERSION.SDK",getVersionSDK()});
        mInfos.add(new String[]{"VERSION.RELEASE",getVersionRelease()});
        mInfos.add(new String[]{"DEVICES",getDevice()});
        mInfos.add(new String[]{"DISPLAY",getDisplay()});
        mInfos.add(new String[]{"BRAND",getBrand()});
        mInfos.add(new String[]{"BOARD",getBoard()});
        mInfos.add(new String[]{"FINGERPRINT",getFingerPrint()});
        mInfos.add(new String[]{"ID",getId()});
        mInfos.add(new String[]{"MENUFACTURE",getMenuFacture()});
        mInfos.add(new String[]{"USER",getUser()});
    }

    public static SysUtil getInstance(){
        if(null == mSysUtil){
            synchronized (SysUtil.class){
                if(null == mSysUtil){
                    mSysUtil = new SysUtil();
                }
            }
        }
        return mSysUtil;
    }

    private List<String[]> mInfos = new ArrayList<>();

    public List<String[]> getInfos(){
        return mInfos;
    }

    @Override
    public String getProduct() {
        return Build.PRODUCT;
    }

    @Override
    public String getCpuAbi() {
        return Build.CPU_ABI;
    }

    @Override
    public String getTags() {
        return Build.TAGS;
    }

    @Override
    public int getVersionCodeBase() {
        return Build.VERSION_CODES.BASE;
    }

    @Override
    public String getModel() {
        return Build.MODEL;
    }

    @Override
    public String getVersionSDK() {
        return Build.VERSION.SDK;
    }

    @Override
    public String getVersionRelease() {
        return Build.VERSION.RELEASE;
    }

    @Override
    public String getDevice() {
        return Build.DEVICE;
    }

    @Override
    public String getDisplay() {
        return Build.DISPLAY;
    }

    @Override
    public String getBrand() {
        return Build.BRAND;
    }

    @Override
    public String getBoard() {
        return Build.BOARD;
    }

    @Override
    public String getFingerPrint() {
        return Build.FINGERPRINT;
    }

    @Override
    public String getId() {
        return Build.ID;
    }

    @Override
    public String getMenuFacture() {
        return Build.MANUFACTURER;
    }

    @Override
    public String getUser() {
        return Build.USER;
    }
}
