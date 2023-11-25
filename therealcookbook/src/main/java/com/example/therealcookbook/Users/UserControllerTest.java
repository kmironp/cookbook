package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class UserControllerTest {

    @Mock
    private UserService mockUserService;

    private UserController userControllerUnderTest;

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        userControllerUnderTest = new UserController(mockUserService);
    }

    @Test
    void testGetAllUsers() {
        // Setup
        when(mockUserService.getAllUsers()).thenReturn(Collections.emptyList());

        // Run the test
        List<User> result = userControllerUnderTest.getAllUsers();

        // Verify the results
        assertEquals(0, result.size(), "Expected an empty list");
    }

    @Test
    void testRegisterNewUser() {
        // Setup
        User user = new User();
        user.setUsername("test");
        user.setPassword("123");
        user.setEmail("asd@asd.com");

        // Run the test
        userControllerUnderTest.registerNewUser(user);

        // Verify the results
        verify(mockUserService).saveUser(user);
    }

    @Test
    void testGetUserByEmail() {
        // Setup: Mock UserService to return a user
        when(mockUserService.GetUserByEmail("test@example.com")).thenReturn(Optional.of(new User()));

        // Run the test
        Optional<User> result = userControllerUnderTest.getUserByEmail("test@example.com");

        // Verify the results
        assertEquals(Optional.of(new User()), result, "Expected a user");
    }

    @Test
    void testDeleteUser_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        userServiceUnderTest.deleteUser(existingUser.getUsername());

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).deleteByUsername(existingUser.getUsername());
    }

    @Test
    void testDeleteUser_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.deleteUser("nonexistentUser")
        );

        // Verify that delete method is not called
        verify(mockUserRepository, never()).deleteByUsername(any());
    }

    @Test
    void testUpdateEmail_UserExists_NewEmailNotInUse() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setEmail("oldEmail@example.com");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.findByEmail("newEmail@example.com")).thenReturn(null);

        // Act
        userServiceUnderTest.updateEmail(existingUser.getUsername(), "newEmail@example.com");

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).findByEmail("newEmail@example.com");
        verify(mockUserRepository, times(1)).save(existingUser);
    }

    @Test
    void testUpdateEmail_NewEmailInUse() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setEmail("oldEmail@example.com");

        User userWithNewEmail = new User();
        userWithNewEmail.setUsername("otherUser");
        userWithNewEmail.setEmail("newEmail@example.com");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.findByEmail("newEmail@example.com")).thenReturn(userWithNewEmail);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updateEmail(existingUser.getUsername(), "newEmail@example.com")
        );

        // Verify that save/update methods are not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testUpdatePassword_UserExists_CorrectOldPassword() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setPassword("oldPassword");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        userServiceUnderTest.updatePassword(existingUser.getUsername(), "oldPassword", "newPassword");

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);
    }

    @Test
    void testUpdatePassword_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updatePassword("nonexistentUser", "oldPassword", "newPassword")
        );

        // Verify that save/update methods are not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testUpdatePassword_IncorrectOldPassword() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setPassword("oldPassword");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updatePassword(existingUser.getUsername(), "wrongPassword", "newPassword")
        );

        // Verify that save/update methods are not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testGetUsername() {
        // Setup: Mock UserService to return a username
        when(mockUserService.getUsername(1)).thenReturn("John");

        // Run the test
        String result = userControllerUnderTest.getUsername(1);

        // Verify the results
        assertEquals("John", result, "Expected a username");
    }

    @Test
    void testGetEmail() {
        // Setup: Mock UserService to return an email
        when(mockUserService.getEmail(1)).thenReturn("john@example.com");

        // Run the test
        String result = userControllerUnderTest.getEmail(1);

        // Verify the results
        assertEquals("john@example.com", result, "Expected an email");
    }

    @Test
    void testGetOwnRec() {
        // Setup: Mock UserService to return a list of recipes
        when(mockUserService.getOwnRec(1)).thenReturn(Collections.singletonList(new Recipe()));

        // Run the test
        List<Recipe> result = userControllerUnderTest.getOwnRec(1);

        // Verify the results
        assertEquals(1, result.size(), "Expected a list of recipes");
    }

    @Test
    void testGetOwnRec_UserServiceReturnsNoItems() {
        // Setup: Mock UserService to return an empty list of recipes
        when(mockUserService.getOwnRec(1)).thenReturn(Collections.emptyList());

        // Run the test
        List<Recipe> result = userControllerUnderTest.getOwnRec(1);

        // Verify the results
        assertEquals(0, result.size(), "Expected an empty list of recipes");
    }

    @Test
    void testGetFavRec() {
        // Setup: Mock UserService to return a list of recipes
        when(mockUserService.getFavRec(1)).thenReturn(Collections.singletonList(new Recipe()));

        // Run the test
        List<Recipe> result = userControllerUnderTest.getFavRec(1);

        // Verify the results
        assertEquals(1, result.size(), "Expected a list of recipes");
    }

    @Test
    void testGetFavRec_UserServiceReturnsNoItems() {
        // Setup: Mock UserService to return an empty list of recipes
        when(mockUserService.getFavRec(1)).thenReturn(Collections.emptyList());

        // Run the test
        List<Recipe> result = userControllerUnderTest.getFavRec(1);

        // Verify the results
        assertEquals(1, result.size(), "Expected an empty list of recipes");
    }

    @Test
    void testEditOwnRec() {
        // Setup: Mock UserService to edit the own recipe
        when(mockUserService.editOwnRec(1, 1, "Updated Recipe")).thenReturn(new Recipe());

        // Run the test
        Recipe result = userControllerUnderTest.editOwnRec(1, 1, "Updated Recipe");

        // Verify the results
        assertEquals(new Recipe(), result, "Expected an edited own recipe");
    }

    @Test
    void testDeleteOwnRec() {
        // Run the test
        userControllerUnderTest.deleteOwnRec(1, 1);

        // Verify the results
        verify(mockUserService).deleteOwnRec(1, 1);
    }

    @Test
    void testEditFavRec() {
        // Setup: Mock UserService to edit the favorite recipe
        when(mockUserService.editFavRec(1, 1, "Updated Recipe")).thenReturn(new Recipe());

        // Run the test
        Recipe result = userControllerUnderTest.editFavRec(1, 1, "Updated Recipe");

        // Verify the results
        assertEquals(new Recipe(), result, "Expected an edited favorite recipe");
    }

    @Test
    void testDeleteFavRec() {
        // Run the test
        userControllerUnderTest.deleteFavRec(1, 1);

        // Verify the results
        verify(mockUserService).deleteFavRec(1, 1);
    }

}
