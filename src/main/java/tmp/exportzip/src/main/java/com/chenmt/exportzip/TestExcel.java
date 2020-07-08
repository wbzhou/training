package tmp.exportzip.src.main.java.com.chenmt.exportzip;


import com.chenmt.exportzip.utils.ExcelUtil;

import java.util.List;

/**
 * @author: create by junting
 * @version: v1.0
 * @description:
 * @date:2020/7/8
 */
public class TestExcel {

    public static void main (String[] tt){
//		System.out.println("佛挡杀佛");
        String excelFile="/Users/weekend/zwb/git/word/excel/ss.xlsx";
        String sheetName="Sheet1";

        ExcelUtil ins=new ExcelUtil();
        try {

            List<Object> list=ins.readExcel(Object.class, excelFile,sheetName);
            for(Object entry : list){
//                System.out.println("当前拿到的数据:"+entry.isRun()+","+entry.getParam());
//                String activityIdParam=entry.getParam();
//调用

//                checkActivity(String activityId);
            }
            System.out.println("list长度:"+list.size());
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
