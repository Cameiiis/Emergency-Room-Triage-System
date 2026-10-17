# Emergency Room Triage System

A small Java console demonstration of a patient priority queue. Patients with a lower numeric priority are treated first; for equal priorities, earlier `HH:mm` arrival times come first. The included sample data is printed and one patient is treated when the program runs.

> Educational demo only. This program does not make clinical triage decisions and must not be used for patient care.

## Requirements

- A Java Development Kit (JDK) with `javac` and `java` available on your PATH.
- A terminal that supports UTF-8 output for the symbols in the sample data.

No external libraries or environment variables are required.

## Compile and run

From the repository root:

```sh
javac -encoding UTF-8 -d out SecondLabExam.java
java -cp out CCE105LAB.SecondLabExam
```

The `-d out` option places the compiled classes under `out/CCE105LAB/`, matching the `package CCE105LAB;` declaration. On Windows, the same commands work in PowerShell or Command Prompt.

The demo creates five sample patients, displays the waiting queue, treats the next patient, and displays the remaining patients. Priority 1 is the most urgent in this sample. The code compares arrival times as strings, so times must use zero-padded 24-hour `HH:mm` format.
