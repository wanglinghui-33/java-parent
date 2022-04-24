package com.dream.freedom.exceptions;

/**
 * 异常都有哪些种类：检查型异常、错误、运行时异常
 *
 * 运行时异常：
 *
 * 1、NullPointException 空指针异常
 * 2、ClassCastException 类型转换异常
 * 3、ArithmeticException 算术异常类，比如： 数字除以0
 * 4、ArrayIndexOutOfBoundsException    数组下标越界异常 ， 比如数组长度是6，你访问超过了6，都会报此异常
 * 5、ArrayStoreException  数组保存异常，数组类型保存异常，比如，int类型的数据，你保存了非int类型的数据
 * 6、NumberFormatException  字符串转换数字异常，比如：Integer num = new Integer("abc");
 * 7、ParseException  转换异常，时间字符串转时间格式，如果SimpleDateFormat 格式和字符的格式不匹配，则会报此异常
 * 8、FileNotFountException 文件未找到异常，出现在IO流读取的文件不存在
 * 9、IOException IO流异常
 * 10、NotSerializableException  不支持序列化异常，参与序列化的对象必须要实现Serializable
 * 11、UnsupportedOperationException 不支持操作的异常，出现的情况：初始化一个不可变的集合，然后继续往里面添加数据，就会报这个错误
 * 12、InstantiationException 实例化异常，java反射时，调用newInstance方法，相当于实例化对象，调用的是无参构造，如果类中没有无参构造就会报这个错误
 *
 *
 *
 * 常见异常类型；
 *
 * 数组负下标异常：NegativeArrayException
 * <p>
 * 违背安全原则异常：SecturityException
 * <p>
 * 文件已结束异常：EOFException
 * 操作数据库异常：SQLException
 * <p>
 * 方法未找到异常：NoSuchMethodException
 * <p>
 * 下标越界异常：IndexOutOfBoundsExecption
 * <p>
 * 系统异常：SystemException
 * <p>
 * 创建一个大小为负数的数组错误异常：NegativeArraySizeException
 * <p>
 * 数据格式异常：NumberFormatException
 * <p>
 * 安全异常：SecurityException
 */
public class ExceptionType {


}
