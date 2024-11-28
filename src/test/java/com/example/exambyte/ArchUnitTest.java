package com.example.exambyte;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packagesOf = ExambyteApplication.class, importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchUnitTest {
    @ArchTest
    ArchRule noMemberShoudBeAutoWired = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
    @ArchTest
    ArchRule alleKlasseSindAnnotiert = classes()
            .that()
            .resideInAnyPackage("..applicationService..")
            .should()
            .beAnnotatedWith(Service.class);

    @ArchTest
    ArchRule DieVariablenInControllerKlassenSolltenPrivateSein = fields()
            .that().areDeclaredInClassesThat()
                .areAnnotatedWith(Controller.class)
                .should().bePrivate();

    @ArchTest
    ArchRule NurControllerKlassenDuerfenAufAndereControllerKlassenZugreifen = classes()
            .that()
            .areAnnotatedWith(Controller.class)
            .should()
            .accessClassesThat()
            .areAnnotatedWith(Controller.class);
    @ArchTest
    ArchRule NurControllerKlassenDuerfenAufAndereControllerKlassenZugreifenn = noClasses()
            .that()
            .areNotAnnotatedWith(Controller.class)
            .should()
            .dependOnClassesThat()
            .areAnnotatedWith(Controller.class);

    @ArchTest
    ArchRule onionTest = onionArchitecture()
            .domainModels("..domainLayer.model..")
            .domainServices("..domain.service..")
            .applicationServices("..applicationService..")
            .adapter("web", "..controller..")
            .adapter("db", "..repositories..")
            .adapter("config", "..config..")
            ;


}
