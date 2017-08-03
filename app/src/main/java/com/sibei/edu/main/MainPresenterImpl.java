package com.sibei.edu.main;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:MainActivity的控制层实现
 */


public class MainPresenterImpl implements MainPresenter{

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void changeFragments(int index) {
        switch (index){
            case 0:
                if(mainView!=null){
                    mainView.setBottomBarHomeSelected();
                    mainView.showHomeFragment();
                }
                break;
            case 1:
                if(mainView!=null){
                    mainView.setBottomBarMineSelected();
                    mainView.showMineFragment();
                }
                break;
        }
    }
}
