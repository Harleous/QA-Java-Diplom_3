package dataProvider;

import org.apache.commons.lang3.RandomStringUtils;

public class RegFormRandomData {

    public static CreateClient randomClientData() {

        CreateClient createClient = new CreateClient();
        createClient.setName(RandomStringUtils.randomAlphabetic(9));
        createClient.setEmail(RandomStringUtils.randomAlphabetic(6)
                + System.currentTimeMillis()
                + "@mail.com");
        createClient.setPassword(RandomStringUtils.randomAlphabetic(6)
                + System.currentTimeMillis());
        return createClient;
    }


    public static String createRandomWrongPassword() {
        return RandomStringUtils.randomAlphabetic(5);

    }

}