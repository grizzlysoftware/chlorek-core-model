package pl.grizzlysoftware.chlorek.core.resolver;

import org.apache.commons.lang3.StringUtils;
import pl.grizzlysoftware.chlorek.core.model.KeyValueTag;
import pl.grizzlysoftware.chlorek.core.model.NullTag;
import pl.grizzlysoftware.chlorek.core.model.Tag;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class CsvTagParser implements TagParser {
    protected String separator;

    public CsvTagParser(String separator) {
        if (StringUtils.isEmpty(separator)) {
            throw new IllegalArgumentException("separator cannot be null or empty string");
        }
        this.separator = separator;
    }

    @Override
    public Tag parse(String tag) {
        if (tag == null || tag.isBlank()) {
            return NullTag.INSTANCE;
        }
        var parts = tag.split(separator);
        var output = resolve(parts);
        return output;
    }

    protected Tag resolve(String[] csvParts) {
        if (csvParts.length < 1) {
            return NullTag.INSTANCE;
        } else if (csvParts.length == 1) {
            return new KeyValueTag(csvParts[0]);
        } else {
            return new KeyValueTag(csvParts[0], csvParts[1]);
        }
    }
}
