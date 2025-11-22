import org.testng.annotations.DataProvider;

public class LoginDataProviders {
    @DataProvider(name = "NegativeLoginTestData")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][] {
                { "invalid@koel.dev", "invalidPass" },
                { "demo@koel.dev", "invalidPass" },
                { "invalid@email.com", "demo" },
                { "", "" },
                { "", "demo" },
                { "demo@koel.dev", "" }
        };
    }
}
