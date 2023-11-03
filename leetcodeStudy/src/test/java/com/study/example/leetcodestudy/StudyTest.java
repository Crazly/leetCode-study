package com.study.example.leetcodestudy;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StudyTest {

//    @Reference(version = "1.0.0")
//    @Reference(version = "1.0.0")
//    private VendorApprovalService vendorApprovalService;

//    @Test
//    public void searchTest() throws Exception {
//        try {
//            //查询补充合同信息
//            BaseResult<VendorApprovalVO> vendorApprovalVOBaseResult = vendorApprovalService.queryVendorApprovalVO("R20231017000004");
//            VendorApprovalVO result = vendorApprovalVOBaseResult.getResult();
//            System.out.println(JSONObject.toJSONString(result));
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

        @Test
    public void testScanner(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input one num");
        int i = sc.nextInt();
        System.out.println(i);
        Integer i2 = new Integer(2);



    }
    @Test
    public void StringTest() throws IOException {
        File f = new File("/hello.txt");
        FileInputStream fileInputStream = new FileInputStream(f);

        int read = fileInputStream.read();


    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
