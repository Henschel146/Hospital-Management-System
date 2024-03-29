package org.group3.hospitalmanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class HospitalManagementSystemApplicationTests {

    @Autowired
    private PasswordEncoder encoder;

    @Test
    void contextLoads() {
        System.out.println(encoder.encode("pass"));
    }

}
