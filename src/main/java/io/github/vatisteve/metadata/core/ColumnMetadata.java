package io.github.vatisteve.metadata.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tinhnv
 * @since Dec 20, 2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnMetadata {

    private String name;
    private String dataType;
    private boolean identity;
    /**
     * There are many cases occur when change primary key constraint
     * @see <a href='https://stackoverflow.com/questions/2111291/remove-primary-key-in-mysql'>Primary key update issue</a>
     */
    private boolean primaryKey;
    @Builder.Default
    private boolean nullable = true;
    private boolean unique;
    private ReferenceMetadata reference;
    private DefaultColumnValue columnDefault;
    private String checkConstraint;

    public ColumnMetadata(ColumnMetadata other) {
        this.name = other.name;
        this.dataType = other.dataType;
        this.identity = other.identity;
        this.primaryKey = other.primaryKey;
        this.nullable = other.nullable;
        this.unique = other.unique;
        this.checkConstraint = other.checkConstraint;
        this.reference = other.reference != null ? new ReferenceMetadata(other.reference) : null;
        this.columnDefault = other.columnDefault != null ? new DefaultColumnValue(other.columnDefault) : null;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DefaultColumnValue {

        private DataType dataType;
        private Object value;

        public DefaultColumnValue(DefaultColumnValue other) {
            this.dataType = other.dataType;
            this.value = other.value;
        }
    }

}