package com.esms.controller;

import com.esms.po.RankBonus;
import com.esms.po.WorkingYearsBonus;
import com.esms.service.IRankBonusService;
import com.esms.service.IWorkYearService;
import com.esms.vo.WokingYearsBonusPages;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lizefeng
 * Date: 2018-08-08
 * Time: 21:59
 * Projectname:   ssm
 */
@Controller
public class WorkYearController {
    @Autowired
    private IWorkYearService service;

    /*查询所有数据*/
    @RequestMapping("/findWorkingYearBonusList.do")
    @ResponseBody
    public WokingYearsBonusPages findAll(
            @RequestParam(value="page", defaultValue="1")int pageNum,
            @RequestParam(value="limit", defaultValue="5") int limit,
            @RequestParam(value="year", defaultValue="0") int year) throws Exception {
        List<WorkingYearsBonus> list;

        //模糊查询，有多少个条件就接收多少个字段

        WorkingYearsBonus wyb = new WorkingYearsBonus();
        wyb.setWybYear(year);

        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        list = service.findSelective(wyb);
        PageInfo pageResult = new PageInfo(list);

        //设置前台需要的数据
        WokingYearsBonusPages wybp = new WokingYearsBonusPages();
        wybp.setCode(0);
        wybp.setMsg("");
        wybp.setCount((int) pageResult.getTotal());
        wybp.setData(pageResult.getList());

        return wybp;
    }

    //插入数据
    @RequestMapping("/addWorkingYearsBonus.do")
    @ResponseBody
    public String doWorkYearBonus(int year,double bonus){

        if(service.Count(year)>0)
        {
            return "exist";
        }
        if(year>=0 && bonus>=0){
            WorkingYearsBonus wyb= new WorkingYearsBonus();
            wyb.setWybYear(year);
            wyb.setWybBonus(bonus);
            service.addWorkYearBonus(wyb);
            return "ok";
        }
        else{
            return "no";
        }
    }
    /*//查询出所有记录
    @RequestMapping("/findList.do")
    public String doFindList(@RequestParam(value="pn",defaultValue = "1") Integer pn, Model model){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        int pageSize = 10;
        PageHelper.startPage(pn, pageSize);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<WorkingYearsBonus> wyb = service.findAll();
        System.out.println(wyb+"=================================");
        *//*for (RankBonus rb:rbs) {
         System.out.println(rb.getRankName());
        }*//*
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(wyb, 5);
        //ModelAndView modelAndView = new ModelAndView();
        // modelAndView.setViewName("admin/rank-list.jsp");
        // modelAndView.addObject("pageInfo",page);
        model.addAttribute("pageInfo", page);
        model.addAttribute("ttttt","tttttttttt********8");
        return "admin/year-list.jsp";

    }*/
    //根据id删除数据
    @RequestMapping("/deleteRecord.do")
    @ResponseBody
    public String doDelete(int id){
        if (service.moveWorkYearBonus(id)==true) {
            return "ok";
        }
        else{
            return "no";
        }

    }
    //更新记录
    @RequestMapping("/updateRecord.do")
    @ResponseBody
    public String doUpdate(int id,int year,double bonus){
        WorkingYearsBonus workingYearsBonus=service.findByYear(year);
        if(workingYearsBonus!=null&&!workingYearsBonus.getWybId().equals(id))
        {
            return "exist";
        }
        WorkingYearsBonus wyb=new WorkingYearsBonus();
        wyb.setWybId(id);
        wyb.setWybYear(year);
        wyb.setWybBonus(bonus);
        if(service.modifyWorkYearBonus(wyb)==true)
            return "ok";
        else
            return "no";
    }
}
