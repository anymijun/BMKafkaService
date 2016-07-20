package com.bluemoon.log.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 暂未定义日志规范,临时日志内容
 *
 * Created by LeonWong on 16/7/19.
 */
public class LogVo implements Serializable {

    private String content;
    private Date crtime;
    private String who;
    private String where;
    private String remark;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
