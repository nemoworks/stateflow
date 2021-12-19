package info.nemowork.stateflow.statemachine.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import info.nemowork.stateflow.statemachine.event.StateChangeEvent;

@Component
public class FlowEventHandler {

    private Map<String, Runnable> stateAction = new HashMap<>();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void registerAction(String state, Runnable r) {
        this.stateAction.put(state, r);
    }

    public FlowEventHandler() {
        this.registerAction("S1", () -> {
            System.out.println("Do sth for S1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        this.registerAction("S2", () -> {
            System.out.println("Do sth for S2");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @EventListener
    public void handleState(StateChangeEvent change) {
        System.out.println("state changed to " + change.getState().getId());
        if (stateAction.containsKey(change.getState().getId())) {
            executorService.submit(stateAction.get(change.getState().getId()));
        }
    }

    @Async
    @EventListener
    public void handleTransition(Transition<String, String> transition) {
        System.out.println("transition happened" + transition.getName() + " started");
    }

}
