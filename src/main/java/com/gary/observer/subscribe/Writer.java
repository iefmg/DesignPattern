package com.gary.observer.subscribe;

import java.util.Observable;

/**
 * @author gefengming
 *
 * 被观察者 作者
 *
 * @date 17/5/21
 */
public class Writer extends Observable{

    private String name;

    private String novel;

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().addWriter(this);
    }

    //添加书籍
    public void addNovel(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》！");
        this.novel = novel;
        //修改状态
        setChanged();
        //通知观察者
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public String getNovel() {
        return novel;
    }
}
