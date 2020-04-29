package com.bodinger.pi;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Api(value = "Relaycontroller", description = "Control the Relay RaspberryPi")
@RestController
public class RelayControler {

    @Autowired
    RelayService relayService;

    @GetMapping("/")
    void reDirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }

    @GetMapping(value = "/state/{id}")
    public RelayState getState(@PathVariable("id") int relayNumber){

        Relay relay = relayService.getRelay(relayNumber);
        return relay.getRelayState();
    }

    @GetMapping(value = "/state")
    public ArrayList<Relay> getStates(){
        return relayService.getRelays();
    }

    @GetMapping(value = "/state/toggle/{id}")
    public RelayState toggleState(@PathVariable("id") int relayNumber){
        Relay relay = relayService.getRelay(relayNumber);
        return relay.toggleState();
    }

    @GetMapping(value = "/state/on/{id}")
    public RelayState setStateOn(@PathVariable("id") int relayNumber){
        Relay relay = relayService.getRelay(relayNumber);
        relay.setStateOn();
        return relay.getRelayState();
    }

    @GetMapping(value = "/state/on")
    public ArrayList<Relay> setAllStateOn(){
        for(int relayNumber=2;relayNumber<6;relayNumber++){
            Relay relay = relayService.getRelay(relayNumber);
            relay.setStateOn();
        }
        return getStates();
    }

    @GetMapping(value = "/state/off/{id}")
    public RelayState setStateOff(@PathVariable("id") int relayNumber){
        Relay relay = relayService.getRelay(relayNumber);
        relay.setStateOff();
        return relay.getRelayState();
    }

    @GetMapping(value = "/state/off")
    public ArrayList<Relay> setAllStateOff(){
        for(int relayNumber=2;relayNumber<6;relayNumber++){
            Relay relay = relayService.getRelay(relayNumber);
            relay.setStateOff();
        }
        return getStates();
    }

}
