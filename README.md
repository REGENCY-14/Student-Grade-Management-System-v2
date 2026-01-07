# Student Grade Management System - Refactored

## Project Structure

The project has been refactored to follow proper software engineering practices with a clean package structure.

```
src/main/java/com/studentgrade/
├── app/
│   └── Main.java                 # Application entry point
├── ui/
│   └── Menu.java                 # Menu UI and user interactions
├── manager/
│   └── GradeManager.java         # Grade management logic
└── model/
    ├── Student.java              # Base student class
    ├── RegularStudent.java        # Regular student implementation
    ├── HonorsStudent.java         # Honors student implementation
    ├── Grade.java                 # Grade model
    ├── Subject.java               # Abstract subject class
    ├── CoreSubject.java           # Core subject implementation
    └── ElectiveSubject.java       # Elective subject implementation
```

## Package Organization

### `com.studentgrade.app`
- **Main.java** - Standalone entry point that initializes all dependencies and starts the application

### `com.studentgrade.ui`
- **Menu.java** - Handles all user interactions and menu navigation. Separated from Main for better separation of concerns

### `com.studentgrade.manager`
- **GradeManager.java** - Manages all grade-related operations (add, calculate averages, view reports)

### `com.studentgrade.model`
Contains all data models:
- **Student.java** - Base student class with common properties
- **RegularStudent.java** - Student with passing grade threshold of 50
- **HonorsStudent.java** - Student with passing grade threshold of 60
- **Grade.java** - Represents a grade record for a student-subject combination
- **Subject.java** - Abstract base class for subjects
- **CoreSubject.java** - Mandatory core subjects (Mathematics, English, Science)
- **ElectiveSubject.java** - Optional elective subjects (Music, Art, PE)

## Key Improvements

### Separation of Concerns
- **Main.java** now only initializes dependencies
- **Menu.java** handles all UI and user interactions
- **GradeManager.java** manages grade logic
- **Model classes** represent data entities

### Dependency Injection
- Dependencies are passed through constructors rather than static references
- GradeManager is properly injected into Student objects
- Scanner is passed to Menu instead of being globally static

### Clean Code Practices
- Clear package structure based on functionality
- Reduced coupling between components
- Easier to test and maintain
- Better reusability of components

## How to Compile and Run

### Compile
```bash
javac -d bin src/main/java/com/studentgrade/**/*.java
```

### Run
```bash
java -cp bin com.studentgrade.app.Main
```

## Features

1. **Add Student** - Add new students (Regular or Honors)
2. **View Students** - Display all students with their statistics
3. **Record Grade** - Record grades for students in core or elective subjects
4. **View Grade Report** - View detailed grade reports for each student
5. **Grade Calculation** - Automatic calculation of core, elective, and overall averages

## Static Members Removed
The refactored code eliminates problematic static references:
- Static ArrayList of students
- Static Scanner
- Static GradeManager

All these are now properly managed through dependency injection.
