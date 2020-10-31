package pl.grizzlysoftware.chlorek.core.resolver;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.grizzlysoftware.chlorek.core.model.KeyValueTag;
import pl.grizzlysoftware.chlorek.core.model.NullTag;
import pl.grizzlysoftware.chlorek.core.model.Tag;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;
import static org.apache.commons.lang3.StringUtils.join;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
@Slf4j
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

        try {
            var output = resolve(parts);
            return output;
        } catch (Exception e) {
            log.warn("Unable to deserialize LoyaltyPointsTimeRangePromoTag from {}, exception:\n{}",
                    join(parts, ":"), getStackTrace(e));
            return NullTag.INSTANCE;
        }
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
