package nl.codecentric.pissalot.core.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
public class UserTest {

    private User user;

    @Before
    public void before() {
        user = new User();
    }

    @Test
    public void testToString() {
        final String displayName = "blabla";
        user.setDisplayName(displayName);
        Assert.assertEquals(String.format("User(%s)",displayName), user.toString());

    }
}
