package com.springboot.foundations;

import com.springboot.foundations.bean.MyBean;
import com.springboot.foundations.bean.MyBeanWithDependency;
import com.springboot.foundations.bean.MyBeanWithProperties;
import com.springboot.foundations.component.ComponentDependency;
import com.springboot.foundations.entity.User;
import com.springboot.foundations.pojo.UserPojo;
import com.springboot.foundations.repository.UserRepository;
import com.springboot.foundations.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FoundationsApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FoundationsApplication.class);


	private ComponentDependency componentDependency;
	private MyBean myBean;
	@Autowired
	private MyBeanWithDependency myBeanWithDependency;
	@Autowired
	private MyBeanWithProperties myBeanWithProperties;
	@Autowired
	private UserPojo userPojo;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.of(1666,03,01) );
		User test2 = new User("TestTransactional2", "TestTransactional2domain.com", LocalDate.of(1666,03,01) );
		User test3 = new User("TestTransactional3", "TestTransactional1@domain.com", LocalDate.of(1666,03,01) );
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.of(1666,03,01) );

		List<User> users = Arrays.asList(test1,test2,test3,test4);

		try{
			userService.saveTransactional(users);
		}catch(Exception e){
			LOGGER.error("error in the transaction, the message was: " + e.getMessage());
		}


		userService.getAllUsers().forEach(u -> LOGGER.info("This is the user in the transactional method: " + u));


	}



	public FoundationsApplication(@Qualifier("componentTwoImpl") ComponentDependency cd, MyBean myBean){
		this.componentDependency = cd;
		this.myBean = myBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(FoundationsApplication.class, args);
	}

	private void saveUserInDataBase(){
		User user1 = new User("Edisa","edisa@gmail.com", LocalDate.of(1989,07,12));
		User user2 = new User("Sebastian","sebas@gmail.com", LocalDate.of(2000,02,12));
		User user3 = new User("Julian","julian@gmail.com", LocalDate.of(1995,02,12));
		User user4 = new User("Ana","anamaria@gmail.com", LocalDate.of(2001,02,12));
		User user5 = new User("rene","rene@gmail.com", LocalDate.of(2002,02,12));
		User user6 = new User("Mercedez","merci@gmail.com", LocalDate.of(2003,02,12));
		User user7 = new User("jairo","jairo@gmail.com", LocalDate.of(2004,02,12));
		User user8 = new User("jairo","paula@gmail.com", LocalDate.of(2005,02,12));
		User user9 = new User("user4","santi@gmail.com", LocalDate.of(2006,02,12));
		User user10 = new User("user5","zeusthedoggo@gmail.com", LocalDate.of(2007,02,12));
		List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		userList.stream().forEach(userRepository::save);
	}

	private void getInformationJpqlFromUser(){
//		LOGGER.info("The user with method findByuserEmail: " + userRepository.findByuserEmail("santi@gmail.com").orElseThrow(() -> new RuntimeException("user not found")));
//
//		userRepository.findAndSort("user", Sort.by("id").descending())
//				      .forEach(user -> LOGGER.info("user with method sort: " + user.toString() ));
//
//		userRepository.findByName("jairo").forEach(user -> LOGGER.info("The user with query Method is: " + user.toString()));

//		LOGGER.info(userRepository.findByEmailAndName("edisa@gmail.com", "Edisa")
//				.orElseThrow(() -> new RuntimeException("user not found")));

//		userRepository.findByNameLike("%er%")
//				.forEach(user -> LOGGER.info("user by name like: " + user));

//		userRepository.findByNameOrEmail("rene", null)
//				.forEach(user -> LOGGER.info("user by name like or: " + user));

//		userRepository.findByBirthDateBetween(LocalDate.of(2000,01,01),LocalDate.of(2021,10,01))
//				.forEach(user -> LOGGER.info("user between dates: " + user));

//		userRepository.findByNameLikeOrderByIdAsc("%user%")
//				.forEach(user -> LOGGER.info("usuario encontrado con like y ordenado con id: " + user));

//		LOGGER.info( "The user with named paramater is: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2001,02,12), "anamaria@gmail.com")
//				      .orElseThrow(() -> new RuntimeException("User not found named parameter")));

	}

	@Override
	public void run(String... args) throws Exception {
//		previousExamples();
		saveUserInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
	}

	private void previousExamples(){
		this.componentDependency.saluda();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println("El correo del usario es   : " + userPojo.getEmail());
		LOGGER.error("This is an error from the appa");
	}
}
