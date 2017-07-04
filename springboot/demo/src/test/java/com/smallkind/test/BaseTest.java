package com.smallkind.test;


import com.smallkind.DemoApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 测试抽象类
 *
 * @author zhouxiang
 * @create 2016-04-25-下午2:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
@WebAppConfiguration
public class BaseTest<T> {

    public MockMvc mockMvc;

    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Autowired
    private T t;

    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.standaloneSetup(t).build();
    }

    //模拟get请求
    public String getRequest(String url) throws Exception{
        logger.info("请求的URL:{}",url);
        //发送请求
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get(url));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        logger.info("客户端获取的反馈数据:{}",result);
        return result;
    }

    //模拟post请求,数据加密
    public String postRequest(String data,String url) throws Exception{
        logger.info("未加密的数据:{}",data);
        //发送请求
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MediaType.APPLICATION_JSON).param("json", data));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        logger.info("客户端获取的反馈数据:{}",result);
        return result;
    }

}
