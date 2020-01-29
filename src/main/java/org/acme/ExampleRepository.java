package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * @author leandrosoares
 */
@ApplicationScoped
public class ExampleRepository implements PanacheRepository<ExampleEntity> {

    public String annotationsTest() {
        try {
            Thread.sleep(3000);
            return "I waited long enough";
        } catch (InterruptedException e) {
            return "exception caught";
        }
    }
    /*@Override
    public List<ExampleEntity> listAll() {
          List<ExampleEntity> a = ExampleEntity.<ExampleEntity> findAll().list();
          return a;
    }*/

}
