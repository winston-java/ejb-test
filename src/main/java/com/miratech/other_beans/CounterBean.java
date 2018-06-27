package com.miratech.other_beans;

import javax.ejb.Stateful;

@Stateful
public class CounterBean {
    public Integer getCounter() {
        return counter;
    }

    public void inc(){
        counter++;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    private Integer counter = 0;
}
