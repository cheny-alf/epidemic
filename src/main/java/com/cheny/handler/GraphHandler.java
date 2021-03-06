package com.cheny.handler;

import com.cheny.bean.GraphColumnarBean;
import com.cheny.bean.GraphPieBean;
import com.cheny.bean.GraphAddBean;
import com.cheny.bean.GraphBean;

import com.cheny.util.HttpClientUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GraphHandler {

    public static String urlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_other";

    public static String getData(){
        return HttpClientUtil.doGet(urlStr);
    }

    public static List<GraphBean> getGraphData() {
        return getGraphData(getData());
    }

    public static List<GraphBean> getGraphData(String str) {
        List<GraphBean> result = new ArrayList<>();

        Gson gson = new Gson();
        Map map = gson.fromJson(str, Map.class);

        String subStr = (String) map.get("data");
        Map subMap = gson.fromJson(subStr, Map.class);

        ArrayList list = (ArrayList) subMap.get("chinaDayList");

        for (int i = 0; i < list.size(); i++) {
            Map tmp = (Map) list.get(i);

            String date = (String) tmp.get("date");
            double nowConfirm = (Double) tmp.get("nowConfirm");
            GraphBean graphBean = new GraphBean(date, (int) nowConfirm);
            result.add(graphBean);
        }

        return result;
    }


    public static List<GraphAddBean> getGraphAddData() {
        return getGraphAddData(getData());
    }

    public static List<GraphAddBean> getGraphAddData(String str) {

        List<GraphAddBean> result = new ArrayList<>();

        Gson gson = new Gson();
        Map map = gson.fromJson(str, Map.class);

        String subStr = (String) map.get("data");
        Map subMap = gson.fromJson(subStr, Map.class);

        ArrayList list = (ArrayList) subMap.get("chinaDayAddList");

        for (int i = 0; i < list.size(); i++) {
            Map tmp = (Map) list.get(i);
            String date = (String) tmp.get("date");
            double addConfirm = (Double) tmp.get("confirm");
            double addSuspect = (Double) tmp.get("suspect");

            GraphAddBean graphAddBean = new GraphAddBean(date,
                    (int) addConfirm, (int) addSuspect);
            result.add(graphAddBean);
        }

        return result;
    }


    public static String urlStrAll = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";

    public static List<GraphColumnarBean> getGraphColumnarData() {
        List<GraphColumnarBean> result = new ArrayList<>();

        String respJson = HttpClientUtil.doGet(urlStrAll);

        Gson gson = new Gson();
        Map map = gson.fromJson(respJson, Map.class);

        // ???????????????????????????  ??????data????????????????????????string
        String subStr = (String) map.get("data");
        Map subMap = gson.fromJson(subStr, Map.class);

//        System.out.println(map);

        ArrayList areaList = (ArrayList) subMap.get("areaTree");
        Map dataMap = (Map) areaList.get(0);
        ArrayList childrenList = (ArrayList) dataMap.get("children");


        for (int i = 0; i < childrenList.size(); i++) {

            Map tmp = (Map) childrenList.get(i);
            String name = (String) tmp.get("name");

            ArrayList children = (ArrayList) tmp.get("children");
            for (int j = 0; j < children.size(); j++) {
                Map subTmp = (Map) children.get(j);
                if ("????????????".equals((String) subTmp.get("name"))) {
                    Map total = (Map) subTmp.get("total");
                    double fromAbroad = (Double) total.get("confirm");

                    GraphColumnarBean bean = new GraphColumnarBean(name, (int) fromAbroad);
                    result.add(bean);
                }
            }
        }

        return result;

    }

    public static List<GraphPieBean> getGraphPieData() {
        return getGraphPieData(getData());
    }

    public static List<GraphPieBean> getGraphPieData(String str) {

        List<GraphPieBean> result = new ArrayList<>();

        Gson gson = new Gson();
        Map map = gson.fromJson(str, Map.class);

        String subStr = (String) map.get("data");
        Map subMap = gson.fromJson(subStr, Map.class);

        Map dataMap = (Map) subMap.get("nowConfirmStatis");

        for (Object o : dataMap.keySet()) {
            String name = (String) o;
            switch (name) {
                case "gat":
                    name = "???????????????";
                    break;
                case "import":
                    name = "??????????????????";
                    break;
                case "province":
                    name = "31???????????????";
                    break;
            }

            double value = (Double) dataMap.get(o);
            name += ":" + (int) value + "???";

            GraphPieBean bean = new GraphPieBean(name, (int) value);
            result.add(bean);
        }

        return result;
    }


    public static void main(String[] args) {
//        getGraphData();

        List<GraphColumnarBean> list = getGraphColumnarData();
        Collections.sort(list);
        System.out.println();
    }
}
