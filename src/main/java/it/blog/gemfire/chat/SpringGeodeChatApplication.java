package it.blog.gemfire.chat;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import it.blog.gemfire.chat.entity.Message;
import it.blog.gemfire.chat.repository.MessageRepository;

@SpringBootApplication
@ImportResource("classpath:application-context.xml")
@EnableGemfireRepositories
public class SpringGeodeChatApplication  implements CommandLineRunner{

	@Autowired
	MessageRepository messageRepository; 
	
	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(SpringGeodeChatApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		String input = "-1";
		Scanner scanner = new Scanner(System.in);

		System.out.println("Your Name?");
		String name = scanner.nextLine();
		
		System.out.println("");
		System.out.println("0 - Exit");
		System.out.println("");
		
		while (!input.equals("0")) {
			
			System.out.print("Message: ");

			input = scanner.nextLine();

			if (!input.equals("0")) 
				newMessage(input, name, scanner);
		}

		scanner.close();
		System.exit(0);
	}
	
	private void newMessage(String message, String name, Scanner scanner)
	{						
		Message msg = new Message(new Date(), message, name);

        messageRepository.save(msg);
	}
}
