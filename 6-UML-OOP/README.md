## Lab: UML Class Diagram of Wheeled Vehicles

### Abstraction

The WheeeledVehicle interface itself is an example of abstraction. Another way it is shown in the UML is that a real life vehicle will have seats, a steering wheel & many other components. However, they are not depicted in the UML since they are not relevant to the game. The AmphibiousVehicle is also an example of abstraction as it is abstracting out properties & methods that do not need to be explicitly specified in its child classes.

### Polymorphism

Method overriding is one way of implementing polymorphism. In the UML,the AmphibiousSeaplane class implements a special implementation of drive since it has to make sure that both, isWaterMode and isFlyMode properties are false. So it overrides the drive() method inherited from the AmphibiousVehicle abstract class.

### Inheritance

Each parent child relationship shown in the diagram is an example of inheritance. For ex, the WheeledVehicle interface is inherited by all classes under it. In this case it serves as a contract that the child classes must implement certain methods. The AmphibiousVehicle abstract class is another example of inheritance. In this case, the code from this class can be reused in multiple child classes.

### Encapsulation

Each of the classes is an example of encapsulation since a group of attributes and/or methods is grouped together in each of these cases. Data hiding is achieved in all cases where something is set as private & is a specific way of implementing encapsulation.

Note: constructors & getters would normally be part of the UML, but since they are not necessary to demonstrate the principles instructed in the lab, they have been skipped in this UML.
