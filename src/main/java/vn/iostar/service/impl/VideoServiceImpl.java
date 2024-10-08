package vn.iostar.service.impl;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.IVideoDao;
import vn.iostar.dao.impl.VideoDaoImpl;
import vn.iostar.entity.Video;
import vn.iostar.service.ICategoryService;
import vn.iostar.service.IVideoService;

import java.util.List;

public class VideoServiceImpl implements IVideoService {

    IVideoDao videoDao = new VideoDaoImpl();
    @Override
    public int count() {
        return videoDao.count();
    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        return  videoDao.findAll(page, pagesize);
    }

    @Override
    public List<Video> findByVideoname(String videoname) {
        return videoDao.findByVideoname(videoname);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public Video findById(int videoid) {
        return videoDao.findById(videoid);
    }

    @Override
    public void insert(Video video) {
        videoDao.insert(video);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public void delete(int videoid) throws Exception {
        videoDao.delete(videoid);
    }

    @Override
    public List<Video> findByIdCategory(int categoryid) {
        return videoDao.findByIdCategory(categoryid);
    }
}
