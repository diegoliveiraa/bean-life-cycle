package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Weapon implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Weapon(String name) {
        this.name = name;
        System.out.println("----------NEW WEAPON--------");
        System.out.println("1. Instantiation: A new weapon has been created: " + name);
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
        System.out.println("3. BeanFactoryAware: Setting bean factory for Weapon: " + this.name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("4. ApplicationContextAware: Setting application context for Weapon: " + this.name);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("6. @PostConstruct: Weapon is being sharpened: " + this.name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization: Weapon is ready for battle: " + this.name);
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Weapon's custom setup for: " + this.name);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("-------RETURN TO WEAPON--------");
        System.out.println("10. @PreDestroy: Weapon is being sheathed: " + this.name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: Weapon is being destroyed: " + this.name);
        restAndRecover();
    }

    private void restAndRecover() {
        System.out.println("12. Resting: Weapon " + this.name + " is being cleaned and stored.");
    }


    public void customDestroy() {
        System.out.println("13. Custom Destruction: Weapon's final polishing: " + this.name);
    }
}
