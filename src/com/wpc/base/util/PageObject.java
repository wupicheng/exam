package com.wpc.base.util;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-3-24
 * Time: 上午10:03
 * To change this template use File | Settings | File Templates.
 */
public class PageObject {

    int totalRecordNum;         //总记录数
    int everyPageNum;  //每页记录数
    int totalPageNum; //总页面数
    int currentPageNum; //当前页
    int prePageNum;    //上一页
    int nextPageNum;    //下一页
    int fromRecord;   //每页起始记录
    int toRecord;   // 结束记录数

    public PageObject() {

    }

    public PageObject(int totalRecordNum, int everyPageNum, int currentPageNum) {
        this.totalRecordNum = totalRecordNum;
        this.everyPageNum = everyPageNum;
        this.totalPageNum = totalRecordNum % everyPageNum == 0 ? totalRecordNum / everyPageNum : totalRecordNum / everyPageNum + 1;
        this.currentPageNum = currentPageNum;
        this.prePageNum = currentPageNum == 1 ? -1 : currentPageNum - 1;
        this.nextPageNum = currentPageNum == this.totalPageNum ? -1 : currentPageNum + 1;
        this.fromRecord = (currentPageNum - 1) * everyPageNum + 1;
        this.toRecord = currentPageNum * everyPageNum > totalRecordNum ? totalRecordNum : currentPageNum * everyPageNum;
    }
    public PageObject(PageObject oldPageObject) {
        this.totalRecordNum = oldPageObject.getTotalRecordNum();
        this.everyPageNum = oldPageObject.getEveryPageNum();
        this.totalPageNum = totalRecordNum % everyPageNum == 0 ? totalRecordNum / everyPageNum : totalRecordNum / everyPageNum + 1;
        this.currentPageNum = oldPageObject.getCurrentPageNum();
        this.prePageNum = currentPageNum == 1 ? -1 : currentPageNum - 1;
        this.nextPageNum = currentPageNum == this.totalPageNum ? -1 : currentPageNum + 1;
        this.fromRecord = (currentPageNum - 1) * everyPageNum + 1;
        this.toRecord = currentPageNum * everyPageNum > totalRecordNum ? totalRecordNum : currentPageNum * everyPageNum;
    }

    public int getToRecord() {
        return toRecord;
    }

    public void setToRecord(int toRecord) {
        this.toRecord = toRecord;
    }

    public int getFromRecord() {
        return fromRecord;
    }

    public void setFromRecord(int fromRecord) {
        this.fromRecord = fromRecord;
    }

    public int getTotalRecordNum() {
        return totalRecordNum;
    }

    public void setTotalRecordNum(int totalRecordNum) {
        this.totalRecordNum = totalRecordNum;
    }

    public int getEveryPageNum() {
        return everyPageNum;
    }

    public void setEveryPageNum(int everyPageNum) {
        this.everyPageNum = everyPageNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getPrePageNum() {
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }


}
