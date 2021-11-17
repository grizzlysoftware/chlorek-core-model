package pl.grizzlysoftware.chlorek.core.mapper;

import pl.grizzlysoftware.chlorek.core.model.Product;
import pl.grizzlysoftware.chlorek.core.model.ProductIngredient;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class CanonicalProductToCanonicalProductIngredientMapper implements Function<Product, ProductIngredient> {
    @Override
    public ProductIngredient apply(Product in) {
        if (in == null) {
            return null;
        }

        ProductIngredient out = new ProductIngredient();
        out.id = 844761495674065L;    //TODO hardcoded ingredient ID
        out.quantity = BigDecimal.ONE;
        out.unit = "Piece";
        out.productId = in.id;

        return out;
    }
}
