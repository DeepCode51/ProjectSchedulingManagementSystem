package com.esms.vo;

/**
 * @program: ssm
 * @Author：方宏泰
 * @Description：接收方法salaryMap.selectSalaryByDepartment()的返回值
 * @Date：19:57 2019/10/7
 * @Version: 1.0
 */
public class EchSalary {
    private Double minSalary= 0.00;

    private Double avgSalary = 0.00;

    private Double maxSalary = 0.00;

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(Double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public EchSalary() { }

    public EchSalary(Double minSalary, Double avgSalary, Double maxSalary) {
        this.minSalary = minSalary;
        this.avgSalary = avgSalary;
        this.maxSalary = maxSalary;
    }
}
