package pl.mwasyluk.filessupport;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class EmployeesReader {
    @Value("classpath:employees.txt")
    @Setter
    public Resource employeesFile;

    @Bean
    public Set<String> getEmployeesAsSet(){
        String employeesAsString = "";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(employeesFile.getInputStream());
            employeesAsString = FileCopyUtils.copyToString(inputStreamReader);
        } catch (IOException e) {
            System.err.println("Problem with reading the file. Check the file / file path and try again.");
        }

        if (employeesAsString.isBlank()) return Collections.emptySet();

        String[] split = employeesAsString.split(",");
        return new HashSet<>(Arrays.asList(split));
    }
}
