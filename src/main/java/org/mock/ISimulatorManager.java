package org.mock;

import com.consol.citrus.dsl.builder.HttpServerActionBuilder;
import com.consol.citrus.simulator.http.HttpBuilderSupport;
import com.consol.citrus.simulator.scenario.ScenarioRunner;

public interface ISimulatorManager {

    HttpBuilderSupport<HttpServerActionBuilder.HttpServerReceiveActionBuilder> parseParams();
    HttpBuilderSupport<HttpServerActionBuilder.HttpServerReceiveActionBuilder> selectResponse();
    void cleanParams();
    void addParamsToScenario(ScenarioRunner scenario);
}
