package com.anisha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployController {
   
	@Autowired
	EmployRepository dao;
         
	    int numRecords=2;
	     int numOfPages;
	@RequestMapping(value = "/")
	public ModelAndView getAllEmployees() {
		ModelAndView mv=new ModelAndView();
		List<Employ> emp=(List<Employ>) dao.findAll();
		numOfPages =emp.size()/numRecords + emp.size() % numRecords;
	    mv.addObject("pages",numOfPages);
	    mv.addObject("employList",emp);
		mv.setViewName("home");
	    return mv;
     
	}
	 
//	@RequestMapping("/displayjavacontractors")
//	public ModelAndView getJavaContractors()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findByDeptAndDesig("ece", "software"));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayjava")
//	public ModelAndView getJavaDepart()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findByDept("java"));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayjavasalary")
//	public ModelAndView getJavaDesig()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findByBasic(20000));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayjavaname")
//	public ModelAndView getJavaName()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findByName("Anisha"));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayjavaEmployeeList")
//	public ModelAndView getJavaEmploy()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findByDeptAndDesigAndBasic("Java","Software",5000));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayjavaEmployee")
//	public ModelAndView getJavastartName()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findByDeptAndDesigAndBasicAndName("Java","Software",5000));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayAllSortByDesig")
//	public ModelAndView getJavaSortByDesig()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findAll(Sort.by("desig")));		
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayAllSortByDesc")
//	public ModelAndView getJavaSortByDesc()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findAll(Sort.by("desig").descending()));
//		mv.setViewName("home");
//		return mv;
//	}
//	@RequestMapping("/displayThree")
//	public ModelAndView getJavaSortByAll()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employList",dao.findByThree("developer", 10000));
//		mv.setViewName("home");
//		return mv;
//	}
	@RequestMapping("/displayAll/page/{pageno}")
	public ModelAndView getJavaSortByAll(@PathVariable("pageno")int pageno)
	{
		ModelAndView mv = new ModelAndView();
		Page<Employ> pages=dao.findAll(PageRequest.of(pageno, numRecords));
		mv.addObject("pages", numOfPages);
		
		
		mv.addObject("employList",(pages).getContent());
		mv.setViewName("home");
		return mv;
	}


}
