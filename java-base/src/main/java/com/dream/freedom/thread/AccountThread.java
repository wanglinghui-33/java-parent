package com.dream.freedom.thread;

/**
 * 多个线程对取款账号进行多线程并发操作
 */
public class AccountThread extends Thread {

    private Account account;


    public AccountThread(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withDram2(5000);

    }
}
