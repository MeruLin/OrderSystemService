package com.zy1401Team2.OSService.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy1401Team2.OSService.bean.Test;
import com.zy1401Team2.OSService.dao.TestMapper;

@Controller
public class TestController {
	@Autowired
	private TestMapper test_mapper;
	
	@RequestMapping("/test.action")
    public @ResponseBody List<Test> doTest(){
    	List<Test> get_test = new ArrayList<Test>();
    	Test param = new Test();
    	param = test_mapper.selectByPrimaryKey(1);
    	get_test.add(param);
    	return get_test;
    }
}
