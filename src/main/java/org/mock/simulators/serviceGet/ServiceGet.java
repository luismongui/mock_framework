package org.mock.simulators.serviceGet;


import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scenario("Consumo service get")
@RequestMapping(value = "/api/get" ,method = RequestMethod.POST)
public class ServiceGet extends AbstractSimulatorScenario {
    @Autowired
    ServiceGetManager responseManager;
    @Override
    public synchronized void run(ScenarioRunner scenario){
        scenario
                .http()
                .receive((builder -> builder
                        .post()
                        .extractFromPayload("$.user.corrid","corr_id"))
                );
        responseManager.getResponse(scenario);
    }

}
