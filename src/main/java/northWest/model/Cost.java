package northWest.model;
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

public class Cost {

    private Shop shop;
    private Warehouse warehouse;
    private int value;
}
