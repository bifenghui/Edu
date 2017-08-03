package com.sibei.edu.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sibei.edu.R;
import com.sibei.edu.home.bean.HomeBean;
import com.sibei.edu.image.ImageLoader;

import java.util.List;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/19
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:首页扩展ListView适配器
 */


public class ExpandAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "ExpandAdapter";

    private List<HomeBean.InfoBean.ClassListBean> class_list;

    public ExpandAdapter(List<HomeBean.InfoBean.ClassListBean> class_list) {
        this.class_list = class_list;
    }

    @Override
    public int getGroupCount() {
        //获取列表组的数量
        return class_list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //获取对应组的下的子元素数量
        return class_list.get(groupPosition).getNext_list().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return class_list.get(groupPosition);
    }

    @Override
    public HomeBean.InfoBean.ClassListBean.NextListBean getChild(int groupPosition, int childPosition) {
        return class_list.get(groupPosition).getNext_list().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_group_item, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.group_name = (TextView) convertView.findViewById(R.id.group_name);
            groupViewHolder.grop_arrow = (ImageView) convertView.findViewById(R.id.grop_arrow);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder= (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.group_name.setText(class_list.get(groupPosition).getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_group_child_item, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.child_text = (TextView) convertView.findViewById(R.id.child_text);
            childViewHolder.child_icon = (ImageView) convertView.findViewById(R.id.child_icon);
            convertView.setTag(childViewHolder);
        }else {
            childViewHolder= (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.child_text.setText(class_list.get(groupPosition).getNext_list().get(childPosition).getName());
        ImageLoader.getInstance().load(parent.getContext(),class_list.get(groupPosition).getNext_list().get(childPosition).getSource_pic(),
                childViewHolder.child_icon);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class GroupViewHolder{
        private TextView group_name;
        private ImageView grop_arrow;
    }

    private static class ChildViewHolder{
        private ImageView child_icon;
        private TextView child_text;
    }

}
