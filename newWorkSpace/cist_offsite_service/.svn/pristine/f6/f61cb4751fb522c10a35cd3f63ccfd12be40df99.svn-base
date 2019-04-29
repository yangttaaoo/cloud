package com.cist.core.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


public final class ThreadPoolManager {
	
	private static final ExecutorService writeEventDispatcher = Executors.newFixedThreadPool(1);
	
	private static final AtomicBoolean lock = new AtomicBoolean();
	
	public static boolean dispatch(Runnable r){
		if(lock.get())
		{
			return false;
		}
		lock.compareAndSet(false,true);
		writeEventDispatcher.execute(r);
		return true;
	}
	
	public static void unlock()
	{
		if(lock.get())
		{
			lock.compareAndSet(true,false);
		}
	}
}
