// class Comment

// Test
class ClassCommentCheck {
    private String id;

    void Bad() { // Noncompliant [[sc=8;ec=11]] {{Rename this method name to match the regular expression '^[a-z][a-zA-Z0-9]*$'.}}
    }

    /**
     * print Test
     * @param id
     */
    void good(String id) {
        System.out.println("Test");
    }
}