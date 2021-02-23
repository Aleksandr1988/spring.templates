package com.demonstration.spring.bean.life.cycle;

import com.demonstration.spring.bean.life.cycle.beans.PrototypeBean;
import com.demonstration.spring.bean.life.cycle.beans.SingletonBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() {
        assertThat(SingletonBean.isCreated()).isTrue();
        assertThat(PrototypeBean.isCreated()).isFalse();

        assertThat(context.getBean("prototype_bean"))
                .isNotNull()
                .isInstanceOf(PrototypeBean.class);
        assertThat(PrototypeBean.isCreated()).isTrue();
    }
}
