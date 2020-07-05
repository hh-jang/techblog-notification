package com.hhjang.techblognotification.crawler;

import com.hhjang.techblognotification.post.Post;
import com.hhjang.techblognotification.post.PostRepository;
import com.hhjang.techblognotification.util.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WooWaBrosService {
    final PostRepository postRepository;

    public WooWaBrosService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void crawling() throws IOException {
        String baseUrl = "http://woowabros.github.io/";

        Document document = Jsoup.connect(baseUrl)
                .timeout(10000)
                .get();
        Elements elements = document.select(".list-module");

        elements.stream().forEach(element -> {
            String title = element.select(".post-link").text();
            String content = element.select(".post-description").text();
            String contentUrl = element.select("a").attr("href");
            String dateStr = getDateStr(contentUrl);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate date = LocalDate.parse(dateStr, formatter);

            if(DateUtil.isToday(date) == false) return;
            Post post = Post.builder()
                    .title(title)
                    .content(content)
                    .url(contentUrl)
                    .postDate(date)
                    .build();

            postRepository.save(post);
        });
    }

    private String getDateStr(String contentUrl) {
        Pattern pattern = Pattern.compile("[0-9]{4}\\/[0-9]{2}\\/[0-p]{2}");
        Matcher matcher = pattern.matcher(contentUrl);

        while (matcher.find()) {
            return matcher.group();
        }

        return "0000/00/00";
    }
}
