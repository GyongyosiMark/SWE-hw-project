package northWest.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class dataManipulator{

    public static void main(String[] args) throws Exception {
        var objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        var transportationProblem = new TransportationProblem();
        transportationProblem.setName("North-West Corner Method");

        var shops = new ArrayList<Shop>();
        shops.add(new Shop("S1", 10));
        shops.add(new Shop("S2", 20));
        shops.add(new Shop("S3", 30));
        transportationProblem.setShops(shops);

        var warehouses = new ArrayList<Warehouse>();
        warehouses.add(new Warehouse("W1", 30));
        warehouses.add(new Warehouse("W2", 20));
        warehouses.add(new Warehouse("W3", 10));
        transportationProblem.setWarehouses(warehouses);

        Random rand = new Random();

        var costs = new ArrayList<Cost>();
        costs.add(new Cost(shops.get(0), warehouses.get(0), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(0), warehouses.get(1), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(0), warehouses.get(2), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(1), warehouses.get(0), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(1), warehouses.get(1), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(1), warehouses.get(2), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(2), warehouses.get(0), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(2), warehouses.get(1), rand.nextInt(10)+1));
        costs.add(new Cost(shops.get(2), warehouses.get(2), rand.nextInt(10)+1));
        transportationProblem.setCosts(costs);

        try(var writer = new FileWriter("transportationProblem.json")){
            objectMapper.writeValue(writer, transportationProblem);
        }

        System.out.println(objectMapper.readValue(new FileReader("transportationProblem.json"), TransportationProblem.class));

    }
}
