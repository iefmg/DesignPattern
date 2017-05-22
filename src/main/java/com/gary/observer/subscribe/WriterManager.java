package com.gary.observer.subscribe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gefengming
 *
 * 作者管理
 *
 * @date 17/5/21
 */
public class WriterManager {

    private Map<String, Writer> writerMap = new HashMap<>();

    public void addWriter(Writer writer){
        writerMap.put(writer.getName(), writer);
    }

    public Writer getWriter(String name){
        return writerMap.get(name);
    }

    public WriterManager(){
    }

    public static WriterManager getInstance(){
        return WriterManagerInstance.instance;
    }

    private static class WriterManagerInstance {
        public static WriterManager instance = new WriterManager();
    }
}
