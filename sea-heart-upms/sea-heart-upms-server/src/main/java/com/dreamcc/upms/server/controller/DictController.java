package com.dreamcc.upms.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreamcc.common.core.util.R;
import com.dreamcc.common.log.annotation.SysLog;
import com.dreamcc.upms.server.entity.SysDict;
import com.dreamcc.upms.server.service.SysDictService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.controller
 * @Description: 字典相关Controller
 * @Author: dreamcc
 * @Date: 2019/8/1 15:26
 * @Version: V1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dict")
public class DictController {

	@Autowired
	private SysDictService sysDictService;

	/**
	 * 通过ID查询字典信息
	 *
	 * @param id ID
	 * @return
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable Integer id) {
		return new R<>(sysDictService.getById(id));
	}

	/**
	 * 分页查询字典信息
	 *
	 * @param page    分页对象
	 * @param sysDict 分页对象
	 * @return
	 */
	@GetMapping("/page")
	public R<IPage> getDictPage(Page page, SysDict sysDict) {
		return new R<>(sysDictService.page(page, Wrappers.query(sysDict)));
	}

	/**
	 * 通过字典类型查找字典
	 *
	 * @param type
	 * @return
	 */
	@GetMapping("/type/{type}")
	@Cacheable(value = "dict_details", key = "#type")
	public R getDictByType(@PathVariable String type) {
		return new R<>(sysDictService.list(Wrappers.<SysDict>query().lambda().eq(SysDict::getType, type)));
	}

	/**
	 * 添加字典
	 *
	 * @param sysDict 字典信息
	 * @return
	 */
	@SysLog("添加字典")
	@PostMapping("/addDict")
	@CacheEvict(value = "dict_details", key = "#sysDict.type")
	@PreAuthorize("@permission.hasPermission('sys_dict_add')")
	public R save(@Valid @RequestBody SysDict sysDict) {
		return new R<>(sysDictService.save(sysDict));
	}

	/**
	 * 修改字典
	 *
	 * @param sysDict 字典信息
	 * @return
	 */
	@SysLog("修改字典")
	@PutMapping("/updateDict")
	@CacheEvict(value = "dict_details", key = "#sysDict.type")
	@PreAuthorize("@permission.hasPermission('sys_dict_edit')")
	public R updateById(@Valid @RequestBody SysDict sysDict) {
		return new R<>(sysDictService.updateById(sysDict));
	}

	/**
	 * 删除字典，并且清除字典缓存
	 *
	 * @param id   ID
	 * @param type 类型
	 * @return
	 */
	@SysLog("删除字典")
	@DeleteMapping("/{id}/{type}")
	@CacheEvict(value = "dict_details", key = "#type")
	@PreAuthorize("@permission.hasPermission('sys_dict_del')")
	public R removeById(@PathVariable Integer id, @PathVariable String type) {
		return new R<>(sysDictService.removeById(id));
	}
}
