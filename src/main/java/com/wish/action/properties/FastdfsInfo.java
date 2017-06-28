package com.wish.action.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FastdfsInfo配置信息类
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/6/25 22:31
 */
@Component
@ConfigurationProperties(prefix = "fdfs")
public class FastdfsInfo {

    private String trackerServer;
    private String intranetGruop;
    private String showPrefixUrl;

    public String getTrackerServer() {
        return trackerServer;
    }

    public void setTrackerServer(String trackerServer) {
        this.trackerServer = trackerServer;
    }

    public String getIntranetGruop() {
        return intranetGruop;
    }

    public void setIntranetGruop(String intranetGruop) {
        this.intranetGruop = intranetGruop;
    }

    public String getShowPrefixUrl() {
        return showPrefixUrl;
    }

    public void setShowPrefixUrl(String showPrefixUrl) {
        this.showPrefixUrl = showPrefixUrl;
    }

    @Override
    public String toString() {
        return "FastdfsInfo{" +
                "trackerServer='" + trackerServer + '\'' +
                ", intranetGruop='" + intranetGruop + '\'' +
                ", showPrefixUrl='" + showPrefixUrl + '\'' +
                '}';
    }
}
