package com.bodinger.pi;

import com.pi4j.io.gpio.*;

public class Relay {

    private Pin pin;
    private String name;
    private GpioPinDigitalOutput outputPin;
    private RelayState relayState;

    public Relay(String name,Pin pin){

        this.pin = pin;
        this.name = name;
        relayState = RelayState.Off;

        GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin as an output pin and turn off
        outputPin = gpio.provisionDigitalOutputPin(pin, name, PinState.LOW);
        outputPin.setShutdownOptions(true, PinState.LOW);
    }

    @Override
    public String toString(){
        return name + " State:" + relayState;
    }

    public void setStateOn(){
        outputPin.setState(PinState.HIGH);
        relayState = RelayState.On;
    }

    public void setStateOff(){
        outputPin.setState(PinState.LOW);
        relayState = RelayState.Off;
    }

    public void setState(RelayState relayState){
        if(relayState == RelayState.On){
            setStateOn();
        } else {
            setStateOff();
        }
    }


    public RelayState toggleState(){
        if(isOn()){
            setStateOff();
        } else {
            setStateOn();
        }
        return relayState;
    }

    public boolean isOn(){
        if(relayState == RelayState.On) return true;
        return false;
    }

    public boolean ifOff(){
        if(relayState == RelayState.Off) return true;
        return false;
    }


    public String getName() {
        return name;
    }


    public RelayState getRelayState() {
        return relayState;
    }

}
