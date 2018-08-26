package blogsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import blogsystem.domain.Authority;
import blogsystem.domain.User;
import blogsystem.repository.UserRepository;
import blogsystem.service.AuthorityService;
import blogsystem.service.UserService;
import sun.print.resources.serviceui;

/**
 * 
 **********************************************************
 * @作者: huisir
 * @日期: 2018年8月12日
 * @描述: 用户 controller
 **********************************************************
 */

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	private AuthorityService authorityService;
	
	
	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model){
		
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title", "用户管理");
		
		return new ModelAndView("users/list", "userModel", model);
	}
	
	/**
	 * 查询用户
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model){
		
		User user = userRepository.findOne(id);
 
 		model.addAttribute("user", user);
 		model.addAttribute("title", "查看用户");
		
		return new ModelAndView("users/view", "userModel", model);
	}
	
	/**
	 * 获取创建表单页面
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model){
		
 		model.addAttribute("user", new User(null, null, null, null));
 		model.addAttribute("title", "创建用户");
		
		return new ModelAndView("users/form", "userModel", model);
	}
	
	
	/**
	 * 创建用户
	 * @param model
	 * @return
	 */
	@PostMapping
	public ModelAndView saveOrUpdateUSer(User user, Long authorityId){
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(authorityId));
		user.setAuthorities(authorities);
		
		user = userRepository.save(user);
		
		return new ModelAndView("redirect:/users");
	}
	
	/**
	 * 删除用户
	 * @param model
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model){
		
		userRepository.delete(id);
		
		return new ModelAndView("redirect:/users");
	}
	
	/**
	 * 注册用户
	 */
	@PostMapping("/register")
	public String registerUser(User user){
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(1L));
		user.setAuthorities(authorities);
		
		userService.registerUser(user);
		return "redirect:/login";
		
	}
	
}
