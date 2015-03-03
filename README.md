# BigDecimalUtils
BigDecimal Utilities for Java.

[Apache Commons](http://commons.apache.org/ "Apache Commons") contains many useful utility packages for Java, but seems to lack one for BigDecimal objects.

This project contains a single BigDecimalUtils you can use in your Java project and also unit tests for the class.  BigDecimalUtils mainly provides utilities to work in a null-safe way with BigDecimal and to ignore precision in comparisons.

Some example methods:

```java
public static BigDecimal getTotal(List<BigDecimal> valuesToSum)
public static BigDecimal toBigDecimal(String s)
public static BigDecimal toBigDecimal(String s, BigDecimal defaultValue)
public static boolean equals(BigDecimal bd1, BigDecimal bd2)
public static boolean isZeroOrNull(BigDecimal bd)
public static BigDecimal add(BigDecimal bd1, BigDecimal bd2)
public static boolean isNegativeOrNull(BigDecimal bd)
...
```
If you have suggestions for additional methods, please open an issue or if you have useful code to contribute, a pull request (as long as the code is ASF license appropriate).

Thanks!

mrg
