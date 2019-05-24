package com.inspur.java_api.rmi.serializable;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException {

        for(int i = 0; i < 10000; i++){
            for(int j = 0; j < 100; j++){
                System.out.println("j------:" + j);
                if(j == 10){
                    break;
                }
            }
            System.out.println("i--------:" + i);
            Thread.currentThread().sleep(1000);
        }

    }
}
