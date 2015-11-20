package com.aniu.mvpexample.app.buy_flower;


import android.os.Handler;

/**
 * Created by aniu on 15/11/19.
 */
public class IBuyFlowerInteractorImpl implements IBuyFlowerInteractor {
    private int num = 100; //我是从网络上获取来的
    @Override
    public void buyFlower(final int num, final OnBuyFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                try{
                    minusFlowerNum(num);
                    listener.onBuySuccess();
                }catch (Exception e){
                    listener.onBuyError();
                }

            }
        }, 3000);
    }

    @Override
    public int getFlowerNum() {
        return num;
    }

    public void minusFlowerNum(int num) {
         //int minusError = 1/0;  //模拟购买失败
         this.num -= num;
    }
}
