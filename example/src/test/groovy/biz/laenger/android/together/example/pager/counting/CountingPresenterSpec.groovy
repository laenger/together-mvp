package biz.laenger.android.together.example.pager.counting

import spock.lang.Specification

class CountingPresenterSpec extends Specification {

    CountingView mockView
    CountingPresenter presenter
    Counter counter

    def setup() {
        mockView = Mock(CountingView)
        presenter = new CountingPresenter()
        counter = Spy(Counter)
        presenter.counter = counter
        presenter.bindView(mockView)
    }

    def "should set initial text"() {
        when:
        presenter.bindView(mockView)

        then:
        1 * counter.getCurrent() >> 42
        1 * mockView.showText("42")
    }

    def "should count button click events and update text"() {
        when:
        presenter.onCountClick()

        then:
        1 * counter.countUp() >> 815
        1 * mockView.showText("815")
    }

}
