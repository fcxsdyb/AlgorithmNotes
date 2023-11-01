package LaiOffer.Class15_ObjectOrientedDesign_II;

public class OOD_ParkingLot {

    /**
     * Design a Parking Lot
     *
     * Steps:
     * 1. Understand/Analyze the use case
     * User case: Describe the parking lot building? Vehicle monitoring? What kind of parking lot?
     *
     * Use cases -> APIs
     * For API, always ask yourself: input/output?
     *
     * Some other questions that may affect your design:
     * One level or multiple levels?
     * Parking-Spot / Vehicle sizes?
     * Track the location of each vehicle?
     * ...
     *
     * 2. Classes and their relationships
     * Single-responsibility Principle: A class should have only one job
     * Vehicle, Parking Spot, Level, ParkingLot.
     *
     * Class relationships:
     * Association: a general binary relationship that describes an activity between two classes.
     * Aggregation/Composition: a special form of association, which represents an ownership relationship
     * between two classes. (has-a)
     * Inheritance
     *
     * Vehicle -- Parking Spot
     * Level -- Parking Spot
     * Parking Lot -- Level
     * Vehicle -- Car, Truck
     *
     * Q: which design do you prefer?
     *      1) ParkingLot - Level - ParkingSpot
     *      2) ParkingLot - ParkingSpot
     *
     * Tips:
     * 1. Using Collections.unmodifiableList(list) can make the private final List safe for outside using.
     */

}
