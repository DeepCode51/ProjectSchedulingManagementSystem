package com.esms.controller;

import com.esms.po.Position;
import com.esms.service.PositionService;
import com.esms.vo.PositionPages;
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
 * @Date: 2019/10/7 8:13
 */
@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    public PositionService positionService = null;


    /**
     *
     * @param pageNum
     * @param limit
     * @param p_name
     * @return
     * @throws Exception
     */
    @RequestMapping("findSelective.do")
    @ResponseBody
    public PositionPages findSelective(
            @RequestParam(value="page", defaultValue="1") int pageNum,
            @RequestParam(value="limit", defaultValue="5") int limit,
            @RequestParam(value="p_name", defaultValue="") String p_name) throws Exception {
        List<Position> list;

        //模糊查询，有多少个条件就接收多少个字段

        Position position = new Position();
        position.setpName(p_name);

        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        list = positionService.findSelective(position);

        PageInfo pageResult = new PageInfo(list);

        //设置前台需要的数据
        PositionPages positionPages = new PositionPages();
        positionPages.setCode(0);
        positionPages.setMsg("");
        positionPages.setCount((int)pageResult.getTotal());
        positionPages.setData(pageResult.getList());
        return positionPages;
    }


    /**
     * 添加
     * @param p_name
     * @param p_duty
     * @param p_post_pay
     * @return
     * @throws Exception
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public int add(String p_name, String p_duty, Double p_post_pay) throws Exception {

        Position position = positionService.findByDname(p_name);
        //查找是否同名
        if(position != null) {
            return position.getpId();
        } else {
            Position p = new Position();
            p.setpId(null);
            p.setpName(p_name);
            p.setpDuty(p_duty);
            p.setpPostPay(p_post_pay);
            p.setpIsdel(1);
            positionService.insertSelective(p);
            return 0;
        }
    }

    /**
     * 查找一个
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findByPrimaryKey.do")
    @ResponseBody
    public Position findByPrimaryKey(int id) throws Exception {
        Position position = positionService.findByPrimaryKey(id);
        return position;
    }

    /**
     * 更新
     * @param id
     * @param p_name
     * @param p_duty
     * @param p_post_pay
     * @throws Exception
     */
    @RequestMapping("/updateByPrimaryKey.do")
    @ResponseBody
    public int updateByPrimaryKey(int id, String p_name, String p_duty, Double p_post_pay) throws Exception {

        Position position = positionService.findByDname(p_name);
        System.out.println(p_name);
        System.out.println(position);
        System.out.println(position != null && !position.getpName().equals(p_name));
        //有同名的且不是同一个
        if(position != null && !position.getpId().equals(id) ) {
            return position.getpId();
        } else {
            Position p = new Position();
            p.setpId(id);
            p.setpName(p_name);
            p.setpDuty(p_duty);
            p.setpPostPay(p_post_pay);
            p.setpIsdel(null);
            positionService.updateByPrimaryKeySelective(p);
            return 0;
        }
    }

    /**
     * 根据名称查找
     * @param p_name
     * @return
     */
    @RequestMapping("/findByDname.do")
    @ResponseBody
    public int findByDname(String p_name) {
        Position position = positionService.findByDname(p_name);
        if(position != null) {
            return position.getpId();
        } else {
            return 0;
        }
    }


    /**
     * 删除一个
     * @param id
     * @throws Exception
     */
    @RequestMapping("/deleteByPrimaryKey.do")
    @ResponseBody
    public int  deleteByPrimaryKey(int id) throws Exception {
        //删除部门，调用更新操作，将状态改为0
        Position position = new Position();
        position.setpId(id);
        positionService.deleteByPrimaryKey(id);
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
            positionService.deleteByQuery(ids);
        }


    }
}
