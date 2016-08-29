package com.zlw.mymodel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zlw.mymodel.R;
import com.zlw.mymodel.common.Const;
import com.zlw.mymodel.main.bean.ContentEntity;
import com.zlw.mymodel.utils.ImageLoadManager;
import com.zlw.mymodel.utils.LogUtil;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * RecyclerView数据适配器
 * Created by zlw on 2015/7/2.
 * 外接方法：
 * 1.获取数据：getDataList()
 * 2.重置数据：setDataList()
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<ContentEntity> dataList; //数据信息

    //============数据操作=============

    /**
     * 获取数据
     */
    public List<ContentEntity> getDataList() {
        return dataList;
    }

    /**
     * 设置数据
     */
    public void setDataList(List<ContentEntity> lists) {
        dataList = lists;
    }

    /**
     * 设置数据
     */
    public void removeDataList() {
        dataList.removeAll(dataList);
    }

    public RecyclerViewAdapter(Context context, List<ContentEntity> dataList) {
        this.dataList = dataList;//初始数据
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView img;
        public JCVideoPlayer video;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.data_text);
            img = (ImageView) itemView.findViewById(R.id.data_img);
            video = (JCVideoPlayer) itemView.findViewById(R.id.data_video);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab1_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //加载数据
        holder.text.setText(dataList.get(position).getText());

        if (dataList.get(position).getType() == Const.TYPE_IMAGE) {
            holder.img.setVisibility(View.VISIBLE);
            if (dataList.get(position).getImage3().contains("gif")) {
                ImageLoadManager.loadGif(mContext, dataList.get(position).getImage0(), holder.img);
            } else {
                ImageLoadManager.loadImage(mContext, dataList.get(position).getImage0(), holder.img);
            }
        } else if (dataList.get(position).getType() == Const.TYPE_VIDEO) {
            holder.video.setVisibility(View.VISIBLE);
            holder.video.setUp(dataList.get(position).getVideo_uri(),
                    "http://p.qpic.cn/videoyun/0/2449_ded7b566b37911e5942f0b208e48548d_2/640",
                    "视频播放");
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}