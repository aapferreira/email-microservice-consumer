package com.emailconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.emailconsumer.controller.EmailConsumerController;

@Component
public class EmailConsumerCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	EmailConsumerController emailConsumerController;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println();
		System.out.println("######");
		System.out.println("Consumidor do microservice de envio de emails");
		System.out.println("Executando a classe CommandLineRunnerTest");
		System.out.println("A interface CommandLineRunner tem um comportamento semelhante ao main, ou seja, é executada juntamente com a aplicação");
		System.out.println("######");
		System.out.println();
		System.out.println();
		
		emailConsumerController.setEmailViaBackEnd();

	}
	
}