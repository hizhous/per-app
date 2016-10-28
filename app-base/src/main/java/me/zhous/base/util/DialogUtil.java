package me.zhous.base.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by zhous on 2016/10/28.
 */
public class DialogUtil {

    public static final int TYPE_MAKE_SURE = 1;
    public static final int TYPE_YES_NO = 2;
    public static final int TYPE_YES_NO_NEUTRAL = 3;

    public static interface IDialogOnClickListener{
        void onPositive(DialogInterface dialog, int which);
        void onNegative(DialogInterface dialog, int which);
        void onNeutral(DialogInterface dialog, int which);
    }

    public static void showMakeSureDialog(Context ctx, String msg, final IDialogOnClickListener onClickListener){
        showMakeSureDialog(ctx,null,msg,onClickListener);
    }

    public static void showMakeSureDialog(Context ctx, String title,String msg, final IDialogOnClickListener onClickListener){
        showDialog(ctx,TYPE_MAKE_SURE,title,msg,onClickListener);
    }

    public static void showYesOrNoDialog(Context ctx, String msg, final IDialogOnClickListener onClickListener){
        showYesOrNoDialog(ctx,null,msg,onClickListener);
    }

    public static void showYesOrNoDialog(Context ctx, String title, String msg, final IDialogOnClickListener onClickListener){
        showDialog(ctx,TYPE_YES_NO,title,msg,onClickListener);
    }

    public static void showDialog(Context ctx,int type,String title, String msg, final IDialogOnClickListener onClickListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        if(!TextUtils.isEmpty(title)){
            builder.setTitle(title);
        }
        builder.setMessage(msg);
        switch (type){
            case TYPE_YES_NO_NEUTRAL:
                builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(null != onClickListener){
                            onClickListener.onNeutral(dialog, which);
                        }
                        dialog.dismiss();
                    }
                });
            case TYPE_YES_NO:
                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(null != onClickListener){
                            onClickListener.onNegative(dialog, which);
                        }
                        dialog.dismiss();
                    }
                });
            case TYPE_MAKE_SURE:
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(null != onClickListener){
                            onClickListener.onPositive(dialog,which);
                        }
                        dialog.dismiss();
                    }
                });
                break;
        }
        builder.create().show();
    }

    public static void showMakeSureDialog(Context ctx, View view, final IDialogOnClickListener onClickListener){
        showMakeSureDialog(ctx,null,view,onClickListener);
    }

    public static void showMakeSureDialog(Context ctx, String title,View view, final IDialogOnClickListener onClickListener){
        showDialog(ctx,TYPE_MAKE_SURE,title,view,onClickListener);
    }

    public static void showYesOrNoDialog(Context ctx, String title, View view, final IDialogOnClickListener onClickListener){
        showDialog(ctx,TYPE_YES_NO,title,view,onClickListener);
    }

    public static void showDialog(Context ctx, int type, String title, View view, final IDialogOnClickListener onClickListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        if(!TextUtils.isEmpty(title)){
            builder.setTitle(title);
        }
        builder.setView(view);
        switch (type){
            case TYPE_YES_NO_NEUTRAL:
                builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(null != onClickListener){
                            onClickListener.onNeutral(dialog, which);
                        }
                        dialog.dismiss();
                    }
                });
            case TYPE_YES_NO:
                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(null != onClickListener){
                            onClickListener.onNegative(dialog, which);
                        }
                        dialog.dismiss();
                    }
                });
            case TYPE_MAKE_SURE:
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(null != onClickListener){
                            onClickListener.onPositive(dialog,which);
                        }
                        dialog.dismiss();
                    }
                });
                break;
        }
        builder.create().show();
    }
}
