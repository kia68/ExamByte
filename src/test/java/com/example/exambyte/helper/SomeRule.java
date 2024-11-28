package com.example.exambyte.helper;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMember;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.springframework.util.StringUtils;

public class SomeRule extends ArchCondition<JavaClass>{

    public static final SomeRule someRule =
            new SomeRule("TODO: insert good description");


    public SomeRule(String description, Object... args) {
        super(description, args);
    }

    private static boolean isNotFinal(JavaMember member) {
        return !member.getModifiers().contains(JavaModifier.FINAL);
    }


    @Override
    public void check(JavaClass javaClass, ConditionEvents events) {
        javaClass.getFields().stream()
                .filter(SomeRule::isNotFinal)
                .forEach(f -> {
                    var methodName = "set" + StringUtils.capitalize(f.getName());
                    var parameterClass = f.getRawType().reflect();
                    var setter = javaClass.tryGetMethod(methodName, parameterClass);
                    if (!setter.isPresent()) {
                        events.add(SimpleConditionEvent.violated(f, "Field " + f.getFullName() + " has no Setter"));
                    } else {
                        events.add(SimpleConditionEvent.satisfied(f, "Field " + f.getFullName() + " has a Setter"));
                    }
                });
    }
}
