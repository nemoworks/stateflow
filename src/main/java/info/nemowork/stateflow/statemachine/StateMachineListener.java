package info.nemowork.stateflow.statemachine;

import java.util.logging.Logger;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

@Component
public class StateMachineListener extends StateMachineListenerAdapter<RFLFlowStates, RFLFlowEvents> {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private static final Logger LOGGER = Logger.getLogger(StateMachineListener.class.getName());

    // @Override
    // public void stateChanged(State<RFLFlowStates, RFLFlowEvents> from, State<RFLFlowStates, RFLFlowEvents> to) {
    //     LOGGER.info(
    //             () -> String.format("Transitioned from %s to %s%n", from == null ? "none" : from.getId(), to.getId()));
    //     applicationEventPublisher.publishEvent(Pair.with(from, to));
    // }
}
