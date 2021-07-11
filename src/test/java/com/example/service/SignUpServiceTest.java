package com.example.service;

import com.example.AbstractContextServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SignUpServiceTest extends AbstractContextServiceTest {

    @Autowired
    private SignUpService signUpService;

    @Test
    public void signUpTest() {
        int res = signUpService.createUsers();
        Assert.assertEquals(1,res);
    }

}
