# Student Grade Management System

A **console-based Java application** to manage student records and grades. This system demonstrates a full application of **Object-Oriented Programming (OOP) principles** including abstraction, inheritance, polymorphism, and encapsulation.

---

## **Features**

### **Student Management**
- Add Regular or Honors students.
- Automatically generates unique student IDs starting from 1000.
- Maintains student status (Active by default).

### **Grade Management**
- Record grades for Core (Mathematics, English, Science) and Elective subjects (Music, Art, Physical Education).
- Automatically generates unique grade IDs and records the date.
- Validates grades (0-100) and displays PASS/FAIL based on student type:
  - **Regular:** Pass ≥ 50
  - **Honors:** Pass ≥ 60

### **Reports**
- View all students with ID, name, type, average grade, and status.
- Display detailed grade reports per student:
  - Shows grades in reverse chronological order.
  - Calculates averages for core subjects, elective subjects, and overall.

### **Menu Navigation**
- Simple console menu:
  1. Add Student
  2. View Students
  3. Record Grade
  4. View Grade Report
  5. Exit

---

## **Project Structure**

- **Student (Abstract Class):** Base class for student types.
- **RegularStudent & HonorsStudent:** Extend `Student`.
- **Subject (Abstract Class):** Base class for subjects.
- **CoreSubject & ElectiveSubject:** Extend `Subject`.
- **Grade:** Stores student grades with unique grade ID and date.
- **GradeManager:** Manages grades, averages, and PASS/FAIL determination.
- **StudentManagement:** Handles student addition, searching, and class averages.
- **Menu:** Console interface for user interaction.

---

## **OOP Principles Used**
- **Abstraction:** `Student` and `Subject` abstract classes.
- **Inheritance:** Student and Subject subclasses.
- **Polymorphism:** Treat Core/Elective subjects as `Subject`; treat both student types as `Student`.
- **Encapsulation:** Private fields with getters/setters.
- **Separation of Concerns:** UI handled by `Menu`, data management by `StudentManagement` and `GradeManager`.

---

## **Requirements**
- Java JDK 8 or above.
- Console/terminal to run the program.

---

## **Usage**
1. Run the `Menu` class.
2. Follow on-screen menu prompts.
3. Add students, record grades, and view reports as needed.

---

## **Notes**
- Supports up to 50 students and 200 grades.
- Ensures grades are within valid range (0-100).
- Unique IDs for students and grades.
- Demonstrates practical use of Java OOP principles.
