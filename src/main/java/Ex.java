import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Ex {
    public static void main(String[] args) throws InterruptedException {
        BankAccount b = new BankAccount();
        Parent p = new Parent(b);
        Child c = new Child(b);
        p.start();   // start(): 쓰레드를 실행하는 메서드
        c.start();
        p.join();    // join(): 쓰레드가 끝나기를 기다리는 메서드
        c.join();
        System.out.println("\nbalance = " + b.getBalance());
    }
}
class BankAccount {
    // 일반적인 코드 연산의 지연이 없어 0원이 잘 나옴.
/*    int balance;
    void deposit(int amount) {
        balance = balance + amount;
    }
    void withdraw(int amount) {
        System.out.print("-");
        balance = balance - amount;
    }
    int getBalance() {
        return balance;
    }*/

    // 임계 구역의 문제점.
/*int balance;
    void deposit(int amount) {
        int temp = balance + amount;
        System.out.print("+");
        balance = temp;
    }
    void withdraw(int amount) {
        int temp = balance - amount;
        System.out.print("-");
        balance = temp;
    }
    int getBalance() {
        return balance;
    }*/
    // ordering 전 (우선 순위가 없이 순서가 뒤죽 박죽)
/*
   int balance;

    Semaphore sem;
    BankAccount() {   // BankAccount 클래스의 생성자가 호출되면 세마포를 만든다.
        sem = new Semaphore(1);  // value 값을 1로 초기화한다.
    }

    void deposit(int amount) {
        try {
            sem.acquire();   // 임계구역에 들어가기를 요청한다.
        } catch (InterruptedException e) {}
        int temp = balance + amount;
        System.out.print("+");
        balance = temp;

        sem.release();   // 임계구역에서 나간다.
    }
    void withdraw(int amount) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {}
        int temp = balance - amount;
        System.out.print("-");
        balance = temp;

        sem.release();
    }
    int getBalance() {
        return balance;
    }*/
    // ordering 을 통해 우선순위 대로 실행할 수 있게. 1.입급->2.출금
    int balance;

    Semaphore sem, semOrder;
    BankAccount() {
        sem = new Semaphore(1);
        semOrder = new Semaphore(0);   // Ordeing을 위한 세마포
    }

    void deposit(int amount) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {}
        int temp = balance + amount;
        System.out.print("+");
        balance = temp;
        sem.release();
        semOrder.release();   // block된 출금 프로세스가 있다면 깨워준다.
    }
    void withdraw(int amount) {
        try {
            semOrder.acquire();   // 출금을 먼저하려고 하면 block한다.
            sem.acquire();
        } catch (InterruptedException e) {}
        int temp = balance - amount;
        System.out.print("-");
        balance = temp;
        sem.release();
    }
    int getBalance() {
        return balance;
    }
}

// 입금 프로세스
class Parent extends Thread {
    BankAccount b;
    Parent(BankAccount b) {
        this.b = b;
    }
    public void run() {   // run(): 쓰레드가 실제로 동작하는 부분(치환)
        for (int i = 0; i < 100; i++)
            b.deposit(1000);
    }
}

// 출금 프로세스
class Child extends Thread {
    BankAccount b;
    Child(BankAccount b) {
        this.b = b;
    }
    public void run() {
        for (int i = 0; i < 100; i++)
            b.withdraw(1000);
    }
}
