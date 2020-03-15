package com.example;

import com.example.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class Demo01ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    private RedisTemplate<String, Employee> employeeRedisTemplate;

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Test
    void contextLoads() throws SQLException {
//        System.out.println(dataSource.getClass());
//        System.out.println(dataSource.getConnection());
//        System.out.println(new MD5Util().encode("sdsa6661"));
//        System.out.println("base64"+new Base64Util().encode("sadas"));
//        System.out.println("base64解密"+new Base64Util().decode("64c2FkYXM="));
//        System.out.println("安全散列算法SHA" + new SHAUtil().encode("sdsa6661"));
//        DESUtil desUtil = new DESUtil();
//        System.out.println("DES对称加密"+ desUtil.encode("123456"));
//        System.out.println("DES解密"+ desUtil.decode("fc5ed466358b50aa"));

//        System.out.println(JwtTokenUtil.getToken(new JwtUser()));

    }

    @Test
    public void set() {

        Employee e = new Employee();
        e.setAddress("aaa");
        e.setEmail("bb");
        employeeRedisTemplate.opsForValue().set("1", e);
        stringRedisTemplate.opsForValue().set("65", "465", 3000, TimeUnit.SECONDS);
        System.out.println(stringRedisTemplate.opsForValue().get("myKey"));
        System.out.println(stringRedisTemplate.opsForValue().size("myKey"));
        Employee employee = employeeRedisTemplate.opsForValue().get("1");
        System.out.println(employee);
        stringRedisTemplate.opsForList().rightPush("listright", "java");
        stringRedisTemplate.opsForList().rightPush("listright", "c");
        stringRedisTemplate.opsForList().rightPush("listright", "c++");
        stringRedisTemplate.opsForList().leftPush("listright", "python");

        String[] strs = new String[]{"1", "2", "3"};
        stringRedisTemplate.opsForList().rightPushAll("list", strs);
        System.out.println(stringRedisTemplate.opsForList().range("list", 0, -1));
        System.out.println(stringRedisTemplate.opsForList().index("listright", 2));

        stringRedisTemplate.opsForHash().put("aaa", "bbb1", "ccc1");
        stringRedisTemplate.opsForHash().put("aaa", "bbb2", "ccc2");
        stringRedisTemplate.opsForHash().put("aaa", "bbb3", "ccc3");
        System.out.println(stringRedisTemplate.opsForHash().hasKey("aaa", "bbb1"));
        System.out.println(stringRedisTemplate.opsForHash().hasKey("aaa", "bbb4"));
        System.out.println(stringRedisTemplate.opsForHash().keys("aaa"));

        System.out.println(stringRedisTemplate.opsForHash().values("aaa"));
        System.out.println(stringRedisTemplate.opsForHash().entries("aaa"));//获取key和value的值


    }


}
