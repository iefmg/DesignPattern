package com.gary.strategy.calprice;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gefengming
 *
 * 计价策略工厂, 支持单策略
 *
 * @date 17/5/23
 */
public class CalPriceFactory {

    private static final String CAL_RPICE_PACKAGE = "com.gary.strategy.calprice";//策略所在包名

    private ClassLoader classLoader = getClass().getClassLoader();//类加载器

    private List<Class<? extends CalPrice>> calPriceList; //策略列表

    private CalPriceFactory(){
        init();
    }

    /**
     * 自动选择消费者策略
     *
     * 简单工厂模式
     * @param customer
     * @return
     */
    @Deprecated
    public static CalPrice chooseCalPrice(Customer customer) {
        double totalTotal = customer.getTotaltotalAmount();
        System.out.println(totalTotal);
        if (totalTotal <= 3000){
            return new Common();
        } else if (totalTotal <= 6000){
            return new VIP();
        } else if (totalTotal <= 9000){
            return new SuperVIP();
        } else {
            return new GoldVIP();
        }
    }

    /**
     * 自动选择消费者策略
     *
     * 工厂模式优化[注解]
     * @param customer
     * @return
     */
    public CalPrice chooseCalPriceV2(Customer customer) {
        //遍历策略列表
        for(Class<? extends CalPrice> clazz : calPriceList) {
            TotalValidRegion validRegion = handleAnnotation(clazz);
            //策略选择逻辑
            if(customer.getTotaltotalAmount() > validRegion.min() && customer.getTotaltotalAmount() <= validRegion.max()){
                try {
                    return clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    throw new RuntimeException("策略获取失败");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException("策略获取失败");
                }
            }
        }

        throw new RuntimeException("策略获取失败, 没有符合的策略");
    }

    /**
     * 注解解析
     *
     * @return
     */
    TotalValidRegion handleAnnotation(Class<? extends CalPrice> clazz) {

        Annotation[] annotations= clazz.getDeclaredAnnotations();
        if(annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof TotalValidRegion) {
                return (TotalValidRegion) annotations[i];
            }
        }

        return null;
    }

    /**
     * 初始化策略列表
     */
    private void init(){
        calPriceList = new ArrayList<Class<? extends CalPrice>>();
        // 获取策略文件
        File[] resources = getResources();

        Class<CalPrice> calPriceClass = null;//策略接口
        try{
            calPriceClass = (Class<CalPrice>)classLoader.loadClass(CalPrice.class.getName());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        if(null == calPriceClass){
            throw new RuntimeException("策略接口未找到");
        }

        for(int i=0; i<resources.length; i++) {
            try {
                Class<?> clazz = classLoader.loadClass(CAL_RPICE_PACKAGE + "." + resources[i].getName().replace(".class", ""));
                // 父子关系则加入策略列表
                if(CalPrice.class.isAssignableFrom(clazz) && calPriceClass != clazz) {
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取包下class文件
     *
     * @return
     */
    private File[] getResources() {

        try {
            File file = new File(classLoader.getResource(CAL_RPICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(pathname.getName().endsWith(".class")){
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("没找到策略资源");
        }
    }


    //单例模式
    public static CalPriceFactory getInstance() {
        return CalPriceFactoryInstance.instance;
    }

    private static class CalPriceFactoryInstance {
        private static CalPriceFactory instance = new CalPriceFactory();
    }
}
