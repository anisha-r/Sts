package com.anisha.add;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
	 @RequestMapping("add")
	 public String hello(@RequestParam("t1")int i,@RequestParam("t2")int j)
	 {
		return (i+j) + "";
		 
	 }
	 @RequestMapping("login")
	 public String register(@RequestParam("username")String a,@RequestParam("password")String b) {
		 if(a =="anisha" && b =="ravi") {
			 System.out.println("enter to login page");
		 }
		 else {
			 System.out.println("failed to login");
		 }
		 return "";
	 }
	

}
