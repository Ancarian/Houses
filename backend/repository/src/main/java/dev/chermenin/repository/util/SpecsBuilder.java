package dev.chermenin.repository.util;

import dev.chermenin.dao.BaseObject;
import dev.chermenin.repository.specs.SpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecsBuilder {

    public static Specification<? extends BaseObject> createSpecification(String searchStr) {
        SpecificationBuilder<? extends BaseObject> builder = new SpecificationBuilder<>();
        Pattern pattern = Pattern.compile("(\\w+?)([:<>_])(\\w+?),");
        Matcher matcher = pattern.matcher(searchStr + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        return builder.build();
    }
}
