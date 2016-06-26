package biz.laenger.android.together.example.pager.shifting

import spock.lang.Specification

class ShiftingPresenterSpec extends Specification {

    ShiftingView mockView
    ShiftingPresenter presenter
    Shifter shifter

    def setup() {
        mockView = Mock(ShiftingView)
        presenter = new ShiftingPresenter()
        shifter = Spy(Shifter)
        presenter.shifter = shifter
    }

    def "should set initial text"() {
        when:
        presenter.bindView(mockView)

        then:
        1 * shifter.getCurrent() >> "foo.bar"
        1 * mockView.showText("foo.bar")
    }

    def "should shift on a button click and update text"() {
        given:
        presenter.bindView(mockView)

        when:
        presenter.onShiftClick()

        then:
        1 * shifter.shift() >> "bar.foo"
        1 * mockView.showText("bar.foo")
    }

}
