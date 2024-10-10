package vn.iostar.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.entity.Category;
import vn.iostar.entity.Video;
import vn.iostar.service.IVideoService;
import vn.iostar.service.impl.VideoServiceImpl;
import vn.iostar.ultis.Constant;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/videos" ,"/admin/video/add", "/admin/video/insert", "/admin/video/edit"
        ,"/admin/video/update", "/admin/video/delete"})
public class VideoController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    public IVideoService videoService = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(url.contains("videos")){
            int id = Integer.parseInt(req.getParameter("categoryid"));
            List<Video> videos = videoService.findByIdCategory(id);
            req.setAttribute("listvideo", videos);
            req.setAttribute("id", id);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
        } else if (url.contains("add")) {
            int id = Integer.parseInt(req.getParameter("categoryid"));
            Category category = new Category();
            category.setCategoryId(Integer.parseInt(req.getParameter("categoryid")));

            req.setAttribute("categoryid", id);
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        }
        else if(url.contains("delete"))
        {
            String videoid= req.getParameter("idvideo");
            int id = Integer.parseInt(req.getParameter("idcategory"));
            try {
                videoService.delete(videoid);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/videos?categoryid=" + id);
        }
        else if(url.contains("edit")){
            String idvideo = req.getParameter("idvideo");
            Video video = videoService.findById(idvideo);
            req.setAttribute("video", video);
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (url.contains("insert")) {
            String videoid = req.getParameter("videoid");
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String images = req.getParameter("poster1");
            int active = Integer.parseInt(req.getParameter("active"));
            int views = Integer.parseInt(req.getParameter("views"));
            ICategoryDao catedao = new CategoryDaoImpl();
            int id = Integer.parseInt(req.getParameter("categoryid"));
            Category category = catedao.findById(id);
            category.setCategoryId(id);
            Video video = new Video();
            video.setVideoId(videoid);
            video.setTitle(title);
            video.setDescription(description);
            video.setActive(active);
            video.setViews(views);
            video.setCategory(category);
            // Upload Images
            String fname = "";
            String uploadPath = Constant.DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part part = req.getPart("poster");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // rename file
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    // upload file
                    part.write(uploadPath + "/" + fname);
                    // ghi ten file vao data
                    video.setPoster(fname);
                } else if (images != null) {
                    video.setPoster(images);
                } else {
                    video.setPoster(images);
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            videoService.insert(video);

            resp.sendRedirect(req.getContextPath() + "/admin/videos?categoryid=" + id);
        } else if (url.contains("update")) {

            int categoryid = Integer.parseInt(req.getParameter("categoryid"));

            String videoid = req.getParameter("videoId");
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String images = req.getParameter("poster1");
            int active = Integer.parseInt(req.getParameter("active"));
            int views = Integer.parseInt(req.getParameter("views"));
            ICategoryDao catedao = new CategoryDaoImpl();
            Video video = new Video();
            System.out.println(videoid);
            video.setVideoId(videoid);
            video.setTitle(title);
            video.setDescription(description);
            video.setActive(active);
            video.setViews(views);
            Category category = catedao.findById(categoryid);
            video.setCategory(category);
            // Giu hinh cu neu khong update
            Video videoservice = videoService.findById(videoid);
            String fileold = videoservice.getPoster();
            //UPload file
            String fname = "";
            String uploadPath = Constant.DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part part = req.getPart("poster");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    part.write(uploadPath + "/" + fname);
                    video.setPoster(fname);
                } else if (images != null) {
                    video.setPoster(images);
                }

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            videoService.update(video);
            resp.sendRedirect(req.getContextPath() + "/admin/videos?categoryid=" + categoryid);
        }
    }
}
