package common;

import org.testng.annotations.DataProvider;
public class StaticProvider {


    @DataProvider(name = "TC01")
    public static Object[][] createData1() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "123456789"}
        };
    };

    @DataProvider(name = "TC02")
    public static Object[][] createData2() {
        return new Object[][]{
                {"", "123456789"}
        };
    };

    @DataProvider(name = "TC03")
    public static Object[][] createData3() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", ""}
        };
    };

    @DataProvider(name = "TC04")
    public static Object[][] createData4() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "12345678", "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes."}
        };
    };

    @DataProvider(name = "TC05")
    public static Object[][] createData5() {
        return new Object[][]{
                {"u0tvz0+a3ii8w2nrxv8o@grr.la", "123456789"}
        };
    };

    @DataProvider(name = "TC06")
    public static Object[][] createData6() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "123456789"}
        };
    };

    @DataProvider(name = "TC07")
    public static Object[][] createData7() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "123456789", "123123123"}
        };
    };

    @DataProvider(name = "TC08")
    public static Object[][] createData8() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "", ""}
        };
    };

    @DataProvider(name = "TC09")
    public static Object[][] createData9() {
        return new Object[][]{
                {"tranthinhan28", "123456789", "123123123", 2}
        };
    };

    @DataProvider(name = "TC10")
    public static Object[][] createData10() {
        return new Object[][]{
                {"tranthinhan@spam4.me", "tranthinhan", "12341234", "12341234", 2}
        };
    };

    @DataProvider(name = "TC11")
    public static Object[][] createData11() {
        return new Object[][]{
                {"tranthinhan@spam4.me", "tranthinhan", "12341234", "1234123", 2}
        };
    };

    @DataProvider(name = "TC12")
    public static Object[][] createData12() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "123456789", 12, "Nha Trang", "Huế", "Soft bed with air conditioner", 1}
        };
    };

    @DataProvider(name = "TC13")
    public static Object[][] createData13() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "123456789",25, "Nha Trang", "Sài Gòn", "Soft seat with air conditioner", 5}
        };
    };

    @DataProvider(name = "TC14")
    public static Object[][] createData14() {
        return new Object[][]{
                {"tranthinhan@spam4.me", "12341234", "Đà Nẵng", "Sài Gòn"}
        };
    };

    @DataProvider(name = "TC15")
    public static Object[][] createData15() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "123456789", "Quảng Ngãi", "Huế", 10, 5}
        };
    };

    @DataProvider(name = "TC16")
    public static Object[][] createData16() {
        return new Object[][]{
                {"h1uv4c9ktg@email2u.shop", "123456789",10, "Nha Trang", "Huế", "Soft seat with air conditioner", 1}
        };
    };
}
