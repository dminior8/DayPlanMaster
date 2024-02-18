package pl.dminior8.DayPlanMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pl.dminior8.DayPlanMaster")
public class DayPlanMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayPlanMasterApplication.class, args);
	}

}
