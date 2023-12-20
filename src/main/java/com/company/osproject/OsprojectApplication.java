package com.company.osproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
//@OpenAPIDefinition(
//		info = @Info(
//				title = "OS Project",
//				version = "1 - version",
//				description = "Operating System Team 14",
//				license = @License(
//						name = "Abduali Abdumutalibov"
//				)
//		),
//		servers = @Server(
//				url = "http://localhost:8003"
//		)
//)
public class OsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsprojectApplication.class, args);
	}

//	@Override
//	public void run(String... args) {
//		JFrame frame = new JFrame("Spring Boot Swing App");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(300,300);
//		JPanel panel = new JPanel(new BorderLayout());
//		JTextField text = new JTextField("Spring Boot can be used with Swing apps");
//		panel.add(text, BorderLayout.CENTER);
//		frame.setContentPane(panel);
//		frame.setVisible(true);
//	}

}
