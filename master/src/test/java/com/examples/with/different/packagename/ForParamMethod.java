package com.examples.with.different.packagename;

public class ForParamMethod {

    public int sum(int n) {
        int a = 0;
        for (int i = 1; i < n; i++) {
            a += i;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return a;
    }

}
