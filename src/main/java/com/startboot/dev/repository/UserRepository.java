package com.startboot.dev.repository;

import com.startboot.dev.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * 使用JpaRepository
 *
 * Created by wdnnccey on 2018/4/13 下午2:32.
 */
public interface UserRepository extends JpaRepository<User,String> {

}
