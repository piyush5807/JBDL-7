package org.example.youtubeinfo.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class VideoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Video> getAllVideos(){
        return mongoTemplate.findAll(Video.class);
    }

    public List<Video> getVideos(int page_no, int page_size){

        Query query = new Query();
        query.skip((page_no-1)*page_size).limit(page_size);

        return mongoTemplate.find(query, Video.class);
    }

    public Video insertVideo(Video video){
        return mongoTemplate.insert(video);
    }

    public Collection<Video> insertVideos(List<Video> videos){
        return mongoTemplate.insertAll(videos);
    }

    public void initDB(){

    }
}
