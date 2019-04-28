/**
 * 订单号生成器
 * 20160105 add by 梁华山
 * 使用方法：
 * IdWorker idWorker = IdWorker.getInstance();
 * idWorker.nextId();
 */
package com.moda.util.uuid;

import java.util.Random;

public class IdWorker {
	
	private static IdWorker instance = null;
	
	private final long workerId;
	private final static long twepoch = 1361753741828L;
	private long sequence = 0L;
	private final static long workerIdBits = 4L;
	private final static long maxWorkerId = -1L ^ -1L << workerIdBits;
	private final static long sequenceBits = 10L;

	private final static long workerIdShift = sequenceBits;
	private final static long timestampLeftShift = sequenceBits + workerIdBits;
	private final static long sequenceMask = -1L ^ -1L << sequenceBits;

	private long lastTimestamp = -1L;

	public static IdWorker getInstance() {
		if (instance == null) {
			Random rand = new Random();
			int workerId = rand.nextInt(16);
			instance = new IdWorker(workerId);
		}
		return instance;
	}
	
	private IdWorker(final long workerId) {
		super();
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}
		this.workerId = workerId;
	}

	public synchronized long nextId() {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & sequenceMask;
			if (this.sequence == 0) {
				System.out.println("###########" + sequenceMask);
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		} else {
			this.sequence = 0;
		}
		if (timestamp < this.lastTimestamp) {
			try {
				throw new Exception(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
						this.lastTimestamp - timestamp));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.lastTimestamp = timestamp;
		long nextId = ((timestamp - twepoch << timestampLeftShift)) | (this.workerId << workerIdShift)
				| (this.sequence);
		return nextId;
	}

	private long tilNextMillis(final long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}

}
