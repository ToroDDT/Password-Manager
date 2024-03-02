package com.MySQL.Database;

import com.MySQL.Database.Config.Parrot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseApplication  {
	public static void main(String[] args) {

		var context = SpringApplication.run(DatabaseApplication.class, args);
		Parrot p = context.getBean(Parrot.class);
		System.out.println(p);
		String S = context.getBean(String.class);
		System.out.println(S);
		Integer n = context.getBean(Integer.class);
		System.out.println(n);
	}

}
