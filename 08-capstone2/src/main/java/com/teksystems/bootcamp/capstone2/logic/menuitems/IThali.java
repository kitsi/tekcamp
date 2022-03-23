package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;
import java.util.List;

public interface IThali {
    final BigDecimal DISCOUNTED_PERCENT = BigDecimal.valueOf(0.80);
    int minNumberItems = 3;

    List getThaliItems();
    BigDecimal calculateThaliPrice();
}
