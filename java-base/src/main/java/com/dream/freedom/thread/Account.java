package com.dream.freedom.thread;

/**
 * 多线程并发
 */
public class Account {

    private String no;

    private double balance;


    public Account() {

    }

    public Account(String no, double balance) {
        this.no = no;
        this.balance = balance;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 取款
     * 如果多个线程来调用，就会出现线程安全问题，比如账号只有10000元，
     * 多个线程来调用，最后竟然可以取走
     *
     * @param money 取款数量
     */
    public void withDram(double money) {
        double before = this.balance;
        double bacan = before - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setBalance(bacan);
    }

    /**
     * 为了线程安全，要加上线程排队
     *
     *
     *
     * @param money
     */
    public void withDram2(double money) {
        // 像这种写法，因为字符串是常量池中的，所以，任何线程进来都会等待
        //synchronized ("abc"){
        // synchronized 小括号里面要写多线程共享的对象
        synchronized (this) {
            // 这里面是要同步的代码块
            double before = this.balance;
            double bacan = before - money;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(bacan);

            System.out.println("线程" + Thread.currentThread().getName() + "取款成功，余额:" + this.getBalance());
        }


    }

}
