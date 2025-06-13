package com.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UserTest {

        private User user;

        @Test
        public void nullUser() {
                Assertions.assertNull(user);
        }
        
        @Test
        public void nonNullUser() {
        		user = new User();
                Assertions.assertNotNull(user);
        }

//      @Test
//      public void testSetFirstName() {
//              String firstName = "hello";
//              assertEquals(firstName,user.getEmailId());
//      }
}