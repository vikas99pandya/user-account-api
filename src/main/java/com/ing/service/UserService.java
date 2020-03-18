package com.ing.service;

import com.ing.dto.UserDTO;
import com.ing.entity.UserStatistics;
import com.ing.exception.UserProductException;

import java.util.List;

/**
 * Service for fetching users and user statistics about products
 */
public interface UserService {

    /**
     * A generic method to retrieve all users
     * @return a list of all users
     * @throws UserProductException generic user product exception
     */
    List<UserDTO>  getAllUsers() throws UserProductException;

    /**
     * A generic method to retrieve specific user statistics
     * @param userId input user id
     * @return a user statistic data
     * @throws UserProductException generic user product exception
     */
    UserStatistics getStatisticsByUserId(int userId) throws UserProductException;

}
