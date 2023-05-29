
package com.springBoot_project_1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot_project_1.dao.UserRepository;
import com.springBoot_project_1.models.User;

@Service
public class UserServiceImpl implements UserService{


//	@Autowired
//	  private UserRepository userRepository;
//	  
//	  @Override
//	  public void saveUser(User user) {
//	    userRepository.save(user);
//	  }
//	  @Override
//	  public User getUserByNameAndPassword(String name, String password)
////	  throws UserNotFoundException 
//	  {
//	    User user = userRepository.findByUserNameAndPassword(name, password);
//	    if(user == null){
////	       throw new UserNotFoundException("Invalid id and password");
//	    	System.out.println("Invalid id and password");
//	    }
//	    return user;
//	  }
}
