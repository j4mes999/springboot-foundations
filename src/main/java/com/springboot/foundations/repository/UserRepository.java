package com.springboot.foundations.repository;

import com.springboot.foundations.dto.UserDto;
import com.springboot.foundations.entity.User;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("Select u From User u WHERE u.email = ?1")
    Optional<User> findByuserEmail(String email);

    @Query("Select u from User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate from, LocalDate to);

    List<User> findByNameLikeOrderByIdAsc(String name);

    @Query("SELECT new com.springboot.foundations.dto.UserDto(u.id, u.name, u.birthDate) " +
           "FROM User u " +
           "WHERE u.birthDate=:bdParam " +
           "AND u.email=:emailParam")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("bdParam") LocalDate date
                                                ,@Param("emailParam") String email);

    List<User> findAll();

}
