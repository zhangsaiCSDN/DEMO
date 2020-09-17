package com.example.studyThread;

import jdk.internal.dynalink.beans.StaticClass;
import lombok.Synchronized;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


public class MyCallable implements Callable<String> {
    private String url;
    private String name;

    public MyCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return fileDow(url, name);
    }

    public String fileDow(String url,String name ){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
            return name.substring(name.lastIndexOf("~")+1,name.length()-1)+"下载完成";
        } catch (IOException e) {
            e.printStackTrace();
            return name.substring(name.lastIndexOf("~")+1,name.length()-1)+"下载失败";
        }
    }
}


class  MycallableTest{
    public static void main(String[] args) throws Exception{
        ExecutorService ex = Executors.newFixedThreadPool(10);
         List<String> resultList = new ArrayList<>();
        for(int i = 0;i<1000;i++){
            Future<String> str = ex.submit(new MyCallable("https://img-blog.csdnimg.cn/20200911152522422.jpg", "C:\\Users\\admin\\Music\\music\\~" + i + ".jpg"));
            resultList.add(str.get());
        }
        System.out.println(resultList);
        ex.shutdownNow();

    }
}