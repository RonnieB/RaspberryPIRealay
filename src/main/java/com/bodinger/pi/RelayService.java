package com.bodinger.pi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class RelayService {

    @Autowired
    Relay relayJ2;

    @Autowired
    Relay relayJ3;

    @Autowired
    Relay relayJ4;

    @Autowired
    Relay relayJ5;

    private ArrayList<Relay> realayList;

    @PostConstruct
    public void init(){
        realayList = new ArrayList<Relay>();
        realayList.add(relayJ2);
        realayList.add(relayJ3);
        realayList.add(relayJ4);
        realayList.add(relayJ5);
    }

    public Relay getRelay(int relay){
        switch (relay){
            case 2:
                return relayJ2;
            case 3:
                return relayJ3;
            case 4:
                return relayJ4;
            case 5:
                return relayJ5;
        }
        return null;
    }

    public ArrayList<Relay> getRelays(){
        return realayList;
    }

}
