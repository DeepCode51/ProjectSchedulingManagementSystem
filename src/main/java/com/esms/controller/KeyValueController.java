package com.esms.controller;

import com.esms.po.KeyValue;
import com.esms.service.impl.KeyValueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KeyValueController {
    @Autowired
    private KeyValueServiceImpl keyValueService = null;

//    测试
    @RequestMapping("/getKeyValueById.do")
    public @ResponseBody String getKeyValueById(Model model, Integer id_id)throws Exception{
        return "error.jsp";
    }
    @RequestMapping("/changeWageItem.do")
    @ResponseBody
    public int changeWageItem(double late_buckle_pay,double early_buckle_pay,double missionallowance,double full_attendance_pay,double food_pay,double traffic_pay)throws Exception{
        /*return late_buckle_pay;*/
        int count=0;

        KeyValue kv1=new KeyValue();
        kv1.setKvKey("food_pay");
        kv1.setKvId(1);
        kv1.setKvValue(food_pay);
        count+=keyValueService.updateByPrimaryKey(kv1);

        KeyValue kv2=new KeyValue();
        kv2.setKvId(2);
        kv2.setKvKey("traffic_pay");
        kv2.setKvValue(traffic_pay);
        count+=keyValueService.updateByPrimaryKey(kv2);

        KeyValue kv3=new KeyValue();
        kv3.setKvId(3);
        kv3.setKvKey("late_buckle_pay");
        kv3.setKvValue(late_buckle_pay);
        count+=keyValueService.updateByPrimaryKey(kv3);

        KeyValue kv4=new KeyValue();
        kv4.setKvId(4);
        kv4.setKvKey("early_buckle_pay");
        kv4.setKvValue(early_buckle_pay);
        count+=keyValueService.updateByPrimaryKey(kv4);

        KeyValue kv5=new KeyValue();
        kv5.setKvId(5);
        kv5.setKvKey("missionallowance");
        kv5.setKvValue(missionallowance);
        count+=keyValueService.updateByPrimaryKey(kv5);

        KeyValue kv6=new KeyValue();
        kv6.setKvId(6);
        kv6.setKvKey("full_attendance_pay");
        kv6.setKvValue(full_attendance_pay);
        count+=keyValueService.updateByPrimaryKey(kv6);

        return count;
    }
    @RequestMapping("/get_late_buckle_pay.do")
    public @ResponseBody KeyValue get_late_buckle_pay(){
        KeyValue keyValue=new KeyValue();
        try {
            keyValue=keyValueService.selectBykvKey("late_buckle_pay");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    @RequestMapping("/get_food_pay.do")
    public @ResponseBody KeyValue get_food_pay(){
        KeyValue keyValue=new KeyValue();
        try {
            keyValue=keyValueService.selectBykvKey("food_pay");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    @RequestMapping("/get_traffic_pay.do")
    public @ResponseBody KeyValue get_traffic_pay(){
        KeyValue keyValue=new KeyValue();
        try {
            keyValue=keyValueService.selectBykvKey("traffic_pay");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    @RequestMapping("/get_early_buckle_pay.do")
    public @ResponseBody KeyValue get_early_buckle_pay(){
        KeyValue keyValue=new KeyValue();
        try {
            keyValue=keyValueService.selectBykvKey("early_buckle_pay");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    @RequestMapping("/get_missionallowance.do")
    public @ResponseBody KeyValue get_missionallowance(){
        KeyValue keyValue=new KeyValue();
        try {
            keyValue=keyValueService.selectBykvKey("missionallowance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }
    @RequestMapping("/get_full_attendance_pay.do")
    public @ResponseBody KeyValue get_full_attendance_pay(){
        KeyValue keyValue=new KeyValue();
        try {
            keyValue=keyValueService.selectBykvKey("full_attendance_pay");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValue;
    }


}
