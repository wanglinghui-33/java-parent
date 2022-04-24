package com.dream.freedom.test.ip;

import com.dream.freedom.utils.ValidatorUtil;
import org.junit.Test;

public class Ipv6Check {

    @Test
    public void checkIpv6(){

        System.out.println(ValidatorUtil.isIpv6("12:12:12:12:12:12:12:1222"));

    }
}
