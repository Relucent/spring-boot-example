package yyl.springboot;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
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
