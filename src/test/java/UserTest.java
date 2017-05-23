import by.issue_tracker.config.JdbcConfig;
import by.issue_tracker.config.WebConfig;
import by.issue_tracker.model.User;
import by.issue_tracker.service.IUserService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
public class UserTest {
    private User user;

    @Autowired
    private IUserService userService;

    @Before
    public void setUp() {
        user = new User();
        user.setId(100);
        user.setFirstName("Jack");
        user.setLastName("Pavlov");
        user.setEmail("jack@mail.ru");
        user.setPassword("b59c67bf196a4758191e42f76670ceba");
        user.setRoleId(1);
    }

    @Test
    public void testCreateUser() throws Exception {
        boolean created = userService.create(user);
        Assert.assertEquals(true, created);
    }

    @Test
    public void testUpdateUser() throws Exception {
        user.setFirstName("Vadim");
        boolean updated = userService.update(user);
        Assert.assertEquals(true, updated);
    }

    @Test
    public void testDeleteUser() throws Exception {
        boolean deleted = userService.delete(user.getId());
        Assert.assertEquals(true, deleted);
    }


}
