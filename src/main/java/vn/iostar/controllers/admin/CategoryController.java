package vn.iostar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.entity.Category;
import vn.iostar.service.ICategoryService;
import vn.iostar.service.impl.CategoryServiceImpl;
import vn.iostar.ultis.Constant;
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", 
		"/admin/category/insert", "/admin/category/edit", "/admin/category/update",
		"/admin/category/delete", "/admin/category/search",  })
public class CategoryController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if(url.contains("categories")) {
			List<Category> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);			
		}
		else if(url.contains("add")){
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);	
		}	
		else if(url.contains("edit")){
			int id = Integer.parseInt(req.getParameter("id"));
			Category category = cateService.findById(id);			
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit1.jsp").forward(req, resp);	
		}	
		  else if(url.contains("delete"))
		  { int id = Integer.parseInt(req.getParameter("id"));
            try {
                cateService.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
		  }

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if(url.contains("insert")) {
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = req.getParameter("images");
			Category category = new Category();
			category.setCategoryname(categoryname);
			category.setStatus(status);
			
			// Upload Images
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("images");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// rename file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload file
					part.write(uploadPath + "/" + fname);
					// ghi ten file vao data
					category.setImages(fname);
				}else if(images != null) {
					category.setImages(images);
				}
				else {
					category.setImages("avatar.png");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		else if (url.contains("update")) {
			
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));

			Category category = new Category();
			category.setCategoryId(categoryid);
			
			category.setCategoryname(categoryname);
			category.setStatus(status);
			
			// Giu hinh cu neu khong update
			Category cateold = cateService.findById(categoryid);
			String fileold = cateold.getImages();
			// Upload Images
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("images");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// rename file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload file
					part.write(uploadPath + "/" + fname);
					// ghi ten file vao data
					category.setImages(fname);
				} else {
					category.setImages(fileold);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			cateService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}

	}
		
	
	

}
