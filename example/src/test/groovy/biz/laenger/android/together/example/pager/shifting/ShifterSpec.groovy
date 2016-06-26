package biz.laenger.android.together.example.pager.shifting

import spock.lang.Specification

class ShifterSpec extends Specification {

    Shifter shifter

    def setup() {
        shifter = new Shifter("foo.bar")
    }

    def "should initially be zero"() {
        expect:
        shifter.current == "foo.bar"
    }

    def "should shift by one"() {
        expect:
        shifter.shift() == "rfoo.ba"
    }

    def "should shift 20 times"() {
        when:
        20.times {
            shifter.shift()
        }

        then:
        shifter.current == "oo.barf"
    }

}
