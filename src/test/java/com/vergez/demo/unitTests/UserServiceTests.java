package com.vergez.demo.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vergez.demo.entities.User;
import com.vergez.demo.repository.UserRepository;
import com.vergez.demo.services.UserService;
import com.vergez.demo.services.impl.UserServiceImpl;

class UserServiceTests {

    @Mock
    UserRepository userRepository;

    @Mock
    UserService userService; //simulation du comportement de mon UserService

    AutoCloseable autoCloseable;

    @Test
    void testCreateUserWithSuccess(){
        // given (etant donne mon user de test)
        User user = new User("Vergez", 30);
        when(userRepository.save(any(User.class))).thenReturn(user);
        // When (lorsque j'appelle mon UserService il se charge de creer mon user passer en parametre)
        User Userresult = userService.createUser(user);

        // then (verification du resultat)
        // On vérifie que le user créé est bien celui que nous avons fourni
        assertEquals(user.getNom(), Userresult.getNom());
        assertEquals(user.getAge(), Userresult.getAge());
        verify(userRepository, times(1)).save(user);
    }

    @BeforeEach
    void setup(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }
}
