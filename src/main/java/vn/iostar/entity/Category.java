package vn.iostar.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	private int categoryId;
	
	
	@Column(name = "CategoryName", columnDefinition = "nvarchar(50) not null")
	@NotEmpty(message = "Không được bỏ trống")
	private String categoryname;
	
	@Column(name = "Images", columnDefinition = "nvarchar(500) null")
	
	private String images;
	
	
	private int status;
	
	//bi-directional many-to-one association to Video
	 @OneToMany(mappedBy="category")
	 private List<Video> videos;


	public Category() {
		
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public List<Video> getVideos() {
		return videos;
	}


	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public Video addVideo(Video video) {
		 getVideos().add(video);
		 video.setCategory(this);
		 return video;
	}
	public Video removeVideo(Video video) {
		 getVideos().remove(video);
		 video.setCategory(null);
		 return video;
	 }
	
	
	
	
}
