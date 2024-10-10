package vn.iostar.dao;

import vn.iostar.entity.Video;

import java.util.List;

public interface IVideoDao {
    int count();
    List<Video> findAll(int page, int pagesize);
    List<Video> findByVideoname(String videoname);
    List<Video> findAll();
    List<Video> findByIdCategory(int categoryid);
    Video findById(String videoid);
    Video findByidCategory(int cateid);
    void insert(Video video);
    void update(Video video);
    void delete(String videoid) throws Exception;

}
