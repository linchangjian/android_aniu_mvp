package com.aniu.mvpexample.app.buy_flower;

/**
 * Created by aniu on 15/11/19.
 */
interface IBuyFlowerView {
    //负责ui 进度 、提示、跳转提供操作接口
    public void showProgress();
    public void hideProgress();
    public void nevigateToHome();
    public void buyError();
    public void buySuccess();

}
