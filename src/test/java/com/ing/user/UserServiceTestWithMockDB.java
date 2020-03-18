package com.ing.user;

import com.ing.dao.UserRepository;
import com.ing.dto.UserDTO;
import com.ing.exception.UserProductException;
import com.ing.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Test for verifying the functionality of user Service with mock db: H2
 * This db is persistent in file
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@TestPropertySource(locations= "classpath:application.properties")
@SpringBootTest
public class UserServiceTestWithMockDB {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService fixture;

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceTestWithMockDB.class);

    @Test
    public void checkAllUsers() {

        try {
            List<UserDTO> userList = fixture.getAllUsers();
            Assert.assertNotNull(userList);
            Assert.assertEquals(userList.size(), 4);
            Assert.assertEquals(userList.get(0).getUserName(), "test1");
        } catch (UserProductException ex) {
            LOG.error("error in test",ex);
            ////////ignore: never goes here
        }
    }
}