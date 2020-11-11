package java0.conc0303;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Homework03 {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        //这是得到的返回值
        int result = getResult1();
//        int result = getResult2();
//        int result = getResult3();
//        int result = getResult4();
//        int result = getResult5();


        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    /**
     * 提交任务到线程池，
     * 通过Future.get()方法获取执行结果
     *
     * @return
     */
    private static int getResult1() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //提交任务到线程池
        Future<Integer> future = executorService.submit(Homework03::sum);
        executorService.shutdown();

        return future.get();
    }

    /**
     * 通过FutureTask包装要执行的任务，将FutureTask作为任务传给单个线程、线程池
     * 然后调用FutureTask.get()获取执行结果
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static int getResult2() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(Homework03::sum);
        new Thread(futureTask).start();

        return futureTask.get();
    }

    /**
     * 根据信号量工具类同步主线程与子线程/线程池中线程，使主线程等待子线程/线程池中线程执行完才结束，执行结果通过共享内存同步
     *
     * @return
     * @throws InterruptedException
     */
    private static int getResult3() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(0);
        final Result result = new Result();
        new Thread(() -> {
            int sum = sum();
            result.setResult(sum);
            semaphore.release();
        }).start();

        semaphore.acquire();

        return result.result;
    }

	/**
	*在主线程中构造count为1的CountDownLatch并countDownLatch.await()，在子线程/线程池中则执行完成方法后，
	*将执行结果放入共享对象中并countDownLatch.countDown()
	*/
    private static int getResult4() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        final Result result = new Result();
        new Thread(() -> {
            int sum = sum();
            result.setResult(sum);
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        return result.result;
    }

	/**
	*通过synchronized+共享对象+wait()/notifyAll()，实现主线程和子线程之间结果的同步；
	*/
    private static int getResult5() throws InterruptedException {
        final Result result = new Result();

        new Thread(() -> {
            synchronized (result) {
                int sum = sum();
                result.setResult(sum);
                result.notifyAll();
            }
        }).start();

        synchronized (result) {
            result.wait();

            return result.result;
        }
    }

 
    private static int sum() {
       return fibo(39);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    private static class Result {
        private int result;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }
}