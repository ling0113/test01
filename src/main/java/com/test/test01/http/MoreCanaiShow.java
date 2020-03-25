package com.test.test01.http;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.annotation.JSONField;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * Auto-generated: 2020-03-11 10:28:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class MoreCanaiShow {

    private String device_version;
    private String last_ip;
    private Created_at created_at;
    private String last_address;
    private String hls_url;
    private String sim_two_network_provider;
    private String playback_kbps;
    private String services_cache;
    private List<Service_days> service_days;
    private String streaming_kbps;
    private String super_user_id;
    private String last_longitude;
    private String sim_two_network_type;
    private String super_user;
    private int id;
    private String is_online;
    private String audio;
    private String sim_two_signal_strength;
    private String sim_one_signal_strength;
    private String last_latitude;
    private String last_snapshot_url;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime last_online_at;
    private String serial_number;
    private String service_provider;
    private String sim_one_network_provider;
    private String sim_one_network_type;
    private String name;
    private Expire_at expire_at;
    private String streaming_resolution;
    private String remarks;
    private String stream_url;
    private String status;

}