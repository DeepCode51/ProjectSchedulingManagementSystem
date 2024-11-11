package com.esms.utils;

import com.esms.po.Employee;
import com.esms.po.MonthlyAttendance;
import com.esms.po.Salary;
import jxl.*;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JXLUtils {

    public static List<MonthlyAttendance> readMonthlyAttendanceTable(File file) throws Exception{
        /* 1:创建workbook */
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        //2:获取第一个工作表sheet
        Sheet sheet = workbook.getSheet(0);
        //3:获取数据
        /*System.out.println("行：" + sheet.getRows());
        System.out.println("列：" + sheet.getColumns());*/
        List<MonthlyAttendance> monthlyAttendanceList = new ArrayList<MonthlyAttendance>();
        for (int i = 1; i < sheet.getRows(); i++) {
            MonthlyAttendance monthlyAttendance = new MonthlyAttendance();
            for (int j = 1; j < sheet.getColumns(); j++) {
                Cell cell = sheet.getCell(j, i);
                //System.out.print(cell.getContents() + " ");
                switch (j) {
                    case 1:
                        Employee employee = new Employee();
                        employee.seteAccount(cell.getContents());
                        monthlyAttendance.setEmployee(employee);
                        break;
                    case 2:
                        monthlyAttendance.setSickLeaveNum(Integer.parseInt(cell.getContents()));
                        break;
                    case 3:
                        monthlyAttendance.setOvertimeHour(Double.parseDouble(cell.getContents()));
                        break;
                    case 4:
                        monthlyAttendance.setWeekendHour(Double.parseDouble(cell.getContents()));
                        break;
                    case 5:
                        monthlyAttendance.setHolidayHour(Double.parseDouble(cell.getContents()));
                        break;
                    case 6:
					try {
						monthlyAttendance.setLateNum(Integer.parseInt(cell.getContents().replace(" ", "")));
					} catch (Exception e) {
						e.printStackTrace();
						monthlyAttendance.setLateNum(0);
					}
                        break;
                    case 7:
					try {
						monthlyAttendance.setEarlyNum(Integer.parseInt(cell.getContents().replace(" ", "")));
					} catch (Exception e) {
						e.printStackTrace();
						monthlyAttendance.setEarlyNum(0);
					}
                        break;
                    case 8:
					try {
						monthlyAttendance.setAbsenceNum(Integer.parseInt(cell.getContents().replace(" ", "")));
					} catch (Exception e) {
						e.printStackTrace();
						monthlyAttendance.setAbsenceNum(0);
					}
                        break;
                    case 9:
					try {
						monthlyAttendance.setCompassionateLeaveNum(Integer.parseInt(cell.getContents().replace(" ", "")));
					} catch (Exception e) {
						e.printStackTrace();
						monthlyAttendance.setCompassionateLeaveNum(0);
					}
                        break;
                    case 10:
					try {
						monthlyAttendance.setBusinessTravelNum(Integer.parseInt(cell.getContents().replace(" ", "")));
					} catch (Exception e) {
						e.printStackTrace();
						monthlyAttendance.setBusinessTravelNum(0);
					}
                        break;
                    case 11:
                        DateCell dc = (DateCell) cell;
                        Date date = dc.getDate();    //获取单元格的date类型
                        monthlyAttendance.setAttendanceTime(date);
                        break;
                }

            }
            //System.out.println(monthlyAttendance);
            monthlyAttendanceList.add(monthlyAttendance);
        }
        //最后一步：关闭资源
        workbook.close();
        return monthlyAttendanceList;
    }

    public static List<Salary> readReissueTable(File file) {
        /* 1:创建workbook */
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        //2:获取第一个工作表sheet
        Sheet sheet = workbook.getSheet(0);
        //3:获取数据
        System.out.println("行：" + sheet.getRows());
        System.out.println("列：" + sheet.getColumns());
        List<Salary> salaryList = new ArrayList<Salary>();
        for (int i = 1; i < sheet.getRows(); i++) {
            Salary salary = new Salary();
            for (int j = 1; j < sheet.getColumns(); j++) {
                Cell cell = sheet.getCell(j, i);
                System.out.print(cell.getContents() + " ");
                switch (j) {
                    case 1:
                        Employee employee = new Employee();
                        employee.seteAccount(cell.getContents());
                        salary.setEmployee(employee);
                        break;
                    case 2:
                        salary.setRissuePay(Double.parseDouble(cell.getContents()));
                        break;
                    case 3:
                        DateCell dc = (DateCell) cell;
                        Date date = dc.getDate();    //获取单元格的date类型
                        salary.setsTime(date);
                        break;
                }

            }
            System.out.println(salary);
            salaryList.add(salary);
        }
        //最后一步：关闭资源
        workbook.close();
        return salaryList;
    }
    //创建excel工资表格
    public static WritableWorkbook createSalaryExcel(OutputStream output,List<Salary> salaries) throws IOException, WriteException {
        WritableWorkbook writableWorkbook= Workbook.createWorkbook(output);
        WritableSheet sheet = writableWorkbook.createSheet("工资表", 0);


        CellFormat cf = writableWorkbook.getSheet(0).getCell(1, 0).getCellFormat();
        WritableCellFormat wc = new WritableCellFormat();
        // 设置水平居中
        wc.setAlignment(Alignment.CENTRE);
        //设置垂直居中
        wc.setVerticalAlignment(VerticalAlignment.CENTRE);
        // 设置边框线
       wc.setBorder(Border.ALL, BorderLineStyle.THIN);
       wc.setBackground(jxl.format.Colour.WHITE);
        //合并单元格，第一个参数：要合并的单元格最左上角的列号，第二个参数：要合并的单元格最左上角的行号，
        //第三个参数：要合并的单元格最右角的列号，第四个参数：要合并的单元格最右下角的行号，
        //前4个
       for(int i = 0;i< 5;i++){
           sheet.mergeCells(i, 0, i, 1);
       }
        sheet.mergeCells(5, 0, 8, 0);   //合并补贴单元格
        sheet.mergeCells(9, 0, 12, 0);   //合并奖金单元格
        sheet.mergeCells(13, 0, 18, 0);   //合并五险一金单元格
        sheet.mergeCells(19, 0, 23, 0);   //合并工资扣额单元格
        /*// 后4个
        for(int i = 23,j = 0;i< 25;i++,j++ ){
            sheet.mergeCells(i, 0, j, 1);
        }*/
        //sheet.mergeCells(23, 0, 23, 1);   //合并工资扣额单元格
       //sheet.mergeCells(1, 0, 1, 1);
       /*Label nc0 = new Label(0, 0, "标题1",wc);//Label(x,y,z)其中x代表单元格的第x+1列，第y+1行, 单元格的内容是z
        Label nc1 = new Label(1, 0, "标题2",wc);
        Label nc2 = new Label(2, 0, "标题3",wc);
        Label nc3 = new Label(0, 1, "dddd");
        Label nc4 = new Label(1, 1, "ffff");


        wsheet.addCell(nc0);
        wsheet.addCell(nc1);
        wsheet.addCell(nc2);
        wsheet.addCell(nc3);
        wsheet.addCell(nc4);*/

        //创建要显示的具体内容
        Label eAccount = new Label(0,0,"员工工号",wc);
        sheet.addCell(eAccount);
        Label eName = new Label(1,0,"员工姓名",wc);
        sheet.addCell(eName);
        Label department = new Label(2,0,"所属部门",wc);
        sheet.addCell(department);
        Label date = new Label(3,0,"日期",wc);
        sheet.addCell(date);
        Label basePay = new Label(4,0,"基本工资",wc);
        sheet.addCell(basePay);
        Label subsidy = new Label(5,0,"补贴",wc);
        sheet.addCell(subsidy);
        Label foodPay = new Label(5,1,"餐饮补贴",wc);
        sheet.addCell(foodPay);
        Label postPay = new Label(6,1,"岗位补贴",wc);
        sheet.addCell(postPay);
        Label trafficPay = new Label(7,1,"交通补贴",wc);
        sheet.addCell(trafficPay);
        Label businessTravePay = new Label(8,1,"出差补贴",wc);
        sheet.addCell(businessTravePay);
        Label bonus = new Label(9,0,"奖金",wc);
        sheet.addCell(bonus);
        Label wokingYearsPay = new Label(9,1,"工龄奖金",wc);
        sheet.addCell(wokingYearsPay);
        Label rankPay = new Label(10,1,"职称奖金",wc);
        sheet.addCell(rankPay);
        Label overtimePay = new Label(11,1,"加班奖金",wc);
        sheet.addCell(overtimePay);
        Label fullAttendancePay = new Label(12,1,"全勤奖金",wc);
        sheet.addCell(fullAttendancePay);
        Label  risks = new Label(13,0,"五险一金",wc);
        sheet.addCell( risks);
        Label persionPay = new Label(13,1,"养老保险",wc);
        sheet.addCell(persionPay);
        Label medicalPay = new Label(14,1,"医疗保险",wc);
        sheet.addCell(medicalPay);
        Label unemploymentPay = new Label(15,1,"失业保险",wc);
        sheet.addCell(unemploymentPay);
        Label injuryPay = new Label(16,1,"工伤保险",wc);
        sheet.addCell(injuryPay);
        Label birthPay = new Label(17,1,"生育保险",wc);
        sheet.addCell(birthPay);
        Label housingPay = new Label(18,1,"住房公积金",wc);
        sheet.addCell(housingPay);
        Label deduction = new Label(19,0,"工资扣额",wc);
        sheet.addCell(deduction);
        Label latePay = new Label(19,1,"迟到扣额",wc);
        sheet.addCell(latePay);
        Label earlyPay = new Label(20,1,"早退扣额",wc);
        sheet.addCell(earlyPay);
        Label sickPay = new Label(21,1,"病假扣额",wc);
        sheet.addCell(sickPay);
        Label thingPay = new Label(22,1,"事假扣额",wc);
        sheet.addCell(thingPay);
        Label individualIncomeTax = new Label(23,1,"个人所得税",wc);
        sheet.addCell(individualIncomeTax);
        Label rissuePay = new Label(24,0,"补发工资",wc);
        sheet.addCell(rissuePay);
        sheet.mergeCells(24, 0, 24, 1); //合并上下单元格
        Label shouldPay = new Label(25,0,"应发工资",wc);
        sheet.addCell(shouldPay);
        sheet.mergeCells(25, 0, 25, 1); //合并上下单元格
        Label actualPay = new Label(26,0,"实发工资",wc);
        sheet.addCell(actualPay);
        sheet.mergeCells(26, 0, 26, 1); //合并上下单元格
        Label sState = new Label(27,0,"状态",wc);
        sheet.mergeCells(27, 0, 27, 1); //合并上下单元格
        sheet.addCell(sState);

        WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT1);
        int row = 1;
        for (Salary salary:salaries){
            row++;
            sheet.addCell(new Label(0,row,salary.getEmployee().geteAccount()));
            sheet.addCell(new Label(1,row,salary.getEmployee().geteName()));
            sheet.addCell(new Label(2,row,salary.getDepartment().getdName()));
            sheet.addCell(new DateTime(3,row,salary.getsTime(),cf1));
            sheet.addCell(new Number(4,row,salary.getBasePay()));
            sheet.addCell(new Number(5,row,salary.getFoodPay()));
            sheet.addCell(new Number(6,row,salary.getPostPay()));
            sheet.addCell(new Number(7,row,salary.getTrafficPay()));
            sheet.addCell(new Number(8,row,salary.getBusinessTravelPay()));
            sheet.addCell(new Number(9,row,salary.getWorkingYearPay()));
            sheet.addCell(new Number(10,row,salary.getRankPay()));
            sheet.addCell(new Number(11,row,salary.getOvertimePay()));
            sheet.addCell(new Number(12,row,salary.getFullAttendancePay()));
            sheet.addCell(new Number(13,row,salary.getPersionPay()));
            sheet.addCell(new Number(14,row,salary.getMedicalPay()));
            sheet.addCell(new Number(15,row,salary.getUnemploymentPay()));
            sheet.addCell(new Number(16,row,salary.getInjuryPay()));
            sheet.addCell(new Number(17,row,salary.getBirthPay()));
            sheet.addCell(new Number(18,row,salary.getHousingPay()));
            sheet.addCell(new Number(19,row,salary.getLatePay()));
            sheet.addCell(new Number(20,row,salary.getEarlyPay()));
            sheet.addCell(new Number(21,row,salary.getSickPay()));
            sheet.addCell(new Number(22,row,salary.getThingPay()));
            sheet.addCell(new Number(23,row,salary.getIndividualIncomeTax()));
            sheet.addCell(new Number(24,row,salary.getRissuePay()));
            sheet.addCell(new Number(25,row,salary.getShouldPay()));
            sheet.addCell(new Number(26,row,salary.getActualPay()));
            if(salary.getsState()==0) {
                sheet.addCell(new Label(27, row, "未发"));
            }
            else{
                sheet.addCell(new Label(27,row,"已发"));
            }
        }
        //output.close();
        return writableWorkbook;
    }
}
