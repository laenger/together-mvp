package biz.laenger.android.together.example.main

import spock.lang.Specification

class MainPresenterSpec extends Specification {

    MainView mockView
    MainPresenter presenter

    def setup() {
        mockView = Mock(MainView)
        presenter = new MainPresenter()
    }

    def "should restore last known item position"() {
        given:
        presenter.onPagerItemSelected(i)

        when:
        presenter.bindView(mockView)

        then:
        1 * mockView.showPagerItem(i)

        where:
        i << (0..10)
    }

}
