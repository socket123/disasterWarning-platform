package com.yoxnet.common.utils;

import org.springframework.util.Assert;

/**
 * 断言判断工具
 *
 */
public class AssertUtil extends Assert
{
  public static void notNull(Object object)
  {
    notNull(object, "[Assertion failed] - 该参数是必需的，不能为空！");
  }

  public static void notEmpty(Object[] array)
  {
    notEmpty(array, "[Assertion failed] - 该数组不能为空: 必须包含至少1个元素！");
  }

  public static void notBlank(String str)
  {
    notBlank(str, "[Assertion failed] - 该参数是必需的，不能为空！");
  }

  public static void notBlank(String str, String message)
  {
    notNull(str, message);
    hasText(str, message);
  }
}