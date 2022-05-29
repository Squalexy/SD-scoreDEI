package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u ORDER BY u.username ASC")
    public List<User> retrieveUsers();

    @Query("SELECT COUNT(u.id) FROM User u WHERE u.email LIKE :email")
    public int findByEmail(@Param("email") String email);

    @Query("SELECT COUNT(u.id) FROM User u WHERE u.username LIKE :username")
    public int findByUsername(@Param("username") String username);

    @Query("SELECT COUNT(u.id) FROM User u WHERE u.telephone LIKE :telephone")
    public int findByTelephone(@Param("telephone") String telephone);

    @Query("SELECT COUNT(u.id) FROM User u WHERE u.email LIKE :email AND username NOT LIKE :username")
    public int findByEmailEdit(@Param("email") String email, @Param("username") String username);

    @Query("SELECT COUNT(u.id) FROM User u WHERE u.username LIKE :username AND username NOT LIKE :username")
    public int findByUsernameEdit(@Param("username") String username);

    @Query("SELECT COUNT(u.id) FROM User u WHERE u.telephone LIKE :telephone AND username NOT LIKE :username")
    public int findByTelephoneEdit(@Param("telephone") String telephone, @Param("username") String username);
}    