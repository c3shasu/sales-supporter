package jp.co.ccube.ss.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.ccube.ss.service.ProjectService;

@Controller
public class ProjectDetailController {

	@Autowired
	ProjectService projectService;



}
