class AvoidDirectlyThrowExceptionFile {
    private String id;
    /**
     * print Test
     * @param id
     */
    void test(String id) throws Exception {
        int[] arr = new int[5];
        try{
            int a = arr[5];
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("Test");
    }
}