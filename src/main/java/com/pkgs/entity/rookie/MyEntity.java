package com.pkgs.entity.rookie;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/21 16:41
 * <p>
 * since: 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "my")
@EqualsAndHashCode(callSuper = false)
public class MyEntity extends Model<MyEntity> {
    private String name;
    private Integer age;
    private String gender;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
