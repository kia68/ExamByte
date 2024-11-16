package com.example.exambyte;

import com.example.exambyte.helper.WithMockOAuth2User;
import com.example.exambyte.service.TestService;
import com.example.exambyte.users.Role;
import com.example.exambyte.users.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class ExamByteTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    TestService testService;


    @Test
    @Disabled
    @DisplayName("Die Startseite ist unter / erreichbar")
    void load() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/");
        MvcResult resultActions = mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("user"))
                .andReturn();

        String html = resultActions.getResponse().getContentAsString();
        System.out.println(html);
        assertThat(html).contains("body");
    }




    @Test
    @WithMockOAuth2User
    @DisplayName("Die Startseite ist für get request Erreichbar")
    void test01() throws Exception{
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Die Startseite ist für get request zeigt home an")
    void test02() throws Exception{
        mvc.perform(get("/"))
                .andExpect(view().name("home"));
    }

    @Test
    @DisplayName("Beim Get Request auf / enthält Model userList")
    void test03() throws Exception{
        mvc.perform(get("/"))
                .andExpect(model().attribute("user", testService.userList()));
    }

    @Test
    @DisplayName("Die /test seite ist für get request erreichbar")
    void test04() throws Exception{
        mvc.perform(get("/tests"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Die /test seite ist für get request zeigt tests an")
    void test05() throws Exception{
        mvc.perform(get("/tests"))
                .andExpect(view().name("tests"));
    }

    @Test
    @DisplayName("beim get request auf /tests enthäht model testList")
    void test06() throws Exception{
        mvc.perform(get("/tests"))
                .andExpect(model().attribute("tests", testService.getTests()));
    }

    @Test
    @DisplayName("Route redirect:/ ist für post Requests erreichbar")
    void test07() throws Exception{
        mvc.perform(post("/"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @DisplayName("Ohne Übergabe-Parameter wird :/ View angezeigt")
    void test08() throws Exception{
        mvc.perform(post("/"))
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @DisplayName("mit Übergabe-Parameter wird :/ View angezeigt")
    void test09() throws Exception{
        mvc.perform(post("/")
                        .param("email", "test@aa.com")
                        .param("role", "student"))
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @DisplayName("mit Übergabe-Parameter wird es ins model hinzugefügt")
    void test10() throws Exception{
        Email email = new Email("test@aa.com");
        Role role = new Role("student");
        User user = new User(email, role);
        List mock = mock(List.class);
        when(testService.userList()).thenReturn(mock);
        mvc.perform(post("/")
                        .param("email", "test@aa.com")
                        .param("role", "student"));
        verify(mock).add(user);
    }

    @Test
    @DisplayName("Die /addAufgabe ist für get request erreichbar")
    void test11() throws Exception{
        mvc.perform(get("/addAufgabe"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Die /addAufgabe ist für get request zeigt aufgaben an ")
    void test12() throws Exception{
        mvc.perform(get("/addAufgabe"))
                .andExpect(view().name("addAufgabe"));
    }

    @Test
    @DisplayName("Die /aufgabe ist für get request zeigt aufgaben an ")
    void test13() throws Exception{
        mvc.perform(get("/addAufgabe"))
                .andExpect(model().attribute("aufgabe", testService.getAufgaben()));
    }


}