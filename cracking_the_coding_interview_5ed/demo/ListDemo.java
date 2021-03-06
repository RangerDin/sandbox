package demo;

class ListDemo {
  private static MyList l;

  private static void trace(String msg) {
    System.out.println(msg);
    System.out.println("------length " + l.length() + "------");
    System.out.println(l);
  }

  private static void test_init() {
    l = new MyList();

    trace("Create a list:");
  }

  private static void test_append() {
    l.appendHead("appended_to_head_1");
    l.appendHead("appended_to_head_2");
    l.appendTail("appended_to_tail_1");
    l.appendTail("appended_to_tail_2");

    trace("Append elements to the list:");
  }

  private static void test_insert() {
    l.insert(1, "inserted_at_pos_1");
    l.insert(4, "inserted_at_pos_4");
    l.insert(1, "inserted_at_pos_1_again");
    l.insert(l.length() + 1, "inserted_to_the_end");
    try {
      l.insert(10, "try_to_insert_to_unreachable_position");
    }
    catch (IllegalArgumentException e) {
      System.out.println("Exception catched: " + e.getMessage());
    }

    trace("Insert element to a specific position:");
  }

  private static void test_head_tail() {
    MyList t = l.tail();
    String h = l.head();
    try {
      while (true) {
        System.out.println("head: " + h);
        System.out.println("tail: \n" + t);
        h = t.head();
        t = t.tail();
      }
    }
    catch (IllegalArgumentException e) {
      System.out.println("Exception catched: " + e.getMessage());
    }
  }

  private static void test_nth() {
    try {
      for(int i = 1; i <= l.length() + 1; i++)
        System.out.println(i + "th element: " + l.nth(i));
    }
    catch (IllegalArgumentException e) {
      System.out.println("Exception catched: " + e.getMessage());
    }
  }

  private static void test_last_remove() {
    try {
      while (true) {
        l.remove(l.last());
        System.out.println("removed last: \n" + l);
      }
    }
    catch (IllegalArgumentException e) {
      System.out.println("Exception catched: " + e.getMessage());
    }
  }

  private static void test_sort() {
    String data[][] = {
      {
        "cat",
        "bird",
        "dog",
        "apple",
        "fruit",
        "bear"
      },
      {
        "a",
      },
      {
        "d",
        "c",
        "b",
        "a"
      },
      {
        "a",
        "a",
        "z",
        "z",
        "a",
        "a"
      },
      {
        "a",
        "b",
        "c",
        "d"
      }
    };

    for(String s[] : data) {
      l = new MyList();
      for(String ss : s)
        l.appendTail(ss);
      System.out.println("list:");
      System.out.println(l);
      l.sort();
      System.out.println("sorted:");
      System.out.println(l);
    }
  }

  public static void main(String args[]) {
    test_init();
    test_append();
    test_insert();
    test_head_tail();
    test_nth();
    test_last_remove();
    test_sort();
  }
}
