package br.com.application.service;

import br.com.application.dto.UserDTO;
import br.com.application.entity.UserEntity;
import br.com.application.repository.UserRepositry;

public class UserService {

    UserRepositry userRepositry = new UserRepositry();

    public UserDTO createNewUser(String name, String age) {
        UserDTO user = new UserDTO(name, Integer.parseInt(age));

        UserEntity savedUser = userRepositry.save(user);

        IO.println(String.format("debug - savedUser: %s", savedUser));

        return new UserDTO(savedUser.getName(), savedUser.getAge());
    }
}
