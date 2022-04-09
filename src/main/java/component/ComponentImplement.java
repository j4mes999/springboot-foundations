package component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void saluda() {
        System.out.println("Hola mundo desde mi componente");
    }
}
