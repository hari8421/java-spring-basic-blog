package com.pluralsight.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pluralsight.blog.model.Post;

import com.pluralsight.blog.data.PostRepository;

@Controller
public class BlogController {
	@Autowired
	private PostRepository postRepository;
	@RequestMapping("/")
	public String listPosts(ModelMap map) {
		List<Post> pList=postRepository.getAllPosts();
		map.put("title", "Blog Post 1");
		map.put("posts", pList);
		return "home";
	}
	
	public BlogController(PostRepository postRepository) {
		this.postRepository=postRepository;
	}

}
