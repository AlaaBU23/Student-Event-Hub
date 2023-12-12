package StudentEventHub.tools;

public class SnowFlakeHelper {
    private long workerId;
    private long datacenterId;
    //12-digit serial number
    private long sequence;

    public SnowFlakeHelper(long workerId, long datacenterId, long sequence) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    //initial timestamp
    private long twepoch = 1288834974657L;

    //5 digits in length
    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    //maximum values
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    //Serial number id length
    private long sequenceBits = 12L;
    //Serial Number Maximum
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    //Number of bits to be shifted left for the job id, 12 bits
    private long workerIdShift = sequenceBits;
    //Data id needs to be shifted left by 12+5=17 bits
    private long datacenterIdShift = sequenceBits + workerIdBits;
    //Timestamps need to be shifted left by a number of bits 12+5+5=22 bits
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    //Last timestamp, initial value is negative
    private long lastTimestamp = -1L;

    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    //ID generation algorithm
    public synchronized long genId() {
        long timestamp = timeGen();

        //If the current timestamp is less than the last timestamp, then there is an exception in the timestamp acquisition.
        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        /**
         * Get the current timestamp if it is equal to the last timestamp (within the same millisecond),
         * then add one to the sequence number;
         * otherwise the sequence number is assigned to 0, starting from 0.
         */
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        //refresh the timestamp
        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    //get new timestamp and compare to the last timestamp
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    //get System Time
    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowFlakeHelper worker = new SnowFlakeHelper(1, 1, 1);
        for (int i = 0; i < 30; i++) {
            System.out.println(worker.genId());
        }
    }
}