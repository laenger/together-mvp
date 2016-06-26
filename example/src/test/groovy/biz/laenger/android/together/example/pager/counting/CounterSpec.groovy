package biz.laenger.android.together.example.pager.counting

import spock.lang.Specification

class CounterSpec extends Specification {

    Counter counter

    def setup() {
        counter = new Counter()
    }

    def "should initially be zero"() {
        expect:
        counter.current == 0
    }

    def "should count up in steps of one"() {
        expect:
        20.times { int i ->
            assert i + 1 == counter.countUp()
        }
        counter.current == 20
    }

}
