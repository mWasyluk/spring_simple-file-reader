package pl.mwasyluk.filessupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class FilesSupportApplication {
	@Autowired
	@Qualifier("getEmployeesAsSet")
	private Set<String> employeesSet;

	public static void main(String[] args) {
		SpringApplication.run(FilesSupportApplication.class, args);
	}

	@Bean
	public void sout(){
		for (String emp: employeesSet) {
			System.out.println(emp);
		}
	}

}
