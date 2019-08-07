package dev.ankang.design.pattern.creational.simplefactory;

import org.junit.Test;

import java.util.Optional;


public class VideoTest {

    @Test
    public void getVideoByName() {
        VideoFactory factory = new VideoFactory();
        Optional<Video> optional = Optional.ofNullable(factory.getVideo("FE"));
        optional.ifPresent(e -> e.product());
    }

    @Test
    public void getVideoByClass() {
        VideoFactory videoFactory = new VideoFactory();
        Optional<Video> video = Optional.ofNullable(videoFactory.getVideo(JavaVideo.class));
        video.ifPresent(e -> e.product());
    }
}