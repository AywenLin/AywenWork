package com.cms.web.banner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.bean.Banner;
import com.cms.bean.Params;
import com.cms.mapper.banner.IBannerMapper;

@Controller
@RequestMapping("/admin/banner")
public class BannerController {

	@Autowired
	private IBannerMapper bannermapper;

	/**
	 * 
	 * (轮播图的查询)<br/>
	 * 方法名：banner<br/>
	 * 创建人：AywenLin <br/>
	 * 时间：2017年11月10日-上午9:34:22 <br/>
	 * 手机:17742597905<br/>
	 * 
	 * @return String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@RequestMapping("banneradmin")
	public ModelAndView banner(ModelAndView modelAndView) {
		int count=bannermapper.countSeclect();
		modelAndView.addObject("count", count);
		modelAndView.setViewName("banner/bannerAdmin");
		return modelAndView;
	}

	/**
	 * 
	 * (轮播图查询的模板)<br/>
	 * 方法名：template<br/>
	 * 创建人：AywenLin <br/>
	 * 时间：2017年11月10日-上午11:34:14 <br/>
	 * 手机:17742597905<br/>
	 * 
	 * @param modelAndView
	 * @return ModelAndView<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	@RequestMapping("template")
	public ModelAndView template(ModelAndView modelAndView,Params params) {
		List<Banner> banners = bannermapper.selectBanners(params);
		modelAndView.addObject("banners", banners);
		modelAndView.setViewName("banner/template");
		return modelAndView;
	}
	
	/**
	 * 
	 * (修改轮播图状态)<br/>
	 * 方法名：update<br/>
	 * 创建人：AywenLin <br/>
	 * 时间：2017年11月13日-下午8:42:29 <br/>
	 * 手机:17742597905<br/>
	 * @param banner
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Banner banner){
		int num=bannermapper.updateStatus(banner);
		if (num>0) {
			return "success";
		}
		else{
			return "fail";
		}
	}

}
