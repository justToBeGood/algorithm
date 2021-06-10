package leetcode;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 请你实现一个类 UndergroundSystem ，它支持以下 3 种方法：
 * 1. checkIn(int id, string stationName, int t)  编号为 id 的乘客在 t 时刻进入地铁站 stationName 。 一个乘客在同一时间只能在一个地铁站进入或者离开。
 * 2. checkOut(int id, string stationName, int t)  编号为 id 的乘客在 t 时刻离开地铁站 stationName 。
 * 3. getAverageTime(string startStation, string endStation)   返回从地铁站 startStation 到地铁站 endStation 的平均花费时间。 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的行程。 调用 getAverageTime 时，询问的路线至少包含一趟行程。 你可以假设所有对 checkIn 和 checkOut 的调用都是符合逻辑的。也就是说，如果一个顾客在 t1 时刻到达某个地铁站，那么他离开的时间 t2 一定满足 t2 > t1 。所有的事件都按时间顺序给出。
 * -1396
 * @Author: wengweixin
 * @E-mail： wengweixin@csair.com
 * @Date: 2021/6/10 11:33
 **/
public class UndergroundSystem {

    Map<Integer, InData> inDataMap=new HashMap<Integer,InData>();
    Map<String,Map<String,TimeData>> averageData=new HashMap<String,Map<String,TimeData>>();
    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        InData inData=new InData();
       inData.setId(id);
       inData.setStationName(stationName);
       inData.setT(t);
        inDataMap.put(id,inData);
    }

    public void checkOut(int id, String stationName, int t) {
        InData in = inDataMap.get(id);
        String origin = in.getStationName();
        int start = in.getT();
        int timeNum=t-start;
        Map<String, TimeData> destinData = averageData.get(origin);
        if (destinData==null){
            Map<String, TimeData> map=new HashMap<>();
            TimeData timeData=new TimeData();
            timeData.setTime(timeNum);
            timeData.setAvge(1);
            map.put(stationName,timeData);
            averageData.put(origin,map);
        }else {
            TimeData timeData = destinData.get(stationName);
            if(timeData==null){
                timeData=new TimeData();
                timeData.setTime(timeNum);
                timeData.setAvge(1);
                destinData.put(stationName,timeData);
            }else {
                double avge = timeData.getAvge();
                int time = timeData.getTime();
                int newTime = time + 1;
                double newAvge = (time * avge + time) / time;
                timeData.setAvge(newAvge);
                timeData.setTime(newTime);
                destinData.put(stationName,timeData);
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        TimeData timeData = averageData.get(startStation).get(endStation);
        return timeData.getAvge();
    }

    class InData{
        private int id;
        private String stationName;
        private int t;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }
    }
    class TimeData{
        private double avge;
        private int time;

        public double getAvge() {
            return avge;
        }

        public void setAvge(double avge) {
            this.avge = avge;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
