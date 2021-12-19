// package info.nemowork.stateflow.statemachine;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.statemachine.config.EnableStateMachine;
// import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
// import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
// import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
// import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

// @Configuration
// @EnableStateMachine
// public class RFLStateMachineConfiguration extends StateMachineConfigurerAdapter<RFLFlowStates, RFLFlowEvents> {

    // @Autowired
    // StateMachineListener stateMachineListener;

    // @Override
    // public void configure(StateMachineConfigurationConfigurer<RFLFlowStates, RFLFlowEvents> config)
    //         throws Exception {
    //     config
    //             .withConfiguration()
    //             .autoStartup(false)
    //             .listener(stateMachineListener);
    // }

    // @Override
    // public void configure(StateMachineStateConfigurer<RFLFlowStates, RFLFlowEvents> states) throws Exception {
    //     states
    //             .withStates()
    //             .initial(RFLFlowStates.WRITTING)
    //             .state(RFLFlowStates.REVIEWING)
    //             .end(RFLFlowStates.APPROVED)
    //             .end(RFLFlowStates.REJECTED);

    // }

    // @Override
    // public void configure(StateMachineTransitionConfigurer<RFLFlowStates, RFLFlowEvents> transitions) throws Exception {
    //     transitions.withExternal()
    //             .source(RFLFlowStates.WRITTING).target(RFLFlowStates.REVIEWING).event(RFLFlowEvents.SUBMIT)
    //             .and().withExternal()
    //             .source(RFLFlowStates.REVIEWING).target(RFLFlowStates.APPROVED).event(RFLFlowEvents.ARRROVE)
    //             .and().withExternal()
    //             .source(RFLFlowStates.REVIEWING).target(RFLFlowStates.REJECTED).event(RFLFlowEvents.REJECT);
    // }

// }
