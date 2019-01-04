package com.firstcourse.FirstCourse.models.data;

import com.firstcourse.FirstCourse.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    User findByEmail(String email);
}
