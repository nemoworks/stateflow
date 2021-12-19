package info.nemowork.stateflow.statemachine.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.statemachine.state.State;

public class StateChangeEvent extends ApplicationEvent {

    State<String, String> state;

    public StateChangeEvent(Object source, State<String, String> state) {
        super(source);
        this.state = state;
    }

    public State<String, String> getState() {
        return this.state;
    }

}
