package com.example.redis;

import com.example.AbstractContextServiceTest;
import com.example.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
public class RedisTest extends AbstractContextServiceTest {
    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testString() {
        Car c = new Car("1","BMW");
        strRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(strRedisTemplate.opsForValue().get("strKey"));
    }

    @Test
    public void testSerializable() {
        Car c = new Car("1","BMW");
        serializableRedisTemplate.opsForValue().set("car", c);
        Car car = (Car) serializableRedisTemplate.opsForValue().get("car");
        System.out.println(car.toString());
    }

}
