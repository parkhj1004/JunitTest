package template;

public class TestMain {

    public static void main(String args[]) {

        TestMain test = new TestMain();


        test.call();


    }

    public void call() {

        TemplateTest t = new TemplateTest();

        t.call(new CouponCacheServiceBImpl());
        t.call(new ProdCacheServiceImpl());


//        CacheService cacheService = new CouponCacheServiceBImpl();
//
//        cacheService.test();

    }
}
