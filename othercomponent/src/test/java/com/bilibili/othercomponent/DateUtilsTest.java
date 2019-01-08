package com.bilibili.othercomponent;


import com.bilibili.othercomponent.ui.utils.DateUtils;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DateUtilsTest {

    private String time;

    public DateUtilsTest(String time) {
        this.time = time;
    }

    @Test
    public void stampToDateTest() {
        assertEquals(time, DateUtils.stampToDate(1545198936037L));
    }

    @Parameterized.Parameters
    public static Collection getTimes() {
        return Arrays.asList("2018-12-19 13:55:36",
                "2018-12-19 13:55:38",
                "2018-12-19");
    }

}
