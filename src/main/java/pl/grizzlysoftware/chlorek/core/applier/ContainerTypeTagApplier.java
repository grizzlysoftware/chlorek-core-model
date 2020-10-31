package pl.grizzlysoftware.chlorek.core.applier;

import pl.grizzlysoftware.chlorek.core.model.Container;
import pl.grizzlysoftware.chlorek.core.model.KeyValueTag;
import pl.grizzlysoftware.chlorek.core.model.Taggable;

import java.util.function.Consumer;

import static pl.grizzlysoftware.chlorek.core.model.TagRegistry.CONTAINER_TYPE_TAG;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class ContainerTypeTagApplier implements Consumer<Taggable> {
    @Override
    public void accept(Taggable taggable) {
        if (taggable instanceof Container) {
            var container = (Container) taggable;
            var containerType = container.getContainerType();
            if (containerType == null) {
                return;
            }
            taggable.addTag(new KeyValueTag(CONTAINER_TYPE_TAG, containerType.name()));
        }
    }
}
