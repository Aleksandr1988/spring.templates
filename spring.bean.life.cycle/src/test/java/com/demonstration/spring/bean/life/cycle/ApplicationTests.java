package com.demonstration.spring.bean.life.cycle;

import com.demonstration.spring.bean.life.cycle.beans.PrototypeBean;
import com.demonstration.spring.bean.life.cycle.beans.SingletonBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
        assertThat(SingletonBean.isCreated()).isTrue();
        assertThat(PrototypeBean.isCreated()).isFalse();
    }
}
