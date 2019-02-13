package com.zjh.administrat.annotation_text2;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME )
public @interface MyAnnotation {
    //属性
    String name() ;
}
