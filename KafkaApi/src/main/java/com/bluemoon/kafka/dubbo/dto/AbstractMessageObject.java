package com.bluemoon.kafka.dubbo.dto;

import java.io.Serializable;

/**
 * 具体的dto对象由业务系统之间来约定,传输对象务必继承此接口,方便以后扩展
 *
 * Created by LeonWong on 16/7/15.
 */
public interface AbstractMessageObject extends Serializable {
    // Nothing
}
