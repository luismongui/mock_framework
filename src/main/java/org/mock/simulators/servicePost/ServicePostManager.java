package org.mock.simulators.servicePost;

import com.consol.citrus.simulator.scenario.ScenarioRunner;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Data
public class ServicePostManager {

    public static String BASIC_PATH = "";

    @Autowired
    GetPathFile getPathFile;
    @Autowired
    GetResponseFileForState getResponseRest;
    public ServicePostManager(){
    }
    public synchronized void getResponse(ScenarioRunner scenario){
        String challenge = scenario.getTestContext().getVariable("challenge",String.class);
        ResponseJson responseJson = getResponseRest.getResponseFile(getClass().getSimpleName(),challenge,"challenge");
        int statusCode = (responseJson.getStatuCode() > 0 ? responseJson.getStatusCode() : 200);
        scenario
                .http()
                .send((builder) -> builder
                                .response()
                                .contentType("application/json")
                                .status(statusCode)
                                .payload(new ClassPathResource(BASIC_PATH + responseJson.getFileNameBody()))

                );
    }
}
