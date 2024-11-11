package com.esms.controller;

import com.esms.po.Department;
import com.esms.po.RankBonus;
import com.esms.service.IRankBonusService;
import com.esms.vo.DepartmentPages;
import com.esms.vo.RankBonusPages;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lizefeng
 * Date: 2018-08-06
 * Time: 10:54
 * Projectname:   ssm
 */
@Controller
public class RankBonusController {
    @Autowired
    private IRankBonusService service;
    //@Qualifier("rankBonusService")

    public void setiRankBonusService(IRankBonusService iRankBonusService) {
        this.service = iRankBonusService;
    }
    //插入数据
    @RequestMapping("/insertRankBonus.do")
    @ResponseBody
    public String doInsertRankBonus(int bonus,String name){
        if(service.CountByName(name)>0){
            return "exist";
        }
        if(!name.equals("")&& bonus>=0){
            RankBonus rb= new RankBonus();
            rb.setRankName(name);
            rb.setRbBonus(bonus);
            service.addRankBonus(rb);

            return "ok";

        }
        else{
            return "no";
        }

    }
    //查询出所有记录
    @RequestMapping("/findAll.do")
    public String doFindAll(@RequestParam(value="pn",defaultValue = "1") Integer pn, Model model){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        int pageSize = 10;
        PageHelper.startPage(pn, pageSize);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<RankBonus> rbs = service.findAll();
        System.out.println(rbs+"=================================");
        /*for (RankBonus rb:rbs) {
         System.out.println(rb.getRankName());
        }*/
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(rbs, 5);
        //ModelAndView modelAndView = new ModelAndView();
       // modelAndView.setViewName("admin/rank-list.jsp");
         // modelAndView.addObject("pageInfo",page);
        model.addAttribute("pageInfo", page);
        return "admin/rank-list.jsp";
    }

    @RequestMapping("/findRankBonusList.do")
    @ResponseBody
    public RankBonusPages findSelective(
            @RequestParam(value="page", defaultValue="1")int pageNum,
            @RequestParam(value="limit", defaultValue="10") int limit,
            @RequestParam(value="rb_name", defaultValue="") String rb_name) throws Exception {
        /*return rb_name;*/
        List<RankBonus> list;
        //模糊查询，有多少个条件就接收多少个字段
        RankBonus rb = new RankBonus();
        rb.setRankName(rb_name);
        //pageNum:起始页面  pageSize:每页的大小
        PageHelper.startPage(pageNum,limit);
        //查找条件，一定要紧跟在startPage后
        list = service.findSelective(rb);
        PageInfo pageResult = new PageInfo(list);

        //设置前台需要的数据
        RankBonusPages rankBonusPages = new RankBonusPages();
        rankBonusPages.setCode(0);
        rankBonusPages.setMsg("");
        rankBonusPages.setCount((int) pageResult.getTotal());
        rankBonusPages.setData(pageResult.getList());
        return rankBonusPages;
    }

    //根据id删除数据
    @RequestMapping("rankBonusDelete.do")
    @ResponseBody
    public String doDelete(int id){
        if(service.CountByRbid(id)>0){
            return "exist";
        }
        if(service.moveRankBonus(id)==true)
            return "ok";
        else{
            return "no";}
    }
    //更新记录
    @RequestMapping("/updateRankBonus.do")
    @ResponseBody
    public String doUpdate(int id,String  rank,int bonus){
        RankBonus rankBonus=service.findByName(rank);
        if(rankBonus!=null&& !rankBonus.getRbId().equals(id)){
            return "exist";
        }
        RankBonus rb=new RankBonus();
        rb.setRbId(id);
        rb.setRbBonus(bonus);
        rb.setRankName(rank);
        if(service.modifyRankName(rb)==true)
            return "ok";
        else
            return "no";
    }


}
