package info.nemowork.stateflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FlowController {

    @Autowired
    private StateMachine<String, String> stateMachine;


    @GetMapping(value = "/start")
    public boolean start() {
        // stateMachine.startReactively();

        stateMachine.start();
        return stateMachine.hasStateMachineError();
    }

    @GetMapping(value = "/next")
    public boolean nextState() {

        stateMachine.sendEvent("E1");
    //  stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload("E1").build()));
     return stateMachine.hasStateMachineError();

    }

    @PostMapping(value = "/event")
    public boolean sendEvent(@RequestBody String event) {

        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(event).build()));
        return stateMachine.hasStateMachineError();

    }

}
