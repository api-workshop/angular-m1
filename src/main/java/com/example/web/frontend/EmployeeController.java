package com.example.web.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Value("${employees-api.url}")
    private String baseURL;

    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> list() {
        return restTemplate.exchange(baseURL + "/api/employees", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
                });
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") final String id) {
        return restTemplate.exchange(baseURL + "/api/employees/{id}", HttpMethod.GET, null,
                Employee.class);
    }

    @PostMapping("/api/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return restTemplate.exchange(baseURL + "/api/employees", HttpMethod.POST,
                new HttpEntity<Employee>(employee), Employee.class);
    }

    @PutMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") final String id,
            @RequestBody Employee employee) {
        employee.setId(id);
        return restTemplate.exchange(baseURL + "/api/employees/{id}", HttpMethod.PUT,
                new HttpEntity<Employee>(employee), Employee.class);
    }

    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") final String id) {
        restTemplate.exchange(baseURL + "/api/employees/{id}", HttpMethod.DELETE,
                null, Employee.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}