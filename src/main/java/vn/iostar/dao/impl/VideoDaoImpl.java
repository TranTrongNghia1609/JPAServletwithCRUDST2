package vn.iostar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iostar.config.JPAConfig;
import vn.iostar.dao.IVideoDao;
import vn.iostar.entity.Category;
import vn.iostar.entity.Video;

import java.util.List;

public class VideoDaoImpl implements IVideoDao {
    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT count(v) FROM Video v";
        Query query = enma.createQuery(jpql);
        return ((Long)query.getSingleResult()).intValue();
    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query= enma.createNamedQuery("Video.findAll", Video.class);
        query.setFirstResult(page*pagesize);
        query.setMaxResults(pagesize);
        return query.getResultList();
    }

    @Override
    public List<Video> findByVideoname(String videoname) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.title like :videoname";


        TypedQuery<Video> query= enma.createQuery(jpql, Video.class);


        query.setParameter("videoname", "%" + videoname + "%");


        return query.getResultList();
    }

    @Override
    public List<Video> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query= enma.createNamedQuery("Video.findAll", Video.class);
        return query.getResultList();
    }

    @Override
    public List<Video> findByIdCategory(int cateid) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.category.categoryId = :cateid";
        TypedQuery<Video> query= enma.createQuery(jpql, Video.class);
        query.setParameter("cateid", cateid);
        return query.getResultList();
    }

    @Override
    public Video findById(int videoid) {
        EntityManager enma = JPAConfig.getEntityManager();
        Video video = enma.find(Video.class, videoid);

        return video;
    }

    @Override
    public void insert(Video video) {
        // TODO Auto-generated method stub
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            // gọi phuong thức để insert, update, delete
            enma.persist(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(Video video) {
        // TODO Auto-generated method stub
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            // gọi phuong thức để insert, update, delete
            enma.merge(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(int videoid) throws Exception {
        // TODO Auto-generated method stub
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            // gọi phuong thức để insert, update, delete
            Video video = enma.find(Video.class, videoid);
            if (video != null) {
                enma.remove(video);
            } else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

}
