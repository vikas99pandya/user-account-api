package com.ing.service.impl;

import com.ing.dao.UserRepository;
import com.ing.dto.UserDTO;
import com.ing.entity.User;
import com.ing.entity.UserStatistics;
import com.ing.exception.UserProductException;
import com.ing.service.UserService;
import com.ing.util.UserProductConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service implementation for fetching users and user statistics about products
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    private List<UserStatistics> statistics = Arrays.asList(
            new UserStatistics(132, 12, false, 1),
            new UserStatistics(520, 600, false, 2)
    );

    @Override
    public List<UserDTO> getAllUsers() throws UserProductException {
        LOG.debug("in method getAllUsers()");
        List<UserDTO> finalUserList =new ArrayList<>();
        try {
            List<User> userList = userRepository.findAll();
            userList.stream().forEach(user->{
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(user, userDTO);
                finalUserList.add(userDTO);
            });
        } catch (DataAccessException dataAccessException) {
            throw new UserProductException(UserProductConstant.ProcessingError.GET_USERS_ERROR.getErrorDesc(), dataAccessException, UserProductConstant.ProcessingError.GET_USERS_ERROR.name());
        }

        return finalUserList;
    }

    @Override
    public UserStatistics getStatisticsByUserId(int userId) throws UserProductException{
        LOG.debug("in method getStatisticsByUserId(int userId)");
        return statistics.stream().filter(s -> s.getUser().getId() == userId).findFirst().get();
    }

}