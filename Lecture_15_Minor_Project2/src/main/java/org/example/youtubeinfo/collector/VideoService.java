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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    VideoRepository repository;

    private static YouTube youTube;

    @Value("${application.name}")
    private String application_name;

    @Value("${api.youtube.key}")
    private String youtube_api_key;

    private static String nextPageToken = null;

    VideoService(){
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();

        youTube = new YouTube.Builder(transport, jsonFactory,
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest httpRequest) throws IOException {

                    }
                }).setApplicationName(application_name).build();
    }

    public List<Video> searchVideos(String key){

        return null;
    }

    public void populateDB(String keyword) throws IOException, ParseException {
        ServiceThread thread = this.new ServiceThread(keyword);
        thread.start();
    }

    public List<Video> listVideos(int page_no, int page_size){

        return repository.getVideos(page_no, page_size);
    }

    private class ServiceThread extends Thread{

        private String nextTokenNumber;
        private String keyword;

        public ServiceThread(String keyword) {
            this.keyword = keyword;
        }

        @Override
        public void run() {

            try {
                YouTube.Search.List search = youTube.search().list(Arrays.asList("id", "snippet"));

                search.setKey(youtube_api_key);
                search.setQ(this.keyword);

                if (nextPageToken != null) {
                    search.setPageToken(nextPageToken);
                }

                SearchListResponse response = search.execute();

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

//                    publishDate = new Date(snippet.getPublishedAt());

                    Video video = new Video(videoId, description, title, thumbnails, publishDate);

                    repository.insertVideo(video);
                }

                nextPageToken = response.getNextPageToken();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
