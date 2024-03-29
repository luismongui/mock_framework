package org.mock;

import com.consol.citrus.endpoint.EndpointAdapter;
import com.consol.citrus.endpoint.adapter.StaticEndpointAdapter;
import com.consol.citrus.http.message.HttpMessage;
import com.consol.citrus.message.Message;
import com.consol.citrus.simulator.http.SimulatorRestAdapter;
import com.consol.citrus.simulator.http.SimulatorRestConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;

public class Simulator extends SimulatorRestAdapter {
     public static void main(String[] args) {
         SpringApplication.run(Simulator.class,args);

    }
    @Override
    public String urlMapping(SimulatorRestConfigurationProperties simulatorRestConfigurationProperties){
         return "/**";
    }

    @Override
    public EndpointAdapter fallbackEndpointAdapter(){
         return new StaticEndpointAdapter() {
             @Override
             protected Message handleMessageInternal(Message message) {
                 return new HttpMessage().status(HttpStatus.BAD_REQUEST);
             }
         };
    }
}
