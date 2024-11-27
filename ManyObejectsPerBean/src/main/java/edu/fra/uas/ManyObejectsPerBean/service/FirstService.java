package edu.fra.uas.ManyObejectsPerBean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {
    
    @Autowired
    CounterService counterService;

    public int zeigeZaehler() {
        return counterService.incrementCounter();
    }
}
