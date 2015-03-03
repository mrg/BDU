package utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestBigDecimalUtils
{
    private BigDecimal bd0 = new BigDecimal("-1.01");
    private BigDecimal bd1 = new BigDecimal("1.01");
    private BigDecimal bd2 = new BigDecimal("1.999");
    private BigDecimal bd3 = new BigDecimal("3.141592653");
    private BigDecimal bd4 = new BigDecimal("3.141592654");
    private BigDecimal bd5 = new BigDecimal("3.141592655");

    private List<BigDecimal> list = Arrays.asList(bd1, bd2, bd4);

    @Test
    public void testAdd()
    {
        Assert.assertEquals(null, BigDecimalUtils.add(null, null));

        Assert.assertEquals(bd1, BigDecimalUtils.add(bd1, null));
        Assert.assertEquals(bd1, BigDecimalUtils.add(bd1, BigDecimal.ZERO));

        Assert.assertEquals(bd1, BigDecimalUtils.add(null, bd1));
        Assert.assertEquals(bd1, BigDecimalUtils.add(BigDecimal.ZERO, bd1));

        // Add preserves scale, so don't add additional here.
        BigDecimal result1 = new BigDecimal("11.01");
        BigDecimal result2 = new BigDecimal("11.999");

        Assert.assertEquals(result1, BigDecimalUtils.add(bd1, BigDecimal.TEN));
        Assert.assertEquals(result2, BigDecimalUtils.add(bd2, BigDecimal.TEN));
    }

    @Test
    public void testEquals()
    {
        // Equals ignores scale, so add additional here.
        BigDecimal result1 = new BigDecimal("1.0100000");
        BigDecimal result2 = new BigDecimal("1.99900");

        Assert.assertTrue(BigDecimalUtils.equals(null, null));
        Assert.assertFalse(BigDecimalUtils.equals(bd1, null));
        Assert.assertFalse(BigDecimalUtils.equals(null, bd1));
        Assert.assertTrue(BigDecimalUtils.equals(bd1, result1));
        Assert.assertTrue(BigDecimalUtils.equals(bd2, result2));
    }

    @Test
    public void testNotEquals()
    {
        // Not-Equals ignores scale, so add additional here.
        BigDecimal result1 = new BigDecimal("1.0100000");
        BigDecimal result2 = new BigDecimal("1.99900");

        Assert.assertFalse(BigDecimalUtils.notEquals(null, null));
        Assert.assertTrue(BigDecimalUtils.notEquals(bd1, null));
        Assert.assertTrue(BigDecimalUtils.notEquals(null, bd1));
        Assert.assertFalse(BigDecimalUtils.notEquals(bd1, result1));
        Assert.assertFalse(BigDecimalUtils.notEquals(bd2, result2));
    }

    @Test
    public void testGetTotal()
    {
        // Get Total preserves scale, so don't add additional here.
        BigDecimal result1 = new BigDecimal("6.150592654");

        Assert.assertEquals(result1, BigDecimalUtils.getTotal(list));
    }

    @Test
    public void testIsGreaterThan()
    {
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(null,  null));
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(null,  bd4));
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(bd4,  null));
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(bd3,  bd3));
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(bd4,  bd4));
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(bd5,  bd5));
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(bd3,  bd4));
        Assert.assertTrue(BigDecimalUtils.isGreaterThan(bd4,  bd3));
        Assert.assertFalse(BigDecimalUtils.isGreaterThan(bd4,  bd5));
        Assert.assertTrue(BigDecimalUtils.isGreaterThan(bd5,  bd4));
    }

    @Test
    public void testIsGreaterThanOrEqualTo()
    {
        Assert.assertFalse(BigDecimalUtils.isGreaterThanOrEqualTo(null,  null));
        Assert.assertFalse(BigDecimalUtils.isGreaterThanOrEqualTo(null,  bd4));
        Assert.assertFalse(BigDecimalUtils.isGreaterThanOrEqualTo(bd4,  null));
        Assert.assertTrue(BigDecimalUtils.isGreaterThanOrEqualTo(bd3,  bd3));
        Assert.assertTrue(BigDecimalUtils.isGreaterThanOrEqualTo(bd4,  bd4));
        Assert.assertTrue(BigDecimalUtils.isGreaterThanOrEqualTo(bd5,  bd5));
        Assert.assertFalse(BigDecimalUtils.isGreaterThanOrEqualTo(bd3,  bd4));
        Assert.assertFalse(BigDecimalUtils.isGreaterThanOrEqualTo(bd4,  bd5));
        Assert.assertTrue(BigDecimalUtils.isGreaterThanOrEqualTo(bd4,  bd3));
        Assert.assertTrue(BigDecimalUtils.isGreaterThanOrEqualTo(bd5,  bd4));

        // >= ignores scale, so add additional here.
        BigDecimal result1 = new BigDecimal("1.0100000");
        BigDecimal result2 = new BigDecimal("1.99900");

        Assert.assertTrue(BigDecimalUtils.isGreaterThanOrEqualTo(bd1,  result1));
        Assert.assertTrue(BigDecimalUtils.isGreaterThanOrEqualTo(bd2,  result2));
    }

    @Test
    public void testIsLessThan()
    {
        Assert.assertFalse(BigDecimalUtils.isLessThan(null,  null));
        Assert.assertFalse(BigDecimalUtils.isLessThan(null,  bd4));
        Assert.assertFalse(BigDecimalUtils.isLessThan(bd4,  null));
        Assert.assertFalse(BigDecimalUtils.isLessThan(bd3,  bd3));
        Assert.assertFalse(BigDecimalUtils.isLessThan(bd4,  bd4));
        Assert.assertFalse(BigDecimalUtils.isLessThan(bd5,  bd5));
        Assert.assertTrue(BigDecimalUtils.isLessThan(bd3,  bd4));
        Assert.assertFalse(BigDecimalUtils.isLessThan(bd4,  bd3));
        Assert.assertTrue(BigDecimalUtils.isLessThan(bd4,  bd5));
        Assert.assertFalse(BigDecimalUtils.isLessThan(bd5,  bd4));
    }

    @Test
    public void testIsLessThanOrEqualTo()
    {
        Assert.assertFalse(BigDecimalUtils.isLessThanOrEqualTo(null,  null));
        Assert.assertFalse(BigDecimalUtils.isLessThanOrEqualTo(null,  bd4));
        Assert.assertFalse(BigDecimalUtils.isLessThanOrEqualTo(bd4,  null));
        Assert.assertTrue(BigDecimalUtils.isLessThanOrEqualTo(bd3,  bd3));
        Assert.assertTrue(BigDecimalUtils.isLessThanOrEqualTo(bd4,  bd4));
        Assert.assertTrue(BigDecimalUtils.isLessThanOrEqualTo(bd5,  bd5));
        Assert.assertTrue(BigDecimalUtils.isLessThanOrEqualTo(bd3,  bd4));
        Assert.assertFalse(BigDecimalUtils.isLessThanOrEqualTo(bd4,  bd3));
        Assert.assertTrue(BigDecimalUtils.isLessThanOrEqualTo(bd4,  bd5));
        Assert.assertFalse(BigDecimalUtils.isLessThanOrEqualTo(bd5,  bd4));

        // <= ignores scale, so add additional here.
        BigDecimal result1 = new BigDecimal("1.0100000");
        BigDecimal result2 = new BigDecimal("1.99900");

        Assert.assertTrue(BigDecimalUtils.isLessThanOrEqualTo(bd1,  result1));
        Assert.assertTrue(BigDecimalUtils.isLessThanOrEqualTo(bd2,  result2));
    }

    @Test
    public void testIsNegative()
    {
        Assert.assertFalse(BigDecimalUtils.isNegative(null));
        Assert.assertTrue(BigDecimalUtils.isNegative(bd0));
        Assert.assertFalse(BigDecimalUtils.isNegative(bd1));
    }

    @Test
    public void testIsNegativeOrNull()
    {
        Assert.assertTrue(BigDecimalUtils.isNegativeOrNull(null));
        Assert.assertTrue(BigDecimalUtils.isNegativeOrNull(bd0));
        Assert.assertFalse(BigDecimalUtils.isNegativeOrNull(bd1));
    }

    @Test
    public void testIsPositive()
    {
        Assert.assertFalse(BigDecimalUtils.isPositive(null));
        Assert.assertFalse(BigDecimalUtils.isPositive(bd0));
        Assert.assertTrue(BigDecimalUtils.isPositive(bd1));
    }

    @Test
    public void testIsNotPositive()
    {
        Assert.assertTrue(BigDecimalUtils.isNotPositive(null));
        Assert.assertTrue(BigDecimalUtils.isNotPositive(bd0));
        Assert.assertFalse(BigDecimalUtils.isNotPositive(bd1));
    }

    @Test
    public void testIsPositiveOrNull()
    {
        Assert.assertTrue(BigDecimalUtils.isPositiveOrNull(null));
        Assert.assertFalse(BigDecimalUtils.isPositiveOrNull(bd0));
        Assert.assertTrue(BigDecimalUtils.isPositiveOrNull(bd1));
    }

    @Test
    public void testIsZero()
    {
        // Is Zero ignores scale, so add additional here.
        BigDecimal zero = new BigDecimal("0.000000");

        Assert.assertFalse(BigDecimalUtils.isZero(null));
        Assert.assertTrue(BigDecimalUtils.isZero(BigDecimal.ZERO));
        Assert.assertTrue(BigDecimalUtils.isZero(zero));
        Assert.assertFalse(BigDecimalUtils.isZero(bd0));
        Assert.assertFalse(BigDecimalUtils.isZero(bd1));
    }

    @Test
    public void testIsNotZero()
    {
        // Is Not-Zero ignores scale, so add additional here.
        BigDecimal zero = new BigDecimal("0.000000");

        Assert.assertFalse(BigDecimalUtils.isNotZero(null));
        Assert.assertFalse(BigDecimalUtils.isNotZero(BigDecimal.ZERO));
        Assert.assertFalse(BigDecimalUtils.isNotZero(zero));
        Assert.assertTrue(BigDecimalUtils.isNotZero(bd0));
        Assert.assertTrue(BigDecimalUtils.isNotZero(bd1));
    }
}
