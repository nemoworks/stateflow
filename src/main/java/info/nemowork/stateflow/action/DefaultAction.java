package info.nemowork.stateflow.action;

import org.javatuples.Pair;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DefaultAction {

    @EventListener(value=Pair.class)
    public void eventAction() {
        System.out.println("event happened");
    }

}
