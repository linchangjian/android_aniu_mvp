package com.aniu.mvpexample.app.buy_flower;

/**
 * Created by aniu on 15/11/19.
 */
public class IBuyFlowerPresenterImpl implements IBuyFlowerPresenter {

    private IBuyFlowerView buyFlowerView;
    private IBuyFlowerInteractor buyFlowerInteractor;

    public IBuyFlowerPresenterImpl(IBuyFlowerView buyFlowerView){
        this.buyFlowerView = buyFlowerView;
        buyFlowerInteractor = new IBuyFlowerInteractorImpl();
    }

    @Override
    public void buyFlower(int num) {
        //买的时候显示进度
        buyFlowerView.showProgress();

        //...此处递交给model层处理数据
        buyFlowerInteractor.buyFlower(num, new OnBuyFinishedListener() {
            @Override
            public void onBuySuccess() {
                buyFlowerView.buySuccess();
                buyFlowerView.hideProgress();

            }

            @Override
            public void onBuyError() {
                buyFlowerView.buyError();
                buyFlowerView.hideProgress();
            }
        });

    }
    @Override
    public int getFlowerNum() {
        //..此处递交给model层处理数据，然后返回数量
        return buyFlowerInteractor.getFlowerNum();
    }


}
