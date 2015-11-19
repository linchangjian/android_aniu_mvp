package com.aniu.mvpexample.app.buy_flower;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aniu.mvpexample.app.R;


/**
 * Created by aniu on 15/11/19.
 */
public class BuyFlowerActivity extends Activity implements IBuyFlowerView, View.OnClickListener {

    private  EditText buy_et_num;
    private  ProgressBar buy_progress;
    private  IBuyFlowerPresenter buyFlowerPresenter;
    private  TextView buy_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_flower);
        findViewById(R.id.buy_btn).setOnClickListener(this);
        buy_et_num = (EditText) findViewById(R.id.buy_et_num);
        buy_progress = (ProgressBar) findViewById(R.id.buy_progress);
        buy_tv = (TextView)findViewById(R.id.buy_tv);
        buyFlowerPresenter = new IBuyFlowerPresenterImpl(this);
        buy_tv.setText(buyFlowerPresenter.getFlowerNum()+"");
    }

    @Override
    public void showProgress() {
        buy_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        buy_progress.setVisibility(View.GONE);

    }

    @Override
    public void nevigateToHome() {

    }

    @Override
    public void buyError() {

    }

    @Override
    public void buySuccess() {
        buy_et_num.setHint(buyFlowerPresenter.getFlowerNum()+"");
        buy_tv.setText(buyFlowerPresenter.getFlowerNum() + "");

    }

    @Override
    public void onClick(View v) {
        String num = buy_et_num.getText().toString();
        int numInt =Integer.valueOf(num);
        Log.d("BUY NUM", numInt+"");
        buyFlowerPresenter.buyFlower(numInt);
    }
}
