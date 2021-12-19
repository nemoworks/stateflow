package info.nemowork.stateflow.statemachine;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import info.nemowork.stateflow.statemachine.event.StateChangeEvent;

@Component
public class StateMachineListener extends StateMachineListenerAdapter<String, String> {

    @Autowired
    private ApplicationEventPublisher publisher;

    // private static final Logger LOGGER =
    // Logger.getLogger(StateMachineListener.class.getName());

    @Override
    public void stateChanged(State<String, String> from, State<String, String> to) {
        // super.stateChanged(from, to);
        publisher.publishEvent(Pair.with(from, to));
    }

    @Override
    public void transition(Transition<String, String> transition) {
        // super.transition(transition);
        publisher.publishEvent(transition);

    }

    @Override
    public void stateEntered(State<String, String> state) {
        super.stateEntered(state);
        publisher.publishEvent(new StateChangeEvent(this, state));
    }

}
