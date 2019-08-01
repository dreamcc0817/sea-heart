package com.dreamcc.upms.server.controller;

import com.dreamcc.common.core.util.R;
import com.dreamcc.upms.server.service.SysDeptService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.controller
 * @Description: 部门相关Controller
 * @Author: dreamcc
 * @Date: 2019/8/1 17:01
 * @Version: V1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private SysDeptService sysDeptService;

	/**
	 * 通过ID查询部门信息
	 *
	 * @param id ID
	 * @return SysDept
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable Integer id) {
		return new R<>(sysDeptService.getById(id));
	}


}
