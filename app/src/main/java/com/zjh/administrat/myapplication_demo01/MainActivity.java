package com.zjh.administrat.myapplication_demo01;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SimpleDraweeView icon_round_simple,icon_circle_simple,icon_scale_simple,icon_step_simple;
    private SimpleDraweeView icon_cache_simple,icon_gif_simple,icon_listener_simple,icon_okhttp_simple;
    private Button icon_round,icon_circle,icon_scale,icon_step,icon_cache,icon_gif,icon_listener,icon_okhttp;
    private Uri uri;
    private Uri gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /*
    *   初始化View
    * */
    private void initView() {
        //simpledraweeView资源id
        icon_round_simple = findViewById(R.id.icon_round_simple);
        icon_circle_simple = findViewById(R.id.icon_circle_simple);
        icon_scale_simple = findViewById(R.id.icon_scale_simple);
        icon_step_simple = findViewById(R.id.icon_step_simple);
        icon_cache_simple = findViewById(R.id.icon_cache_simple);
        icon_gif_simple = findViewById(R.id.icon_gif_simple);
        icon_listener_simple = findViewById(R.id.icon_listener_simple);
        icon_okhttp_simple = findViewById(R.id.icon_okhttp_simple);

        //按钮的资源id
        icon_round = findViewById(R.id.icon_round); //圆角
        icon_circle = findViewById(R.id.icon_circle); //圆形
        icon_scale = findViewById(R.id.icon_scale); //比例1.2
        icon_step = findViewById(R.id.icon_step); //渐进式
        icon_cache = findViewById(R.id.icon_cache); //磁盘缓存
        icon_gif = findViewById(R.id.icon_gif); //加载动图
        icon_listener = findViewById(R.id.icon_listener); //加载监听
        icon_okhttp = findViewById(R.id.icon_okhttp); //配置okhttp

        icon_round.setOnClickListener(this);
        icon_circle.setOnClickListener(this);
        icon_scale.setOnClickListener(this);
        icon_step.setOnClickListener(this);
        icon_cache.setOnClickListener(this);
        icon_gif.setOnClickListener(this);
        icon_listener.setOnClickListener(this);
        icon_okhttp.setOnClickListener(this);

        uri = Uri.parse("http://img4.imgtn.bdimg.com/it/u=2183681910,73882324&fm=26&gp=0.jpg");
        gif = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535551551658&di=934935e17256ee57ed0416598b78154e&imgtype=0&src=http%3A%2F%2Fs6.sinaimg.cn%2Fmw690%2F0062ywFUgy6Y2pBG8Vn65%26690");

    }


    /*
    *   点击事件监听
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icon_round:
                icon_round_simple.setImageURI(uri);
                //控制显示隐藏图片
                icon_round_simple.setVisibility(View.VISIBLE);
                icon_circle_simple.setVisibility(View.GONE);
                icon_scale_simple.setVisibility(View.GONE);
                icon_step_simple.setVisibility(View.GONE);
                icon_cache_simple.setVisibility(View.GONE);
                icon_gif_simple.setVisibility(View.GONE);
                icon_listener_simple.setVisibility(View.GONE);
                icon_okhttp_simple.setVisibility(View.GONE);
                break;
            case R.id.icon_circle:
                icon_circle_simple.setImageURI(uri);
                //控制显示隐藏图片
                icon_round_simple.setVisibility(View.GONE);
                icon_circle_simple.setVisibility(View.VISIBLE);
                icon_scale_simple.setVisibility(View.GONE);
                icon_step_simple.setVisibility(View.GONE);
                icon_cache_simple.setVisibility(View.GONE);
                icon_gif_simple.setVisibility(View.GONE);
                icon_listener_simple.setVisibility(View.GONE);
                icon_okhttp_simple.setVisibility(View.GONE);
                break;
            case R.id.icon_scale:
                icon_scale_simple.setImageURI(uri);
                //控制显示隐藏图片
                icon_round_simple.setVisibility(View.GONE);
                icon_circle_simple.setVisibility(View.GONE);
                icon_scale_simple.setVisibility(View.VISIBLE);
                icon_step_simple.setVisibility(View.GONE);
                icon_cache_simple.setVisibility(View.GONE);
                icon_gif_simple.setVisibility(View.GONE);
                icon_listener_simple.setVisibility(View.GONE);
                icon_okhttp_simple.setVisibility(View.GONE);
                break;
            case R.id.icon_step:
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                        //图片地址
                        .setUri(uri)
                        .setAutoPlayAnimations(true)
                        //点击重新加载时 可以重新加载4 次
                        .setTapToRetryEnabled(true)
                        .build();
                GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        .setFadeDuration(5000)
                        .build();
                icon_step_simple.setHierarchy(hierarchy);
                icon_step_simple.setController(controller);
                //控制显示隐藏图片
                icon_round_simple.setVisibility(View.GONE);
                icon_circle_simple.setVisibility(View.GONE);
                icon_scale_simple.setVisibility(View.GONE);
                icon_step_simple.setVisibility(View.VISIBLE);
                icon_cache_simple.setVisibility(View.GONE);
                icon_gif_simple.setVisibility(View.GONE);
                icon_listener_simple.setVisibility(View.GONE);
                icon_okhttp_simple.setVisibility(View.GONE);

                break;
            case R.id.icon_cache:

                break;
            case R.id.icon_gif:
                DraweeController draweeController =
                        Fresco.newDraweeControllerBuilder()
                                .setUri(gif)
                                .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                                .build();
                icon_gif_simple.setController(draweeController);
                //控制显示隐藏图片
                icon_round_simple.setVisibility(View.GONE);
                icon_circle_simple.setVisibility(View.GONE);
                icon_scale_simple.setVisibility(View.GONE);
                icon_step_simple.setVisibility(View.GONE);
                icon_cache_simple.setVisibility(View.GONE);
                icon_gif_simple.setVisibility(View.VISIBLE);
                icon_listener_simple.setVisibility(View.GONE);
                icon_okhttp_simple.setVisibility(View.GONE);
                break;
            case R.id.icon_listener:

                break;
            case R.id.icon_okhttp:

                break;
            default:
                break;
        }

    }


}
