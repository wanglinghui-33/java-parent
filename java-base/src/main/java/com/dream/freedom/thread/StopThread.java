package com.dream.freedom.thread;

/**
 * 合理的终止线程
 */
public class StopThread implements Runnable{

    // 采用标记的方式中断线程
    private boolean is_flat = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (is_flat){
                System.out.println(Thread.currentThread().getName() + "--->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                // 进入这里，说明线程中断，在这里要把剩下的数据处理掉，就不会造成数据丢失
                // 比如：保存或者修改
                return;
            }
        }
    }

    public boolean isIs_flat() {
        return is_flat;
    }

    public void setIs_flat(boolean is_flat) {
        this.is_flat = is_flat;
    }
}
