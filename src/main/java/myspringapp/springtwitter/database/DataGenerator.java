package myspringapp.springtwitter.database;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataGenerator {

    public String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public int generateRandomInt() {
        return RandomUtils.nextInt(18,60);
    }

    public String generateRandomDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date randomDate = new Date(System.currentTimeMillis() - RandomUtils.nextLong(0,365) * 24 * 60 * 60 * 1000);
        return sdf.format(randomDate);
    }
}
