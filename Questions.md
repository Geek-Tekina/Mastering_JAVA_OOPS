# Java OOPS Practice Questions

## Day 1: Book Inventory System

Design a `Book` class for a bookstore.

### Requirements

* Each book should have:

    * Book ID
    * Title
    * Author
    * Price
    * Stock Quantity
* Book ID should be generated or treated appropriately.
* Price should never become negative.
* Stock should never become negative.
* Implement methods to:

    * Increase stock
    * Decrease stock
    * Update price
    * Display book information
* Decide which fields are:

    * Generated
    * Mandatory
    * Optional
    * Mutable
    * Immutable

---

## Day 2: Student Management System

Design a `Student` class.

### Requirements

* Each student should have:

    * Student ID
    * Name
    * Age
    * Department
    * CGPA
* Student ID should be auto-generated.
* Implement constructor overloading:

    * Name + Age
    * Name + Age + Department
    * Name + Age + Department + CGPA
* Use constructor chaining.
* Validate:

    * Age cannot be negative.
    * CGPA must be between 0 and 10.
* Implement methods to:

    * Update CGPA
    * Change department
    * Promote student
* Decide which fields are:

    * Generated
    * Mandatory
    * Optional
    * Mutable
    * Immutable

---

## Day 3: Classroom Management System

Design a `Classroom` that manages students.

### Requirements

* Each classroom should have:

    * Classroom ID
    * Teacher Name
    * Capacity
    * Students
* Use a collection to store students.
* Implement methods to:

    * Add student
    * Remove student by ID
    * Find student by ID
    * Display all students
    * Get current strength
* A classroom should not exceed its capacity.
* Decide:

    * Should missing students throw exceptions?
    * Which failures are business failures?
    * Why should `List<Student>` be preferred over `ArrayList<Student>`?

---

## Day 4A: Aggregation

Design a `Team` and `Player` system.

### Requirements

#### Player

* Player ID
* Name
* Position

#### Team

* Team ID
* Team Name
* Players

### Questions

* Can a Player exist without a Team?
* Who creates the Player?
* What happens to Players if a Team is deleted?
* Implement methods to:

    * Add Player
    * Remove Player
    * Display Players

Determine the relationship type and justify your answer.

---

## Day 4B: Composition

Design a `House` and `Room` system.

### Requirements

#### Room

* Room Number
* Room Type

#### House

* House ID
* Owner Name
* Rooms

### Questions

* Can a Room exist independently?
* Who should create the Room?
* What happens to Rooms if a House is deleted?
* Why should:

    * `addRoom(String roomType)`
      be preferred over:
    * `addRoom(Room room)`?

Implement methods to:

* Add Room
* Display Rooms

Determine the relationship type and justify your answer.

---

## Day 5: Employee Management System (Inheritance)

Design an employee hierarchy.

### Hierarchy

Employee
├── Developer
├── Manager
└── Intern

### Employee Requirements

* Employee ID
* Employee Email
* Name
* Gender
* Age
* Phone Number
* Address
* Salary

### Developer Requirements

* Tech Stack

### Manager Requirements

* Team Size

### Intern Requirements

* Internship Duration

### Questions

* Which fields are:

    * Generated?
    * Mandatory?
    * Optional?
    * Mutable?
    * Immutable?
* Why is Employee a parent class?
* Why should Employee be abstract?
* Is this relationship truly an IS-A relationship?

### Bonus Behaviour

Implement bonus calculation such that:

* Developer receives 20% of salary.
* Manager receives 30% of salary.
* Intern receives 5% of salary.

### Think Before Coding

* Should `calculateBonus()` have implementation in Employee?
* Should it be abstract?
* Could an interface work instead?
* Which approach best models the business requirements?

### Demonstrate

* Constructor chaining using `super()`.
* Method overriding.
* Runtime polymorphism using:

```java
Employee employee = new Developer(...);
Employee employee = new Manager(...);
Employee employee = new Intern(...);
```

Explain why the correct `calculateBonus()` method executes at runtime.
