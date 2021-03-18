package cacheklasser.cacheopgaven.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

public class User
{
    public int userId;

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId()
    { return userId; }

    public void setUserId(int userId)
    { this.userId = userId;}

    public String getDataSlow() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        String generatedString = RandomStringUtils.randomAlphabetic(1000);

        return generatedString;

    }
}
