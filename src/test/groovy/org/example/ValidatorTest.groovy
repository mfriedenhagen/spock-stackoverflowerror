package org.example

import spock.lang.Specification
import spock.lang.Subject

class ValidatorTest extends Specification {

    ProjectValidator projectValidator = Mock(ProjectValidator)

    def 'Overflow?'() {
        given:
        @Subject validator = new Validator(projectValidator)
        when:
        validator.validate(1)
        then:
        1 * projectValidator.validate(1, R1)
        1 * projectValidator.validate(1, R2)
    }

}
