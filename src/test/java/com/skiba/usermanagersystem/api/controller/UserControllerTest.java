package com.skiba.usermanagersystem.api.controller;

import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.data.TestDataLoader;
import com.skiba.usermanagersystem.repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:application-test.properties")
public class UserControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestDataLoader testDataLoader;

    @BeforeClass
    public void setUp() {
        testDataLoader.add2Users();
    }

    @Test
    public void shouldReturnAllUsers() {
        //given

        //when
        ResponseEntity<List<UserDisplay>> responseEntity = testRestTemplate
                .exchange("/api/users",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<UserDisplay>>() {
                        });

        //then
        //check response
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //check user list
        List<UserDisplay> returnedUsers = responseEntity.getBody();
        assertThat(returnedUsers).isNotNull();
        assertThat(returnedUsers.size()).isNotZero();

    }


}