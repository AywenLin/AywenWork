package com.cms.web.comment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.bean.Comment;
import com.cms.bean.Params;
import com.cms.mapper.comment.ICommentMapper;

@Controller
@RequestMapping("admin/comment")
public class CommentController {

	@Autowired
	private ICommentMapper commentMapper;

	@RequestMapping("list")
	public String comment(Model model) {
		//查询总数
		int count =commentMapper.findCount(); 
		model.addAttribute("count", count);
		return "comment/list";
	}

	/**
	 * 查询评
	 * @param ModelAndView
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("template")
	public ModelAndView commentlist(ModelAndView ModelAndView, Params params) {
		//查询总评论
		List<Map<String, Object>> comms = commentMapper.findComments(params);
 		ModelAndView.addObject("comms", comms);
		ModelAndView.setViewName("comment/template");
		return ModelAndView;
	}
	


	@RequestMapping("pag")
	public String pag() {

		return "pag";
	}
	
	
}
