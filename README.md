###MyModel 演示：


![Gif图片已丢失](https://github.com/zhaolewei/MyModel/Gif.gif)

<hr/>
###扩展库的应用方法：
##myrecyclerview-lib ： 上拉刷新下拉加载的RecycleView

#0.导入类库并在build.gadler中引用该类库，并在app:中引入该库（ctrl+shift+alt+s）


#1.把RecycleView的布局文件和类对象类型更改为PullLoadMoreRecyclerView
    <com.zlw.pullloadmorerecyclerview.PullLoadMoreRecyclerView
        android:id="@+id/pullLoadMoreRecyclerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp" />
        
    private PullLoadMoreRecyclerViewtuan_rv;
注：PullLoadMoreRecyclerView  不需要setLayoutManager

#2.设置PullLoadMoreRecyclerView加载参数
```java
    
mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) view.findViewById(R.id.pullLoadMoreRecyclerView);
// mPullLoadMoreRecyclerView.setRefreshing(true);//设置下拉刷新是否可见
//mPullLoadMoreRecyclerView.setPullRefreshEnable(false);//设置是否下拉刷新
//mPullLoadMoreRecyclerView.setPushRefreshEnable(false);//设置是否上拉刷新
mPullLoadMoreRecyclerView.setFooterViewText("正在加载...");//设置上拉刷新文字
mPullLoadMoreRecyclerView.setLinearLayout();
//设置监听事件
mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());
mPullLoadMoreRecyclerView.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.empty_view, null));//setEmptyView
```

#3.回调监听
```java
class PullLoadMoreListener implements PullLoadMoreRecyclerView.PullLoadMoreListener {
/**
     * 上拉刷新回调
     */
@Override
public void onRefresh() { }

/**
     * 下拉加载回调
     */
@Override
public void onLoadMore() {}
}
```
4.完成刷新效果
```java
mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
```






<hr>
 |               email: 739043667@qq.com
                 address：https://github.com/zhaolewei/MyModel