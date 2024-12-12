package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Item implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Item(String name) {
        this.name = name;
        System.out.println("----------NEW ITEM--------");
        System.out.println("1. Instantiation: A new item has been created: " + name);
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware: Setting bean factory for Item: " + this.name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("4. ApplicationContextAware: Setting application context for Item: " + this.name);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("6. @PostConstruct: Item is being prepared: " + this.name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization: Item is ready for use: " + this.name);
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Item's custom setup for: " + this.name);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("-------RETURN TO ITEM--------");
        System.out.println("10. @PreDestroy: Item is being removed: " + this.name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: Item is being destroyed: " + this.name);
        restAndRecover();
    }

    private void restAndRecover() {
        System.out.println("12. Resting: Item " + this.name + " is being safely discarded.");
    }


    public void customDestroy() {
        System.out.println("13. Custom Destruction: Item's final cleanup for: " + this.name);
    }
}
