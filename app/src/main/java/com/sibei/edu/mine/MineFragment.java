package com.sibei.edu.mine;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.sibei.edu.R;
import com.sibei.edu.user.UserManager;
import com.sibei.edu.user.UserPreferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:我的界面
 */
public class MineFragment extends Fragment {


    @BindView(R.id.mine_avatar)
    CircleImageView mineAvatar;
    @BindView(R.id.mine_nickname)
    TextView mineNickname;
    Unbinder unbinder;

    public MineFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        mineNickname.setText(UserPreferences.getNICKNAME());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.mine_exit)
    public void onViewClicked() {
        new MaterialDialog.Builder(getActivity())
                .content("确定退出EDU嘛?")
                .contentColor(ContextCompat.getColor(getActivity(),R.color.black_353535))
                .positiveColor(ContextCompat.getColor(getActivity(),R.color.blue_0283DF))
                .positiveText("确定")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        UserManager.clearCache();
                        getActivity().finishAffinity();
                    }
                })
                .negativeColor(ContextCompat.getColor(getActivity(),R.color.grey_b2b2b2))
                .negativeText("取消")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                }).build().show();

    }
}
