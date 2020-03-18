package com.ing.controller;

import com.ing.dto.UserDTO;
import com.ing.entity.UserStatistics;
import com.ing.exception.UserProductException;
import com.ing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for fetching users and user statistics data
 */
@RestController
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * method to fetch all users
     * @throws UserProductException generic user product exception
     */
    @GetMapping("/users")
    public List<UserDTO>  getAllUsers() throws UserProductException {
        LOG.debug("in method getUserStatistics");
        return userService.getAllUsers();
    }

    /**
     * method to fetch statistics of an user
     * @throws UserProductException generic user product exception
     */
    @GetMapping("/users/{userId}")
    public UserStatistics getUserStatistics(@PathVariable int userId) throws UserProductException {
        LOG.debug("in method getUserStatistics");
        return userService.getStatisticsByUserId(userId);
    }
}
