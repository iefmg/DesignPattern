package com.gary.observer.subscribe;

import java.util.Observable;
import java.util.Observer;

/**
 * @author gefengming
 *
 * 观察者 读者
 *
 * @date 17/5/21
 */
public class Reader implements Observer{

    private String name;

    public Reader(String readerName){
        super();
        this.name = readerName;
    }

    //订阅
    public void subscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).addObserver(this);
    }

    //取消订阅
    public void unsubscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).deleteObserver(this);
    }

    //实现读者收到通知
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Writer) {
            Writer writer = (Writer) o;
            System.out.println(name+"知道" + writer.getName() + "发布了新书《" + writer.getNovel() + "》，非要去看！");
        }
    }
}
