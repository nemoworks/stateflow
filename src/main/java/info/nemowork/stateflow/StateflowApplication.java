package info.nemowork.stateflow;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class StateflowApplication implements ApplicationRunner{

	@Autowired
    private StateMachine<String, String> stateMachine;


	public static void main(String[] args) {
		SpringApplication.run(StateflowApplication.class, args);
	}

	@Override
   public void run(ApplicationArguments arg0) throws Exception {
	  stateMachine.start();
   }

}
