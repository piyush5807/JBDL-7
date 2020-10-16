package org.example.youtubeinfo.collector;

import org.json.simple.JSONObject;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Video {

    @Indexed(name = "videoId", unique = true, background = true)
    private String videoId;

    @TextIndexed
    private String description;

    @TextIndexed
    private String title;

    private JSONObject thumbnails;

    private Date publishDate;

    public Video(String videoId, String description, String title, JSONObject thumbnails, Date publishDate) {
        this.videoId = videoId;
        this.description = description;
        this.title = title;
        this.thumbnails = thumbnails;
        this.publishDate = publishDate;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JSONObject getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(JSONObject thumbnails) {
        this.thumbnails = thumbnails;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
