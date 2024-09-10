package com.rk.junittesting.mock

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LoginStatus.SUCCESS)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testUserService() {
        val userService = UserService(userRepository)
        val result = userService.loginUser("john@gmail.com", "545664")
        assertEquals("Logged in successfully", result)

    }

}