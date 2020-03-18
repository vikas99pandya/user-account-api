package com.ing.user;

import com.ing.dao.UserRepository;
import com.ing.dto.UserDTO;
import com.ing.entity.User;
import com.ing.exception.UserProductException;
import com.ing.service.UserService;
import com.ing.service.impl.UserServiceImpl;
import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for verifying the functionality of UserService with easy mock of objects
 */
public class UserServiceTestWithEasyMock extends EasyMockSupport {

    private UserService fixture;
    private UserRepository userRepository = createMock(UserRepository .class);
    private List<User> userList;
    @Before
    public void setUp() {
        fixture= new UserServiceImpl(userRepository);
        userList= new ArrayList<>();
        setUserList(userList);
    }

    @Test
    public void checkAllUsers(){
        EasyMock.expect(userRepository.findAll()).andReturn(userList);
        EasyMock.replay(userRepository);

        try {
            List<UserDTO> userList = fixture.getAllUsers();
            EasyMock.verify(userRepository);
            Assert.assertNotNull(userList);
            Assert.assertEquals(userList.size(),4);
            Assert.assertEquals(userList.get(0).getUserName(),"test1");
        }
        catch(UserProductException ex){
            ////////
        }
    }


    private void setUserList(List userList){
        User user1 =new User(1,"test1","test1","test1");
        user1.setNumberOfLogins(5);
        userList.add(user1);

        User user2 =new User(2,"test2","test2","test2");
        user2.setNumberOfLogins(25);
        userList.add(user2);

        User user3 =new User(3,"test3","test3","test3");
        user3.setNumberOfLogins(55);
        userList.add(user3);

        User user4=new User(4,"test4","test4","test4");
        user4.setNumberOfLogins(65);
        userList.add(user4);
    }
}
