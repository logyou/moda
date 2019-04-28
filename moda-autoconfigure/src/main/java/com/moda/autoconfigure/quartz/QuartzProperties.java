package com.moda.autoconfigure.quartz;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Quartz 配置信息
 *
 * @author lyh
 * @create 2018/09/02 23:26
 **/
@ConfigurationProperties(prefix = "org.quartz")
public class QuartzProperties {
    private final Scheduler scheduler = new Scheduler();
    private final ThreadPool threadPool = new ThreadPool();
    private final JobStore jobStore = new JobStore();

    public Scheduler getScheduler() {
        return scheduler;
    }

    public ThreadPool getThreadPool() {
        return threadPool;
    }

    public JobStore getJobStore() {
        return jobStore;
    }

    public static class Scheduler {
        private String instanceName;
        private String instanceId;

        public String getInstanceName() {
            return instanceName;
        }

        public void setInstanceName(String instanceName) {
            this.instanceName = instanceName;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }
    }

    public static class ThreadPool {
        private String className;
        private Integer threadCount;
        private Integer threadPriority;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public Integer getThreadCount() {
            return threadCount;
        }

        public void setThreadCount(Integer threadCount) {
            this.threadCount = threadCount;
        }

        public Integer getThreadPriority() {
            return threadPriority;
        }

        public void setThreadPriority(Integer threadPriority) {
            this.threadPriority = threadPriority;
        }
    }

    public static class JobStore {
        private String className;
        private Boolean isClustered;
        private Integer clusterCheckinInterval;
        private Integer maxMisfiresToHandleAtATime;
        private Integer misfireThreshold;
        private String tablePrefix;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public Boolean getIsClustered() {
            return isClustered;
        }

        public void setIsClustered(Boolean isClustered) {
            this.isClustered = isClustered;
        }

        public Integer getClusterCheckinInterval() {
            return clusterCheckinInterval;
        }

        public void setClusterCheckinInterval(Integer clusterCheckinInterval) {
            this.clusterCheckinInterval = clusterCheckinInterval;
        }

        public Integer getMaxMisfiresToHandleAtATime() {
            return maxMisfiresToHandleAtATime;
        }

        public void setMaxMisfiresToHandleAtATime(Integer maxMisfiresToHandleAtATime) {
            this.maxMisfiresToHandleAtATime = maxMisfiresToHandleAtATime;
        }

        public Integer getMisfireThreshold() {
            return misfireThreshold;
        }

        public void setMisfireThreshold(Integer misfireThreshold) {
            this.misfireThreshold = misfireThreshold;
        }

        public String getTablePrefix() {
            return tablePrefix;
        }

        public void setTablePrefix(String tablePrefix) {
            this.tablePrefix = tablePrefix;
        }
    }
}
