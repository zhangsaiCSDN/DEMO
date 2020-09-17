package com.example.studyThread;

import com.example.zhujie.PersonConfig;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;


public class FileDowloadThread extends Thread{
    private String url;
    private String name;
    public static int at ;

    public FileDowloadThread(String url, String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public  void run() {

        fileDow(url,name);
        at++;
        System.out.println(name+"下载结束:>"+at);
    }

    private  void fileDow(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class DowLoadTest{
    public static void main(String[] args) {

        for(int i = 0;i<1000;i++){
            new FileDowloadThread("https://img-blog.csdnimg.cn/20200911152522422.jpg","C:\\Users\\admin\\Music\\music\\"+i+".jpg").start();
        }
    }
}
