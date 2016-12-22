package personal.chencs.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import personal.chencs.learn.domain.SalesVolume;

@Controller
@RequestMapping(value = "echart", produces="application/json;charset=UTF-8")
public class EChartController {

	// 指定name查询
	@RequestMapping(value = "/getData")
	public @ResponseBody String getData(){
		System.out.println("get data");
		
		List<SalesVolume> list = new ArrayList<>();
		list.add(new SalesVolume("衬衫", 5));
		list.add(new SalesVolume("羊毛衫", 20));
		list.add(new SalesVolume("雪纺衫", 36));
		list.add(new SalesVolume("裤子", 20));
		list.add(new SalesVolume("高跟鞋", 10));
		list.add(new SalesVolume("袜子", 30));
		list.add(new SalesVolume("外套", 45));
		
		return JSON.toJSONString(list);
	}
}
