# Test project for spock StackOverflowError while mocking

See https://github.com/spockframework/spock/issues/1909

* Running `mvn -V -qclean test -Dspockframework.version=2.4-M2-groovy-4.0` fails.
* Running `mvn -V -q clean test -Dspockframework.version=2.4-M1-groovy-4.0` succeeds.
