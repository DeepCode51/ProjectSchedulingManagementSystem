package com.esms.controller;

import com.esms.po.Department;
import com.esms.service.DepartmentService;
import com.esms.vo.DepartmentPages;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
* @Author: xjx
* @DATE: 2019/10/6 15:23
*/

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService = null;

    /**
     * 查找部门
     * @param pageNum
     * @param limit
     * @param d_name
     * @return
     * @throws Exception
     */
    @RequestMapping("/findSelective.do")
    @ResponseBody
    public DepartmentPages findSelective(
            @RequestParam(value="page", defaultValue="1")int pageNum,
            @RequestParam(value="limit", defaultValue="5") int limit,
            @RequestParam(value="d_name", defaultValue="") String d_name) throws Exception {
        List<Department> list;

        //模糊查询，有多少个条件就接收多少个字段

        Department department = new Department();
        department.setdName(d_name);

        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        list = departmentService.findSelective(department);
        PageInfo pageResult = new PageInfo(list);

        //设置前台需要的数据
        DepartmentPages departmentPages = new DepartmentPages();
        departmentPages.setCode(0);
        departmentPages.setMsg("");
        departmentPages.setCount((int) pageResult.getTotal());
        departmentPages.setData(pageResult.getList());

        return departmentPages;
    }

    /**
     * 添加部门
     * @param d_name
     * @param d_remark
     * @return
     * @throws Exception
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public int add(String d_name, String d_remark) throws Exception {

        Department department = departmentService.findByDname(d_name);

        //查找是否同名
        if(department != null) {
            return department.getdId();
        } else {
            Department d = new Department();
            d.setdId(null);
            d.setdName(d_name);
            d.setdRemark(d_remark);
            d.setdIsdel(1);
            departmentService.insertSelective(d);
            return 0;
        }
    }


    /**
     * 查找一个部门
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findByPrimaryKey.do")
    @ResponseBody
    public Department findByPrimaryKey(int id) throws Exception {
        Department department = departmentService.selectByPrimaryKey(id);
        return department;
    }

    /**
     * 更新部门
     * @param id
     * @param d_name
     * @param d_remark
     * @throws Exception
     */
    @RequestMapping("/updateByPrimaryKey.do")
    @ResponseBody
    public int updateByPrimaryKey(int id, String d_name, String d_remark) throws Exception {
        Department department = departmentService.findByDname(d_name);
        //有同名的且不是同一个
        if(department != null && !department.getdId().equals(id) ) {
            return department.getdId();
        } else {
            Department d = new Department();
            d.setdId(id);
            d.setdName(d_name);
            d.setdRemark(d_remark);
            d.setdIsdel(null);
            departmentService.updateByPrimaryKeySelective(d);
            return 0;
        }
    }

    @RequestMapping("/findByDname.do")
    @ResponseBody
    public int findByDname(String d_name) {

        Department department = departmentService.findByDname(d_name);
        if(department != null) {
            return department.getdId();
        } else {
            return 0;
        }
    }

    /**
     * 删除部门
     * @param id
     */
    @RequestMapping("/deleteByPrimaryKey.do")
    @ResponseBody
    public int deleteByPrimaryKey(int id) throws Exception {
        //删除部门，调用更新操作，将状态改为0
        Department department = new Department();
        department.setdId(id);
        department.setdIsdel(0);
        departmentService.updateByPrimaryKeySelective(department);
        return 1;
    }

    /**
     * 批量删除
     * @param ids
     */
    @RequestMapping("/deleteByQuery.do")
    public void deleteByQuery (@RequestParam(value = "arr")int[] ids) {
        //批量删除，实则修改状态为0
        //如果有id才执行
        if(ids.length > 0) {
           departmentService.deleteByQuery(ids);
        }

//        var arr = [3,4,5];
//        $.ajax({
//                type:'post',
//                url:'department/deleteByQuery.do',
//                data: {"arr":arr},
//                traditional: true,
//                dataType:'json',
//        });

    }

}
