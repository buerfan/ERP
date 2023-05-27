package com.example.icecreamfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.icecreamfactory.entity.Student;
import com.example.icecreamfactory.entity.User;
import com.example.icecreamfactory.repository.StudentRepository;
import com.example.icecreamfactory.repository.UserRepository;

@SpringBootApplication
public class IcecreamfactoryApplication  {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamfactoryApplication.class, args);
	}
}
