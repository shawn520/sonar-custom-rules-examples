package org.sonar.samples.java.checks.Dnaming;
class PackageNaming {
    private String id;
    public BadMethodName() {}

    void $Bad() { // Noncompliant [[sc=8;ec=11]] {{Rename this method name to match the regular expression '^[a-z][a-zA-Z0-9]*$'.}}
    }

    void _good(String id) {
        System.out.println("Test");
    }
}