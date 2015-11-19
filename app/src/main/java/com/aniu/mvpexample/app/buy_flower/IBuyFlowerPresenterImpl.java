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
        buyFlowerInteractor.buyFlower(num);
        buyFlowerView.buySuccess();
    }

    @Override
    public int getFlowerNum() {
        return buyFlowerInteractor.getFlowerNum();
    }
}
