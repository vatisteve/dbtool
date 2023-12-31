package io.github.vatisteve.metadata.core;

/**
 * @author tinhnv
 * @since Dec 19, 2023
 */
public interface DataType {

    String name();

    default String getLabel() {
        return name();
    }

    default String getValue() {
        return name();
    }

    DataType getParent();

    boolean isEnable();

    enum BasicDataType implements DataType {

        NUMERIC, STRING, TEMPORAL, SPATIAL;

        @Override
        public DataType getParent() {
            return null;
        }

        @Override
        public boolean isEnable() {
            return false;
        }
    }

}