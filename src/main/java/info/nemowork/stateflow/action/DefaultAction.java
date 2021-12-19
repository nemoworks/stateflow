package info.nemowork.stateflow.action;

import org.javatuples.Pair;
import org.javatuples.Unit;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DefaultAction {

    @EventListener(value=Pair.class)
    public void eventAction() {
        System.out.println("state changed from " );
    }

    @EventListener(value=Unit.class) 
    public void transitionAction(){

    }
    )

}
