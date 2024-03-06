package org.example;


abstract class Status<StatusT, StatusBuilderT> {
    static class Builder<StatusT, StatusBuilderT> {}
}

class S1 extends Status<S1, Status.Builder> {}
class S2 extends Status<S2 , Status.Builder> {}

class S3 extends Status<S3 , Status.Builder> {}
record Foo() {}

abstract class Resource<SpecT,StatusT,StatusBuilderT> {}
class R1 extends Resource<Foo, S1, S1.Builder> {}
class R2 extends Resource<Foo, S2, S2.Builder> {}
class R3 extends Resource<Foo, S3, S3.Builder> {}
class ProjectValidator {
    public <
            SpecT extends Record,
            StatusT extends Status<StatusT,StatusBuilderT>,
            StatusBuilderT extends Status.Builder<StatusT, StatusBuilderT>,
            T extends Resource<SpecT,StatusT,StatusBuilderT>>
    void validate(long id, Class<T> klass) {
        throw new UnsupportedOperationException("Just for testing");
    }
}

public class Validator {
    private final ProjectValidator projectValidator;

    public Validator(ProjectValidator projectValidator) {
        this.projectValidator = projectValidator;
    }

    public void validate(long id) {
        projectValidator.validate(id, R1.class);
        projectValidator.validate(id, R2.class);
        projectValidator.validate(id, R3.class);
    }
}
