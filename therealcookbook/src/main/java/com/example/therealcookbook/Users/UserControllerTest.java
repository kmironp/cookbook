package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import com.example.therealcookbook.Recipes.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    @Mock
    private RecipeRepository mockRecipeRepository;

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
    void testGetUsername_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        String result = userServiceUnderTest.getUsername(existingUser.getUsername());

        // Assert
        assertEquals(existingUser.getUsername(), result);
    }

    @Test
    void testGetUsername_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.getUsername("nonexistentUser")
        );
    }

    @Test
    void testGetEmail_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setEmail("existingUser@example.com");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        String result = userServiceUnderTest.getEmail(existingUser.getUsername());

        // Assert
        assertEquals(existingUser.getEmail(), result);
    }

    @Test
    void testGetEmail_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.getEmail("nonexistentUser")
        );
    }

    @Test
    void testGetOwnRecipes_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe recipe1 = new Recipe();
        recipe1.setId(1);
        recipe1.setName("Recipe 1");

        Recipe recipe2 = new Recipe();
        recipe2.setId(2);
        recipe2.setName("Recipe 2");

        existingUser.setOwnRecipes(List.of(recipe1, recipe2));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        List<Recipe> result = userServiceUnderTest.getOwnRecipes(existingUser.getUsername());

        // Assert
        assertEquals(existingUser.getOwnRecipes(), result);
    }

    @Test
    void testGetOwnRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.getOwnRecipes("nonexistentUser")
        );
    }

    @Test
    void testGetOwnRecipes_UserExistsNoRecipes() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setOwnRecipes(Collections.emptyList());

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        List<Recipe> result = userServiceUnderTest.getOwnRecipes(existingUser.getUsername());

        // Assert
        assertEquals(existingUser.getOwnRecipes(), result);
    }

    @Test
    void testAddOwnRecipe_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe recipeToAdd = new Recipe();
        recipeToAdd.setName("New Recipe");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.save(existingUser)).thenReturn(existingUser);

        // Act
        userServiceUnderTest.addOwnRecipe(existingUser.getUsername(), recipeToAdd);

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);

        List<Recipe> ownRecipes = existingUser.getOwnRecipes();
        assertNotNull(ownRecipes);
        assertEquals(1, ownRecipes.size());
        assertEquals(recipeToAdd, ownRecipes.get(0));
    }

    @Test
    void testAddOwnRecipe_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.addOwnRecipe("nonexistentUser", new Recipe())
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testAddOwnRecipe_NullOwnRecipesList() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe recipeToAdd = new Recipe();
        recipeToAdd.setName("New Recipe");

        // Simulate a case where the user's ownRecipes list is null
        existingUser.setOwnRecipes(null);

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.save(existingUser)).thenReturn(existingUser);

        // Act
        userServiceUnderTest.addOwnRecipe(existingUser.getUsername(), recipeToAdd);

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);

        List<Recipe> ownRecipes = existingUser.getOwnRecipes();
        assertNotNull(ownRecipes);
        assertEquals(1, ownRecipes.size());
        assertEquals(recipeToAdd, ownRecipes.get(0));
    }

    @Test
    void testUpdateOwnRecipe_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setOwnRecipes(new ArrayList<>(List.of(existingRecipe)));

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setId(1);
        updatedRecipe.setName("Updated Recipe");
        updatedRecipe.setDescription("An updated delicious recipe");
        updatedRecipe.setServings(6);
        updatedRecipe.setVegan(false);
        updatedRecipe.setVegetarian(false);
        updatedRecipe.setLactose(true);
        updatedRecipe.setGluten(true);

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.save(existingUser)).thenReturn(existingUser);

        // Act
        userServiceUnderTest.updateOwnRecipe(existingUser.getUsername(), updatedRecipe);

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);

        List<Recipe> ownRecipes = existingUser.getOwnRecipes();
        assertNotNull(ownRecipes);
        assertEquals(1, ownRecipes.size());

        Recipe updatedRecipeResult = ownRecipes.get(0);
        assertEquals(updatedRecipe.getName(), updatedRecipeResult.getName());
        assertEquals(updatedRecipe.getDescription(), updatedRecipeResult.getDescription());
        assertEquals(updatedRecipe.getServings(), updatedRecipeResult.getServings());
        assertEquals(updatedRecipe.isVegan(), updatedRecipeResult.isVegan());
        assertEquals(updatedRecipe.isVegetarian(), updatedRecipeResult.isVegetarian());
        assertEquals(updatedRecipe.isLactose(), updatedRecipeResult.isLactose());
        assertEquals(updatedRecipe.isGluten(), updatedRecipeResult.isGluten());
    }

    @Test
    void testUpdateOwnRecipe_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updateOwnRecipe("nonexistentUser", new Recipe())
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testUpdateOwnRecipe_UserExistsNoOwnRecipes() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setOwnRecipes(new ArrayList<>());

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setId(1);
        updatedRecipe.setName("Updated Recipe");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.save(existingUser)).thenReturn(existingUser);

        // Act
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updateOwnRecipe(existingUser.getUsername(), updatedRecipe)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testUpdateOwnRecipe_RecipeNotFound() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setOwnRecipes(new ArrayList<>(List.of(existingRecipe)));

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setId(2);
        updatedRecipe.setName("Updated Recipe");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updateOwnRecipe(existingUser.getUsername(), updatedRecipe)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testDeleteOwnRecipe_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setOwnRecipes(new ArrayList<>(List.of(existingRecipe)));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.save(existingUser)).thenReturn(existingUser);

        // Act
        userServiceUnderTest.deleteOwnRecipe(existingUser.getUsername(), existingRecipe.getId());

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);

        List<Recipe> ownRecipes = existingUser.getOwnRecipes();
        assertNotNull(ownRecipes);
        assertTrue(ownRecipes.isEmpty());
    }

    @Test
    void testDeleteOwnRecipe_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.deleteOwnRecipe("nonexistentUser", 1)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testDeleteOwnRecipe_UserExistsNoOwnRecipes() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setOwnRecipes(new ArrayList<>());

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.deleteOwnRecipe(existingUser.getUsername(), 1)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testDeleteOwnRecipe_RecipeNotFound() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setOwnRecipes(new ArrayList<>(List.of(existingRecipe)));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.deleteOwnRecipe(existingUser.getUsername(), 2)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testGetFavouriteRecipes_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe favRecipe1 = new Recipe();
        favRecipe1.setId(1);
        favRecipe1.setName("Favorite Recipe 1");

        Recipe favRecipe2 = new Recipe();
        favRecipe2.setId(2);
        favRecipe2.setName("Favorite Recipe 2");

        existingUser.setFavouriteRecipes(new ArrayList<>(List.of(favRecipe1, favRecipe2)));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        List<Recipe> favouriteRecipes = userServiceUnderTest.getFavouriteRecipes(existingUser.getUsername());

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        assertEquals(2, favouriteRecipes.size());
        assertTrue(favouriteRecipes.contains(favRecipe1));
        assertTrue(favouriteRecipes.contains(favRecipe2));
    }

    @Test
    void testGetFavouriteRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.getFavouriteRecipes("nonexistentUser")
        );

        // Verify that findByUsername method is called
        verify(mockUserRepository, times(1)).findByUsername("nonexistentUser");
    }

    @Test
    void testGetFavouriteRecipes_NoFavouriteRecipes() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setFavouriteRecipes(new ArrayList<>());

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        List<Recipe> favouriteRecipes = userServiceUnderTest.getFavouriteRecipes(existingUser.getUsername());

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        assertTrue(favouriteRecipes.isEmpty());
    }

    @Test
    void testAddToMyFavouriteRecipes_UserExistsAndRecipeExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setFavouriteRecipes(new ArrayList<>());

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockRecipeRepository.findById(existingRecipe.getId())).thenReturn(Optional.of(existingRecipe));

        // Act
        userServiceUnderTest.addToMyFavouriteRecipes(existingUser.getUsername(), existingRecipe.getId());

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockRecipeRepository, times(1)).findById(existingRecipe.getId());

        List<Recipe> favouriteRecipes = existingUser.getFavouriteRecipes();
        assertNotNull(favouriteRecipes);
        assertEquals(1, favouriteRecipes.size());
        assertTrue(favouriteRecipes.contains(existingRecipe));

        verify(mockUserRepository, times(1)).save(existingUser);
    }

    @Test
    void testAddToMyFavouriteRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.addToMyFavouriteRecipes("nonexistentUser", 1)
        );

        // Verify that findById method is not called
        verify(mockRecipeRepository, never()).findById(any());
    }

    @Test
    void testAddToMyFavouriteRecipes_RecipeDoesNotExist() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockRecipeRepository.findById(1)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.addToMyFavouriteRecipes(existingUser.getUsername(), 1)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testAddToMyFavouriteRecipes_RecipeAlreadyInFavorites() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setFavouriteRecipes(new ArrayList<>(List.of(existingRecipe)));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockRecipeRepository.findById(existingRecipe.getId())).thenReturn(Optional.of(existingRecipe));

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.addToMyFavouriteRecipes(existingUser.getUsername(), existingRecipe.getId())
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testRemoveFromFavouriteRecipes_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setFavouriteRecipes(new ArrayList<>(List.of(existingRecipe)));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
        when(mockUserRepository.save(existingUser)).thenReturn(existingUser);

        // Act
        userServiceUnderTest.removeFromFavouriteRecipes(existingUser.getUsername(), existingRecipe.getId());

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);

        List<Recipe> favouriteRecipes = existingUser.getFavouriteRecipes();
        assertNotNull(favouriteRecipes);
        assertTrue(favouriteRecipes.isEmpty());
    }

    @Test
    void testRemoveFromFavouriteRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.removeFromFavouriteRecipes("nonexistentUser", 1)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testRemoveFromFavouriteRecipes_UserExistsNoFavouriteRecipes() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setFavouriteRecipes(new ArrayList<>());

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.removeFromFavouriteRecipes(existingUser.getUsername(), 1)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testRemoveFromFavouriteRecipes_RecipeNotFound() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Existing Recipe");

        existingUser.setFavouriteRecipes(new ArrayList<>(List.of(existingRecipe)));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.removeFromFavouriteRecipes(existingUser.getUsername(), 2)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testLogin_ValidCredentials() {
        // Arrange
        String email = "johndoe@example.com";
        String password = "secret";

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        when(mockUserRepository.findByEmail(email)).thenReturn(user);

        // Act
        User loggedInUser = userServiceUnderTest.login(email, password);

        // Assert
        assertNotNull(loggedInUser);
        assertEquals(email, loggedInUser.getEmail());
        assertEquals(password, loggedInUser.getPassword());

        // Verify that findByEmail method is called once with the correct email
        verify(mockUserRepository, times(1)).findByEmail(email);
    }

    @Test
    void testLogin_InvalidCredentials() {
        // Arrange
        String email = "johndoe@example.com";
        String password = "wrongpassword";

        when(mockUserRepository.findByEmail(email)).thenReturn(null);

        // Act
        User loggedInUser = userServiceUnderTest.login(email, password);

        // Assert
        assertNull(loggedInUser);

        // Verify that findByEmail method is called once with the correct email
        verify(mockUserRepository, times(1)).findByEmail(email);
    }

}
