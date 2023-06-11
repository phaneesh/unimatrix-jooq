package io.github.phaneesh;

import lombok.Getter;
import org.jooq.DSLContext;

public class AbstractDao {

    @Getter
    private final DSLContext dslContext;

    public AbstractDao(final DSLContext dslContext) {
        this.dslContext = dslContext;
    }
}
