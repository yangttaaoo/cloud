package com.Threed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.rabbitmq.tools.json.JSONUtil;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String str="{\"date1\":\"2018-10-12 15:03:20\"}";
        JSONObject obj= new JSONObject().fromObject(str);
        String [] dateFormats=new  String[] {"yyyy-MM-dd HH:mm:ss"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        User user=(User)JSONObject.toBean(obj, User.class);
        System.out.println(user.toString());
/*        ExecutorService newFixedThreadPool = newFixedThreadPool(5);
        System.out.println(newFixedThreadPool);*/
    }
    //构造一个固定线程数目的线程池
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
    //构造一个缓冲线程池
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
}
