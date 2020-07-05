package com.hhjang.techblognotification.crawler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WooWaBrosServiceTest {
    @Autowired
    WooWaBrosService service;

    @Test
    public void temp() throws IOException {
        service.crawling();
    }

    @Test
    public void getDate() {
        String temp = "/experience/2020/06/26/custom-annotation.html";


    }
}