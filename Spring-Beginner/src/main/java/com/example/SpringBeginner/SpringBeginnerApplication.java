package com.example.SpringBeginner;

import com.example.SpringBeginner.model.student;
import com.example.SpringBeginner.view.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.util.HashMap;

@SpringBootApplication
public class SpringBeginnerApplication {

	@Autowired
	student s1;

	public static void main(String[] args) {

//		SpringApplication.run(SpringBeginnerApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringBeginnerApplication.class, args);
//		HashMap<String,Integer> demohashmap = new HashMap<>();
//		demohashmap.put(("quang",19));
//		demohashmap.put(("hien",19));
		//arrayList => get(i)
		// hashMap => get(key)
//		System.out.println(demohashmap.get("quang"));

		student s = (student) context.getBean(student.class);
		s.setName("Thang");
		System.out.println(s.getName());

		// ioc -- tao Bean
		// di -- -]
		view v = new view();
		v.ViewMain();
	}

}
