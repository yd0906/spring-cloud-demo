package com.jlc.cloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.jlc.cloud.model.Message;
import com.jlc.cloud.model.PageBean;
import com.jlc.cloud.service.IMessageService;

@Controller
public class MyabatisController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping("/page/{currentPage}/{pageSize}")
    public String index(Model model, @PathVariable("currentPage") int currentPage,
                        @PathVariable("pageSize") int pageSize) {

        // 指定当前需要显示的页码（currentPage），页面列表长度（pageSize）
        PageHelper.startPage(currentPage, pageSize);

        model.addAttribute("page", new PageBean<Message>(messageService.list()));
        return "page";
    }
    
    @RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/toUpload")
	public String toUpload(Model model) {
		return "upload";
	}

	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile[] files, String name,HttpServletRequest request) {
		if(files != null){
			for(MultipartFile file : files){
				System.out.println(file.getOriginalFilename());
			}
		}
		System.out.println(request.getParameter("name"));
		return name;
	}
}
