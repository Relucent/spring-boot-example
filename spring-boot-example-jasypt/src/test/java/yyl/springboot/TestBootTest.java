package yyl.springboot;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBootTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void test() {
        String plaintext = "123456789";
        System.out.println(stringEncryptor.encrypt(plaintext));
        System.out.println(stringEncryptor.encrypt(plaintext));
        System.out.println(stringEncryptor.encrypt(plaintext));
    }
}
