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
                throw new IllegalArgumentException("Unsupported product: " + product);
        }
    }

    public static String getPostFixCreateActivityUrl(Product product, String templateType) {
        if (Product.EINVOICE_GCC == product) {
            return "einvoice-gcc/activity/v1/EINVOICEGCC/create";
        }
        if (Product.EINVOICE_MY == product) {
            TemplateType type = TemplateType.valueOf(templateType);
            switch (type) {
                case EINVOICE_MY_SALES:
                case EINVOICE_MY_SALES_B2C:
                    return "einvoice-my/activity/v1/EINVOICEMYSALES/create";
                case EINVOICE_MY_PURCHASE:
                    return "einvoice-my/activity/v1/EINVOICEMYPURCHASE/create";
                default:
                    throw new IllegalArgumentException("Unsupported template type for EINVOICE_MY: " + type);
            }
        }
        if (Product.EINVOICE_INDIA == product) {
            return "einvoice/activity/v1/EINVOICE/create";
        }
        throw new IllegalArgumentException("Unsupported product: " + product);
    }

    public static String countryToFtpConfigProduct(String country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        switch (country.toLowerCase()) {
            case "my":
                return "EINVOICE_MY";
            case "in":
                return "EINVOICE_INDIA";
            case "ksa":
                return "EINVOICE_GCC";
            default:
                throw new IllegalArgumentException("Unsupported country: " + country);
        }
    }
}