package geekbrains.java3.lesson7;

public class TestClass<T> {

    static Thread t = new Thread();


    @BeforeSuite
    static void bs(){
        t.start();
        t.stop();
        System.out.println("BeforeSuite");
    }

//    @BeforeSuite
//    static void bs2(){
//        System.out.println("BeforeSuite");
//    }

    @Test(order = 9)
    static void a(int n){
        System.out.println(n);
    }

    @Test(order = 12)
    static void b(int n){
        System.out.println(n);
    }

    @Test(order = 2)
    static void c(int n){
        System.out.println(n);
    }

    static void d(int n){
        System.out.println(n);
    }

    @Test(order = 2)
    static void e(int n){
        System.out.println(n);
    }

    @Test(order = 3)
    static void f(int n){
        System.out.println(n);
    }

    @Test(order = 7)
    static void f7(int n){
        System.out.println(n);
    }

    @Test
    static void g(int n){
        System.out.println(n);
    }

    @AfterSuite
    static void as(){
        System.out.println("AfterSuite");
    }

}
