package utils;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BigDecimalUtils
{
    private static final Log log = LogFactory.getLog(BigDecimalUtils.class);

    /**
     * No instances required.
     */
    private BigDecimalUtils() { } // NOSONAR


    // Returns an list of all values in a map for the specified key
    public static List<BigDecimal> allValuesForKey(List<Map<String, BigDecimal>> sourceList, String key)
    {
        List<BigDecimal> valueList = null;

        if (sourceList != null)
        {
            valueList = new ArrayList<BigDecimal>();

            for (Map<String, BigDecimal> peMap : sourceList)
                valueList.add(peMap.get(key));
        }

        return valueList;
    }

    public static BigDecimal getTotal(List<BigDecimal> valuesToSum)
    {
        BigDecimal calculatedTotal = ZERO;

        if (valuesToSum != null)
        {
            for (int i = 0; i < valuesToSum.size(); i++)
            {
                BigDecimal value = valuesToSum.get(i);

                if (value == null)
                    continue;

                calculatedTotal = calculatedTotal.add(value);
            }
        }

        return calculatedTotal;
    }

    public static BigDecimal toBigDecimal(String s)
    {
        return toBigDecimal(s, null);
    }

    public static BigDecimal toBigDecimal(String s, BigDecimal defaultValue)
    {
        BigDecimal bd = defaultValue;

        try
        {
            if (StringUtils.isNotEmpty(s))
                bd = new BigDecimal(s);
        }
        catch (NumberFormatException exception)
        {
            log.error("Could not convert '" + s + "' to a BigDecimal.", exception);

            throw exception;
        }

        return bd;
    }

    /**
     * Null-safe equals that ignores the scale of the BigDecimals.
     *
     * @param bd1
     * @param bd2
     * @return true if bd1 == bd2; false if bd1 != bd2.
     */
    public static boolean equals(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == bd2)
            return true;

        if (bd1 == null || bd2 == null)
            return false;

        return bd1.compareTo(bd2) == 0;
    }

    /**
     * Null-safe not-equals that ignores the scale of the BigDecimals.
     *
     * @param bd1
     * @param bd2
     * @return true if bd1 != bd2; false if bd1 == bd2.
     */
    public static boolean notEquals(BigDecimal bd1, BigDecimal bd2)
    {
        return equals(bd1, bd2) == false;
    }

    /**
     * @param bd
     * @return The value of the bd or zero if bd is null.
     */
    public static BigDecimal getValue(BigDecimal bd)
    {
        return bd == null ? ZERO : bd;
    }

    /**
     * @param bd
     * @return true if bd is zero; false if bd is not zero or is null.
     */
    public static boolean isZero(BigDecimal bd)
    {
        return bd == null ? false : ZERO.compareTo(bd) == 0;
    }

    /**
     * @param bd
     * @return true if bd is not zero or null; false if bd is zero.
     */
    public static boolean isNotZero(BigDecimal bd)
    {
        return bd == null ? false : isZero(bd) == false;
    }

    /**
     * @param bd
     * @return true if bd is zero or null; false if bd is non-zero.
     */
    public static boolean isZeroOrNull(BigDecimal bd)
    {
        return bd == null || ZERO.compareTo(bd) == 0;
    }

    /**
     * @param bd
     * @return true if bd is not zero or null; false if bd is zero.
     */
    public static boolean isNotZeroOrNull(BigDecimal bd)
    {
        return isZeroOrNull(bd) == false;
    }

    /**
     * Null-safe addition of two BigDecimal objects. Null is presumed to be
     * zero for the calculation. If both operands are null, null is returned.
     *
     * @param bd1
     * @param bd2
     * @return The addition of bd1 + bd2 or null if bd1 and bd2 are null.
     */
    public static BigDecimal add(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == null)
            return bd2;
        else if (bd2 == null)
            return bd1;
        else
            return bd1.add(bd2);
    }

    /**
     * Null-safe subtraction of two BigDecimal objects. Null is presumed to be
     * zero for the calculation. If both operands are null, null is returned.
     *
     * @param bd1
     * @param bd2
     * @return The subtraction of bd1 - bd2 or null if bd1 and bd2 are null.
     */
    public static BigDecimal subtract(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == null)
            return bd2;
        else if (bd2 == null)
            return bd1;
        else
            return bd1.subtract(bd2);
    }

    /**
     * Null-safe less-than.  If either are null, the result is always false.
     *
     * @param bd1
     * @param bd2
     * @return true if bd1 < bd2; false if bd1 >= bd2 or if bd1 or bd2 is null.
     */
    public static boolean isLessThan(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == null || bd2 == null)
            return false;
        else
            return bd1.compareTo(bd2) < 0;
    }

    /**
     * Null-safe less-than or equal-to.  If either are null, the result is always false.
     *
     * @param bd1
     * @param bd2
     * @return true if bd1 <= bd2; false if bd1 > bd2 or if bd1 or bd2 is null.
     */
    public static boolean isLessThanOrEqualTo(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == null || bd2 == null)
            return false;
        else
            return bd1.compareTo(bd2) <= 0;
    }

    /**
     * Null-safe greater-than.  If either are null, the result is always false.
     *
     * @param bd1
     * @param bd2
     * @return true if bd1 > bd2; false if bd1 <= bd2 or if bd1 or bd2 is null.
     */
    public static boolean isGreaterThan(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == null || bd2 == null)
            return false;
        else
            return isLessThanOrEqualTo(bd1, bd2) == false;
    }

    /**
     * Null-safe greater-than or equal-to.  If either are null, the result is always false.
     *
     * @param bd1
     * @param bd2
     * @return true if bd1 >= bd2; false if bd1 < bd2 or if bd1 or bd2 is null.
     */
    public static boolean isGreaterThanOrEqualTo(BigDecimal bd1, BigDecimal bd2)
    {
        if (bd1 == null || bd2 == null)
            return false;
        else
            return isLessThan(bd1, bd2) == false;
    }

    /**
     * @param bd
     * @return true if bd < 0; false if bd >= 0 or bd is null.
     */
    public static boolean isNegative(BigDecimal bd)
    {
        return isLessThan(bd, ZERO);
    }

    /**
     * @param bd
     * @return true if bd < 0 or bd is null; false if bd >= 0.
     */
    public static boolean isNegativeOrNull(BigDecimal bd)
    {
        if (bd == null)
            return true;
        else
            return isNegative(bd);
    }

    /**
     * @param bd
     * @return true if bd > 0; false if bd <= 0 or bd is null.
     */
    public static boolean isPositive(BigDecimal bd)
    {
        return isGreaterThan(bd, ZERO);
    }

    /**
     * @param bd
     * @return true if bd > 0 or bd is null; false if bd <= 0.
     */
    public static boolean isPositiveOrNull(BigDecimal bd)
    {
        if (bd == null)
            return true;
        else
            return isPositive(bd);
    }

    /**
     * @param bd
     * @return true if bd <= 0 or bd is null; false if bd > 0.
     */
    public static boolean isNotPositive(BigDecimal bd)
    {
        return isPositive(bd) == false;
    }
}
