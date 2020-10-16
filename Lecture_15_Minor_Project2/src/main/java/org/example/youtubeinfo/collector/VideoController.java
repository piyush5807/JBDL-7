package org.example.youtubeinfo.collector;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class.getCanonicalName());

    @Autowired
    VideoService service;

    @GetMapping("/search")
    public List<Video> searchVideos(@RequestParam("key") String key) throws Exception{

        if(key.length() < 1){
            throw new Exception("Search string is empty");
        }

        return service.searchVideos(key);
    }

    @GetMapping("/list")
    public List<Video> listAllVideos(@RequestParam(value = "page_no", required = false, defaultValue = "1") int page_no,
                                     @RequestParam(value = "page_size", required = false, defaultValue = "10") int page_size){

        return service.listVideos(page_no, page_size);
    }

    @PostMapping("/fetch_yt_videos")
    public void fetchVideoFromYoutube(@RequestParam(value = "keyword")String keyword) throws IOException, ParseException {
        service.populateDB(keyword);
    }
}
