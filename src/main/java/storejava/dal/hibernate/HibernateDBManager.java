package storejava.dal.hibernate;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * This class like DBConnectionManager in working but using hibernate
 * 
 */
public class HibernateDBManager {
    
    // عشان الابلكيشن بتاعك يكلم الداتا بيز عن طريق الهايبر نيت ما ينفعش يكلمه كده على طول
    // عشان كده الهايبر نيت حطت قواعد عشان تكلم الداتا بيز اول حاجة هنفتحلك سيشن تكلم من خلاله الداتا بيز
    // declare SessionFactory, in this case we can call it for example dbSessionFactory
    // دي حاجة على سبيل المثال زي مثلا انا عايز اسافر هتعامل مع مصلحة الجوازات عشان اقدر ادخل البلد
    // دلوقتي احنا اول حاجة عرفنا ان في حاجة اسمها مصلحة الجوازات 
    private static SessionFactory dbSessionFactory;
    
     // file contain all information about database ده الملف اللي فيه كل المعلومات عني عشان ابعته لمصلحة الجوازات 
    private static String dbConfigFilename;

    public static void setDbConfigFilename(String dbConfigFilename) {
        HibernateDBManager.dbConfigFilename = dbConfigFilename;
    }

    public static SessionFactory getDbSessionFactory() {
        return dbSessionFactory;
    }
    
    
    // method to build session
    public static void buildSessionFactory() throws Exception {
        try{
        // if SessionFactory already exist, return
        if(dbSessionFactory != null){
            return;
        }
        
        if(dbConfigFilename == null){
            throw new Exception("ERROR : You must call setDbConfigFilename(filename) first");
        }
        
        // if not, build a new SessionFactory
        // first step -> use the configuration file which have all information about database
        // اول خطوة هبعت الملف بتاعي اللي في كل معلوماتي لمصلحة الجوازات
        // Loading Configuration from xml file (Database Connection Info)
        Configuration configuration =
                                new Configuration().configure(dbConfigFilename);
        
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.Branches.class);
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.Brands.class);
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.Categories.class);
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.Cities.class);
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.Products.class);
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.ProductsSizes.class);
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.Sizes.class);
        configuration.addAnnotatedClass(storejava.dal.hibernate.entity.Zones.class);
        //configuration.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
         // create an object from StandardServiceRegistryBuilder which give you like a permission to talk to database
        // ده اللي بيطلع التصاريح
        // prepare the serviceRegistryBuilder
        StandardServiceRegistryBuilder serviceRegistryBuilder = 
                                new StandardServiceRegistryBuilder();
        
        // applySettings (Database Connection Info) to the builder
        // قسم التصاريح هيراجع بياناتي هيشوفها مناسبة للمعايير بتاعتهم و مظبوطة عشان تروح الدولة اللي عايزها ولا لا
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        
        // give me a StandardServiceRegistry or a permission لو سمحت طلعلي تصريح
         // obtain the ServiceRegistry (Legal Paper)
        ServiceRegistry serviceRegistry =
                                serviceRegistryBuilder.build();
        
        // now you can build a SessionFactory دلوقتي بعد ما بعت الملف اللي فيه بياناتك و طلعلك التصريح تقدر تدخل الدولة
        // building the SessionFactory الكشك
        dbSessionFactory = 
                configuration.buildSessionFactory(serviceRegistry);
        }catch(HibernateException ex){
            dbSessionFactory = null;
            dbConfigFilename = null;
            throw ex;
        }
    }
}
