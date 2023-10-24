package myspringapp.springtwitter;

import myspringapp.springtwitter.database.DataInitializer;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringTwitterApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringTwitterApplication.class);
		ConfigurableApplicationContext context = app.run(args);
		DataInitializer dataInitializer = context.getBean(DataInitializer.class);
		dataInitializer.initializeUsers();
		dataInitializer.initializeTweets();
		dataInitializer.initializeComments();
		dataInitializer.initializeNotifications();
		dataInitializer.initializeFollowing();
		dataInitializer.initializeMessages();
	}

}
