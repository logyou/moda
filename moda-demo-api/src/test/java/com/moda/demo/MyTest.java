package com.moda.demo;

/**
 * @author lyh
 * @date 2019-05-24
 **/
public class MyTest {
    public static void main(String[] args) {
//        String s = "~lyh/devkeep-admin-api.git";
        String s = "devkeep-admin-api.git";
        System.out.println(s.indexOf(".") + ":" + s.indexOf("/"));
        System.out.println(s.substring(s.indexOf("/"), s.indexOf(".")));
    }
}
