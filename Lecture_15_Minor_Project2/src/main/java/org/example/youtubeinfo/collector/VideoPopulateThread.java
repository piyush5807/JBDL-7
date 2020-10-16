package org.example.youtubeinfo.collector;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResultSnippet;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class VideoPopulateThread extends Thread{

    @Autowired
    VideoRepository videoRepository;

    @Value("${application.name}")
    private String application_name;

    @Value("${api.youtube.key}")
    private String youtube_api_key;

    private String nextPageToken;
    private String keyword;

    private static YouTube youTube;

    public VideoPopulateThread(){

        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();

        youTube = new YouTube.Builder(transport, jsonFactory,
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest httpRequest) throws IOException {

                    }
                }).setApplicationName(this.application_name).build();

        this.nextPageToken = null;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void run() {
        while(true){

            try {
                System.out.println(this.youtube_api_key);
                YouTube.Search.List search = youTube.search().list(Arrays.asList("id", "snippet"));

                search.setKey(this.youtube_api_key);
                search.setQ(this.keyword);

                if (nextPageToken != null) {
                    search.setPageToken(nextPageToken);
                }

                SearchListResponse response = null;

                response = search.execute();

                List<SearchResult> items = response.getItems();

                for (SearchResult item : items) {

                    String videoId = null, title = null, description = null;
                    Date publishDate = null;
                    JSONObject thumbnails = null;

                    ResourceId Id = item.getId();

                    if (Id.getKind().equals("youtube#video")) {
                        videoId = Id.getVideoId();
                    }

                    SearchResultSnippet snippet = item.getSnippet();
                    description = snippet.getDescription();
                    title = snippet.getDescription();
                    String thumbnailDetails = snippet.getThumbnails().toString();

                    thumbnails = (JSONObject) JSONValue.parseWithException(thumbnailDetails);

                    publishDate = new Date(snippet.getPublishedAt());

                    Video video = new Video(videoId, description, title, thumbnails, publishDate);

                    videoRepository.insertVideo(video);
                }

                nextPageToken = response.getNextPageToken();

                Thread.sleep(10000);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
