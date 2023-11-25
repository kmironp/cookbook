package com.example.therealcookbook.Users;

import com.example.therealcookbook.Recipes.Recipe;
import com.example.therealcookbook.Recipes.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

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

    @Test
    void testGetAllOwnRecipes_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setOwnRecipes(Collections.singletonList(new Recipe()));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        List<Recipe> result = userServiceUnderTest.getAllOwnRecipes(existingUser.getUsername());

        // Assert
        assertEquals(existingUser.getOwnRecipes(), result);
    }

    @Test
    void testGetAllOwnRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.getAllOwnRecipes("nonexistentUser")
        );
    }

    @Test
    void testUpdateOwnRecipe_UserExists_RecipeExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(1);
        existingRecipe.setName("Old Recipe");
        existingRecipe.setDescription("Old Description");

        existingUser.setOwnRecipes(Collections.singletonList(existingRecipe));

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setName("Updated Recipe");
        updatedRecipe.setDescription("Updated Description");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        userServiceUnderTest.updateOwnRecipe(existingUser.getUsername(), 1, updatedRecipe);

        // Assert
        verify(mockUserRepository, times(1)).save(existingUser);
        assertTrue(existingUser.getOwnRecipes().stream().anyMatch(r -> r.getName().equals("Updated Recipe")));
    }

    @Test
    void testUpdateOwnRecipe_UserExists_RecipeNotFound() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        existingUser.setOwnRecipes(new ArrayList<>());  // Empty list

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setName("Updated Recipe");
        updatedRecipe.setDescription("Updated Description");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updateOwnRecipe(existingUser.getUsername(), 1, updatedRecipe)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testUpdateOwnRecipe_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setName("Updated Recipe");
        updatedRecipe.setDescription("Updated Description");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.updateOwnRecipe("nonexistentUser", 1, updatedRecipe)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testDeleteOwnRecipe_UserExists_RecipeExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe recipeToDelete = new Recipe();
        recipeToDelete.setId(123);

        List<Recipe> ownRecipes = new ArrayList<>();
        ownRecipes.add(recipeToDelete);
        existingUser.setOwnRecipes(ownRecipes);

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        userServiceUnderTest.deleteOwnRecipe(existingUser.getUsername(), 123);

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);
    }

    @Test
    void testDeleteOwnRecipe_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.deleteOwnRecipe("nonexistentUser", 123)
        );

        // Verify that save/update methods are not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testDeleteOwnRecipe_RecipeDoesNotExist() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.deleteOwnRecipe(existingUser.getUsername(), 123)
        );

        // Verify that save/update methods are not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testUploadOwnRecipe_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("New Recipe");

        // Act
        userServiceUnderTest.uploadOwnRecipe(existingUser.getUsername(), newRecipe);

        // Assert
        verify(mockUserRepository, times(1)).save(existingUser);
        assertTrue(existingUser.getOwnRecipes().contains(newRecipe));
    }

    @Test
    void testUploadOwnRecipe_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("New Recipe");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.uploadOwnRecipe("nonexistentUser", newRecipe)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testGetAllFavouriteRecipes_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");

        Recipe favouriteRecipe1 = new Recipe();
        favouriteRecipe1.setId(1);
        favouriteRecipe1.setName("Favourite Recipe 1");

        Recipe favouriteRecipe2 = new Recipe();
        favouriteRecipe2.setId(2);
        favouriteRecipe2.setName("Favourite Recipe 2");

        existingUser.setFavouriteRecipes(List.of(favouriteRecipe1, favouriteRecipe2));

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        List<Recipe> result = userServiceUnderTest.getAllFavouriteRecipes(existingUser.getUsername());

        // Assert
        assertEquals(existingUser.getFavouriteRecipes(), result);
    }

    @Test
    void testGetAllFavouriteRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.getAllFavouriteRecipes("nonexistentUser")
        );
    }

    @Test
    void testRemoveOneFromMyFavoriteRecipes_UserExistsAndRecipeExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        Recipe recipeToRemove = new Recipe();
        recipeToRemove.setId(123);

        List<Recipe> favoriteRecipes = new ArrayList<>();
        favoriteRecipes.add(recipeToRemove);
        existingUser.setFavouriteRecipes(favoriteRecipes);

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        userServiceUnderTest.removeOneFromMyFavoriteRecipes(existingUser.getUsername(), recipeToRemove.getId());

        // Assert
        verify(mockUserRepository, times(1)).findByUsername(existingUser.getUsername());
        verify(mockUserRepository, times(1)).save(existingUser);

        // Check if the recipe has been removed from favoriteRecipes
        assertFalse(existingUser.getFavouriteRecipes().contains(recipeToRemove));
    }

    @Test
    void testRemoveOneFromMyFavoriteRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.removeOneFromMyFavoriteRecipes("nonexistentUser", 123)
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testRemoveOneFromMyFavoriteRecipes_UserExistsAndRecipeDoesNotExist() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        Recipe recipeToRemove = new Recipe();
        recipeToRemove.setId(123);

        List<Recipe> favoriteRecipes = new ArrayList<>();
        existingUser.setFavouriteRecipes(favoriteRecipes);

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.removeOneFromMyFavoriteRecipes(existingUser.getUsername(), recipeToRemove.getId())
        );

        // Verify that save method is not called
        verify(mockUserRepository, never()).save(any());
    }

    @Test
    void testAddToMyFavouriteRecipes_UserExists() {
        // Arrange
        User existingUser = new User();
        existingUser.setUsername("existingUser");
        existingUser.setFavouriteRecipes(new ArrayList<>());

        Recipe recipeToAdd = new Recipe();
        recipeToAdd.setName("Favorite Recipe");
        recipeToAdd.setDescription("Delicious dish");

        when(mockUserRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);

        // Act
        userServiceUnderTest.addToMyFavouriteRecipes(existingUser.getUsername(), recipeToAdd);

        // Assert
        assertEquals(1, existingUser.getFavouriteRecipes().size());
        assertEquals("Favorite Recipe", existingUser.getFavouriteRecipes().get(0).getName());
    }

    @Test
    void testAddToMyFavouriteRecipes_UserDoesNotExist() {
        // Arrange
        when(mockUserRepository.findByUsername("nonexistentUser")).thenReturn(null);

        Recipe recipeToAdd = new Recipe();
        recipeToAdd.setName("Favorite Recipe");
        recipeToAdd.setDescription("Delicious dish");

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () ->
                userServiceUnderTest.addToMyFavouriteRecipes("nonexistentUser", recipeToAdd)
        );
    }

    @Test
    void testGetAllRecipesAllUserAvailable() {
        // Arrange
        Recipe recipe1 = new Recipe();
        recipe1.setId(1);
        recipe1.setName("Recipe 1");

        Recipe recipe2 = new Recipe();
        recipe2.setId(2);
        recipe2.setName("Recipe 2");

        List<Recipe> allRecipes = new ArrayList<>();
        allRecipes.add(recipe1);
        allRecipes.add(recipe2);

        when(mockRecipeRepository.findAll()).thenReturn(allRecipes);

        // Act
        List<Recipe> result = userServiceUnderTest.getAllRecipesAllUserAvailable();

        // Assert
        assertEquals(allRecipes, result);
    }

    @Test
    void testGetRecipesByName() {
        // Arrange
        String searchName = "chicken";

        Recipe chickenRecipe1 = new Recipe();
        chickenRecipe1.setId(1);
        chickenRecipe1.setName("Chicken Curry");

        Recipe chickenRecipe2 = new Recipe();
        chickenRecipe2.setId(2);
        chickenRecipe2.setName("Grilled Chicken");

        List<Recipe> matchingRecipes = new ArrayList<>();
        matchingRecipes.add(chickenRecipe1);
        matchingRecipes.add(chickenRecipe2);

        when(mockRecipeRepository.findByNameContainingIgnoreCase(searchName)).thenReturn(matchingRecipes);

        // Act
        List<Recipe> result = userServiceUnderTest.getRecipesByName(searchName);

        // Assert
        assertEquals(matchingRecipes, result);
    }

    @Test
    void testGetRecipeByIncludeIngredient() {
        // Arrange
        String searchIngredient = "chicken";

        Recipe chickenRecipe1 = new Recipe();
        chickenRecipe1.setId(1);
        chickenRecipe1.setName("Chicken Curry");
        chickenRecipe1.setIngredientNames(List.of("chicken", "rice", "curry sauce"));

        Recipe chickenRecipe2 = new Recipe();
        chickenRecipe2.setId(2);
        chickenRecipe2.setName("Grilled Chicken");
        chickenRecipe2.setIngredientNames(List.of("chicken", "lemon", "garlic"));

        List<Recipe> matchingRecipes = new ArrayList<>();
        matchingRecipes.add(chickenRecipe1);
        matchingRecipes.add(chickenRecipe2);

        when(mockRecipeRepository.findByIngredientNamesContainingIgnoreCase(searchIngredient)).thenReturn(matchingRecipes);

        // Act
        List<Recipe> result = userServiceUnderTest.getRecipeByIncludeIngredient(searchIngredient);

        // Assert
        assertEquals(matchingRecipes, result);
    }

    @Test
    void testGetRecipeIfIncludeSpecialDemand() {
        // Arrange
        Recipe specialRecipe1 = new Recipe();
        specialRecipe1.setId(1);
        specialRecipe1.setName("Special Recipe 1");
        specialRecipe1.setVegan(true);
        specialRecipe1.setVegetarian(true);
        specialRecipe1.setLactose(true);
        specialRecipe1.setGluten(true);

        Recipe specialRecipe2 = new Recipe();
        specialRecipe2.setId(2);
        specialRecipe2.setName("Special Recipe 2");
        specialRecipe2.setVegan(true);
        specialRecipe2.setVegetarian(false);
        specialRecipe2.setLactose(true);
        specialRecipe2.setGluten(true);

        List<Recipe> specialRecipes = new ArrayList<>();
        specialRecipes.add(specialRecipe1);
        specialRecipes.add(specialRecipe2);

        when(mockRecipeRepository.findByVeganIsTrueAndVegetarianIsTrueAndLactoseIsTrueAndGlutenIsTrue()).thenReturn(specialRecipes);

        // Act
        List<Recipe> result = userServiceUnderTest.getRecipeIfIncludeSpecialDemand();

        // Assert
        assertEquals(specialRecipes, result);
    }

    @Test
    void testGetRecipeIfNotIncludeSpecialDemand() {
        // Arrange
        Recipe nonVeganNonVegetarianNonGlutenFreeRecipe1 = new Recipe();
        nonVeganNonVegetarianNonGlutenFreeRecipe1.setId(1);
        nonVeganNonVegetarianNonGlutenFreeRecipe1.setName("Non-Vegan Non-Vegetarian Non-Gluten-Free Dish");
        nonVeganNonVegetarianNonGlutenFreeRecipe1.setVegan(false);
        nonVeganNonVegetarianNonGlutenFreeRecipe1.setVegetarian(false);
        nonVeganNonVegetarianNonGlutenFreeRecipe1.setLactose(true); // Can contain lactose
        nonVeganNonVegetarianNonGlutenFreeRecipe1.setGluten(false);

        Recipe nonVeganNonVegetarianNonGlutenFreeRecipe2 = new Recipe();
        nonVeganNonVegetarianNonGlutenFreeRecipe2.setId(2);
        nonVeganNonVegetarianNonGlutenFreeRecipe2.setName("Another Non-Vegan Non-Vegetarian Non-Gluten-Free Dish");
        nonVeganNonVegetarianNonGlutenFreeRecipe2.setVegan(false);
        nonVeganNonVegetarianNonGlutenFreeRecipe2.setVegetarian(false);
        nonVeganNonVegetarianNonGlutenFreeRecipe2.setLactose(true); // Can contain lactose
        nonVeganNonVegetarianNonGlutenFreeRecipe2.setGluten(false);

        List<Recipe> nonVeganNonVegetarianNonGlutenFreeRecipes = new ArrayList<>();
        nonVeganNonVegetarianNonGlutenFreeRecipes.add(nonVeganNonVegetarianNonGlutenFreeRecipe1);
        nonVeganNonVegetarianNonGlutenFreeRecipes.add(nonVeganNonVegetarianNonGlutenFreeRecipe2);

        when(mockRecipeRepository.findByVeganIsFalseAndVegetarianIsFalseAndLactoseIsFalseAndGlutenIsFalse())
                .thenReturn(nonVeganNonVegetarianNonGlutenFreeRecipes);

        // Act
        List<Recipe> result = userServiceUnderTest.getRecipeIfNotIncludeSpecialDemand();

        // Assert
        assertEquals(nonVeganNonVegetarianNonGlutenFreeRecipes, result);
    }

    @Test
    void testUpdateRecipeServings() {
        // Arrange
        Integer recipeId = 1;
        Integer newServings = 4;

        User user = new User();
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);

        when(mockRecipeRepository.findById(recipeId)).thenReturn(Optional.of(recipe));

        // Act
        userServiceUnderTest.updateRecipeServings(recipeId, newServings);

        // Assert
        verify(mockRecipeRepository, times(1)).findById(recipeId);
        verify(mockRecipeRepository, times(1)).save(recipe);

        // Add additional assertions based on your specific requirements
    }

    @Test
    void testUpdateRecipeServings_RecipeNotFound() {
        // Arrange
        Integer recipeId = 1;
        Integer newServings = 4;

        when(mockRecipeRepository.findById(recipeId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
                () -> userServiceUnderTest.updateRecipeServings(recipeId, newServings));

        // Verify that findById is called
        verify(mockRecipeRepository, times(1)).findById(recipeId);
        // Verify that save is not called
        verify(mockRecipeRepository, never()).save(any());
    }

    @Test
    void testUpdateRecipeIngredientAmounts() {
        // Arrange
        Integer recipeId = 1;
        List<Integer> newIngredientAmounts = Arrays.asList(100, 200, 300);

        User user = new User();
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);

        when(mockRecipeRepository.findById(recipeId)).thenReturn(Optional.of(recipe));

        // Act
        userServiceUnderTest.updateRecipeIngredientAmounts(recipeId, newIngredientAmounts);

        // Assert
        verify(mockRecipeRepository, times(1)).findById(recipeId);
        verify(mockRecipeRepository, times(1)).save(recipe);

        // Add additional assertions based on your specific requirements
    }

    @Test
    void testUpdateRecipeIngredientAmounts_RecipeNotFound() {
        // Arrange
        Integer recipeId = 1;
        List<Integer> newIngredientAmounts = Arrays.asList(100, 200, 300);

        when(mockRecipeRepository.findById(recipeId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
                () -> userServiceUnderTest.updateRecipeIngredientAmounts(recipeId, newIngredientAmounts));

        // Verify that findById is called
        verify(mockRecipeRepository, times(1)).findById(recipeId);
        // Verify that save is not called
        verify(mockRecipeRepository, never()).save(any());
    }

}
