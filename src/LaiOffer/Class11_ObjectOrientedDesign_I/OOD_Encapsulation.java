package LaiOffer.Class11_ObjectOrientedDesign_I;

public class OOD_Encapsulation {

    /**
     * Data Encapsulation: Data Abstraction and Access Labels
     * 1) Providing only essential information to the outside world and hiding their background details
     * 2) Separate interface and implementation
     *
     * Access Labels: public default protected private
     * Access           public      protected       private
     * Same Class       yes         yes             yes
     * Derived Class    yes         yes             no
     * Outside Class    yes         no              no
     *
     * Access Levels:
     * Modify           Class       Package         Subclass        World
     * public           Y           Y               Y               Y
     * protected        Y           Y               Y               N
     * default          Y           Y               N               N
     * private          Y           N               N               N
     *
     * How to select appropriate labels?
     * 1. API: public
     * 2. Internal implementation: private
     * 3. Class inheritance: do we need to use protected for methods/attributes
     *      a. Protected methods: sometimes useful when we want to override an implementation in subclasses
     *      b. Protected attributes: be careful, try to use private first
     * 4. "default" in java (package-private): declare a class as public only when we define public API in it,
     * otherwise package-private is good enough
     */

}
