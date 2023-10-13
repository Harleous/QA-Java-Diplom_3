package dataProvider;

import org.apache.commons.lang3.RandomStringUtils;

public class RegFormRandomData {
    public static CreateUser getUserData() {
        CreateUser createUser = new CreateUser();
        createUser.setName(RandomStringUtils.randomAlphabetic(9));
        createUser.setEmail(RandomStringUtils.randomAlphabetic(6)
                + System.currentTimeMillis()
                + "@mail.com");
        createUser.setPassword(RandomStringUtils.randomAlphabetic(6)
                + System.currentTimeMillis());
        return createUser;
    }
}