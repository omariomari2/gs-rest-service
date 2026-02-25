package com.example.restservice;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest
@AutoConfigureRestTestClient
public class EmployeeControllerTests {

  @Autowired
  private RestTestClient restTestClient;

  @Test
  public void getEmployeesShouldReturnInitialList() {
    this.restTestClient.get().uri("/employees")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.Employees.length()").isEqualTo(4);
  }

  @Test
  public void postEmployeeShouldAddEmployeeToList() {
    Employee employee = new Employee("E005", "Jane", "Doe", "jane.doe@example.com", "Engineer");

    this.restTestClient.post().uri("/employees")
        .body(employee)
        .exchange()
        .expectStatus().isCreated()
        .expectBody()
        .jsonPath("$.employee_id").isEqualTo("E005");

    this.restTestClient.get().uri("/employees")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.Employees.length()").isEqualTo(5)
        .jsonPath("$.Employees[4].employee_id").isEqualTo("E005");
  }
}

