package com.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.model.Queries;
import com.service.QueriesService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {
	
//		@Autowired
//		private QueriesService queryService;
        
        public MockMvc setup(){
//        	@Autowired
            MockMvc mockMvc;
    		// resource: https://stackoverflow.com/questions/18813615/how-to-avoid-the-circular-view-path-exception-with-spring-mvc-test
            HomeController controller = new HomeController();
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/WEB-INF/page/");
            viewResolver.setSuffix(".jsp");
            mockMvc = standaloneSetup(controller)
            			.setViewResolvers(viewResolver)
            			.build();
            return mockMvc;
        }        
        
        @Test
        public void helloGetIsOk() throws Exception {
            MockMvc mockMvc = setup();
            mockMvc.perform(get("/hello"))
            	.andExpect(status().isOk())
            	.andDo(print());
        }
        
        @Test
        public void helloIsGetOkAndContainsExpectedModelAndView() throws Exception {
            MockMvc mockMvc = setup();
            MvcResult result = mockMvc.perform(get("/hello")).andReturn();
            ModelAndView mav = result.getModelAndView();
            Assertions.assertNotNull(mav);
            Assertions.assertEquals("hello",mav.getViewName());
            Assertions.assertEquals("Hello World",mav.getModelMap().get("hello"));
        }
        
        @Test
        public void index1GetIsOk() throws Exception {
                MockMvc mockMvc = setup();
                mockMvc.perform(get("/index1"))
                .andExpect(status().isOk())
                .andDo(print());
        }       
        
        @Test
        public void contactUsGetContainsExpectedModelAndViewAndNonNullContactForm() throws Exception {
                MockMvc mockMvc = setup();
                MvcResult result = mockMvc.perform(get("/contactus"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
                ModelAndView mav = result.getModelAndView();
                Assertions.assertNotNull(mav);
                Assertions.assertEquals("contactUs",mav.getViewName());
                Assertions.assertNotNull(mav.getModelMap().get("contact"));
        }
        
        @Test
        public void contactUsSetEmailSetSubjectAndSetMessageWorkAsExpected() throws Exception {
                MockMvc mockMvc = setup();
                MvcResult result0 = mockMvc.perform(get("/contactus")).andReturn();
                ModelAndView mav = result0.getModelAndView();
                Queries testQuery = (Queries) mav.getModelMap().get("contact");
                testQuery.setEmail("testemail@shopieasy.com");
                testQuery.setSubject("test email");
                testQuery.setMessage("this is a test message");
                Assertions.assertNotNull(testQuery);
                Assertions.assertEquals("testemail@shopieasy.com",testQuery.getEmail());
                Assertions.assertEquals("test email",testQuery.getSubject());
                Assertions.assertEquals("this is a test message",testQuery.getMessage());
        }
        
        
        @Test
        public void contactUsPostIsOk() throws Exception {
                MockMvc mockMvc = setup();
                MvcResult result0 = mockMvc.perform(get("/contactus")).andReturn();
                ModelAndView mav = result0.getModelAndView();
                Queries testQuery = (Queries) mav.getModelMap().get("contact");
                testQuery.setEmail("testemail@shopieasy.com");
                testQuery.setSubject("test email");
                testQuery.setMessage("this is a test message");
                Assertions.assertNotNull(testQuery);
                mockMvc.perform(post("/contactus")
            					.param("email",testQuery.getEmail())
            					.param("subject",testQuery.getSubject())
            					.param("message",testQuery.getMessage()))
            					.andDo(print())
            					.andReturn();
        }
}