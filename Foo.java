public class Foo {
  public static void main(String[] argv) throws Exception {
    int no = 31;
    int count;
    for (count = 0; no > 0; ++count) {
      no &= no - 1;
    }
    System.out.println(count);
  }
}