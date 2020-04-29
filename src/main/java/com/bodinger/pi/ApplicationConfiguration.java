package com.bodinger.pi;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "relayJ2")
    public Relay getRelayJ2(){
        return new Relay("relayJ2", RaspiPin.GPIO_07);
    }

    @Bean(name = "relayJ3")
    public Relay getRelayJ3(){
        return new Relay("relayJ3", RaspiPin.GPIO_03);
    }

    @Bean(name = "relayJ4")
    public Relay getRelayJ4(){
        return new Relay("relayJ4", RaspiPin.GPIO_22);
    }

    @Bean(name = "relayJ5")
    public Relay getRelayJ5(){
        return new Relay("relayJ5", RaspiPin.GPIO_25);
    }

}
