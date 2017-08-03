package com.sibei.edu.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sibei.edu.R;
import com.sibei.edu.home.bean.CourseBean;
import com.sibei.edu.home.interfaces.OnItemClickListener;
import com.sibei.edu.image.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/20
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:课程列表适配器
 */


public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {

    private List<CourseBean.InfoBean.CourseListBean> mList;
    private Context context;
    private OnItemClickListener listener;

    public CourseListAdapter(List<CourseBean.InfoBean.CourseListBean> course_list) {
        this.mList = course_list;
    }

    public void refreshData(List<CourseBean.InfoBean.CourseListBean> course_list){
        if(mList!=null){
            mList.clear();
            mList.addAll(course_list);
            notifyDataSetChanged();
        }
    }

    public void loadData(List<CourseBean.InfoBean.CourseListBean> course_list){
        if(mList!=null){
            mList.addAll(course_list);
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_course_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemTitle.setText(mList.get(position).getName());
        ImageLoader.getInstance().load(context,mList.get(position).getVideo_pic(),holder.itemIcon);
        holder.itemContent.setText("主讲教师:"+mList.get(position).getLecturer_name());
        holder.itemContentExtra.setText(mList.get(position).getLecturer_info());
        holder.itemReadNums.setText(mList.get(position).getView_num()+"人观看");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.OnItemClick(mList.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_icon)
        ImageView itemIcon;
        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.item_read_nums)
        TextView itemReadNums;
        @BindView(R.id.item_content)
        TextView itemContent;
        @BindView(R.id.item_content_extra)
        TextView itemContentExtra;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
