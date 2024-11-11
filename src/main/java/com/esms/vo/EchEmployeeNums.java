package com.esms.vo;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：存放各个部门，及其对应员工数
 * @Date：10:19 2019/10/6
 * @Version: 1.0
 */
public class EchEmployeeNums {
    private String department;
    private Integer num;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
