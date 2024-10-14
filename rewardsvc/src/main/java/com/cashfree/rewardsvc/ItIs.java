package rewardsvc/src/main/java/com/cashfree/rewardsvc;

import in.cleartax.ftp.dtos.ingestionTemplate.TemplateType;
import in.cleartax.ftp.models.clientConfig.Product;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static in.cleartax.ftp.constants.Constants.*;

public class ItIs {

    public static String getResourceFromProduct(Product product) {
        switch (product) {
            case EINVOICE_MY:
                return INGESTION_EINVOICEMYSALES;
            case EINVOICE_INDIA:
                return INGESTION_EINVOICE;
            case EINVOICE_GCC:
                return INGESTION_EINVOICEGCC;
            default:
                return INGESTION_EINVOICE;
        }
    }

    public static String getPostFixCreateActivityUrl(Product product, String templateType) {
        if (Product.EINVOICE_GCC.equals(product)) {
            return "einvoice-gcc/activity/v1/EINVOICEGCC/create";
        }
        if (Product.EINVOICE_MY.equals(product) && TemplateType.EINVOICE_MY_SALES.name().equals(templateType)) {
            return "einvoice-my/activity/v1/EINVOICEMYSALES/create";
        }
        if (Product.EINVOICE_MY.equals(product) && TemplateType.EINVOICE_MY_PURCHASE.name().equals(templateType)) {
            return "einvoice-my/activity/v1/EINVOICEMYPURCHASE/create";
        }
        if (Product.EINVOICE_MY.equals(product) && TemplateType.EINVOICE_MY_SALES_B2C.name().equals(templateType)) {
            return "einvoice-my/activity/v1/EINVOICEMYSALES/create";
        }
        return "einvoice/activity/v1/EINVOICE/create";
    }

    public static String countryToFtpConfigProduct(String country) {
        country = country.toLowerCase();
        switch (country) {
            case "my":
                return "EINVOICE_MY";
            case "in":
                return "EINVOICE_INDIA";
            case "ksa":
                return "EINVOICE_GCC";
            default:
                return "EINVOICE_INDIA";
        }

    }
}
