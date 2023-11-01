package LaiOffer.Class17_ObjectOrientedDesign_III;

public class OOD_DesignPatterns {

    /**
     * Simple Design Patterns
     *
     * Builder Pattern
     * 1. The constructor should not have too many parameters.
     * 2. Do not use too many constructors.
     *
     * Solution 1: limited constructors, but use setter/getter
     * Disadvantages:
     * 1. Need many steps to create an object. Cannot ensure an object is created totally or not.
     * 2. What if we do not want to expose setters for some data fields?
     *
     * Solution 2: Using Builder Pattern
     * Create a nested class like UserBuilder to store the information needed for create an object
     *
     * Factory Pattern
     * 1. Separate instance/object creation logic from its usage
     * 2. More clean especially when we have complicated instance creation logic
     * 3. Provide chances to have different object allocation strategies
     *
     * Abstract Factory Pattern
     * The abstract factory pattern provides a way to encapsulate a group of individual factories
     * that have a common theme without specifying their concrete classes.
     *
     * Singleton
     * Ensure a class has only one instance, and provide a global point of access of it.
     *
     * Top 10 Object-Oriented Design Principles
     * 1. DRY （Don't repeat yourself） - avoids duplication in code.
     * 2. Encapsulate what changes - hides implementation detail, helps in maintenance
     * 3. Open Closed design principle - open for extension, closed for modification
     * 4. SRP （Single Responsibility Principle）- one class should do one thing and do it well
     * 5. DIP （Dependency Inversion Principle） - don't ask, let framework give to you
     * 6. Favor Composition over Inheritance- Code reuse without cost of inflexibility
     * 7. LSP （Liskov Substitution Principle）- Sub type must be substitutable for super type
     * 8. ISP （Interface Segregation Principle） - Avoid monolithic interface, reduce pain on client side
     * 9. Programming for Interface - Helps in maintenance, improves flexibility
     * 10.Delegation principle - Don't do all things by yourself, delegate it
     */

}
