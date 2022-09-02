package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int amount;

    public FruitTransaction(Operation operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return amount == that.amount && operation == that.operation
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, amount);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getOperation(String operation) {
            for (Operation type : values()) {
                if (type.operation.equals(operation)) {
                    return type;
                }
            }
            throw new RuntimeException("Operation type: "
                    + operation
                    + " not exist!");
        }
    }
}