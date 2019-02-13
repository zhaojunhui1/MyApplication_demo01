package com.zjh.administrat.annotation_text2;


public class DraweeViewAnnotation {

    @MyAnnotation(name = "我是设置的值:Hello world")
    public void execute(){
        System.out.println("走过");
    }


}
