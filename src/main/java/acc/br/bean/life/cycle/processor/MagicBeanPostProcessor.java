package acc.br.bean.life.cycle.processor;

import acc.br.bean.life.cycle.beans.Character;
import acc.br.bean.life.cycle.beans.Item;
import acc.br.bean.life.cycle.beans.Weapon;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MagicBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Character) {
            System.out.println("5. BeanPostProcessor: Adding a touch of magic to character " + beanName);
        } else if (bean instanceof Weapon) {
            System.out.println("5. BeanPostProcessor: Adding a touch of magic to weapon " + beanName);
        } else if (bean instanceof Item) {
            System.out.println("5. BeanPostProcessor: Adding a touch of magic to item " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Character) {
            System.out.println("9. BeanPostProcessor: Magic continues for character " + beanName);
        } else if (bean instanceof Weapon) {
            System.out.println("9. BeanPostProcessor: Magic continues for weapon " + beanName);
        } else if (bean instanceof Item) {
            System.out.println("9. BeanPostProcessor: Magic continues for item " + beanName);
        }
        return bean;
    }
}
