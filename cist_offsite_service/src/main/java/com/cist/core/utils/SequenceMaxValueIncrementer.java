package com.cist.core.utils;

import java.util.concurrent.atomic.AtomicLong;

public enum SequenceMaxValueIncrementer{

	INSTANCE;
	
	private final AtomicLong sequence=new AtomicLong();
	
	
	public long getNextKey() {
		// TODO Auto-generated method stub
		sequence.weakCompareAndSet(Long.MAX_VALUE, 0);
		return sequence.incrementAndGet();
	}

}
