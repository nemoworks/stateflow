package info.nemowork.stateflow.statemachine;

import java.util.logging.Logger;

import org.javatuples.Pair;
import org.javatuples.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Component
public class StateMachineListener extends StateMachineListenerAdapter<String, String> {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private static final Logger LOGGER = Logger.getLogger(StateMachineListener.class.getName());

    @Override
    public void stateChanged(State<String, String> from, State<String, String> to) {
        super.stateChanged(from, to);
        applicationEventPublisher.publishEvent(Pair.with(from, to));
    }

    @Override
    public void transition(Transition<String, String> transition) {
        super.transition(transition);
        applicationEventPublisher.publishEvent(Unit.with(transition));

    }

}
