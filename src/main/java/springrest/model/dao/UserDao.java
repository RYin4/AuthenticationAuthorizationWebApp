package springrest.model.dao;

import java.util.List;

import springrest.model.User;

public interface UserDao {

    List<User> getUsers();

}