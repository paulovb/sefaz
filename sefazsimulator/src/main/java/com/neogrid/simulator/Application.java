package com.neogrid.simulator;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.neogrid.simulator.config.SpringMongoConfig;
import com.neogrid.simulator.model.User;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		User userA = new User("1", "192.168.2.5", "pbischof", "paulo.bischof@neogrid.com");
		mongoOperation.save(userA, "user");

		// find
		Query findUserQuery = new Query();
		findUserQuery.addCriteria(Criteria.where("ip").is("192.168.2.5"));
		User userA1 = mongoOperation.findOne(findUserQuery, User.class, "user");
		System.out.println(userA1);
		
    }
}
