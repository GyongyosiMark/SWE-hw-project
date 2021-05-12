package northWest.model;

import java.util.ArrayList;
import java.util.List;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

public class TransportationProblem {

    private String name;
    private List<Shop> shops;
    private List<Warehouse> warehouses;
    public ArrayList<Cost> costs;

}
