package vn.iostar.service;

import vn.iostar.entity.Video;

import java.util.List;

public interface IVideoService {
    int count();


    List<Video> findAll(int page, int pagesize);


    List<Video> findByVideoname(String videoname);


    List<Video> findAll();


    Video findById(int videoid);


    void insert(Video video);


    void update(Video video);


    void delete(int videoid) throws Exception;

    List<Video> findByIdCategory(int categoryid);
}
