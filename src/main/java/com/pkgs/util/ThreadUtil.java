package com.pkgs.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 16:11
 * <p>
 * since: 1.0.0
 */
public class ThreadUtil {

    public static class CustomerThreadFactory implements ThreadFactory {
        private AtomicInteger counter = new AtomicInteger(1);
        private String prefix;

        public CustomerThreadFactory(String prefix) {
            this.prefix = prefix;
        }


        @Override
        public Thread newThread(Runnable r) {
            String threadName = prefix + "-" + counter.getAndIncrement();
            return new Thread(r, threadName);
        }
    }


    public static ExecutorService fixedPool(String prefix, int threadNum) {
        CustomerThreadFactory factory = new CustomerThreadFactory(prefix);
        return new ThreadPoolExecutor(
                threadNum,
                threadNum,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                factory);
    }
}
