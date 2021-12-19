package info.nemowork.stateflow.statemachine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer;
import org.springframework.statemachine.config.model.StateMachineModelFactory;
import org.springframework.statemachine.uml.UmlStateMachineModelFactory;

@Configuration
@EnableStateMachine
public class UMLStateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

	@Autowired
	private StateMachineListener listener;

	@Override
	public void configure(StateMachineModelConfigurer<String, String> model) throws Exception {
		model
				.withModel()
				.factory(modelFactory());
	}

	@Override
	public void configure(StateMachineConfigurationConfigurer<String, String> config)
			throws Exception {
		config
				.withConfiguration()
				.autoStartup(false)
				.listener(listener);
	}

	@Bean
	public StateMachineModelFactory<String, String> modelFactory() {
		return new UmlStateMachineModelFactory("classpath:simple-machine.uml");
	}
}
