package cat.itacademy.s04.t01.n01.config;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        PathPatternParser pathPatternParser = new PathPatternParser();

        pathPatternParser.setCaseSensitive(false);

        pathMatchConfigurer.setPatternParser(pathPatternParser);
    }
}