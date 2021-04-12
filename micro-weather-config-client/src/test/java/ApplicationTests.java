import com.stackstone.weather.config.client.ConfigClientApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Copyright (c) 2021 Oriental Standard All rights reserved.</p>
 *
 * @author LiLei
 * @version 1.0.0
 * @date 2021/4/12 10:50
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigClientApplication.class)
class ApplicationTests {

    @Value("${auther}")
    private String auther;

    @Test
    void contextLoads() {
        Assertions.assertEquals("waylau.com", auther);
    }
}
