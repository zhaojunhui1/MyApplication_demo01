package com.zjh.administrat.annotation_text2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

   // @DraweeViewAnnotation(name = "Hello world") //自定义注解
    @BindView(R.id.getValues)
    Button mgetValues;
    @BindView(R.id.addList)
    Button maddList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定关联当前类
        ButterKnife.bind(this);
    }



    @OnClick({R.id.getValues, R.id.addList})//使用ButterKnife
    public void getAnnotation(View view) {//点击注解值，进行吐丝
        switch (view.getId()){
            case R.id.getValues:
               // Toast.makeText(this, "获取注解值", Toast.LENGTH_SHORT).show();

                DraweeViewAnnotation draweeViewAnnotation=new DraweeViewAnnotation();
                Class<DraweeViewAnnotation> c=DraweeViewAnnotation.class;
                try {
                    Method method = c.getMethod("execute",new Class[]{});
                    if(method.isAnnotationPresent(MyAnnotation.class)){
                        MyAnnotation myAnnotation=method.getAnnotation(MyAnnotation.class);
                        try {
                            //利用反射获取值
                            method.invoke(draweeViewAnnotation,new Object[]{});
                            myAnnotation.name();
                            Toast.makeText(MainActivity.this, myAnnotation.name(), Toast.LENGTH_SHORT).show();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.addList:
                //Toast.makeText(this, "反射添加集合", Toast.LENGTH_SHORT).show();
                ArrayList<String> list = new ArrayList<>();
                list.add("添加List集合:String类型");
                Class<?> clz = list.getClass();
                try {
                    Method method = clz.getMethod("add", Object.class);
                    method.invoke(list, 100);

                    Toast.makeText(this, list+"", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

        /*Field[] fields = StartActivity.class.getDeclaredFields();
        for (Field filed : fields) {
            if (filed.isAnnotationPresent(DraweeViewAnnotation.class)) {
                DraweeViewAnnotation annotation = filed.getAnnotation(DraweeViewAnnotation.class);

                Toast.makeText(this, annotation.name(), Toast.LENGTH_SHORT).show();
            }
        }*/

    }



}
