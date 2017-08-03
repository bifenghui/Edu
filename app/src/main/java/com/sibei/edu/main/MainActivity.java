package com.sibei.edu.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sibei.edu.R;
import com.sibei.edu.base.ToolbarActivity;
import com.sibei.edu.home.HomeFragment;
import com.sibei.edu.mine.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ToolbarActivity implements MainView{
    private static final String TAG = "MainActivity";
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.bottom_bar_home_icon)
    ImageView bottomBarHomeIcon;
    @BindView(R.id.bottom_bar_home_text)
    TextView bottomBarHomeText;
    @BindView(R.id.bottom_bar_mine_icon)
    ImageView bottomBarMineIcon;
    @BindView(R.id.bottom_bar_mine_text)
    TextView bottomBarMineText;

    private HomeFragment homeFragment;
    private MineFragment mineFragment;
    private MainPresenter mainPresenter;

    public static void start(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.changeFragments(0);
    }

    @OnClick({R.id.bottom_bar_home, R.id.bottom_bar_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bottom_bar_home:
                mainPresenter.changeFragments(0);
                break;
            case R.id.bottom_bar_mine:
                mainPresenter.changeFragments(1);
                break;
        }
    }


    @Override
    public void setBottomBarHomeSelected() {
        setTitle("EDU");
        bottomBarHomeIcon.setImageResource(R.drawable.ic_home_pressed);
        bottomBarHomeText.setTextColor(getResources().getColor(R.color.blue_0283DF));
        bottomBarMineIcon.setImageResource(R.drawable.ic_mine);
        bottomBarMineText.setTextColor(getResources().getColor(R.color.grey_cccccc));
    }

    @Override
    public void setBottomBarMineSelected() {
        setTitle("我的");
        bottomBarMineIcon.setImageResource(R.drawable.ic_mine_pressed);
        bottomBarMineText.setTextColor(getResources().getColor(R.color.blue_0283DF));
        bottomBarHomeIcon.setImageResource(R.drawable.ic_home);
        bottomBarHomeText.setTextColor(getResources().getColor(R.color.grey_cccccc));
    }

    @Override
    public void showHomeFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.main_container, homeFragment, HomeFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    public void showMineFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mineFragment = new MineFragment();
        fragmentTransaction.replace(R.id.main_container, mineFragment, MineFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
