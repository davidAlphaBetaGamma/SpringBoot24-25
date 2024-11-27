package edu.fra.uas.ManyObejectsPerBean.service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private int counter = 0;

    public int incrementCounter() {
        counter++;
        return counter;
    }

}
