package me.zhous.objectpool.pool;

/**
 * <p>Title: TestObject</p>
 * <p>Description: TestObject</p>
 * <p>Copyright (c) 2016 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 *
 * @author zhouweida
 * @date: 2016-09-23
 * @time: 11:03
 */
public class TestObject {

    private String name;
    private int count;
    private int iMax[];

    public TestObject(String n,int c){
        // 创建一个10M的内存占用，引起内存抖动，比较是否使用对象池的区别
        iMax = new int[32768 * 10];
        reset(n,c);
    }

    public void reset(String n,int c){
        this.name = n;
        this.count = c;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

}
