package data;

import models.ItemDetails;
import org.testng.annotations.DataProvider;

import java.util.List;

public class CustomDataProvider {

    public static final String DP_ITEM_PRICE = "dpItemPrice";
    public static final String DP_CREDENTIALS = "dpCredentials";

    @DataProvider(name = DP_CREDENTIALS)
    public static Object[][] credentialDataProvider() {
        final var validData = DataGiver.getValidCredentials();

        return new Object[][]{
                {validData.getEmail(), validData.getPassword()},
        };
    }

    @DataProvider(name = DP_ITEM_PRICE)
    public static Object[][] provideItemPriceData() {
        List<ItemDetails> items = ExcelReader.readDetailsItemsExcel();

        System.out.println("📂 Data Uploaded from Excel:");
        for (ItemDetails item : items) {
            System.out.println("➡ " + item.getItemName() + " - " + item.getItemPrice());
        }

        return new Object[][]{{items}};
    }

}
