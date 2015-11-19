package com.aniu.mvpexample.app.buy_flower;

/**
 * Created by aniu on 15/11/19.
 */
public class IBuyFlowerInteractorImpl implements IBuyFlowerInteractor {
    private int num = 100;
    @Override
    public void buyFlower(int num) {
        this.num -= num;
    }

    @Override
    public int getFlowerNum() {
        return num;
    }
}
